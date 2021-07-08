package com.trabalho.pratico.back.repository;

import com.trabalho.pratico.back.models.Enfermeiro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnfermeiroRepository extends JpaRepository<Enfermeiro ,Long>{
    Enfermeiro findByUsername(String username);
}
