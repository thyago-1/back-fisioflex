package com.fisioflexbackend.dto;

import lombok.Data;

@Data
public class PrescricaoRequest {
    private Long pacienteId;
    private String descricao;
    private String exercicios;
}
