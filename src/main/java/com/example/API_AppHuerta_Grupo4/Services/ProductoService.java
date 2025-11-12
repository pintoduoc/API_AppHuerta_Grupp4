package com.example.API_AppHuerta_Grupo4.Services;

import com.example.API_AppHuerta_Grupo4.Model.Producto;
import com.example.API_AppHuerta_Grupo4.Repositorios.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    //Listar
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    //Buscar por ID
    public Producto getProductoById(Integer id) {
        if (productoRepository.existsById(id)) {
            return productoRepository.findById(id).get();
        }else {
            return null;
        }
    }

    //Agregar
    public Producto addProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    //Eliminar por ID
    public boolean deleteProducto(int id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

        //Actualizar
        public Producto updateProducto(int id, Producto producto) {
            if (productoRepository.existsById(id)) {
                Producto buscado = productoRepository.findById(id).get();
                buscado.setNombre(producto.getNombre());
                buscado.setDescripcion(producto.getDescripcion());
                buscado.setPrecio(producto.getPrecio());
                productoRepository.save(buscado);
                return buscado;
            }else {
                return null;
            }
        }
    }
