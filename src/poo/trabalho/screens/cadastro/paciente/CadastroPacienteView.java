package poo.trabalho.screens.cadastro.paciente;

import poo.trabalho.screens.cadastro.CadastroPessoaView;

public class CadastroPacienteView extends CadastroPessoaView {
	
	private static final long serialVersionUID = 622202191394462017L;
	
	public CadastroPacienteView() {
		super("Cadastro Paciente");
		
		controller = new CadastroPacienteController(this);
	}

}
