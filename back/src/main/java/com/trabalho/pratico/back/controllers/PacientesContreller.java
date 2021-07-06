package com.trabalho.pratico.back.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("test")
public class PacientesContreller {
    
    @GetMapping
    public String teste(){
        return "its work";
    }
}
