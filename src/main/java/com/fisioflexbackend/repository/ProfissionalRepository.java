package com.fisioflexbackend.repository;

import com.fisioflexbackend.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
    Optional<Profissional> findByRegistroProfissionalAndSenha(String registroProfissional, String senha);
}
