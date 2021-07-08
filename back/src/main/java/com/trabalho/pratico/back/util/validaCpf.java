package com.trabalho.pratico.back.util;

import com.trabalho.pratico.back.repository.EnfermeiroRepository;
import com.trabalho.pratico.back.repository.MedicoRepository;
import com.trabalho.pratico.back.repository.PacienteRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class validaCpf {
    public final EnfermeiroRepository enfermeiroRepository;
    public final MedicoRepository medicoRepository;
    public final PacienteRepository pacienteRepository;
    public void Cadastrado(String cpf){
        if(enfermeiroRepository.existsByCpf(cpf)
        ||medicoRepository.existsByCpf(cpf)
        ||pacienteRepository.existsByCpf(cpf)){
            new ResponseStatusException(HttpStatus.CONFLICT,"CPF ja cadastrado");
        }
        
    }
}
