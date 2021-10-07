package poo.trabalho.interfaces;

import poo.trabalho.modal.Medico;
import poo.trabalho.modal.Paciente;

public interface HospitalInterface {
	
	public Medico consultarMedico(String cpfOrCrm);
	public Paciente consultarPaciente(String cpf);
	public void cadastrarMedico(Medico medico);
	public void cadastrarPaciente(Paciente paciente);
	
}
