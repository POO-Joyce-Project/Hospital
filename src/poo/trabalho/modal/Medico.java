package poo.trabalho.modal;

import java.util.Date;

public class Medico extends Pessoa {

	private String crm;
	private String especialidade;

	// Inicializadores
	public Medico(String nome, String cpf, char sexo, Date dataNascimento, String tipoSanguineo, String crm, String especialidade) {
		super(nome, cpf, sexo, dataNascimento, tipoSanguineo);
		
		this.crm = crm;
		this.especialidade = especialidade;
	}

	public Medico() {
		this(null, null, '?', null, null, null, null);
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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		
		sb.append("CRM: " + getCrm() + "\n");
		sb.append("Especialidade: " + getEspecialidade() + "\n");
		
		return sb.toString();
	}

}
