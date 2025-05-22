package com.fisioflexbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultaRequest {
    private Long pacienteId;
    private String data; 
    private String hora; 
}
