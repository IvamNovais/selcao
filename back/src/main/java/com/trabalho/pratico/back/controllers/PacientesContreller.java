package com.trabalho.pratico.back.controllers;

import java.util.List;

import com.trabalho.pratico.back.models.Paciente;
import com.trabalho.pratico.back.requests.PacientePostRequestBody;
import com.trabalho.pratico.back.requests.PacientePutRequestBody;
import com.trabalho.pratico.back.services.PacienteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController()
@RequiredArgsConstructor
public class PacientesContreller {
    private final PacienteService service;
    @GetMapping
    public List<Paciente> list(){
        return service.getPacientes();
    }
    @GetMapping(path = "/{id}")
    public Paciente find(@PathVariable long id){
        return service.findPacienteOrThrowsBadRequest(id);
    }
    @PostMapping
    public ResponseEntity<Paciente> save(@RequestBody PacientePostRequestBody pacientePostRequestBody){
        return new ResponseEntity<>(service.savePaciente(pacientePostRequestBody), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Paciente> update(@RequestBody PacientePutRequestBody pacientePutRequestBody){
        return new ResponseEntity<>(service.updatePaciente(pacientePutRequestBody), HttpStatus.OK);
    }
}
