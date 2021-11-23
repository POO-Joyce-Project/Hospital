package poo.trabalho.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import poo.trabalho.Principal;
import poo.trabalho.model.Paciente;

public class PacienteDAO {
	
	public static void carregarPacientes() {
		ResultSet set = Principal.getMySQL().executeQuery("SELECT * FROM `pacientes`");

		try {
			while (set.next()) {
				String nome = set.getString("nome");
				String cpf = set.getString("cpf");
				String sexo = set.getString("sexo");
				java.util.Date nascimento = set.getTimestamp("nascimento");
				String tipoSanguineo = set.getString("tipoSanguineo");

				Paciente paciente = new Paciente(nome, cpf, sexo, nascimento, tipoSanguineo, null);

				Principal.getHospitalController().getHospital().getPacientes().add(paciente);
			}

			set.close();

			System.out.println("Pacientes carregados com sucesso.");
		} catch (SQLException ex) {
			System.err.println("Erro ao carregar os pacientes: " + ex.getMessage());
		}		
	}

	public static void cadastrarPaciente(Paciente paciente) {
		String cpf = paciente.getCpf();
		String nome = paciente.getNome();
		String sexo = paciente.getSexo();
		Date nascimento = new Date(paciente.getDataNascimento().getTime());
		String tipoSanguineo = paciente.getTipoSanguineo();
		
		Principal.getMySQL().executeUpdate("INSERT INTO `pacientes` (`cpf`, `nome`, `sexo`, `nascimento`, `tipoSanguineo`) "
				+ "VALUES ('" + cpf + "', '"+ nome + "', '" + sexo + "', '" + nascimento + "', '" + tipoSanguineo + "');");
	}
}
