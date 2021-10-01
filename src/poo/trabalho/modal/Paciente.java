package poo.trabalho.modal;

import java.util.Date;

public class Paciente extends Pessoa {

	private FichaMedica fichaMedica;

	public Paciente(String nome, Endereco endereco, char sexo, Date dataNascimento, int cpf, FichaMedica fichaMedica) {
		super(nome, endereco, sexo, dataNascimento, cpf);

		this.fichaMedica = fichaMedica;
	}

	public Paciente() {
		this(null, null, '?', null, 0,  null);
	}

	public FichaMedica getFichaMedica() {
		return fichaMedica;
	}

	public void setFichaMedica(FichaMedica fichaMedica) {
		this.fichaMedica = fichaMedica;
	}

}
