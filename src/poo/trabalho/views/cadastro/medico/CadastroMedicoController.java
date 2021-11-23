package poo.trabalho.views.cadastro.medico;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import poo.trabalho.Principal;
import poo.trabalho.model.Medico;
import poo.trabalho.views.cadastro.ICadastroController;

public class CadastroMedicoController implements ICadastroController {

	private CadastroMedicoView view;

	public CadastroMedicoController(CadastroMedicoView view) {
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
			String especialidade = view.getEspecialidadeTextField().getText();
			String crm = view.getCrmTextField().getText();

			Medico medico = new Medico(nome, cpf, sexo, nascimento, tipoSanguineo, especialidade, crm);

			Principal.getHospitalController().cadastrarMedico(medico);

			JOptionPane.showMessageDialog(view, "Cadastro realizado com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(view, "Não foi possível realizar o cadastro!", "ERROR", JOptionPane.ERROR_MESSAGE);

			System.err.println("Não foi possível cadastrar um novo médico: " + exception);
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
		view.getEspecialidadeTextField().setText("");
		view.getCrmTextField().setText("");
	}

	@Override
	public boolean checarCamposVazios() {
		return view.getNomeTextField().getText().isBlank()
				|| view.getCpfTextField().getText().replace("_", "").replace(".", "").replace("-", "").isBlank()
				|| view.getNascimentoTextField().getText().replace("_", "").replace("/", "").isBlank()
				|| view.getEspecialidadeTextField().getText().isBlank() || view.getCrmTextField().getText().isBlank();
	}

}
