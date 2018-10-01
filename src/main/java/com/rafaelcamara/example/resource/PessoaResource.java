package com.rafaelcamara.example.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelcamara.example.domain.Pessoa;
import com.rafaelcamara.example.service.PessoaService;

@RestController
@RequestMapping(value="/rest")
public class PessoaResource {
	
	@Autowired
	private PessoaService service;
	
	@RequestMapping(value= "/pessoa/{pCPF}", method=RequestMethod.GET)
	public ResponseEntity<Pessoa> consultarPorChavePrimaria (@PathVariable String pCPF) {
		if(pCPF != null) {
			Pessoa pessoa = service.consultarPorChavePrimaria(pCPF);
			return ResponseEntity.ok().body(pessoa);
		}else {
			return ResponseEntity.badRequest().build();
		}	
	}
	
	@RequestMapping(value= "/pessoas", method=RequestMethod.GET)
	public ResponseEntity<List<Pessoa>> consultar () {
		List<Pessoa> pessoas = service.consultar();
		return ResponseEntity.ok().body(pessoas);
	}
	
	@RequestMapping(value= "/pessoa/save/{pCPF}", method=RequestMethod.POST)	
	public ResponseEntity <Void> save (@PathVariable String pCPF,
										@RequestBody Pessoa pPessoa) {
		Pessoa pessoa = pPessoa;
		pessoa.setCpf(pCPF);
		service.save(pessoa);
		return ResponseEntity.noContent().build();
		
	}	
	
	@RequestMapping(value= "/pessoa/remove/{pCPF}", method=RequestMethod.DELETE)	
	public ResponseEntity <Void> remove (@PathVariable String pCPF) {
		boolean retorno = service.delete(pCPF);
		if(retorno) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
		
	}	

}
