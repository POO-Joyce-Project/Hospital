package poo.trabalho.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {

	private String user, pass, db, host;
	private Connection connection;

	public MySQL(String host, String db, String user, String pass) {
		this.host = host;
		this.db = db;
		this.user = user;
		this.pass = pass;
	}

	public boolean openConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + db + "?autoReconnect=true", user, pass);

			return true;
		} catch (Exception exception) {
			System.out.println("Erro ao conectar o MySQL: " + exception.getMessage());
		}

		return false;
	}
	
	public void createTables() {
		executeUpdate(
				"CREATE TABLE IF NOT EXISTS `medicos` ("
				+ "  `cpf` VARCHAR(11) NOT NULL,"
				+ "  `nome` VARCHAR(45) NOT NULL,"
				+ "  `sexo` VARCHAR(10) NOT NULL,"
				+ "  `nascimento` DATE NOT NULL,"
				+ "  `tipoSanguineo` VARCHAR(2) NOT NULL,"
				+ "  `especialidade` VARCHAR(45) NOT NULL,"
				+ "  `crm` VARCHAR(45) NOT NULL,"
				+ "  PRIMARY KEY (`cpf`));");

		executeUpdate(
				"CREATE TABLE IF NOT EXISTS `pacientes` ("
				+ "  `cpf` VARCHAR(11) NOT NULL,"
				+ "  `nome` VARCHAR(45) NOT NULL,"
				+ "  `sexo` VARCHAR(10) NOT NULL,"
				+ "  `nascimento` DATE NOT NULL,"
				+ "  `tipoSanguineo` VARCHAR(2) NOT NULL,"
				+ "  PRIMARY KEY (`cpf`));");

		executeUpdate(
				"CREATE TABLE IF NOT EXISTS `laudos` ("
				+ "  `idLaudo` INT NOT NULL AUTO_INCREMENT,"
				+ "  `observacao` VARCHAR(99) NOT NULL,"
				+ "  `medicacaoRegular` VARCHAR(99) NOT NULL,"
				+ "  `sintomas` VARCHAR(99) NOT NULL,"
				+ "  `diagnostico` VARCHAR(99) NOT NULL,"
				+ "  `cpfMedico` VARCHAR(11) NOT NULL,"
				+ "  `cpfPaciente` VARCHAR(11) NOT NULL,"
				+ "  PRIMARY KEY (`idLaudo`),"
				+ "  FOREIGN KEY (`cpfMedico`) REFERENCES `medicos` (`cpf`),"
				+ "  FOREIGN KEY (`cpfPaciente`) REFERENCES `pacientes` (`cpf`));");
	}

	public ResultSet executeQuery(String query) {
		try {
			return getConnection().createStatement().executeQuery(query);
		} catch (Exception exception) {
			System.out.println("Erro ao conectar o MySQL: " + exception.getMessage());
		}

		return null;
	}

	public void executeUpdate(String update) {
		try {
			Statement statement = getConnection().createStatement();
			statement.executeUpdate(update);
			statement.close();
		} catch (SQLException exception) {
			System.out.println("Erro ao conectar o MySQL: " + exception.getMessage());
		}
	}

	public void executeUpdateAsync(String update) {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Statement statement = getConnection().createStatement();
					statement.executeUpdate(update);
					statement.close();
				} catch (SQLException exception) {
					System.out.println("Erro ao conectar o MySQL: " + exception.getMessage());
				}
			}
		});

		thread.start();
	}

	public Connection getConnection() {
		return connection;
	}

}