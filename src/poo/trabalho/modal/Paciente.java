package poo.trabalho.modal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Paciente extends Pessoa {

	private List<Laudo> laudos;

	public Paciente(String nome, char sexo, Date dataNascimento, String tipoSanguineo, int cpf, List<Laudo> laudos) {
		super(nome, sexo, dataNascimento, tipoSanguineo, cpf);

		this.laudos = laudos;
	}

	public Paciente() {
		this(null, '?', null, null, 0, null);
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
