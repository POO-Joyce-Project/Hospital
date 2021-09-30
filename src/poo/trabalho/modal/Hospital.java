package poo.trabalho.modal;

import java.util.List;

public class Hospital {

	private String nome;
	private Endereco endereco;
	private List<Medico> medicos;
	private List<Paciente> pacientes;
	
	public Hospital(String nome, Endereco endereco, List<Medico> medicos, List<Paciente> pacientes) {
		this.nome = nome;
		this.endereco = endereco;
		this.medicos = medicos;
		this.pacientes = pacientes;
	}
	
	public String getNome() {
		return nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}
	
	public Medico getMedico(Medico medico) {
		return medicos.stream().filter(medicoSearch -> medicoSearch == medico).findFirst().orElse(null);
	}

	public void addMedico(Medico medico) {
		medicos.add(medico);
	}
	
	public void removeMedico(Medico medico) {
		medicos.remove(medico);
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}
	
	public Paciente getPaciente(Paciente paciente) {
		return pacientes.stream().filter(pacienteSearch -> pacienteSearch == paciente).findFirst().orElse(null);
	}

	public void addPaciente(Paciente paciente) {
		pacientes.add(paciente);
	}

	public void removePaciente(Paciente paciente) {
		pacientes.remove(paciente);
	}
	
}
