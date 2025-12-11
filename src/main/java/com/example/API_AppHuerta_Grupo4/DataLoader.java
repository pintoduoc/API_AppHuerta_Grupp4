package com.example.API_AppHuerta_Grupo4;

import com.example.API_AppHuerta_Grupo4.Model.Producto;
import com.example.API_AppHuerta_Grupo4.Repositorios.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner initDatabase(ProductoRepository productoRepository) {
        return args -> {
            if(productoRepository.count() == 0) {
                productoRepository.save(new Producto(0, "Lechuga", "Lechuga fresca y orgánica", "$1200 / unidad", 1));
                productoRepository.save(new Producto(0, "Zanahoria", "Zanahorias recién cosechadas", "$1000 / kilo", 2));
                productoRepository.save(new Producto(0, "Tomate", "Tomates maduros del huerto", "$1800 / kilo", 3));
                System.out.println("Productos cargados en la base de datos");
            }
        };
    }
}
