package br.com.cep.model;

import javax.persistence.*;

@Entity
@Table(name = "TCep")
public class Cep {

	public Cep() {
	}

	@Id
	@Column(name = "CEP", length = 10, nullable = false)
	private String cep;

	@Column(name = "LOGRADOURO", length = 255, nullable = false)
	private String logradouro;

	@Column(name = "COMPLEMENTO", length = 255, nullable = true)
	private String complemento;

	@Column(name = "BAIRRO", length = 50, nullable = true)
	private String bairro;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ibge", nullable=false)
	private Cidade cidade;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
}
