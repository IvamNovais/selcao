package com.trabalho.pratico.back.services;

import java.util.Optional;
import java.util.List;

import com.trabalho.pratico.back.mapper.EnfermeiroMapper;
import com.trabalho.pratico.back.models.Enfermeiro;
import com.trabalho.pratico.back.repository.EnfermeiroRepository;
import com.trabalho.pratico.back.requests.EnfermeiroPostRequestBody;
import com.trabalho.pratico.back.requests.EnfermeiroPutRequestBody;
import com.trabalho.pratico.back.util.validaCpf;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class EnfermeiroService{
    private final validaCpf validaCpf; 
    private final EnfermeiroRepository enfermeiroRepository;
    public UserDetails loadUserByUsername(String username) throws BadRequest {
        UserDetails o = Optional.ofNullable(enfermeiroRepository.findByUsername(username))
                                    .orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"usuario nao encontrado"));
        return o;
    }
    public List<Enfermeiro> getEnfermeiros(){
        return enfermeiroRepository.findAll();
    }
    public Enfermeiro findEnfermeiroOrThrowsBadRequest(long id){
        return enfermeiroRepository.findById(id).
        orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Enfermeiro nao encontado"));
    }
    public Enfermeiro saveEnfermeiro(EnfermeiroPostRequestBody enfermeiroPostRequestBody){
        Enfermeiro enfermeiro = EnfermeiroMapper.INSTANCE.toEnfermeiro(enfermeiroPostRequestBody);
        enfermeiro.setAuthorities("ROLE_USER");
        validaCpf.Cadastrado(enfermeiro.getCpf());
        return enfermeiroRepository.save(enfermeiro);

    }
    public Enfermeiro updateEnfermeiro(EnfermeiroPutRequestBody enfermeiroPutRequestBody){
        findEnfermeiroOrThrowsBadRequest(enfermeiroPutRequestBody.getId());
        Enfermeiro enfermeiro = EnfermeiroMapper.INSTANCE.toEnfermeiro(enfermeiroPutRequestBody);
        enfermeiro.setAuthorities("ROLE_USER");
        validaCpf.Cadastrado(enfermeiro.getCpf());
        return enfermeiroRepository.save(enfermeiro);

    }
    public void delete(long id){
        enfermeiroRepository.delete(findEnfermeiroOrThrowsBadRequest(id));
    }
}
