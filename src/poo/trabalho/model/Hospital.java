package poo.trabalho.model;

import java.util.ArrayList;
import java.util.List;

public class Hospital {

	private String nome;
	private List<Medico> medicos;
	private List<Paciente> pacientes;
	private List<Laudo> laudos;

	public Hospital() {
		this.nome = "Anchieta";
		this.medicos = new ArrayList<>();
		this.pacientes = new ArrayList<>();
		this.laudos = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}
	
	public List<Laudo> getLaudos() {
		return laudos;
	}

}
