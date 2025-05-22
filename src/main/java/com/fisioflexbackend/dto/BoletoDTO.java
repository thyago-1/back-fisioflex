package com.fisioflexbackend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor; 

@Getter
@Setter
@AllArgsConstructor // <- ESSENCIAL para o erro
@NoArgsConstructor  // <- Recomendado para serialização
public class BoletoDTO {
    private Long id;
    private String descricao; 
    private double valor;
    private String vencimento;
}
