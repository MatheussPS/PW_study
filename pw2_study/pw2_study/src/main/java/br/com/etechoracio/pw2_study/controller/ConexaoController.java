//Matheus Pinter e Paulo Sergio

package br.com.etechoracio.pw2_study.controller;

import br.com.etechoracio.pw2_study.entity.Conexao;
import br.com.etechoracio.pw2_study.service.ConexaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(description = "Endpoint criado para gerenciar as conexões na aplicação", name = "Conexões")
@RestController
@RequestMapping("/conexoes")
public class ConexaoController {

    private final ConexaoService conexaoService;


    public ConexaoController(ConexaoService conexaoService) {
        this.conexaoService = conexaoService;
    }

    @Operation(summary = "Exibe o total as conexões")
    @GetMapping(path = "/find")
    public ResponseEntity<String> getAllConexoes(){
        return ResponseEntity.status(HttpStatus.OK).body("Total de "+ conexaoService.getAllConexoes()+ " conexões");
    }

}
