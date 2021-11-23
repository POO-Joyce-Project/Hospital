package poo.trabalho.views.cadastro.laudo;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;

import poo.trabalho.views.cadastro.ICadastroController;
import poo.trabalho.views.hospital.HospitalView;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

public class CadastroLaudoView extends JPanel implements DocumentListener{

	private static final long serialVersionUID = -8688440258472237108L;

	private ICadastroController controller;

	private JFormattedTextField cpfPacienteTextField;
	private JFormattedTextField medicoTextField;
	private JFormattedTextField sintomasTextField;
	private JFormattedTextField medicacaoTextField;
	private JFormattedTextField observacaoTextField;
	private JFormattedTextField diagnosticoTextField;
	private JButton cadastrarButton;
	private JButton limparButton;

	public CadastroLaudoView() {
		controller = new CadastroLaudoController(this);

		setupTitle();
		setupPaciente();
		setupMedico();
		setupSintomas();
		setupMedicacao();
		setupObservacao();
		setupDiagnostico();
		setupCadastrarButton();
		setupLimparButton();

		setLayout(null);
		setBounds(0, 0, HospitalView.WIDTH, HospitalView.HEIGHT);
	}

	private void setupTitle() {
		JLabel titleLabel = new JLabel("Ficha Médica");

		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		titleLabel.setBounds(240, 11, 127, 20);

		add(titleLabel);
	}
	
	private void setupPaciente() {
		JLabel cpfLabel = new JLabel("CPF do paciente:");
		cpfLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		cpfLabel.setBounds(10, 70, 110, 14);
		add(cpfLabel);
		
		try {
			MaskFormatter mask = new MaskFormatter("###.###.###-##");
			mask.setPlaceholderCharacter('_');
			
			cpfPacienteTextField = new JFormattedTextField(mask);
			cpfPacienteTextField.setBounds(215, 70, 298, 20);
			cpfPacienteTextField.getDocument().addDocumentListener(this);
			add(cpfPacienteTextField);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private void setupMedico() {
		JLabel medicoLabel = new JLabel("CPF do médico responsável:");
		medicoLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		medicoLabel.setBounds(10, 120, 179, 14);
		add(medicoLabel);

		try {
			MaskFormatter mask = new MaskFormatter("###.###.###-##");
			mask.setPlaceholderCharacter('_');
			
			medicoTextField = new JFormattedTextField(mask);
			medicoTextField.setBounds(215, 120, 298, 20);
			medicoTextField.getDocument().addDocumentListener(this);
			add(medicoTextField);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private void setupSintomas() {
		JLabel sintomasLabel = new JLabel("Sintomas:");
		sintomasLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		sintomasLabel.setBounds(10, 170, 134, 14);
		add(sintomasLabel);

		sintomasTextField = new JFormattedTextField();
		sintomasTextField.setBounds(215, 170, 298, 20);
		sintomasTextField.getDocument().addDocumentListener(this);
		add(sintomasTextField);
	}
	
	private void setupMedicacao() {
		JLabel medicacaoLabel = new JLabel("Medicação regular:");
		medicacaoLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		medicacaoLabel.setBounds(10, 220, 134, 14);
		add(medicacaoLabel);

		medicacaoTextField = new JFormattedTextField();
		medicacaoTextField.setBounds(215, 220, 298, 20);
		medicacaoTextField.getDocument().addDocumentListener(this);
		add(medicacaoTextField);
	}
	
	private void setupObservacao() {
		JLabel observacaoLabel = new JLabel("Observação:");
		observacaoLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		observacaoLabel.setBounds(10, 270, 134, 14);
		add(observacaoLabel);

		observacaoTextField = new JFormattedTextField();
		observacaoTextField.setBounds(215, 270, 298, 20);
		observacaoTextField.getDocument().addDocumentListener(this);
		add(observacaoTextField);
	}
	
	private void setupDiagnostico() {
		JLabel diagonistoLabel = new JLabel("Diagnóstico:");
		diagonistoLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		diagonistoLabel.setBounds(10, 320, 134, 14);
		add(diagonistoLabel);

		diagnosticoTextField = new JFormattedTextField();
		diagnosticoTextField.setBounds(215, 320, 298, 20);
		diagnosticoTextField.getDocument().addDocumentListener(this);
		add(diagnosticoTextField);
	}
	
	private void setupCadastrarButton() {
		cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (cadastrarButton.isEnabled()) {
					controller.cadastrar();
				}
			}
		});
		cadastrarButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		cadastrarButton.setEnabled(false);
		cadastrarButton.setBounds(150, 416, 100, 23);
		add(cadastrarButton);
	}
	
	private void setupLimparButton() {
		limparButton = new JButton("Limpar");
		limparButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				controller.limparCampos();
			}
		});
		limparButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		limparButton.setBounds(365, 416, 100, 23);
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

	public JFormattedTextField getCpfPacienteTextField() {
		return cpfPacienteTextField;
	}

	public JFormattedTextField getMedicoTextField() {
		return medicoTextField;
	}

	public JFormattedTextField getSintomasTextField() {
		return sintomasTextField;
	}

	public JFormattedTextField getMedicacaoTextField() {
		return medicacaoTextField;
	}

	public JFormattedTextField getObservacaoTextField() {
		return observacaoTextField;
	}

	public JFormattedTextField getDiagnosticoTextField() {
		return diagnosticoTextField;
	}

	public JButton getCadastrarButton() {
		return cadastrarButton;
	}

	public JButton getLimparButton() {
		return limparButton;
	}
	
}
