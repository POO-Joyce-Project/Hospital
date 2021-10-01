package poo.trabalho.modal;

import java.util.Date;
import java.util.Random;

import poo.trabalho.controller.Principal;

public class Pessoa {

	private int id;
	private String nome;
	private char sexo;
	private Date dataNascimento;
	private String tipoSanguineo;
	private int cpf;

	public Pessoa(String nome, char sexo, Date dataNascimento, String tipoSanguineo, int cpf) {
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.tipoSanguineo = tipoSanguineo;
		this.cpf = cpf;
		
		this.id = generateId(); // Gerar ID aleat�rio.
	}

	public Pessoa() {
		this(null, '?', null, null, 0);
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

}
