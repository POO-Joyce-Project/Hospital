package poo.trabalho.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Pessoa {

	private String nome;
	private String cpf;
	private String sexo;
	private Date dataNascimento;
	private String tipoSanguineo;

	public Pessoa(String nome, String cpf, String sexo, Date dataNascimento, String tipoSanguineo) {
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.tipoSanguineo = tipoSanguineo;
	}

	public Pessoa() {
		this(null, null, null, null, null);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateFormatted = sdf.format(dataNascimento);
		
		sb.append("Nome: " + getNome() + "\n");
		sb.append("CPF: " + getCpf() + "\n");
		sb.append("Genero: " + getSexo() + "\n");
		sb.append("Data de nascimento: " + dateFormatted  + "\n");
		sb.append("Tipo sanguineo: " + getTipoSanguineo() + "\n");
		
		return sb.toString();
	}

}
