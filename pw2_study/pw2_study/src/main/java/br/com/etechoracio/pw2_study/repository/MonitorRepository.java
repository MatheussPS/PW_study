//Matheus Pinter e Paulo Sergio

package br.com.etechoracio.pw2_study.repository;

import br.com.etechoracio.pw2_study.entity.Disciplina;
import br.com.etechoracio.pw2_study.entity.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long> {

    Optional<Monitor> findByIdDisciplina(Disciplina idDisciplina);

    Optional<Monitor> findByWhatsapp(String whatsapp);

    Optional<Monitor> findByEmail(String email);

}
