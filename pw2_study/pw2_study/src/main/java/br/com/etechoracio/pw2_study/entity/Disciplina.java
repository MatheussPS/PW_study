package br.com.etechoracio.pw2_study.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//Matheus Pinter e Paulo Sergio
@Getter
@Setter
@Entity
@Table(name = "TBL_DISCIPLINA")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DISCIPLINA")
    private Long idDiscplina;

    @Column(name = "TX_NOME")
    private String txNome;
}
