//Matheus Pinter e Paulo Sergio

package br.com.etechoracio.pw2_study.exception;

public class MonitorWhatsappAlreadyExists extends RuntimeException{

    public MonitorWhatsappAlreadyExists() {
        super("Este WhatsApp já está cadastrado!!");
    }
}
