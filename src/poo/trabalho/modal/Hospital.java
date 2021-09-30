package poo.trabalho.modal;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Hospital {

	private String nome;
	private Endereco endereco;
	private List<Medico> medicos;
	private List<Paciente> pacientes;

	public Hospital() {
		this.nome = "Anchieta";
		this.endereco = new Endereco("Área Especial 8, 9, 10, St. C Norte Qnc", "Brasília-DF");
		this.medicos = new ArrayList<>();
		this.pacientes = new ArrayList<>();
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

	public void cadastrarPaciente(Paciente paciente) {
		pacientes.add(paciente);
	}

	public void removePaciente(Paciente paciente) {
		pacientes.remove(paciente);
	}

}
