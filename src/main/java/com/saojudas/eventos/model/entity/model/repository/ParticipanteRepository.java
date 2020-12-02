package com.saojudas.eventos.model.entity.model.repository;

import com.saojudas.eventos.model.entity.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParticipanteRepository extends JpaRepository<Participante,Integer> {

//Criamos os repositories de participantes ele vai extender a interface JPARepositorie que tem varios metodos
//embutidos  para fazer um crud


}