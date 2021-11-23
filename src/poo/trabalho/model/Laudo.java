package poo.trabalho.model;

public class Laudo {

	private int id;
	private String observacao;
	private String medicacaoRegular;
	private String sintomas;
	private String diagnostico;
	private Paciente paciente;
	private Medico medico;

	// Inicializadores
	public Laudo(int id, String observacao, String medicacaoRegular, String sintomas, String diagnostico, Paciente paciente, Medico medico) {
		this.id = id;
		this.observacao = observacao;
		this.medicacaoRegular = medicacaoRegular;
		this.sintomas = sintomas;
		this.diagnostico = diagnostico;
		this.paciente = paciente;
		this.medico = medico;
	}

	public Laudo() {
		this(0, null, null, null, null, null, null);
	}

	// Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getMedicacaoRegular() {
		return medicacaoRegular;
	}

	public void setMedicacaoRegular(String medicacaoRegular) {
		this.medicacaoRegular = medicacaoRegular;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("    - Diagnostico: " + getDiagnostico() + "\n");
		sb.append("    - Sintomas: " + getSintomas() + "\n");
		sb.append("    - Medicacao regular: " + getMedicacaoRegular() + "\n");
		sb.append("    - Observacao: " + getObservacao() + "\n");
		sb.append("    - Medico responsavel: " + getMedico().getNome() + "\n");

		return sb.toString();
	}

}
