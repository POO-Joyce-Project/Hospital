package poo.trabalho.views.hospital;

import poo.trabalho.model.Hospital;
import poo.trabalho.model.Medico;
import poo.trabalho.model.Paciente;

public class HospitalController implements IHospitalController {

	private Hospital hospital;

	public HospitalController() {
		hospital = new Hospital();
	}

	@Override
	public Medico consultarMedico(String cpfOrCrm) {
		for (Medico medico : hospital.getMedicos()) {
			if (medico.getCpf().equalsIgnoreCase(cpfOrCrm) || medico.getCrm().equalsIgnoreCase(cpfOrCrm)) {
				return medico;
			}
		}

		return null;
	}

	@Override
	public Paciente consultarPaciente(String cpf) {
		for (Paciente paciente : hospital.getPacientes()) {
			if (paciente.getCpf().equalsIgnoreCase(cpf)) {
				return paciente;
			}
		}

		return null;
	}

	@Override
	public void cadastrarMedico(Medico medico) {
		hospital.getMedicos().add(medico);
	}

	@Override
	public void cadastrarPaciente(Paciente paciente) {
		hospital.getPacientes().add(paciente);
	}

	public Hospital getHospital() {
		return hospital;
	}

}
