package poo.trabalho.views.consulta.paciente;

import java.util.List;

import poo.trabalho.Principal;
import poo.trabalho.model.Paciente;
import poo.trabalho.utils.Utils;
import poo.trabalho.views.consulta.IConsultaController;

public class ConsultaPacienteController implements IConsultaController {
	
	private ConsultaPacienteView view;

	public ConsultaPacienteController(ConsultaPacienteView view) {
		this.view = view;
	}

	@Override
	public void carregarDados() {
		List<Paciente> pacientes = Principal.getHospitalController().getHospital().getPacientes();

		for (Paciente paciente : pacientes) {
			String data[] = { Utils.formatarCPF(paciente.getCpf()), paciente.getNome(),
					Utils.formatarNascimento(paciente.getDataNascimento()), paciente.getSexo(),
					paciente.getTipoSanguineo() };

			view.getTableModel().addRow(data);
		}
	}

	@Override
	public void recarregarDados() {
		List<Paciente> pacientes = Principal.getHospitalController().getHospital().getPacientes();
		
		if (view.getTableModel().getRowCount() == pacientes.size())
			return;
		
		int i = 0;

		for (Paciente paciente : pacientes) {
			if (view.getTableModel().getRowCount() <= i) 
				view.getTableModel().addRow(new Object[] {});
			
			view.getTableModel().setValueAt(Utils.formatarCPF(paciente.getCpf()), i, 0);
			view.getTableModel().setValueAt(paciente.getNome(), i, 1);
			view.getTableModel().setValueAt(Utils.formatarNascimento(paciente.getDataNascimento()), i, 2);
			view.getTableModel().setValueAt(paciente.getSexo(), i, 3);
			view.getTableModel().setValueAt(paciente.getTipoSanguineo(), i, 4);

			i++;
		}
	}

}
