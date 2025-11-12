package com.example.API_AppHuerta_Grupo4.Repositorios;

import com.example.API_AppHuerta_Grupo4.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
