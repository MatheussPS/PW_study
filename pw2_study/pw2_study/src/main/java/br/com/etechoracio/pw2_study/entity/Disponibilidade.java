package br.com.etechoracio.pw2_study.entity;

//Matheus Pinter e Paulo Sergio

import br.com.etechoracio.pw2_study.enums.DiaSemanaEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "TBL_DISPONIBILIDADE")
public class Disponibilidade {

    @Id
    @Column(name = "ID_DISPONIBILIDADE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDisponibilidade;

    @Column(name = "TX_DIA_SEMANA")
    @Enumerated(EnumType.STRING)
    private DiaSemanaEnum txDiaSemana;

    @Column(name = "DT_DAS")
    private LocalDateTime dtDas;

    @Column(name = "DT_ATE")
    private LocalDateTime dtAte;

    @JoinTable(name = "TBL_REL_MONITOR_DISPONIBILIDADE",
            joinColumns = @JoinColumn(name = "ID_MONITOR"),
            inverseJoinColumns = @JoinColumn(name = "ID_DISPONIBILIDADE")
    )
    @ManyToMany
    private List<Monitor> monitores;


}
