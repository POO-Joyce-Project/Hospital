package poo.trabalho;

import java.awt.EventQueue;

import poo.trabalho.views.hospital.HospitalController;
import poo.trabalho.views.hospital.HospitalView;

public class Principal {

	private static HospitalController hospitalController = new HospitalController();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HospitalView frame = new HospitalView();
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

}
