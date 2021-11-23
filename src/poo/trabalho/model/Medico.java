package poo.trabalho.model;

import java.util.Date;

public class Medico extends Pessoa {

	private String crm;
	private String especialidade;

	// Inicializadores
	public Medico(String nome, String cpf, String sexo, Date dataNascimento, String tipoSanguineo, String especialidade, String crm) {
		super(nome, cpf, sexo, dataNascimento, tipoSanguineo);
		
		this.especialidade = especialidade;
		this.crm = crm;
	}

	public Medico() {
		this(null, null, null, null, null, null, null);
	}

	// Getters e setters
	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		
		sb.append("CRM: " + getCrm() + "\n");
		sb.append("Especialidade: " + getEspecialidade() + "\n");
		
		return sb.toString();
	}

}
