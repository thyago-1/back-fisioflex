package com.fisioflexbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PagamentoResponse {
    private Long id;
    private String data;
    private double valor;
    private String status;
}
