package com.saojudas.eventos.rest;




import com.saojudas.eventos.rest.exception.Apierrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {//vai fazer o tratamento de erro da nossa api toda vez que ele receber um erro ele vai interceptar e tratar um erro especifico

    @ExceptionHandler(MethodArgumentNotValidException.class)//atraves da anotação vai capturar o erro
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Apierrors handlerValidationErrors(MethodArgumentNotValidException ex){

        BindingResult bindingResult = ex.getBindingResult();//tem todas as msgs derro
        List<String> messages = bindingResult.getAllErrors()
                .stream()
                .map( objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList() );// vai transformar os erros gerados em uma lista retornando

        return new Apierrors(messages);

    }

    //tratamento de erro ResponseStatusException
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity handleResponseStatusException(ResponseStatusException ex){

        String messagemErro = ex.getMessage();
        HttpStatus codigoStatus = ex.getStatus();
        Apierrors apierrors = new Apierrors(messagemErro);//na classe Apierrors vai transformar em uma lista de erros
        return new ResponseEntity(apierrors,codigoStatus);


    }


}
