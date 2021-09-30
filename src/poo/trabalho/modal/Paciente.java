package poo.trabalho.modal;

import java.util.Date;

public class Paciente extends Pessoa {
	
	private FichaMedica fichaMedica;

	public Paciente(String nome, String endereco, char sexo, Date dataNascimento, FichaMedica fichaMedica) {
		super(nome, endereco, sexo, dataNascimento);
		

		this.fichaMedica = fichaMedica;
	}


	public FichaMedica getFichaMedica() {
		return fichaMedica;
	}

	public void setFichaMedica(FichaMedica fichaMedica) {
		this.fichaMedica = fichaMedica;
	}
	
}
