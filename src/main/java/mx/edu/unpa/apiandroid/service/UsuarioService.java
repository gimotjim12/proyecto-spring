package mx.edu.unpa.apiandroid.service;

import mx.edu.unpa.apiandroid.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public Iterable<Usuario> findAll();
    public Optional<Usuario> findById(Integer id);
    public Usuario save (Usuario usuario);
    public void deleteById(Integer id);
}