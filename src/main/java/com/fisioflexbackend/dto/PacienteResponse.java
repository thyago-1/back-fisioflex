package com.fisioflexbackend.dto;

import lombok.Data;

@Data
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
    private String tipo;
}
