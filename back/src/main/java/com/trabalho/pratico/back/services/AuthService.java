package com.trabalho.pratico.back.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService{
    private final MedicoService medicoService;
    private final EnfermeiroService enfermeiroService;
    @Override
    public UserDetails loadUserByUsername(String username) throws BadRequest {
        UserDetails o = medicoService.loadUserByUsername(username);
        if(o==null){
            o=enfermeiroService.loadUserByUsername(username);   
        }
        return o;
    }
}
