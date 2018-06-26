package br.com.correios.dto;

public class BairroDTO {

	private String bairroDistrito;
	private String LocalidadeUf;
	
	// ctlr+3 gcuf passa direto para o construtor
	public BairroDTO(String bairroDistrito, String localidadeUf, String cep) {
		this.bairroDistrito = bairroDistrito;
		LocalidadeUf = localidadeUf;
	}
	public String getBairroDistrito() {
		return bairroDistrito;
	}
	public void setBairroDistrito(String bairroDistrito) {
		this.bairroDistrito = bairroDistrito;
	}
	public String getLocalidadeUf() {
		return LocalidadeUf;
	}
	public void setLocalidadeUf(String localidadeUf) {
		LocalidadeUf = localidadeUf;
	}

	
}
