package com.fisioflexbackend.controller;

import com.fisioflexbackend.dto.PacienteRequest;
import com.fisioflexbackend.dto.PacienteResponse;
import com.fisioflexbackend.model.Paciente;
import com.fisioflexbackend.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fisioflexbackend.dto.PacienteLoginRequest;
import com.fisioflexbackend.dto.PacienteLoginResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins = "*")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    // ✅ Cadastrar paciente usando DTO
    @PostMapping
    public PacienteResponse criar(@RequestBody PacienteRequest request) {
        Paciente paciente = new Paciente();
        paciente.setNome(request.getNome());
        paciente.setEmail(request.getEmail());
        paciente.setSenha(request.getSenha());
        paciente.setCpf(request.getCpf());
        paciente.setIdade(request.getIdade());
        paciente.setPeso(request.getPeso());
        paciente.setAltura(request.getAltura());
        paciente.setSexo(request.getSexo());
        paciente.setEndereco(request.getEndereco());
        paciente.setTelefone(request.getTelefone());

        Paciente salvo = pacienteRepository.save(paciente);

        return toResponse(salvo);
    }

    // ✅ Listar pacientes com DTO (sem senha)
    @GetMapping
    public List<PacienteResponse> listarTodos() {
        return pacienteRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> loginPaciente(@RequestBody PacienteLoginRequest request) {
        Paciente paciente = pacienteRepository.findByCpf(request.getCpf());

        if (paciente == null || !paciente.getSenha().equals(request.getSenha())) {
            return ResponseEntity.status(401).body("CPF ou senha incorretos");
        }

        return ResponseEntity.ok(new PacienteLoginResponse(paciente.getNome()));
    }
    
  
    private PacienteResponse toResponse(Paciente paciente) {
        PacienteResponse response = new PacienteResponse();
        response.setId(paciente.getId());
        response.setNome(paciente.getNome());
        response.setEmail(paciente.getEmail());
        response.setCpf(paciente.getCpf());
        response.setIdade(paciente.getIdade());
        response.setPeso(paciente.getPeso());
        response.setAltura(paciente.getAltura());
        response.setSexo(paciente.getSexo());
        response.setEndereco(paciente.getEndereco());
        response.setTelefone(paciente.getTelefone());
        return response;
    }
}
