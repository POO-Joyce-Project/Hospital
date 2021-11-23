package poo.trabalho.screens.consulta.medico;

import poo.trabalho.screens.consulta.ConsultaPessoaView;

public class ConsultaMedicoView extends ConsultaPessoaView {

	private static final long serialVersionUID = -7208265776832543135L;

	public ConsultaMedicoView() {
		super();

		tableModel.addColumn("Especialidade");
		tableModel.addColumn("CRM");

		controller = new ConsultaMedicoController(this);
		controller.carregarDados();
	}

}
