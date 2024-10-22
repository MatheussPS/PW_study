//Matheus Pinter e Paulo Sergio

package br.com.etechoracio.pw2_study.exception;

public class MonitorEmailAlreadyExists extends RuntimeException{

    public MonitorEmailAlreadyExists() {
        super("Este email já está cadastrado!!!");
    }
}
