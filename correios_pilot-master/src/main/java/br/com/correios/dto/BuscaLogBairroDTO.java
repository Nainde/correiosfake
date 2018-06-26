package br.com.correios.dto;

public class BuscaLogBairroDTO {

	private String nomeLogradouro;
	private String bairroDistrito;
	private String LocalidadeUf;
	private String cep;
	
	// ctlr+3 gcuf passa direto para o construtor
	public BuscaLogBairroDTO(String nomeLogradouro, String bairroDistrito, String localidadeUf, String cep) {
		this.nomeLogradouro = nomeLogradouro;
		this.bairroDistrito = bairroDistrito;
		LocalidadeUf = localidadeUf;
		this.cep = cep;
	}
	public String getNomeLogradouro() {
		return nomeLogradouro;
	}
	public void setNomeLogradouro(String nomeLogradouro) {
		this.nomeLogradouro = nomeLogradouro;
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
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	
}