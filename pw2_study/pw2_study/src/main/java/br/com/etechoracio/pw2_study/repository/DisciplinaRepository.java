//Matheus Pinter e Paulo Sergio

package br.com.etechoracio.pw2_study.repository;

import br.com.etechoracio.pw2_study.entity.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{

    public Optional<Disciplina> findByTxNome(String name);

}
