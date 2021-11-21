package poo.trabalho.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CadastroPessoaView extends JPanel {
	
	private static final long serialVersionUID = -6296201519154331596L;
	
	private JTextField nomeTextField;
	private JFormattedTextField cpfTextField;
	private JComboBox<String> sexoComboBox;
	private JFormattedTextField nascimentoTextField;
	private JTextField sanguineoTextField;
	private JButton cadastrarButton;
	private JButton limparButton;
	
	public CadastroPessoaView(String title) {
		setupTitle(title);
		setupName();
		setupCpf();
		setupSexo();
		setupDataNascimento();
		setupSanguineo();
		setupCadastrarButton();
		setupLimparButton();
		
		setLayout(null);
		setBounds(0, 0, PrincipalView.WIDTH, PrincipalView.HEIGHT);
	}
	
	private void setupTitle(String title) {
		JLabel titleLabel = new JLabel(title);
		
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		titleLabel.setBounds(220, 11, 186, 20);
		
		add(titleLabel);
	}
	
	private void setupName() {
		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		nomeLabel.setBounds(10, 63, 46, 14);
		add(nomeLabel);
		
		nomeTextField = new JTextField();
		nomeTextField.setBounds(66, 60, 311, 20);
		nomeTextField.setColumns(10);
		add(nomeTextField);
	}
	
	private void setupCpf() {
		JLabel cpfLabel = new JLabel("CPF:");
		cpfLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		cpfLabel.setBounds(10, 114, 46, 14);
		add(cpfLabel);
		
		try {
			MaskFormatter mask = new MaskFormatter("###.###.###-##");
			mask.setPlaceholderCharacter('_');
			
			cpfTextField = new JFormattedTextField(mask);
			cpfTextField.setBounds(66, 110, 311, 20);
			add(cpfTextField);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}
	
	private void setupSexo() {
		JLabel sexoLabel = new JLabel("Sexo:");
		sexoLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		sexoLabel.setBounds(10, 162, 46, 14);
		add(sexoLabel);
		
		String[] sexo = new String[] {"Masculino", "Feminino"};
		
		sexoComboBox = new JComboBox<String>();
		sexoComboBox.setModel(new DefaultComboBoxModel<String>(sexo));
		sexoComboBox.setBounds(66, 160, 108, 20);
		add(sexoComboBox);
	}
	
	private void setupDataNascimento() {
		JLabel dataLabel = new JLabel("Data de nascimento:");
		dataLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		dataLabel.setBounds(10, 212, 130, 14);
		add(dataLabel);
		
		try {
			MaskFormatter mask = new MaskFormatter("##/##/####");
			mask.setPlaceholderCharacter('_');
			
			nascimentoTextField = new JFormattedTextField(mask);
			nascimentoTextField.setBounds(150, 210, 86, 20);
			add(nascimentoTextField);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setupSanguineo() {
		JLabel tipoLabel = new JLabel("Tipo sanguíneo: ");
		tipoLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		tipoLabel.setBounds(10, 262, 108, 14);
		add(tipoLabel);
		
		sanguineoTextField = new JTextField();
		sanguineoTextField.setBounds(150, 260, 108, 20);
		sanguineoTextField.setColumns(10);
		add(sanguineoTextField);
	}
	
	private void setupCadastrarButton() {
		cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		cadastrarButton.setBounds(165, 416, 100, 23);
		add(cadastrarButton);
	}
	
	private void setupLimparButton() {
		limparButton = new JButton("Limpar");
		limparButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		limparButton.setBounds(380, 416, 100, 23);
		add(limparButton);
	}
	
}
