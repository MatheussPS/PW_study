package br.com.etechoracio.pw2_study.entity;

//Matheus Pinter e Paulo Sergio

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_MONITOR")
public class Monitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MONITOR")
    private Long idMonitor;

    @Column(name = "TX_NOME")
    private String nome;

    @Column(name = "TX_FOTO")
    private String foto;

    @Column(name = "TX_WHATSAPP")
    private String whatsapp;

    @Column(name = "TX_EMAIL")
    private String email;

    @Column(name = "TX_CONTEUDO")
    private String conteudo;

    @JoinColumn(name = "ID_DISCIPLINA")
    @ManyToOne
    private Disciplina idDisciplina;

}
