package br.edu.facear.model;

public class Empregador {
	
	private Integer id;
	private String nome;
	private String email;
	private String cpf;
	private String celular;
	private String idade;
	private String sexo;
	private String cidade;
	private String senha;
	
//////////////////////////////////////////////////
	
	public Empregador(Integer id, String nome, String email, String cpf, String celular, String idade, String sexo,
			String cidade, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.celular = celular;
		this.idade = idade;
		this.sexo = sexo;
		this.cidade = cidade;
		this.senha = senha;
	}
	
	////////////////////////////////////////////
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
	

}
