package com.fisioflexbackend.repository;

import com.fisioflexbackend.model.Pagamento;
import com.fisioflexbackend.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    List<Pagamento> findByPaciente(Paciente paciente);
}
