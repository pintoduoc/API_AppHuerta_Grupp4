package com.example.API_AppHuerta_Grupo4.Assemblers;

import com.example.API_AppHuerta_Grupo4.Controllers.ProductoController;
import com.example.API_AppHuerta_Grupo4.Model.Producto;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductoModelAssembler implements RepresentationModelAssembler<Producto, EntityModel<Producto>> {
    @Override
    public EntityModel<Producto> toModel(Producto producto) {
        return EntityModel.of(producto,
                linkTo(methodOn(ProductoController.class).getProductoById(producto.getId())).withSelfRel(),
                linkTo(methodOn(ProductoController.class).getAllProductos()).withRel("GET")
                );
    }
}
