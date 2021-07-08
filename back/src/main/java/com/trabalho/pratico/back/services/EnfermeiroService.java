package com.trabalho.pratico.back.services;

import java.util.Optional;

import com.trabalho.pratico.back.repository.EnfermeiroRepository;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class EnfermeiroService{
    private final EnfermeiroRepository enfermeiroRepository;
    public UserDetails loadUserByUsername(String username) throws BadRequest {
        UserDetails o = Optional.ofNullable(enfermeiroRepository.findByUsername(username))
                                    .orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"usuario nao encontrado"));
        return o;
    }
}
