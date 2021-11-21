package poo.trabalho.views.hospital;

import poo.trabalho.model.Medico;
import poo.trabalho.model.Paciente;

public interface IHospitalController {
	
	public Medico consultarMedico(String cpfOrCrm);
	public Paciente consultarPaciente(String cpf);
	public void cadastrarMedico(Medico medico);
	public void cadastrarPaciente(Paciente paciente);
	
}
