package com.rafaelcamara.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelcamara.example.domain.Pessoa;
import com.rafaelcamara.example.interfaceDAO.PessoaDAO;

@Service
public class PessoaService {
	
	@Autowired
	private  PessoaDAO dao;
	
	public Pessoa consultarPorChavePrimaria( String pCPF) {
		return dao.consultarPorChavePrimaria(pCPF);
	}
	
	public List<Pessoa> consultar(){
		return dao.findAll();
	}
	
	public void save(Pessoa pPessoa) {
		if(pPessoa.getCpf()!=null) {
			dao.save(pPessoa);
		}
	}
	
	public boolean delete (String pCpf) {
		Pessoa pessoa;
		if(pCpf != null) {
			pessoa = this.consultarPorChavePrimaria(pCpf);
			if(pessoa.getCpf()!=null) {
				dao.delete(pessoa);
				return true;
			} else {
				return false;
			}
		}else {
			return false;
		}
		
	}

}
