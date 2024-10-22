//Matheus Pinter e Paulo Sergio

package br.com.etechoracio.pw2_study.exception;

public class MonitorIsInDisciplinaException extends RuntimeException{

    public MonitorIsInDisciplinaException() {
        super("Não é possível deletar a disciplina, pois há um monitor atrelado a mesma");
    }
}
