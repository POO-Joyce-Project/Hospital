package poo.trabalho.model;

import java.util.ArrayList;
import java.util.List;

public class Hospital {

	private final String nome;
	private final List<Medico> medicos;
	private final List<Paciente> pacientes;

	public Hospital() {
		this.nome = "Anchieta";
		this.medicos = new ArrayList<>();
		this.pacientes = new ArrayList<>();
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

}
