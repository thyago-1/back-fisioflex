package com.fisioflexbackend.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EvolucaoResponse {
    private LocalDate data;
    private String descricao;
    private double progresso;
}
