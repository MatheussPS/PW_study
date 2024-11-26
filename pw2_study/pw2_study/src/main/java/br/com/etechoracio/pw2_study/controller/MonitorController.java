//Matheus Pinter e Paulo Sergio

package br.com.etechoracio.pw2_study.controller;

import br.com.etechoracio.pw2_study.entity.Monitor;
import br.com.etechoracio.pw2_study.service.MonitorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(description = "Endpoint criado para gerenciar os monitores na aplicação", name = "Monitores")
@RestController
@RequestMapping("/monitor")
public class MonitorController {

    @Autowired
    private MonitorService monitorService;

    @Operation(summary = "Adiciona um monitor")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "OK"))
    @PostMapping(path = "/postar")
    public ResponseEntity<String> cadastrarMonitor(@RequestBody Monitor monitor){
        monitorService.cadastrarMonitor(monitor);
        return ResponseEntity.status(HttpStatus.OK).body("Monitor cadastrado!!!!");
    }


}
