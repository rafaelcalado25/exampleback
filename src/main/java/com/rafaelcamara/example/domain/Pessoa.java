package com.rafaelcamara.example.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.rafaelcamara.example.domain.enu.TipoLogradouro;
@Entity
public class Pessoa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	private String cpf;
	
	@Column(nullable=false)
	private String nome;

	private Integer tipoLogradouro;
	
	private String logradouro;
	
	private Integer numero;
	
	private String bairro;
	
	private String cidade;
	
	private String estado;
	
	private String telefoneCelular;
	
	private String telefoneFixo;
	
	public Pessoa() {
		
	}

	

	public Pessoa(String cpf, String nome, Integer tipoLogradouro, String logradouro, Integer numero,
			String bairro, String cidade, String estado, String telefoneCelular, String telefoneFixo) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.tipoLogradouro = tipoLogradouro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.telefoneCelular = telefoneCelular;
		this.telefoneFixo = telefoneFixo;
	}


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public TipoLogradouro getTipoLogradouro() {
		return TipoLogradouro.toEnum(tipoLogradouro);
	}



	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro.getCod();
	}



	public String getLogradouro() {
		return logradouro;
	}



	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}



	public Integer getNumero() {
		return numero;
	}



	public void setNumero(Integer numero) {
		this.numero = numero;
	}



	public String getBairro() {
		return bairro;
	}



	public void setBairro(String bairro) {
		this.bairro = bairro;
	}



	public String getCidade() {
		return cidade;
	}



	public void setCidade(String cidade) {
		this.cidade = cidade;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getTelefoneCelular() {
		return telefoneCelular;
	}



	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}



	public String getTelefoneFixo() {
		return telefoneFixo;
	}



	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Pessoa [cpf=" + cpf + ", nome=" + nome + ", tipoLogradouro=" + tipoLogradouro + ", logradouro="
				+ logradouro + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado
				+ ", telefoneCelular=" + telefoneCelular + ", telefoneFixo=" + telefoneFixo + "]";
	}	

}
