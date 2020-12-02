package com.saojudas.eventos.rest;

import com.saojudas.eventos.model.entity.Evento;
import com.saojudas.eventos.model.entity.Participante;
import com.saojudas.eventos.model.entity.model.repository.EventoRepository;
import com.saojudas.eventos.model.entity.model.repository.ParticipanteRepository;
import com.saojudas.eventos.rest.dto.ParticipantesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/participantes")
@RequiredArgsConstructor
public class ParticipantesController {


    private final EventoRepository eventorepository;
    private final ParticipanteRepository repository;

    @PostMapping
    public Participante salvar(@RequestBody ParticipantesDTO dto){

        //LocalDate data = LocalDate.parse(dto.getDataCadastro(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Integer idEvento= dto.getIdEvento();
        Evento evento =
                eventorepository.findById(idEvento)
                        .orElseThrow(() ->
                                new ResponseStatusException(
                                        HttpStatus.BAD_REQUEST,"Evento inesistente"));

        Participante participante = new Participante();
        participante.setNome(dto.getNome());
        participante.setEmail(dto.getEmail());
        participante.setCpf(dto.getCpf());
        participante.setSexo(dto.getSexo());
        //participante.setDataCadastro(data);
        participante.setEvento(evento);

        return  repository.save(participante);
    }



}
