package com.saojudas.eventos.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantesDTO {

    private String nome;
    private String email;
    private String cpf;
    private String sexo;
    private Integer idEvento;

}
