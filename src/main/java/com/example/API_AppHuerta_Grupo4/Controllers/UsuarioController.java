package com.example.API_AppHuerta_Grupo4.Controllers;

import com.example.API_AppHuerta_Grupo4.Assemblers.UsuarioModelAssembler;
import com.example.API_AppHuerta_Grupo4.Model.Usuario;
import com.example.API_AppHuerta_Grupo4.Services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuarios", description = "Operaciones para la clase 'Usuario'")
public class UsuarioController {
    @Autowired
    UsuarioModelAssembler assembler;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    @Operation(summary = "Obtener todos los usuarios", description = "Devuelve todos los usuarios registrados")
    public CollectionModel<EntityModel<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        return assembler.toCollectionModel(usuarios);
    }

    @PostMapping
    @Operation(summary = "Añadir usuario", description = "Registra un usuario a la base de datos. Requiere: nombres, apellidos, correo, clave, direccion y si acepta los terminos y condiciones (True o False)")
    public EntityModel<Usuario> addUsuario(@RequestBody Usuario usuario) {
        Usuario nuevo = usuarioService.addUsuario(usuario);
        if (nuevo != null) {
            return assembler.toModel(nuevo);
        }else {
            return null;
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar Usuario", description = "Busca un usuario con la ID ingresada")
    public EntityModel<Usuario> getUsuarioById(@PathVariable int id) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        if(usuario != null) {
            return assembler.toModel(usuario);
        }else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar usuario", description = "Borra el usuario con la ID ingresada")
    public void deleteUsuario(@PathVariable int id) {
        usuarioService.deleteUsuario(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar usuario", description = "Actualiza un usuario. Requiere: ID del usuario a actualizar, nuevos nombres, nuevos apellidos, nuevo correo, nueva clave, nueva direccion y si acepta los terminos y condiciones (True o False)")
    public EntityModel<Usuario> updateUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.updateUsuario(id, usuario);
        if (nuevoUsuario != null) {
            return assembler.toModel(nuevoUsuario);
        }else {
            return null;
        }
    }
}
