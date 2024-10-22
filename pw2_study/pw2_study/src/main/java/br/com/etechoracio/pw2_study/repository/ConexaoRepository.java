//Matheus Pinter e Paulo Sergio

package br.com.etechoracio.pw2_study.repository;

import br.com.etechoracio.pw2_study.entity.Conexao;
import br.com.etechoracio.pw2_study.entity.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConexaoRepository extends JpaRepository<Conexao, Long> {
    Optional<Conexao> findByMonitor(Monitor monitor);

}
