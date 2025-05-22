package com.fisioflexbackend.controller;

import com.fisioflexbackend.dto.PagamentoResponse;
import com.fisioflexbackend.model.Paciente;
import com.fisioflexbackend.model.Pagamento;
import com.fisioflexbackend.repository.PacienteRepository;
import com.fisioflexbackend.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pagamentos")
@CrossOrigin(origins = "*")
public class PagamentoController {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;
    @PostMapping
    public ResponseEntity<?> criarPagamento(@RequestBody Pagamento novo) {
        if (novo.getPaciente() == null || novo.getPaciente().getId() == null) {
            return ResponseEntity.badRequest().body("Paciente inválido");
        }

        Paciente paciente = pacienteRepository.findById(novo.getPaciente().getId()).orElse(null);
        if (paciente == null) {
            return ResponseEntity.badRequest().body("Paciente não encontrado");
        }

        novo.setPaciente(paciente);
        Pagamento salvo = pagamentoRepository.save(novo);

        return ResponseEntity.ok(salvo);
    }

    @GetMapping("/{idPaciente}")
    public ResponseEntity<?> listarPagamentosDoPaciente(@PathVariable Long idPaciente) {
        Paciente paciente = pacienteRepository.findById(idPaciente).orElse(null);
        if (paciente == null) {
            return ResponseEntity.notFound().build();
        }

        List<Pagamento> pagamentos = pagamentoRepository.findByPaciente(paciente);

        List<PagamentoResponse> resposta = pagamentos.stream()
                .map(p -> new PagamentoResponse(
                        p.getId(),
                        p.getData().toString(),
                        p.getValor(),
                        p.getStatus()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(resposta);
    }
}
