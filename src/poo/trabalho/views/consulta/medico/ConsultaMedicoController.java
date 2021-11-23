package poo.trabalho.views.consulta.medico;

import java.util.List;

import poo.trabalho.Principal;
import poo.trabalho.model.Medico;
import poo.trabalho.utils.Utils;
import poo.trabalho.views.consulta.IConsultaController;

public class ConsultaMedicoController implements IConsultaController {

	private ConsultaMedicoView view;

	public ConsultaMedicoController(ConsultaMedicoView view) {
		this.view = view;
	}

	@Override
	public void carregarDados() {
		List<Medico> medicos = Principal.getHospitalController().getHospital().getMedicos();
		
		for (Medico medico : medicos) {
			String data[] = { Utils.formatarCPF(medico.getCpf()), 
								medico.getNome(),
								Utils.formatarNascimento(medico.getDataNascimento()), 
								medico.getSexo(), 
								medico.getTipoSanguineo(),
								medico.getEspecialidade(), 
								medico.getCrm() };
			
			view.getTableModel().addRow(data);
		}
	}

	@Override
	public void recarregarDados() {
		List<Medico> medicos = Principal.getHospitalController().getHospital().getMedicos();

		if (view.getTableModel().getRowCount() == medicos.size())
			return;

		int i = 0;

		for (Medico medico : medicos) {
			if (view.getTableModel().getRowCount() <= i)
				view.getTableModel().addRow(new Object[] {});

			view.getTableModel().setValueAt(Utils.formatarCPF(medico.getCpf()), i, 0);
			view.getTableModel().setValueAt(medico.getNome(), i, 1);
			view.getTableModel().setValueAt(Utils.formatarNascimento(medico.getDataNascimento()), i, 2);
			view.getTableModel().setValueAt(medico.getSexo(), i, 3);
			view.getTableModel().setValueAt(medico.getTipoSanguineo(), i, 4);
			view.getTableModel().setValueAt(medico.getEspecialidade(), i, 5);
			view.getTableModel().setValueAt(medico.getCrm(), i, 6);

			i++;
		}
	}

}
