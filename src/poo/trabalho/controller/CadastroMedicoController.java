package poo.trabalho.controller;

import javax.swing.JOptionPane;

import poo.trabalho.interfaces.ICadastroController;
import poo.trabalho.view.CadastroMedicoView;

public class CadastroMedicoController implements ICadastroController {

	private CadastroMedicoView view;

	public CadastroMedicoController(CadastroMedicoView view) {
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
		view.getEspecialidadeTextField().setText("");
		view.getCrmTextField().setText("");
	}

	@Override
	public boolean checarCamposVazios() {
		return view.getNomeTextField().getText().isBlank()
				|| view.getCpfTextField().getText().replace("_", "").replace(".", "").replace("-", "").isBlank()
				|| view.getNascimentoTextField().getText().replace("_", "").replace("/", "").isBlank()
				|| view.getSanguineoTextField().getText().isBlank()
				|| view.getEspecialidadeTextField().getText().isBlank() || view.getCrmTextField().getText().isBlank();
	}

}
