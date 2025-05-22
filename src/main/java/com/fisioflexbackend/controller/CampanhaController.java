package com.fisioflexbackend.controller;

import com.fisioflexbackend.model.Campanha;
import com.fisioflexbackend.repository.CampanhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campanhas")
@CrossOrigin(origins = "*")
public class CampanhaController {

    @Autowired
    private CampanhaRepository campanhaRepository;

    @GetMapping
    public List<Campanha> listar() {
        return campanhaRepository.findAll();
    }

    @PostMapping
    public Campanha criar(@RequestBody Campanha campanha) {
        return campanhaRepository.save(campanha);
    }
}
