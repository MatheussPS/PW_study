//Matheus Pinter e Paulo Sergio

package br.com.etechoracio.pw2_study.controller;

import br.com.etechoracio.pw2_study.dtos.UpdateDisciplinaDto;
import br.com.etechoracio.pw2_study.entity.Disciplina;
import br.com.etechoracio.pw2_study.service.DisciplinaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(description = "Endpoints criados para gerenciar as discinplinas na aplicação", name = "Discplinas")
@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @Operation(summary = "Lista discplina por id")
    @GetMapping(path = "find/id/{id}")
    public ResponseEntity<Disciplina> getDisciplinaById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.getDisciplinaById(id));


    }

    @Operation(summary = "Lista todas as disciplinas")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "OK"))
    @GetMapping("/findAll")
    public ResponseEntity<List<Disciplina>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.findAllDisciplinas());
    }

    @Operation(summary = "Adiciona uma disciplina")
    @PostMapping("/save")
    public ResponseEntity<Disciplina> save(@RequestBody Disciplina model){
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaService.postDisiciplina(model));
    }

    @Operation(summary = "Deleta uma disciplina por id")
    @DeleteMapping(path = "deletar/id/{id}")
    public ResponseEntity<String> deleteDisciplinaById(@PathVariable("id") Long id){
        disciplinaService.deleteDisciplinaById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Discplina deletada!");
    }

    @Operation(summary = "Atualiza uma disciplina por id")
    @PutMapping(path = "update/id/{id}")
    public ResponseEntity<Disciplina> updateDisciplinaById(@PathVariable("id") Long id, @RequestBody UpdateDisciplinaDto nome){
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.updateDisciplinaById(id, nome));
    }

}
