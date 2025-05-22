package com.fisioflexbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AtendimentoResponse {
    private Long id;
    private String data;
    private String descricao;
}
