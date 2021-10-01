package poo.trabalho.modal;

public class Laudo {

	private String observacao;
	private String medicacaoRegular;
	private String sintomas;
	private String diagnostico;
	private Medico medicoResponsavel;

	// Inicializadores
	public Laudo(String observacao, String medicacaoRegular, String sintomas, String diagnostico, Medico medicoResponsavel) {
		this.observacao = observacao;
		this.medicacaoRegular = medicacaoRegular;
		this.sintomas = sintomas;
		this.diagnostico = diagnostico;
		this.medicoResponsavel = medicoResponsavel;
	}

	public Laudo() {
		this(null, null, null, null, null);
	}

	// Getters e Setters
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

	public Medico getMedicoResponsavel() {
		return medicoResponsavel;
	}

	public void setMedicoResponsavel(Medico medicoResponsavel) {
		this.medicoResponsavel = medicoResponsavel;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("   - Sintomas: " +  getSintomas() + "\n");
		sb.append("   - Observacao: " +  getObservacao() + "\n");
		sb.append("   - Medicacao regular: " + getMedicacaoRegular() + "\n");
		sb.append("   - Diagnostico: " + getDiagnostico() + "\n");
//		sb.append("   - Medico responsavel: " + getMedicoResponsavel().getNome() + "\n");
		
		return sb.toString();
	}

}
