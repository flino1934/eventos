package com.saojudas.eventos.rest.exception;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class Apierrors {

    @Getter
    List<String> errors;

    public Apierrors(List<String> errors) {
        this.errors = errors;
    }

    public Apierrors(String message) {

        this.errors = Arrays.asList(message);

    }
}
