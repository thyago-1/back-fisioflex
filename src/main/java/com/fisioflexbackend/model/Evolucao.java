package com.fisioflexbackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Evolucao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    private String descricao;

    private double progresso;  // de 0 a 100 %

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
}
