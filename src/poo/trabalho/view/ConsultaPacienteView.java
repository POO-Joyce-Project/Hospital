package poo.trabalho.view;

import javax.swing.JPanel;

public class ConsultaPacienteView extends JPanel {

	private static final long serialVersionUID = -7208265776832543135L;

	public ConsultaPacienteView() {
		ConsultaPessoaView pessoaView = new ConsultaPessoaView();
		add(pessoaView);
		
		setLayout(null);
		setBounds(0, 0, pessoaView.getWidth(), pessoaView.getHeight());
	}
}
