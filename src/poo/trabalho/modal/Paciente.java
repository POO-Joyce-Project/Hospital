package poo.trabalho.modal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Paciente extends Pessoa {

	private List<Laudo> laudos;

	public Paciente(String nome, char sexo, Date dataNascimento, int cpf, FichaMedica fichaMedica) {
		super(nome, sexo, dataNascimento, cpf);

		this.laudos = laudos;
	}

	public Paciente() {
		this(null, '?', null, null, null);
	}

	public List<Laudo> getLaudos() {
		return laudos;
	}

	public void adicionarLaudo(Laudo laudo) {
		if (getLaudos() == null)
			this.laudos = new ArrayList<>();
		
		this.laudos.add(laudo);
	}
	
	@Override
	public String toString() {
		
		return super.toString();
	}

}
