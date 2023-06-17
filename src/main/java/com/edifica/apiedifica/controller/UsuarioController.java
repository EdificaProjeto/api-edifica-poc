package com.edifica.apiedifica.controller;

import com.edifica.apiedifica.model.Usuario;
import com.edifica.apiedifica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private final UsuarioRepository repository;


    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Usuario> listAll(){
        return repository.findAll();
    }

    @PostMapping
    public Usuario save(@RequestBody Usuario usuario){
        return repository.save(usuario);
    }
}
