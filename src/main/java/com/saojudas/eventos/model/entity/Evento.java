package com.saojudas.eventos.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data//tras o getter setter to string entre
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Evento {//esta classe é responsavel pela entidade evento

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//vai gerar uma chave auto incremento
    private  Integer id;

    @Column(nullable = false,length = 150)
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @Column(nullable = false,length = 150)
    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String descricao;

    @Column(name = "nome_lider_evento",nullable = false,length = 150)
    @NotEmpty(message = "{campo.nomeLiderEvento.obrigatorio}")
    private String nomeLiderEvento;

    @Column(nullable = false,length = 150)
    @NotEmpty(message = "{campo.endereco.obrigatorio}")
    private String endereco;

    @Column(name = "data_evento",nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataEvento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_cadastro",updatable = false)
    private LocalDate dataCadastro;

    @PrePersist
    public void prePersis(){
        setDataCadastro(LocalDate.now());
    }

}
