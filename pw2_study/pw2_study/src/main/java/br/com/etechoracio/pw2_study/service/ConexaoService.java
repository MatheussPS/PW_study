//Matheus Pinter e Paulo Sergio

package br.com.etechoracio.pw2_study.service;

import br.com.etechoracio.pw2_study.entity.Conexao;
import br.com.etechoracio.pw2_study.entity.Monitor;
import br.com.etechoracio.pw2_study.repository.ConexaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConexaoService {

    private final ConexaoRepository conexaoRepository;

    @Autowired
    public ConexaoService(ConexaoRepository conexaoRepository) {
        this.conexaoRepository = conexaoRepository;
    }

    public Integer getAllConexoes(){
        return conexaoRepository.findAll().size();
    }

    public Optional<Conexao> getConexaoByMonitor(Monitor monitor){
        return conexaoRepository.findByMonitor(monitor);
    }



}
