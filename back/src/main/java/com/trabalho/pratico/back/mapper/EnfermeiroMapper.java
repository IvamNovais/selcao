package com.trabalho.pratico.back.mapper;

import com.trabalho.pratico.back.models.Enfermeiro;
import com.trabalho.pratico.back.requests.EnfermeiroPostRequestBody;
import com.trabalho.pratico.back.requests.EnfermeiroPutRequestBody;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class EnfermeiroMapper {
    public static final EnfermeiroMapper INSTANCE = Mappers.getMapper(EnfermeiroMapper.class);
    public abstract Enfermeiro toEnfermeiro(EnfermeiroPostRequestBody enfermeiroPostRequestBody);
    public abstract Enfermeiro toEnfermeiro(EnfermeiroPutRequestBody enfermeiroPutRequestBody);
}
