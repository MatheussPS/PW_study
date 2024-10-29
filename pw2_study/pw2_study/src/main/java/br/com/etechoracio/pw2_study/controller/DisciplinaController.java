//Matheus Pinter e Paulo Sergio

package br.com.etechoracio.pw2_study.controller;

import br.com.etechoracio.pw2_study.dtos.UpdateDisciplinaDto;
import br.com.etechoracio.pw2_study.entity.Disciplina;
import br.com.etechoracio.pw2_study.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping(path = "find/id/{id}")
    public ResponseEntity<Disciplina> getDisciplinaById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.getDisciplinaById(id));


    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Disciplina>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.findAllDisciplinas());
    }

    @PostMapping("/save")
    public ResponseEntity<Disciplina> save(@RequestBody Disciplina model){
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaService.postDisiciplina(model));
    }

    @DeleteMapping(path = "deletar/id/{id}")
    public ResponseEntity<String> deleteDisciplinaById(@PathVariable("id") Long id){
        disciplinaService.deleteDisciplinaById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Discplina deletada!");
    }

    @PutMapping(path = "update/id/{id}")
    public ResponseEntity<Disciplina> updateDisciplinaById(@PathVariable("id") Long id, @RequestBody UpdateDisciplinaDto nome){
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.updateDisciplinaById(id, nome));
    }

}
