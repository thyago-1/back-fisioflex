package com.fisioflexbackend.controller;

import com.fisioflexbackend.dto.ResumoFinanceiroDTO;
import com.fisioflexbackend.dto.BoletoDTO;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Arrays;

@RestController
@RequestMapping("/financas")
@CrossOrigin(origins = "*")
public class FinancaController {

    @GetMapping("/resumo")
    public ResumoFinanceiroDTO getResumo() {
        ResumoFinanceiroDTO dto = new ResumoFinanceiroDTO();
        dto.setReceitaMensal(7500.00);
        dto.setDespesaMensal(3200.00);
        return dto;
    }

    @GetMapping("/boletos-receber")
    public List<BoletoDTO> getBoletosReceber() {
        return Arrays.asList(
            new BoletoDTO(1L, "Maria Souza", 200.0, "10/04/2025"),
            new BoletoDTO(2L, "Carlos Oliveira", 350.0, "15/04/2025")
        );
    }

    @GetMapping("/boletos-pagar")
    public List<BoletoDTO> getBoletosPagar() {
        return Arrays.asList(
            new BoletoDTO(1L, "Aluguel", 1500.0, "05/04/2025"),
            new BoletoDTO(2L, "Conta de Luz", 300.0, "07/04/2025")
        );
    }
}
