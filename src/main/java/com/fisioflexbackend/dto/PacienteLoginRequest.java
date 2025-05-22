package com.fisioflexbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteLoginRequest {
    private String cpf;
    private String senha;
}
