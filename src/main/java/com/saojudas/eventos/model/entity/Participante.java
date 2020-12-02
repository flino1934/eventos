package com.saojudas.eventos.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data//tras o getter setter to string entre outros
public class Participante {//esta classe é responsavel pela entidade participante

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//vai gerar uma chave auto incremento
    private Integer id;
    @Column(nullable = false,length = 150)
    private String nome;
    @Column(nullable = false,length = 150)
    private String email;
    @Column(nullable = false,length = 11)
    @CPF
    private String cpf;
    @Column(length = 11)
    private String sexo;
    @Column(name = "data_cadastro")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @ManyToOne
    @JoinColumn(name = "id_evento")// 1 evento varios participantes no banco de dados vai ter uma coluna com o id do evento FK
    private Evento evento;

    @PrePersist
    public void prePersis(){
        setDataCadastro(LocalDate.now());
    }

}
