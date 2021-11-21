package poo.trabalho.view;

import poo.trabalho.controller.CadastroPacienteController;

public class CadastroPacienteView extends CadastroPessoaView {
	
	private static final long serialVersionUID = 622202191394462017L;
	
	public CadastroPacienteView() {
		super("Cadastro Paciente");
		
		controller = new CadastroPacienteController(this);
	}

}
