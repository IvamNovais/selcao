package com.trabalho.pratico.back.mapper;

import com.trabalho.pratico.back.models.Paciente;
import com.trabalho.pratico.back.requests.PacientePostRequestBody;
import com.trabalho.pratico.back.requests.PacientePutRequestBody;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class PacienteMapper {
    public static final PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);
    public abstract Paciente toPaciente(PacientePostRequestBody pacientePostRequestBody);
    public abstract Paciente toPaciente(PacientePutRequestBody pacientePutRequestBody);
}