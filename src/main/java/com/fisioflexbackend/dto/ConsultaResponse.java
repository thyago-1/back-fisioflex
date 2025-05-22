package com.fisioflexbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultaResponse {
    private Long id;
    private String data;
    private String hora;
    private String nomePaciente;
}
