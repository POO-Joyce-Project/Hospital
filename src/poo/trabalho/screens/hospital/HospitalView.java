package poo.trabalho.screens.hospital;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import poo.trabalho.screens.cadastro.laudo.CadastroLaudoView;
import poo.trabalho.screens.cadastro.medico.CadastroMedicoView;
import poo.trabalho.screens.cadastro.paciente.CadastroPacienteView;
import poo.trabalho.screens.consulta.laudo.ConsultaLaudoView;
import poo.trabalho.screens.consulta.medico.ConsultaMedicoView;
import poo.trabalho.screens.consulta.paciente.ConsultaPacienteView;

import javax.swing.JTabbedPane;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class HospitalView extends JFrame {

	private static final long serialVersionUID = 95876338498256068L;

	public static final int WIDTH = 650;
	public static final int HEIGHT = 450;

	private JPanel contentPane;

	public HospitalView() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		setupTabPanes();

		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, WIDTH, HEIGHT + 100);
	}

	private void setupTabPanes() {
		JTabbedPane cadastro = new JTabbedPane(JTabbedPane.TOP);

		cadastro.add("Cadastro", setupCadastroTabPane());
		cadastro.add("Consulta", setupConsultaTabPane());

		contentPane.add(cadastro, BorderLayout.CENTER);
	}

	private JTabbedPane setupCadastroTabPane() {
		JTabbedPane tipoCadastro = new JTabbedPane(JTabbedPane.TOP);

		CadastroMedicoView cadastroMedico = new CadastroMedicoView();
		tipoCadastro.add("M?dico", cadastroMedico);

		CadastroPacienteView cadastroPaciente = new CadastroPacienteView();
		tipoCadastro.add("Paciente", cadastroPaciente);

		CadastroLaudoView cadastroLaudo = new CadastroLaudoView();
		tipoCadastro.add("Ficha m?dica", cadastroLaudo);

		return tipoCadastro;
	}

	private JTabbedPane setupConsultaTabPane() {
		JTabbedPane tipoConsulta = new JTabbedPane(JTabbedPane.TOP);

		ConsultaMedicoView consultaMedico = new ConsultaMedicoView();
		tipoConsulta.add("M?dico", consultaMedico);

		ConsultaPacienteView consultaPaciente = new ConsultaPacienteView();
		tipoConsulta.add("Paciente", consultaPaciente);
		
		ConsultaLaudoView consultaLaudo = new ConsultaLaudoView();
		tipoConsulta.add("Ficha m?dica", consultaLaudo);
		
		tipoConsulta.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent event) {
				consultaMedico.getConsultaController().recarregarDados();
				consultaPaciente.getConsultaController().recarregarDados();
				consultaLaudo.getController().recarregarDados();
			}
		});

		return tipoConsulta;
	}

}
