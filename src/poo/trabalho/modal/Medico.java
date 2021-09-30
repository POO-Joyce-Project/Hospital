package poo.trabalho.modal;

public class Medico extends Pessoa{
	
	private String crm;
	private String especialidade;
	
	//Inicializador 
	public Medico(String crm, String especialidade) {
		super();
		this.crm = crm;
		this.especialidade = especialidade;
	}
	
	//Getters e setters
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
