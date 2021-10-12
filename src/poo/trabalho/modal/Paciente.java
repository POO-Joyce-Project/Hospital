package poo.trabalho.modal;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import poo.trabalho.view.LaudoView;

public class Paciente extends Pessoa {

	private List<Laudo> laudos;

	public Paciente(String nome, String cpf, char sexo, Date dataNascimento, String tipoSanguineo, List<Laudo> laudos) {
		super(nome, cpf, sexo, dataNascimento, tipoSanguineo);

		this.laudos = laudos;
	}

	public Paciente() {
		this(null, null, '?', null, null, null);
	}

	public List<Laudo> getLaudos() {
		return laudos;
	}

	public void adicionarLaudo(Laudo laudo) {
		if (laudo == null)
			return;
		
		if (getLaudos() == null)
			this.laudos = new ArrayList<>();
		
		this.laudos.add(laudo);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		
		sb.append("Ficha medica: ");
		LaudoView.infoLaudos(getLaudos());
		
		return sb.toString();
	}

}
