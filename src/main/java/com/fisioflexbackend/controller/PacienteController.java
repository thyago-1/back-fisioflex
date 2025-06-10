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
import com.fisioflexbackend.dto.UsuarioDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins = "*")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    
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

        paciente.setTipo("Paciente");  // ✅ ESSA LINHA É OBRIGATÓRIA!

        Paciente salvo = pacienteRepository.save(paciente);

        return toResponse(salvo);
    }

    
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

        
        String token = "mock-token";

        
        UsuarioDTO usuario = new UsuarioDTO(
                paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                "PACIENTE"
        );

        
        PacienteResponse pacienteResponse = toResponse(paciente);

       
        PacienteLoginResponse response = new PacienteLoginResponse(token, usuario, pacienteResponse);

       
        return ResponseEntity.ok(response);
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
        response.setTipo(paciente.getTipo()); 
        return response;
    }
}