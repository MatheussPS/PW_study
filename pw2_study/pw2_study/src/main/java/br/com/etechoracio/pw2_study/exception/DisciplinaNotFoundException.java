package br.com.etechoracio.pw2_study.exception;

public class DisciplinaNotFoundException extends RuntimeException{

    public DisciplinaNotFoundException() {
        super("Disciplina não encontrada!");
    }
}
