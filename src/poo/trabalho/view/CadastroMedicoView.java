package poo.trabalho.view;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class CadastroMedicoView extends CadastroPessoaView {

	private static final long serialVersionUID = 622202191394462017L;
	
	private JTextField crmTextField;
	private JTextField especialidadeTextField;
	
	public CadastroMedicoView() {
		super("Cadastro M�dico");
		
		setupEspecialidade();
		setupCrm();
	}
	
	private void setupEspecialidade() {
		JLabel especilidadeLabel = new JLabel("Especialidade: ");
		especilidadeLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		especilidadeLabel.setBounds(10, 312, 88, 14);
		add(especilidadeLabel);
		
		especialidadeTextField = new JTextField();
		especialidadeTextField.setBounds(150, 310, 149, 20);
		especialidadeTextField.setColumns(10);
		add(especialidadeTextField);
	}
	
	private void setupCrm() {
		JLabel crmLabel = new JLabel("CRM: ");
		crmLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		crmLabel.setBounds(10, 362, 46, 14);
		add(crmLabel);
		
		crmTextField = new JTextField();
		crmTextField.setBounds(66, 360, 106, 20);
		crmTextField.setColumns(10);
		add(crmTextField);
	}

}
