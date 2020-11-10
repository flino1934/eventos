package com.saojudas.eventos.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data//tras o getter setter to string entre outros
public class Evento {//esta classe é responsavel pela entidade evento

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//vai gerar uma chave auto incremento
    private  Integer id;
    @Column(nullable = false,length = 150)
    private String nome;
    @Column(nullable = false,length = 150)
    private String descricao;
    @Column(name = "data_cadastro")
    private Date dataCadastro;

}
