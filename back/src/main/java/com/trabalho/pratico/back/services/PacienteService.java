package com.trabalho.pratico.back.services;

import java.util.List;

import com.trabalho.pratico.back.mapper.PacienteMapper;
import com.trabalho.pratico.back.models.Paciente;
import com.trabalho.pratico.back.repository.PacienteRepository;
import com.trabalho.pratico.back.requests.PacientePostRequestBody;
import com.trabalho.pratico.back.requests.PacientePutRequestBody;
import com.trabalho.pratico.back.util.validaCpf;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository repository;
    private final validaCpf validaCpf; 

    public List<Paciente> getPacientes(){
        return repository.findAll();
    }
    public Paciente findPacienteOrThrowsBadRequest(long id){
        return repository.findById(id).
        orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"paciente nao encontado"));
    }
    public Paciente savePaciente(PacientePostRequestBody pacientePostRequestBody){
        Paciente paciente = PacienteMapper.INSTANCE.toPaciente(pacientePostRequestBody);
        validaCpf.Cadastrado(paciente.getCpf());
        return repository.save(paciente);

    }
    public Paciente updatePaciente(PacientePutRequestBody pacientePutRequestBody){
        findPacienteOrThrowsBadRequest(pacientePutRequestBody.getId());
        Paciente paciente = PacienteMapper.INSTANCE.toPaciente(pacientePutRequestBody);
        validaCpf.Cadastrado(paciente.getCpf());
        return repository.save(paciente);

    }
    public void delete(long id){
        repository.delete(findPacienteOrThrowsBadRequest(id));
    }
}
