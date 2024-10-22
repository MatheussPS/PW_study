package br.com.etechoracio.pw2_study.exception;

public class DisciplinaAlreadyExistsException extends RuntimeException{
    public DisciplinaAlreadyExistsException() {
        super("Esta disciplina já existe!");
    }
}
