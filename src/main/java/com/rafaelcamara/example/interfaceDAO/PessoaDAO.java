package com.rafaelcamara.example.interfaceDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rafaelcamara.example.domain.Pessoa;

@Repository
public interface PessoaDAO extends JpaRepository<Pessoa, String> {
	
	@Query("SELECT DISTINCT c from Pessoa as c where c.cpf=:cpf")
	Pessoa consultarPorChavePrimaria(@Param("cpf") String pCPF);

}
