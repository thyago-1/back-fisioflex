package com.fisioflexbackend.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profissional extends Usuario {

    private String especialidade;

    private String registroProfissional;
}
