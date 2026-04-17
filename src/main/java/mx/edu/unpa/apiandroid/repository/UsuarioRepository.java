package mx.edu.unpa.apiandroid.repository;

import mx.edu.unpa.apiandroid.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}