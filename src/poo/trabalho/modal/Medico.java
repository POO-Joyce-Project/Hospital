package poo.trabalho.modal;

import java.util.Date;

import poo.trabalho.controller.Principal;

public class Medico extends Pessoa {

	private String crm;
	private String especialidade;

	// Inicializadores
	public Medico(String nome, Endereco endereco, char sexo, Date dataNascimento, int cpf, String crm, String especialidade) {
		super(nome, endereco, sexo, dataNascimento, cpf);
		
		this.crm = crm;
		this.especialidade = especialidade;
	}
	public Medico() { 
		this(null, null, '?', null, 0,  null, null);
	}

	// Getters e setters
	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	

}
