package com.fisioflexbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteResponse {
    private Long id;
    private String nome;
    private String email;

    private String cpf;
    private int idade;
    private double peso;
    private double altura;
    private String sexo;
    private String endereco;
    private String telefone;
}
