package br.com.etechoracio.pw2_study.service;

import br.com.etechoracio.pw2_study.dtos.UpdateDisciplinaDto;
import br.com.etechoracio.pw2_study.entity.Disciplina;
import br.com.etechoracio.pw2_study.exception.DisciplinaAlreadyExistsException;
import br.com.etechoracio.pw2_study.exception.DisciplinaNotFoundException;
import br.com.etechoracio.pw2_study.exception.MonitorIsInDisciplinaException;
import br.com.etechoracio.pw2_study.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;
    private final MonitorService monitorService;

    @Autowired
    public DisciplinaService(DisciplinaRepository disciplinaRepository, MonitorService monitorService) {
        this.disciplinaRepository = disciplinaRepository;
        this.monitorService = monitorService;
    }


    public List<Disciplina> findAllDisciplinas(){
        return disciplinaRepository.findAll();
    }

    public Disciplina getDisciplinaById(Long id){
        return disciplinaRepository.findById(id).orElseThrow(DisciplinaNotFoundException::new);
    }

    public Disciplina postDisiciplina(Disciplina model){
        var optionalValidation = disciplinaRepository.findByTxNome(model.getTxNome());
        if(optionalValidation.isPresent()) throw new DisciplinaAlreadyExistsException();

        disciplinaRepository.save(model);
        return model;
    }

    public void deleteDisciplinaById(Long id){
        var disciplina = getDisciplinaById(id); // if it doesn't exist, throws exception
        var isMonitorPresent = monitorService.findByDisicplinaID(disciplina);

        if (isMonitorPresent) throw new MonitorIsInDisciplinaException();


        disciplinaRepository.deleteById(id);
    }

    public Disciplina updateDisciplinaById(Long id, UpdateDisciplinaDto model){

        var doesNameExist = disciplinaRepository.findByTxNome(model.nome()).isPresent();
        if(doesNameExist){
            throw new DisciplinaAlreadyExistsException();
        }

        var disciplina = getDisciplinaById(id);
        disciplina.setTxNome(model.nome());

        return disciplinaRepository.save(disciplina);
    }

}
