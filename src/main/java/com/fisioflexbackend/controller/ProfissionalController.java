package com.fisioflexbackend.controller;

import com.fisioflexbackend.model.Profissional;
import com.fisioflexbackend.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionais")
@CrossOrigin(origins = "*")
public class ProfissionalController {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    
    @GetMapping
    public List<Profissional> listarProfissionais() {
        return profissionalRepository.findAll();
    }

    
    @GetMapping("/login")
    public ResponseEntity<Profissional> loginProfissional(
            @RequestParam String registro,
            @RequestParam String senha
    ) {
        return profissionalRepository.findByRegistroProfissionalAndSenha(registro, senha)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).build());
    }
}
