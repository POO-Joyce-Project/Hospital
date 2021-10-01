package poo.trabalho.modal;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import poo.trabalho.controller.Principal;

public class Hospital {

	private String nome;
	private List<Medico> medicos;
	private List<Paciente> pacientes;

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

	public Medico getMedico(Predicate<Pessoa> predicate) {
		return medicos.stream().filter(predicate).findFirst().orElse(null);
	}

	public void cadastrarMedico(Medico medico) {
		medicos.add(medico);
	}

	public void removeMedico(Medico medico) {
		medicos.remove(medico);
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public Paciente getPaciente(Predicate<Pessoa> predicate) {
		return pacientes.stream().filter(predicate).findFirst().orElse(null);
	}

	public Paciente consultarPaciente(int id) {
		
		for (Paciente paciente : pacientes) {
			if (paciente.getId() == id) {
				return paciente;
			}
		}
		
		return null;
	}
	
	public Paciente consultarPaciente(String nome) {
		
		for (Paciente paciente : pacientes) {
			if (paciente.getNome() == nome) {
				return paciente;
			}
		}
		
		return null;
	}

	public void cadastrarPaciente(Paciente paciente) {
		pacientes.add(paciente);
	}

	public void removePaciente(Paciente paciente) {
		pacientes.remove(paciente);
	}
	
	
	public Medico consultarMedico(int id) {
		for(Medico medico : Principal.getHospital().getMedicos()){
			if(medico.getId() == id) {
				return medico;
			}
		}
		
		return null;
	}
	
	
	public Medico consultarMedicoCpf(int cpf) {
		for(Medico medico : Principal.getHospital().getMedicos()){
			if(medico.getCpf() == cpf) {
				return medico;
			}
		}
		
		return null;
	}
	
	

}
