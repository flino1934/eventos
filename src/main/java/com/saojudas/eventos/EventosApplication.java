package com.saojudas.eventos;

import com.saojudas.eventos.model.entity.Evento;
import com.saojudas.eventos.model.entity.model.repository.EventoRepository;
import org.h2.command.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class EventosApplication {

//    @Bean
//    public CommandLineRunner run(@Autowired EventoRepository repository){
//        return args -> {
//            Evento evento = Evento.builder().nome("Banca").descricao("Dia que vamos sofrer").build();
//            repository.save(evento);
//        };
//    }

    //classe de inicialização do spring tudo apartir desse contexto sera inicializado no spring
    public static void main(String[] args) {

        SpringApplication.run(EventosApplication.class,args);

    }

}
