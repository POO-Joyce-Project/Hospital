package poo.trabalho.modal;

import java.util.Date;

public class Paciente extends Pessoa {
	
	private Pessoa pessoa;
	private FichaMedica fichaMedica;

	public Paciente(String nome, String endereco, char sexo, Date dataNascimento, Pessoa pessoa, FichaMedica fichaMedica) {
		super(nome, endereco, sexo, dataNascimento);
		
		this.pessoa = pessoa;
		this.fichaMedica = fichaMedica;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public FichaMedica getFichaMedica() {
		return fichaMedica;
	}

	public void setFichaMedica(FichaMedica fichaMedica) {
		this.fichaMedica = fichaMedica;
	}
	
}
