//Matheus Pinter e Paulo Sergio

package br.com.etechoracio.pw2_study.infra;

import br.com.etechoracio.pw2_study.exception.DisciplinaAlreadyExistsException;
import br.com.etechoracio.pw2_study.exception.DisciplinaNotFoundException;
import br.com.etechoracio.pw2_study.exception.MonitorIsInDisciplinaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExcepitonsHandler {

    @ExceptionHandler(DisciplinaAlreadyExistsException.class)
    private ResponseEntity<String> disciplinaAlreadyExistsHandler(DisciplinaAlreadyExistsException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(DisciplinaNotFoundException.class)
    private ResponseEntity<String> disciplinaNotFoundHandler(DisciplinaNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(MonitorIsInDisciplinaException.class)
    private ResponseEntity<String> monitorIsInDisciplinaException(MonitorIsInDisciplinaException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
