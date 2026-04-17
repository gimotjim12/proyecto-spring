package mx.edu.unpa.apiandroid.controller;

import mx.edu.unpa.apiandroid.model.Usuario;
import mx.edu.unpa.apiandroid.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(path ="/app")
    public Iterable<Usuario> index() {
        return usuarioService.findAll();
    }

    @PostMapping(path ="/fnd")
    public ResponseEntity<?> read(@RequestParam ("id") Integer id) {
    	Optional<Usuario> oUsuario = usuarioService.findById(id);
    	if(oUsuario.isPresent()) {
    		LinkedList<Usuario> usuarioList = new LinkedList<>();
    		usuarioList.add(oUsuario.get());
    		return ResponseEntity.ok(usuarioList);
    	}else {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
        
    }

    @PostMapping("/create")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
    	Usuario saveUsuario= usuarioService.save(usuario);
    	
    	return ResponseEntity.status(HttpStatus.CREATED).body(saveUsuario);
    }
    
    @PutMapping("/save")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
    	
    	if(usuario != null) {
    		usuarioService.save(usuario);
    		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    	}else {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    	}

    }
    
    @DeleteMapping("/del/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
    	Optional<Usuario> oUsuario = usuarioService.findById(id);
	    	
	    	if(oUsuario.isPresent()) {
	    		usuarioService.deleteById(id);
	    		return ResponseEntity.noContent().build();
	    	}else {
	    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    	}
	
	    }
}