//Matheus Pinter e Paulo Sergio

package br.com.etechoracio.pw2_study.infra;

import br.com.etechoracio.pw2_study.dtos.ExceptionsDto;
import br.com.etechoracio.pw2_study.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExcepitonsHandler {

    @ExceptionHandler(DisciplinaAlreadyExistsException.class)
    private ResponseEntity<ExceptionsDto> disciplinaAlreadyExistsHandler(DisciplinaAlreadyExistsException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionsDto(HttpStatus.BAD_REQUEST, e.getMessage()));
    }

    @ExceptionHandler(DisciplinaNotFoundException.class)
    private ResponseEntity<ExceptionsDto> disciplinaNotFoundHandler(DisciplinaNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionsDto(HttpStatus.NOT_FOUND, e.getMessage()));
    }

    @ExceptionHandler(MonitorIsInDisciplinaException.class)
    private ResponseEntity<ExceptionsDto> monitorIsInDisciplinaException(MonitorIsInDisciplinaException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionsDto(HttpStatus.BAD_REQUEST, e.getMessage()));
    }

    @ExceptionHandler(MonitorWhatsappAlreadyExists.class)
    private ResponseEntity<ExceptionsDto> monitorWhatsappAlreadyExistsHandler(MonitorWhatsappAlreadyExists e){
        var mensagem = e.getMessage();
        var status = HttpStatus.BAD_REQUEST
        return ResponseEntity.status(status).body(new ExceptionsDto(status, mensagem));
    }

    @ExceptionHandler(MonitorEmailAlreadyExists.class)
    private ResponseEntity<ExceptionsDto> monitorEmailAlreadyExistsHandler(MonitorEmailAlreadyExists e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionsDto(HttpStatus.BAD_REQUEST, e.getMessage()));
    }
}
