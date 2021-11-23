package poo.trabalho.screens.cadastro.paciente;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import poo.trabalho.Principal;
import poo.trabalho.interfaces.ICadastroController;
import poo.trabalho.model.Paciente;

public class CadastroPacienteController implements ICadastroController {

	private CadastroPacienteView view;

	public CadastroPacienteController(CadastroPacienteView view) {
		this.view = view;
	}

	@Override
	public void cadastrar() {
		try {
			String nome = view.getNomeTextField().getText();
			String cpf = view.getCpfTextField().getText().replace(".", "").replace("-", "");
			String sexo = view.getSexoComboBox().getSelectedItem().toString();
			Date nascimento = new SimpleDateFormat("dd/MM/yyyy").parse(view.getNascimentoTextField().getText());
			String tipoSanguineo = view.getSanguineoComboBox().getSelectedItem().toString();

			Paciente paciente = new Paciente(nome, cpf, sexo, nascimento, tipoSanguineo, null);

			Principal.getHospitalController().cadastrarPaciente(paciente);

			JOptionPane.showMessageDialog(view, "Cadastro realizado com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(view, "Não foi possível realizar o cadastro!", "ERROR", JOptionPane.ERROR_MESSAGE);

			System.err.println("Não foi possível cadastrar um novo paciente: " + exception);
		}

		limparCampos();
	}

	@Override
	public void limparCampos() {
		view.getNomeTextField().setText("");
		view.getCpfTextField().setValue(null);
		view.getSexoComboBox().setSelectedIndex(0);
		view.getNascimentoTextField().setValue(null);
		view.getSanguineoComboBox().setSelectedIndex(0);
	}

	@Override
	public boolean checarCamposVazios() {
		return view.getNomeTextField().getText().isBlank()
				|| view.getCpfTextField().getText().replace("_", "").replace(".", "").replace("-", "").isBlank()
				|| view.getNascimentoTextField().getText().replace("_", "").replace("/", "").isBlank();
	}

}
