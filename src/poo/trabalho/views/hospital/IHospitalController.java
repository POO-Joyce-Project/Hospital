package poo.trabalho.views.hospital;

import poo.trabalho.model.Laudo;
import poo.trabalho.model.Medico;
import poo.trabalho.model.Paciente;

public interface IHospitalController {
	
	public Medico consultarMedico(String cpfOrCrm);
	public Paciente consultarPaciente(String cpf);
	public Laudo consultarLaudo(int idLaudo);
	public void cadastrarMedico(Medico medico);
	public void cadastrarPaciente(Paciente paciente);
	public void cadastrarLaudo(Laudo laudo, Paciente paciente);
	
}
