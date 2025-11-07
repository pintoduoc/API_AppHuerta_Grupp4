package com.example.API_AppHuerta_Grupo4.Repositorios;

import com.example.API_AppHuerta_Grupo4.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}
