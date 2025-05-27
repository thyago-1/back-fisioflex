package com.fisioflexbackend.dto;

import lombok.Data;

@Data
public class PrescricaoResponse {
    private Long id;
    private PacienteDTO paciente;  // ✅ DEVE SER PacienteDTO
    private String descricao;
    private String exercicios;
}
