package com.trabalho.pratico.back.controllers;

import java.util.List;

import com.trabalho.pratico.back.models.Enfermeiro;
import com.trabalho.pratico.back.requests.EnfermeiroPostRequestBody;
import com.trabalho.pratico.back.requests.EnfermeiroPutRequestBody;
import com.trabalho.pratico.back.services.EnfermeiroService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController()
@RequestMapping("enfermeiro")
@RequiredArgsConstructor
public class EnfermeiroContrller {
    private final EnfermeiroService service;
    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Enfermeiro> list(){
        return service.getEnfermeiros();
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/{id}")
    public Enfermeiro find(@PathVariable long id){
        return service.findEnfermeiroOrThrowsBadRequest(id);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<Enfermeiro> save(@RequestBody EnfermeiroPostRequestBody enfermeiroPostRequestBody){
        return new ResponseEntity<>(service.saveEnfermeiro(enfermeiroPostRequestBody), HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping
    public ResponseEntity<Enfermeiro> update(@RequestBody EnfermeiroPutRequestBody enfermeiroPutRequestBody){
        return new ResponseEntity<>(service.updateEnfermeiro(enfermeiroPutRequestBody), HttpStatus.OK);
    }
}
