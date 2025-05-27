package com.fisioflexbackend.dto;

public class PacienteLoginResponse {
    private String token;
    private UsuarioDTO usuario;
    private PacienteResponse paciente;

    // Construtores
    public PacienteLoginResponse() {}

    public PacienteLoginResponse(String token, UsuarioDTO usuario, PacienteResponse paciente) {
        this.token = token;
        this.usuario = usuario;
        this.paciente = paciente;
    }

    // Getters e Setters
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public UsuarioDTO getUsuario() { return usuario; }
    public void setUsuario(UsuarioDTO usuario) { this.usuario = usuario; }

    public PacienteResponse getPaciente() { return paciente; }
    public void setPaciente(PacienteResponse paciente) { this.paciente = paciente; }
}
