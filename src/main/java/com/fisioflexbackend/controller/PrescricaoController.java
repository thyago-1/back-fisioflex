package com.fisioflexbackend.controller;

import com.fisioflexbackend.model.Prescricao;
import com.fisioflexbackend.repository.PrescricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescricoes")
@CrossOrigin(origins = "*")
public class PrescricaoController {

    @Autowired
    private PrescricaoRepository prescricaoRepository;

    @PostMapping
    public Prescricao criarPrescricao(@RequestBody Prescricao prescricao) {
        return prescricaoRepository.save(prescricao);
    }

    @GetMapping
    public List<Prescricao> listar() {
        return prescricaoRepository.findAll();
    }
}
