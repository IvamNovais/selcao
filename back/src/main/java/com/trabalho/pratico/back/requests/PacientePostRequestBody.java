package com.trabalho.pratico.back.requests;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
@AllArgsConstructor
public class PacientePostRequestBody {
    private String nome;
    private String cpf;
    private Date nascimento;
    private String uf;
    private float peso;
    private float altura; 
}
