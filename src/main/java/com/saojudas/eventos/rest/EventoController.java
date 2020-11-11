package com.saojudas.eventos.rest;

import com.saojudas.eventos.model.entity.Evento;
import com.saojudas.eventos.model.entity.model.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController//faz esse controlador ser um REST
@RequestMapping("/api/eventos")//URL base de dentro desse controller
public class EventoController {


    private final EventoRepository repository;

    @Autowired
    public EventoController(EventoRepository repository) {
        this.repository = repository;
    }

    @PostMapping//Para quando fizer uma solicitação post sera chamado diretamente esse metodo.
    @ResponseStatus(HttpStatus.CREATED)//se tudo ocorrer com sucesso vai retornar o status CREATED
    public Evento salvar(@RequestBody Evento evento){//Indica que vai receber uma requesição passando os parametros
        return repository.save(evento);
    }

    @GetMapping("{id}")//esta mapeado para o metodo http get
    public Evento acharPorId( @PathVariable Integer id){

       return repository
               .findById(id).
               orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
       //vai fazer uma pesquisa por id se não ele vai retornar um codigo 404
    }

    @DeleteMapping("{id}")//vai reponder o metodo delete http
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar (@PathVariable Integer id){

        repository
                .findById(id)
                .map(evento -> {
                    repository.delete(evento);
                    return Void.TYPE;
                }).
                orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//vai pesquisar pelo id se encontrar vai armazenar dentro do map e deletar, o map esta encontrando um obj do tipo evento

    }


}
