package poo.trabalho.views.cadastro;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import poo.trabalho.views.hospital.HospitalView;

import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class CadastroPessoaView extends JPanel implements DocumentListener {
	
	private static final long serialVersionUID = -6296201519154331596L;
	
	protected ICadastroController controller;
	
	protected JTextField nomeTextField;
	protected JFormattedTextField cpfTextField;
	protected JComboBox<String> sexoComboBox;
	protected JFormattedTextField nascimentoTextField;
	protected JTextField sanguineoTextField;
	protected JButton cadastrarButton;
	protected JButton limparButton;
	
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
		setBounds(0, 0, HospitalView.WIDTH, HospitalView.HEIGHT);
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
		nomeLabel.setBounds(10, 60, 46, 14);
		add(nomeLabel);
		
		nomeTextField = new JTextField();
		nomeTextField.setBounds(215, 60, 300, 20);
		nomeTextField.setColumns(10);
		nomeTextField.getDocument().addDocumentListener(this);
		
		add(nomeTextField);
	}
	
	private void setupCpf() {
		JLabel cpfLabel = new JLabel("CPF:");
		cpfLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		cpfLabel.setBounds(10, 110, 46, 14);
		add(cpfLabel);
		
		try {
			MaskFormatter mask = new MaskFormatter("###.###.###-##");
			mask.setPlaceholderCharacter('_');
			
			cpfTextField = new JFormattedTextField(mask);
			cpfTextField.setBounds(215, 110, 300, 20);
			cpfTextField.getDocument().addDocumentListener(this);
			add(cpfTextField);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}
	
	private void setupSexo() {
		JLabel sexoLabel = new JLabel("Sexo:");
		sexoLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		sexoLabel.setBounds(10, 160, 46, 14);
		add(sexoLabel);
		
		String[] sexo = new String[] {"Masculino", "Feminino"};
		
		sexoComboBox = new JComboBox<String>();
		sexoComboBox.setModel(new DefaultComboBoxModel<String>(sexo));
		sexoComboBox.setBounds(215, 160, 108, 20);
		add(sexoComboBox);
	}
	
	private void setupDataNascimento() {
		JLabel dataLabel = new JLabel("Data de nascimento:");
		dataLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		dataLabel.setBounds(10, 210, 130, 14);
		add(dataLabel);
		
		try {
			MaskFormatter mask = new MaskFormatter("##/##/####");
			mask.setPlaceholderCharacter('_');
			
			nascimentoTextField = new JFormattedTextField(mask);
			nascimentoTextField.setBounds(215, 210, 300, 20);
			nascimentoTextField.getDocument().addDocumentListener(this);
			add(nascimentoTextField);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private void setupSanguineo() {
		JLabel tipoLabel = new JLabel("Tipo sanguíneo: ");
		tipoLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		tipoLabel.setBounds(10, 260, 108, 14);
		add(tipoLabel);
		
		sanguineoTextField = new JTextField();
		sanguineoTextField.setBounds(215, 260, 300, 20);
		sanguineoTextField.setColumns(10);
		sanguineoTextField.getDocument().addDocumentListener(this);
		add(sanguineoTextField);
	}
	
	private void setupCadastrarButton() {
		cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		cadastrarButton.setBounds(150, 416, 100, 23);
		cadastrarButton.setEnabled(false);
		
		cadastrarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (cadastrarButton.isEnabled()) {
					controller.cadastrar();
				}
			}
		});
		
		add(cadastrarButton);
	}
	
	private void setupLimparButton() {
		limparButton = new JButton("Limpar");
		limparButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		limparButton.setBounds(365, 416, 100, 23);
		
		limparButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				controller.limparCampos();
			}
		});
		
		add(limparButton);
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		check();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		check();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		check();
	}
	
	private void check() {
		if (controller.checarCamposVazios()) {
			cadastrarButton.setEnabled(false);
		} else {
			cadastrarButton.setEnabled(true);
		}
	}

	public JTextField getNomeTextField() {
		return nomeTextField;
	}

	public JFormattedTextField getCpfTextField() {
		return cpfTextField;
	}
	
	public JComboBox<String> getSexoComboBox() {
		return sexoComboBox;
	}

	public JFormattedTextField getNascimentoTextField() {
		return nascimentoTextField;
	}

	public JTextField getSanguineoTextField() {
		return sanguineoTextField;
	}

	public JButton getCadastrarButton() {
		return cadastrarButton;
	}

	public JButton getLimparButton() {
		return limparButton;
	}
	
}
