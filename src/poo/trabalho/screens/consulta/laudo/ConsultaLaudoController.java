package poo.trabalho.screens.consulta.laudo;

import java.util.List;

import poo.trabalho.Principal;
import poo.trabalho.interfaces.IConsultaController;
import poo.trabalho.model.Laudo;
import poo.trabalho.utils.Utils;

public class ConsultaLaudoController implements IConsultaController {

	private ConsultaLaudoView view;

	public ConsultaLaudoController(ConsultaLaudoView view) {
		this.view = view;
	}

	@Override
	public void carregarDados() {
		List<Laudo> laudos = Principal.getHospitalController().getHospital().getLaudos();

		for (Laudo laudo : laudos) {
			String data[] = { String.valueOf(laudo.getId()),
								Utils.formatarCPF(laudo.getPaciente().getCpf()),
								Utils.formatarCPF(laudo.getMedico().getCpf()),
								laudo.getSintomas(),
								laudo.getMedicacaoRegular(),
								laudo.getObservacao(),
								laudo.getDiagnostico() };
			
			view.getTableModel().addRow(data);
		}
	}

	@Override
	public void recarregarDados() {
		List<Laudo> laudos = Principal.getHospitalController().getHospital().getLaudos();

		if (view.getTableModel().getRowCount() == laudos.size())
			return;

		int i = 0;

		for (Laudo laudo : laudos) {
			if (view.getTableModel().getRowCount() <= i)
				view.getTableModel().addRow(new Object[] {});

			view.getTableModel().setValueAt(String.valueOf(laudo.getId()), i, 0);
			view.getTableModel().setValueAt(Utils.formatarCPF(laudo.getPaciente().getCpf()), i, 1);
			view.getTableModel().setValueAt(Utils.formatarCPF(laudo.getMedico().getCpf()), i, 2);
			view.getTableModel().setValueAt(laudo.getSintomas(), i, 3);
			view.getTableModel().setValueAt(laudo.getMedicacaoRegular(), i, 4);
			view.getTableModel().setValueAt(laudo.getObservacao(), i, 5);
			view.getTableModel().setValueAt(laudo.getDiagnostico(), i, 6);

			i++;
		}
	}

}
