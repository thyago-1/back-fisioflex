package com.fisioflexbackend.controller;

import com.fisioflexbackend.dto.AtendimentoResponse;
import com.fisioflexbackend.model.Atendimento;
import com.fisioflexbackend.model.Paciente;
import com.fisioflexbackend.repository.AtendimentoRepository;
import com.fisioflexbackend.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/atendimentos")
@CrossOrigin(origins = "*")
public class AtendimentoController {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping("/{idPaciente}")
    public ResponseEntity<?> listarAtendimentosPorPaciente(@PathVariable Long idPaciente) {
        Paciente paciente = pacienteRepository.findById(idPaciente).orElse(null);
        if (paciente == null) {
            return ResponseEntity.notFound().build();
        }

        List<Atendimento> atendimentos = atendimentoRepository.findByPaciente(paciente);

        List<AtendimentoResponse> resposta = atendimentos.stream()
                .map(a -> new AtendimentoResponse(
                        a.getId(),
                        a.getData().toString(),
                        a.getDescricao()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(resposta);
    }
}
