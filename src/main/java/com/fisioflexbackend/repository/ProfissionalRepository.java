package com.fisioflexbackend.repository;

import com.fisioflexbackend.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

    
    Profissional findByRegistroProfissional(String registroProfissional);

}
