package com.saojudas.eventos.rest;

import com.saojudas.eventos.model.entity.Evento;
import com.saojudas.eventos.model.entity.model.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;


@RestController//faz esse controlador ser um REST
@RequestMapping("/api/eventos")//URL base de dentro desse controller
@CrossOrigin("http://localhost:4200")
public class EventoController {


    private final EventoRepository repository;

    @Autowired
    public EventoController(EventoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Evento>obterTodos(){
        return repository.findAll();
    }

    @PostMapping//Para quando fizer uma solicitação post sera chamado diretamente esse metodo.
    @ResponseStatus(HttpStatus.CREATED)//se tudo ocorrer com sucesso vai retornar o status CREATED
    public Evento salvar(@RequestBody @Valid Evento evento){//Indica que vai receber uma requesição passando os parametros
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
                orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Evento não encontrado"));
//vai pesquisar pelo id se encontrar vai armazenar dentro do map e deletar, o map esta encontrando um obj do tipo evento

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//é uma resposta que foi bem sucedida em cache o usuario não precisa sair da pagina e
    public void atualizar( @PathVariable Integer id, @RequestBody @Valid Evento eventoAtualizado){//vai passar o usuario atualizado pelo http
        repository
                .findById(id)
                .map(evento ->{
                    eventoAtualizado.setId(evento.getId());
                    return repository.save(eventoAtualizado);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Evento não encontrado"));//caso não encontre vai retornar um erro

    }

}
