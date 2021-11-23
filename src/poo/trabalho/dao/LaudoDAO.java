package poo.trabalho.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import poo.trabalho.Principal;
import poo.trabalho.model.Laudo;
import poo.trabalho.model.Medico;
import poo.trabalho.model.Paciente;

public class LaudoDAO {
	
	public static void carregarLaudos() {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				ResultSet set = Principal.getMySQL().executeQuery("SELECT * FROM `laudos`");
				
				try {
					while (set.next()) {
						int id = set.getInt("idLaudo");
						String observacao = set.getString("observacao");
						String medicacaoRegular = set.getString("medicacaoRegular");
						String sintomas = set.getString("sintomas");
						String diagnostico = set.getString("diagnostico");
						String cpfMedico = set.getString("cpfMedico");
						String cpfPaciente = set.getString("cpfPaciente");
						
						Paciente paciente = Principal.getHospitalController().consultarPaciente(cpfPaciente);
						Medico medico = Principal.getHospitalController().consultarMedico(cpfMedico);
						
						if (medico != null && paciente != null) {
							Laudo laudo = new Laudo(id, observacao, medicacaoRegular, sintomas, diagnostico, paciente, medico);
							
							paciente.adicionarLaudo(laudo);
							
							Principal.getHospitalController().getHospital().getLaudos().add(laudo);
						} else {
							System.err.println("Laudo " + id + ": Paciente ou médico não cadastrado no banco de dados.");
						}
					}
					
					set.close();
					
					System.out.println("Laudos carregados com sucesso.");
				} catch (SQLException ex) {
					System.err.println("Erro ao carregar os Laudos: " + ex.getMessage());
				}
			}
		});
		
		thread.start();
	}

	public static void cadastrarLaudo(Laudo laudo, Paciente paciente) {
		String observacao = laudo.getObservacao();
		String medicacao = laudo.getMedicacaoRegular();
		String sintomas = laudo.getSintomas();
		String diagnostico = laudo.getDiagnostico();
		String cpfMedico = laudo.getMedico().getCpf();
		String cpfPaciente = paciente.getCpf();
		
		try {
			Statement stmt = Principal.getMySQL().getConnection().createStatement();
			stmt.executeUpdate("INSERT INTO `laudos` (`observacao`, `medicacaoRegular`, `sintomas`, `diagnostico`, `cpfMedico`, `cpfPaciente`) "
								+ "VALUES ('" + observacao + "', '"+ medicacao + "', '" + sintomas + "', '" + diagnostico + "', '" + cpfMedico + "', '" + cpfPaciente + "');",
									Statement.RETURN_GENERATED_KEYS);

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				laudo.setId(rs.getInt(1));
			}
		} catch (SQLException ex) {
			System.err.println("Erro ao carregar os Laudo: " + ex.getMessage());
		}
		
//		Principal.getMySQL().executeUpdate("INSERT INTO `laudos` (`observacao`, `medicacaoRegular`, `sintomas`, `diagnostico`, `cpfMedico`, `cpfPaciente`) "
//				+ "VALUES ('" + observacao + "', '"+ medicacao + "', '" + sintomas + "', '" + diagnostico + "', '" + cpfMedico + "', '" + cpfPaciente + "');");
	}
}
