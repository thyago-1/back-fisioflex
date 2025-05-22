package com.fisioflexbackend.repository;

import com.fisioflexbackend.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
	
	Paciente findByCpf(String cpf);

}
