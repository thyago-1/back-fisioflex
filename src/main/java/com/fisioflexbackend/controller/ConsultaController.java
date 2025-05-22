package com.fisioflexbackend.controller;

import com.fisioflexbackend.dto.ConsultaDTO;
import com.fisioflexbackend.model.Consulta;
import com.fisioflexbackend.model.Paciente;
import com.fisioflexbackend.repository.ConsultaRepository;
import com.fisioflexbackend.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/consultas")
@CrossOrigin(origins = "*")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    public Consulta criarConsulta(@RequestBody ConsultaDTO dto) {
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        Consulta consulta = new Consulta();
        consulta.setPaciente(paciente);
        consulta.setData(LocalDate.parse(dto.getData()));
        consulta.setHora(LocalTime.parse(dto.getHora()));

        return consultaRepository.save(consulta);
    }

    @GetMapping
    public List<Consulta> listarConsultas() {
        return consultaRepository.findAll();
    }
}
