package com.fisioflexbackend.dto;

public class ProfissionalLoginRequest {
    private String registro;
    private String senha;

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
