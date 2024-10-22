//Matheus Pinter e Paulo Sergio

package br.com.etechoracio.pw2_study.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TBL_CONEXAO")
public class Conexao {
    @Id
    @Column(name = "ID_CONEXAO")
    private Long id;

    @Column(name = "DT_CRIACAO")
    private LocalDateTime criacao;

    @JoinColumn(name = "ID_MONITOR")
    @ManyToOne
    private Monitor monitor;


}
