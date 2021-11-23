package poo.trabalho.screens.cadastro.medico;

import javax.swing.JLabel;
import javax.swing.JTextField;

import poo.trabalho.screens.cadastro.CadastroPessoaView;

import java.awt.Font;

public class CadastroMedicoView extends CadastroPessoaView {

	private static final long serialVersionUID = 622202191394462017L;
	
	private JTextField especialidadeTextField;
	
	public CadastroMedicoView() {
		super("Cadastro Médico");
		
		controller = new CadastroMedicoController(this);
		
		setupEspecialidade();
	}
	
	private void setupEspecialidade() {
		JLabel especilidadeLabel = new JLabel("Especialidade: ");
		especilidadeLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		especilidadeLabel.setBounds(10, 312, 88, 14);
		add(especilidadeLabel);
		
		especialidadeTextField = new JTextField();
		especialidadeTextField.setBounds(215, 310, 300, 20);
		especialidadeTextField.setColumns(10);
		especialidadeTextField.getDocument().addDocumentListener(this);
		add(especialidadeTextField);
	}

	public JTextField getEspecialidadeTextField() {
		return especialidadeTextField;
	}

}
