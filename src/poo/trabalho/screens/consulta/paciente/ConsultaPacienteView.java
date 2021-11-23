package poo.trabalho.screens.consulta.paciente;

import poo.trabalho.screens.consulta.ConsultaPessoaView;

public class ConsultaPacienteView extends ConsultaPessoaView {

	private static final long serialVersionUID = -7208265776832543135L;

	public ConsultaPacienteView() {
		super();
		
		controller = new ConsultaPacienteController(this);
		controller.carregarDados();
	}

}
