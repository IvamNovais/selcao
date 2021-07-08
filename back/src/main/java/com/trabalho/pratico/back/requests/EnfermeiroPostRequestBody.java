package com.trabalho.pratico.back.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class EnfermeiroPostRequestBody {
    private String username;
    private String cpf;
    private String password;
}
