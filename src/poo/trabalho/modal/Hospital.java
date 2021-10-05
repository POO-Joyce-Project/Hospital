package poo.trabalho.modal;

import java.util.ArrayList;
import java.util.List;

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
	
	public Medico consultarMedico(String cpfOrCrm) {
		for (Medico medico : medicos) {
			if (medico.getCpf().equalsIgnoreCase(cpfOrCrm) || medico.getCrm().equalsIgnoreCase(cpfOrCrm)) {
				return medico;
			}
		}

		return null;
	}

	public void cadastrarMedico(Medico medico) {
		medicos.add(medico);
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public Paciente consultarPaciente(String cpf) {
		for (Paciente paciente : pacientes) {
			if (paciente.getCpf().equalsIgnoreCase(cpf)) {
				return paciente;
			}
		}

		return null;
	}

	public void cadastrarPaciente(Paciente paciente) {
		pacientes.add(paciente);
	}
	
	public Pessoa consultarPessoa(String cpf) {
		List<Pessoa> pessoas = new ArrayList<>();
		
		pessoas.addAll(Principal.getHospital().getMedicos());
		pessoas.addAll(Principal.getHospital().getPacientes());
		
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getCpf().equalsIgnoreCase(cpf)) {
				return pessoa;
			}
		}
		
		return null;
	}

}
