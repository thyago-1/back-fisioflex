package com.fisioflexbackend.repository;

import com.fisioflexbackend.model.Atendimento;
import com.fisioflexbackend.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
    List<Atendimento> findByPaciente(Paciente paciente);
}
