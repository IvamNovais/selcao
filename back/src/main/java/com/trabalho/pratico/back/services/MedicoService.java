package com.trabalho.pratico.back.services;
import com.trabalho.pratico.back.repository.MedicoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicoService {
    private final MedicoRepository medicoRepository;
        public UserDetails loadUserByUsername(String username) throws BadRequest {
        UserDetails o = medicoRepository.findByUsername(username);
        if(o==null){

        }
        return o;
    }
}
