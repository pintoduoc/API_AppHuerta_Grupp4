package com.example.API_AppHuerta_Grupo4.Services;

import com.example.API_AppHuerta_Grupo4.Model.Usuario;
import com.example.API_AppHuerta_Grupo4.Repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    //Listar
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    //Buscar por ID
    public Usuario getUsuarioById(Integer id) {
        if(usuarioRepository.existsById(id)) {
            return usuarioRepository.findById(id).get();
        }else {
            return null;
        }
    }

    //Agregar
    public Usuario addUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    //Eliminar por ID
    public boolean deleteUsuario(int id) {
        if(usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    //Actualizar
    public Usuario updateUsuario(int id, Usuario usuario) {
        if(usuarioRepository.existsById(id)) {
            Usuario buscado = usuarioRepository.findById(id).get();
            buscado.setNombres(usuario.getNombres());
            buscado.setApellidos(usuario.getApellidos());
            buscado.setCorreo(usuario.getCorreo());
            buscado.setClave(usuario.getClave());
            buscado.setDireccion(usuario.getDireccion());
            buscado.setAceptaTerminos(usuario.getAceptaTerminos());
            usuarioRepository.save(buscado);
            return buscado;
        }else {
            return null;
        }
    }
}
