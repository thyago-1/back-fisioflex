package com.fisioflexbackend.dto;

public class ProfissionalLoginResponse {
    private String token;
    private Long id;
    private String nome;
    private String email;
    private String especialidade;
    private String registroProfissional;

    public ProfissionalLoginResponse(String token, Long id, String nome, String email, String especialidade, String registroProfissional) {
        this.token = token;
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.especialidade = especialidade;
        this.registroProfissional = registroProfissional;
    }

    // Getters e Setters
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    public String getRegistroProfissional() { return registroProfissional; }
    public void setRegistroProfissional(String registroProfissional) { this.registroProfissional = registroProfissional; }
}
