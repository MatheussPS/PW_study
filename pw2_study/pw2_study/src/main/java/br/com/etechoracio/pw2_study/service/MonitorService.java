//Matheus Pinter e Paulo Sergio

package br.com.etechoracio.pw2_study.service;

import br.com.etechoracio.pw2_study.entity.Disciplina;
import br.com.etechoracio.pw2_study.entity.Monitor;
import br.com.etechoracio.pw2_study.repository.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MonitorService {

    private final MonitorRepository monitorRepository;
    private final ConexaoService conexaoService;
    @Autowired
    public MonitorService(MonitorRepository monitorRepository, ConexaoService conexaoService) {
        this.monitorRepository = monitorRepository;
        this.conexaoService = conexaoService;
    }

    public Optional<Monitor> findById(Long id){
        return Optional.ofNullable(monitorRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    public Boolean findByDisicplinaID(Disciplina id){
        var monitor = monitorRepository.findByIdDisciplina(id);
        return monitor.isPresent();
    }

    public void deleteByMonitorId(Long id){
        var monitorIsPresent = findById(id);
        var isDisciplinaPresent = conexaoService.getConexaoByMonitor(monitorIsPresent);
    }
}
