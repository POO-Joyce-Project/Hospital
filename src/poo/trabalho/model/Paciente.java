package poo.trabalho.model;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

public class Paciente extends Pessoa {

	private List<Laudo> laudos;

	public Paciente(String nome, String cpf, String sexo, Date dataNascimento, String tipoSanguineo, List<Laudo> laudos) {
		super(nome, cpf, sexo, dataNascimento, tipoSanguineo);

		this.laudos = laudos;
	}

	public Paciente() {
		this(null, null, null, null, null, null);
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

		sb.append("Ficha medica: \n");
		sb.append(infoLaudos());

		return sb.toString();
	}

	private String infoLaudos() {
		StringBuilder sb = new StringBuilder();

		if (laudos == null || laudos.isEmpty()) {
			sb.append("N/A");
		} else {
			int count = 1;

			for (Laudo laudo : laudos) {
				sb.append("  Laudo " + count + ":\n");
				sb.append("    - Diagnostico: " + laudo.getDiagnostico() + "\n");
				sb.append("    - Sintomas: " + laudo.getSintomas() + "\n");
				sb.append("    - Medicacao regular: " + laudo.getMedicacaoRegular() + "\n");
				sb.append("    - Observacao: " + laudo.getObservacao() + "\n");
				sb.append("    - Medico responsavel: " + laudo.getMedico().getNome() + "\n");

				count++;
			}
		}

		return sb.toString();
	}

}
