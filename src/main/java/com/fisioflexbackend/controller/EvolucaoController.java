package com.fisioflexbackend.controller;

import com.fisioflexbackend.dto.EvolucaoRequest;
import com.fisioflexbackend.dto.EvolucaoResponse;
import com.fisioflexbackend.model.Evolucao;
import com.fisioflexbackend.model.Paciente;
import com.fisioflexbackend.repository.EvolucaoRepository;
import com.fisioflexbackend.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/evolucao")
@CrossOrigin(origins = "*")
public class EvolucaoController {

    @Autowired
    private EvolucaoRepository evolucaoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping("/{pacienteId}")
    public List<EvolucaoResponse> listarPorPaciente(@PathVariable Long pacienteId) {
        return evolucaoRepository.findByPacienteId(pacienteId)
                .stream().map(this::toResponse).collect(Collectors.toList());
    }

    @PostMapping
    public EvolucaoResponse criar(@RequestBody EvolucaoRequest request) {
        Paciente paciente = pacienteRepository.findById(request.getPacienteId()).orElseThrow();

        Evolucao e = new Evolucao();
        e.setPaciente(paciente);
        e.setData(request.getData());
        e.setDescricao(request.getDescricao());
        e.setProgresso(request.getProgresso());

        Evolucao salvo = evolucaoRepository.save(e);

        return toResponse(salvo);
    }

    @PutMapping("/{id}")
    public EvolucaoResponse atualizar(@PathVariable Long id, @RequestBody EvolucaoRequest request) {
        Evolucao e = evolucaoRepository.findById(id).orElseThrow();
        e.setData(request.getData());
        e.setDescricao(request.getDescricao());
        e.setProgresso(request.getProgresso());

        Evolucao atualizado = evolucaoRepository.save(e);
        return toResponse(atualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        evolucaoRepository.deleteById(id);
    }

    private EvolucaoResponse toResponse(Evolucao e) {
        EvolucaoResponse dto = new EvolucaoResponse();
        dto.setData(e.getData());
        dto.setDescricao(e.getDescricao());
        dto.setProgresso(e.getProgresso());
        return dto;
    }
}
