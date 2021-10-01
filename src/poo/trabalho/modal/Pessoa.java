package poo.trabalho.modal;

import java.util.Date;
import java.util.Random;

import poo.trabalho.controller.Principal;

public class Pessoa {

	private int id;
	private String nome;
	private Endereco endereco;
	private char sexo;
	private Date dataNascimento;

	public Pessoa(String nome, Endereco endereco, char sexo, Date dataNascimento) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		
		this.id = generateId(); // Gerar ID aleatório.
	}

	public Pessoa() {
		this(null, null, '?', null);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		if (endereco == null)
			setEndereco(new Endereco(null, null));
		
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getId() {
		return id;
	}
	
	private int generateId() {
		int id = new Random().nextInt(1000);
		
		while (Principal.getHospital().consultarPaciente(id) != null) {
			id = new Random().nextInt(1000);
		}
		
		return id;
	}

}
