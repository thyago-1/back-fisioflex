package com.fisioflexbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteRequest {
    private String nome;
    private String email;
    private String senha;

    private String cpf;
    private int idade;
    private double peso;
    private double altura;
    private String sexo;
    private String endereco;
    private String telefone;
}
