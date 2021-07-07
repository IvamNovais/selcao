package com.trabalho.pratico.back.repository;

import com.trabalho.pratico.back.models.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente ,Long> {
    
}
