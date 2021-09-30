package poo.trabalho.modal;

public class FichaMedica {

	private String nome;
	private String observacao;
	private String tipoSanguineo;
	private String medicacaoRegular;
	private float altura;
	private float peso;

	// Inicializadores
	public FichaMedica(String nome, String observacao, String tipoSanguineo, String medicacaoRegular, float altura, float peso) {
		this.nome = nome;
		this.observacao = observacao;
		this.tipoSanguineo = tipoSanguineo;
		this.medicacaoRegular = medicacaoRegular;
		this.altura = altura;
		this.peso = peso;
	}

	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public String getMedicacaoRegular() {
		return medicacaoRegular;
	}

	public void setMedicacaoRegular(String medicacaoRegular) {
		this.medicacaoRegular = medicacaoRegular;
	}

	public Float getAltura() {
		return altura;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

}
