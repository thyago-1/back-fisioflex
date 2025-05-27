package com.fisioflexbackend.controller;

import com.fisioflexbackend.dto.ProfissionalLoginRequest;
import com.fisioflexbackend.dto.ProfissionalLoginResponse;
import com.fisioflexbackend.model.Profissional;
import com.fisioflexbackend.repository.ProfissionalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profissionais")
@CrossOrigin(origins = "*")
public class ProfissionalController {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    // ✅ Listar todos os profissionais
    @GetMapping
    public List<Profissional> listarProfissionais() {
        return profissionalRepository.findAll();
    }

    // ✅ Buscar profissional por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Profissional> profissionalOpt = profissionalRepository.findById(id);

        if (profissionalOpt.isPresent()) {
            return ResponseEntity.ok(profissionalOpt.get());
        } else {
            return ResponseEntity.status(404).body("Profissional não encontrado");
        }
    }

    // ✅ Login do profissional
    @PostMapping("/login")
    public ResponseEntity<?> loginProfissional(@RequestBody ProfissionalLoginRequest request) {
        Profissional profissional = profissionalRepository.findByRegistroProfissional(request.getRegistro());

        if (profissional == null || !profissional.getSenha().equals(request.getSenha())) {
            return ResponseEntity.status(401).body("Registro ou senha incorretos");
        }

        // ✅ Token mock
        String token = "mock-token";

        // ✅ Montar resposta
        ProfissionalLoginResponse response = new ProfissionalLoginResponse(
            token,
            profissional.getId(),
            profissional.getNome(),
            profissional.getEmail(),
            profissional.getEspecialidade(),
            profissional.getRegistroProfissional()
        );

        return ResponseEntity.ok(response);
    }
}
