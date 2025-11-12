package com.example.API_AppHuerta_Grupo4.Controllers;

import com.example.API_AppHuerta_Grupo4.Assemblers.ProductoModelAssembler;
import com.example.API_AppHuerta_Grupo4.Model.Producto;
import com.example.API_AppHuerta_Grupo4.Services.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@Tag(name = "Productos", description = "Operaciones para la clase 'Producto'")
public class ProductoController {
    @Autowired
    ProductoModelAssembler assembler;

    @Autowired
    ProductoService productoService;

    @GetMapping
    @Operation(summary = "Obtener todos los productos", description = "Devuelve todos los productos disponibles")
    public CollectionModel<EntityModel<Producto>> getAllProductos() {
        List<Producto> productos = productoService.getAllProductos();
        return assembler.toCollectionModel(productos);
    }

    @PostMapping
    @Operation(summary = "Añadir producto", description = "Añade un producto a la base de datos. Requiere: nombre, descripcion y precio")
    public EntityModel<Producto> addProducto(@RequestBody Producto producto) {
        Producto nuevo = productoService.addProducto(producto);
        if (nuevo != null) {
            return assembler.toModel(nuevo);
        }else {
            return null;
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Producto", description = "Busca un producto con la ID ingresada")
    public EntityModel<Producto> getProductoById(@PathVariable int id) {
        Producto producto = productoService.getProductoById(id);
        if(producto != null) {
            return assembler.toModel(producto);
        }else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar producto", description = "Borra el producto con la ID ingresada")
    public void deleteProducto(@PathVariable int id) {
        productoService.deleteProducto(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar producto", description = "Actualiza un producto. Requiere: ID del producto a actualizar, nuevo nombre, nueva descripcion y nuevo precio")
    public EntityModel<Producto> updateProducto(@PathVariable int id, @RequestBody Producto producto) {
        Producto nuevoProducto = productoService.updateProducto(id, producto);
        if (nuevoProducto != null) {
            return assembler.toModel(nuevoProducto);
        }else {
            return null;
        }
    }
}
