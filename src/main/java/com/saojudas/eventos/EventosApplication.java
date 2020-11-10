package com.saojudas.eventos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventosApplication {

    //classe de inicialização do spring tudo apartir desse contexto sera inicializado no spring
    public static void main(String[] args) {

        SpringApplication.run(EventosApplication.class,args);

    }

}
