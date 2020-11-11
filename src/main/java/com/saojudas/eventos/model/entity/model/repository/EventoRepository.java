package com.saojudas.eventos.model.entity.model.repository;

import com.saojudas.eventos.model.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento,Integer> {
//Criamos os repositories de participantes ele vai extender a interface JPARepositorie que tem varios metodos
//embutidos  para fazer um crud
}
