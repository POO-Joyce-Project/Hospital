package poo.trabalho.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import poo.trabalho.Principal;
import poo.trabalho.model.Medico;

public class MedicoDAO {
	
	public static void carregarMedicos() {
		ResultSet set = Principal.getMySQL().executeQuery("SELECT * FROM `medicos`");

		try {
			while (set.next()) {
				String nome = set.getString("nome");
				String cpf = set.getString("cpf");
				String sexo = set.getString("sexo");
				java.util.Date nascimento = set.getTimestamp("nascimento");
				String tipoSanguineo = set.getString("tipoSanguineo");
				String especialidade = set.getString("tipoSanguineo");
				String crm = set.getString("crm");

				Medico medico = new Medico(nome, cpf, sexo, nascimento, tipoSanguineo, especialidade, crm);

				Principal.getHospitalController().getHospital().getMedicos().add(medico);
			}

			set.close();

			System.out.println("Médicos carregados com sucesso.");
		} catch (SQLException ex) {
			System.err.println("Erro ao carregar os médicos: " + ex.getMessage());
		}
	}

	public static void cadastrarMedico(Medico medico) {
		String cpf = medico.getCpf();
		String nome = medico.getNome();
		String sexo = medico.getSexo();
		Date nascimento = new Date(medico.getDataNascimento().getTime());
		String tipoSanguineo = medico.getTipoSanguineo();
		String especialidade = medico.getEspecialidade();
		String crm = medico.getCrm();
		
		Principal.getMySQL().executeUpdate("INSERT INTO `medicos` (`cpf`, `nome`, `sexo`, `nascimento`, `tipoSanguineo`, `especialidade`, `crm`) "
				+ "VALUES ('" + cpf + "', '"+ nome + "', '" + sexo + "', '" + nascimento + "', '" + tipoSanguineo + "', '" + especialidade + "', '" + crm +"');");
	}
}
