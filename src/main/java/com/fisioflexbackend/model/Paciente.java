package com.fisioflexbackend.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente extends Usuario {

    private String cpf;
    private int idade;
    private double peso;
    private double altura;
    private String sexo;
    private String endereco;
    private String telefone;
}
