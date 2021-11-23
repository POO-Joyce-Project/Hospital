package poo.trabalho.views.cadastro.laudo;

import javax.swing.JOptionPane;

import poo.trabalho.Principal;
import poo.trabalho.model.Laudo;
import poo.trabalho.model.Medico;
import poo.trabalho.model.Paciente;
import poo.trabalho.views.cadastro.ICadastroController;

public class CadastroLaudoController implements ICadastroController {
	
	private CadastroLaudoView view;

	public CadastroLaudoController(CadastroLaudoView view) {
		this.view = view;
	}

	@Override
	public void cadastrar() {
		try {
			String cpfPaciente = view.getCpfPacienteTextField().getText().replace(".", "").replace("-", "");
			String cpfMedico = view.getMedicoTextField().getText().replace(".", "").replace("-", "");
			String sintomas = view.getSintomasTextField().getText();
			String medicacaoRegular = view.getMedicacaoTextField().getText();
			String observacao = view.getObservacaoTextField().getText();
			String diagnostico = view.getDiagnosticoTextField().getText();
			
			Paciente paciente = Principal.getHospitalController().consultarPaciente(cpfPaciente);
			Medico medico = Principal.getHospitalController().consultarMedico(cpfMedico);
			
			if (medico == null || paciente == null)
				throw new NullPointerException("Paciente ou m�dico n�o cadastrado no banco de dados.");
			
			Laudo laudo = new Laudo(0, observacao, medicacaoRegular, sintomas, diagnostico, paciente, medico);
			
			Principal.getHospitalController().cadastrarLaudo(laudo, paciente);
			
			JOptionPane.showMessageDialog(view, "Cadastro realizado com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(view, "Paciente ou m�dico n�o p�de ser encontrado no banco de dados.", "N�o foi poss�vel realizar o cadastro!", JOptionPane.ERROR_MESSAGE);
			
			System.err.println("N�o foi poss�vel cadastrar um novo paciente: " + exception.getMessage());
		}
		
		limparCampos();
	}

	@Override
	public void limparCampos() {
		view.getCpfPacienteTextField().setValue(null);
		view.getMedicoTextField().setValue(null);
		view.getSintomasTextField().setText("");
		view.getMedicacaoTextField().setText("");
		view.getObservacaoTextField().setText("");
		view.getDiagnosticoTextField().setText("");
	}

	@Override
	public boolean checarCamposVazios() {
		return view.getCpfPacienteTextField().getText().replace("_", "").replace(".", "").replace("-", "").isBlank()
				|| view.getMedicoTextField().getText().replace("_", "").replace(".", "").replace("-", "").isBlank()
				|| view.getSintomasTextField().getText().replace(",", "").replace(";", "").isBlank()
				|| view.getMedicacaoTextField().getText().isBlank()
				|| view.getObservacaoTextField().getText().isBlank()
				|| view.getDiagnosticoTextField().getText().isBlank();
	}

}
