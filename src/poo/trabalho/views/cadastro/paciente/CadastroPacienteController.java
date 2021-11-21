package poo.trabalho.views.cadastro.paciente;

import javax.swing.JOptionPane;

import poo.trabalho.views.cadastro.ICadastroController;

public class CadastroPacienteController implements ICadastroController {

	private CadastroPacienteView view;

	public CadastroPacienteController(CadastroPacienteView view) {
		this.view = view;
	}

	@Override
	public void cadastrar() {
		// TODO: Implementar persistência com o banco de dados.

		JOptionPane.showMessageDialog(view, "Cadastro realizado com sucesso!", "SUCESSO",
				JOptionPane.INFORMATION_MESSAGE);

		limparCampos();
	}

	@Override
	public void limparCampos() {
		view.getNomeTextField().setText("");
		view.getCpfTextField().setValue(null);
		view.getSexoComboBox().setSelectedIndex(0);
		view.getNascimentoTextField().setValue(null);
		view.getSanguineoTextField().setText("");
	}

	@Override
	public boolean checarCamposVazios() {
		return view.getNomeTextField().getText().isBlank()
				|| view.getCpfTextField().getText().replace("_", "").replace(".", "").replace("-", "").isBlank()
				|| view.getNascimentoTextField().getText().replace("_", "").replace("/", "").isBlank()
				|| view.getSanguineoTextField().getText().isBlank();
	}

}
