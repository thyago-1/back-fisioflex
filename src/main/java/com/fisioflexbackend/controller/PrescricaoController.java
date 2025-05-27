package com.fisioflexbackend.controller;

import com.fisioflexbackend.dto.PrescricaoRequest;
import com.fisioflexbackend.dto.PrescricaoResponse;
import com.fisioflexbackend.dto.PacienteDTO;
import com.fisioflexbackend.model.Paciente;
import com.fisioflexbackend.model.Prescricao;
import com.fisioflexbackend.repository.PacienteRepository;
import com.fisioflexbackend.repository.PrescricaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/prescricoes")
@CrossOrigin(origins = "*")
public class PrescricaoController {

    @Autowired
    private PrescricaoRepository prescricaoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    // ✅ Criar prescrição
    @PostMapping
    public ResponseEntity<?> criarPrescricao(@RequestBody PrescricaoRequest request) {
        Paciente paciente = pacienteRepository.findById(request.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        Prescricao prescricao = new Prescricao();
        prescricao.setPaciente(paciente);
        prescricao.setDescricao(request.getDescricao());
        prescricao.setExercicios(request.getExercicios());

        Prescricao salva = prescricaoRepository.save(prescricao);

        return ResponseEntity.ok(toResponse(salva));
    }

    // ✅ Listar todas as prescrições
    @GetMapping
    public List<PrescricaoResponse> listarTodas() {
        return prescricaoRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    // ✅ Conversão Prescricao → PrescricaoResponse
    private PrescricaoResponse toResponse(Prescricao prescricao) {
        PrescricaoResponse response = new PrescricaoResponse();
        response.setId(prescricao.getId());
        response.setDescricao(prescricao.getDescricao());
        response.setExercicios(prescricao.getExercicios());

        Paciente paciente = prescricao.getPaciente();
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId(paciente.getId());
        pacienteDTO.setNome(paciente.getNome());
        pacienteDTO.setCpf(paciente.getCpf());

        response.setPaciente(pacienteDTO);

        return response;
    }
}
