package com.rafaelcamara.example.domain.enu;

public enum TipoLogradouro {
	
	RUA(1, "Rua"),
	AVENIDA(2, "Avenida");
	
	private int cod;
	private String descricao;
	
	private TipoLogradouro(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static TipoLogradouro toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoLogradouro x : TipoLogradouro.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
