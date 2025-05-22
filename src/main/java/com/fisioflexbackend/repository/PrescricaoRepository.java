package com.fisioflexbackend.repository;

import com.fisioflexbackend.model.Prescricao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescricaoRepository extends JpaRepository<Prescricao, Long> {
}
