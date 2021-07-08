package com.trabalho.pratico.back.repository;

import com.trabalho.pratico.back.models.Medico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico ,Long>{
    Medico findByUsername(String username);
}
