package poo.trabalho;

import java.awt.EventQueue;

import poo.trabalho.dao.LaudoDAO;
import poo.trabalho.dao.MedicoDAO;
import poo.trabalho.dao.MySQL;
import poo.trabalho.dao.PacienteDAO;
import poo.trabalho.views.hospital.HospitalController;
import poo.trabalho.views.hospital.HospitalView;

public class Principal {

	private static HospitalController hospitalController;
	private static MySQL sql;

	public static void main(String[] args) {
		
		hospitalController = new HospitalController();

		sql = new MySQL("localhost", "hospital", "root", "123456");
		sql.openConnection();
		sql.createTables();

		PacienteDAO.carregarPacientes();
		MedicoDAO.carregarMedicos();
		LaudoDAO.carregarLaudos();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HospitalView frame = new HospitalView();
					
					frame.setTitle(hospitalController.getHospital().getNome());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static HospitalController getHospitalController() {
		return hospitalController;
	}

	public static MySQL getMySQL() {
		return sql;
	}

}
