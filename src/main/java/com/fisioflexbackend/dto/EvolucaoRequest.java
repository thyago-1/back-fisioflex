package com.fisioflexbackend.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class EvolucaoRequest {
    private Long pacienteId;
    private LocalDate data;
    private String descricao;
    private double progresso;
}
