package com.fisioflexbackend.repository;

import com.fisioflexbackend.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
