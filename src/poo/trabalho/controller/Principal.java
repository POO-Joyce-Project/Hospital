package poo.trabalho.controller;

import java.awt.EventQueue;

import poo.trabalho.view.PrincipalView;

public class Principal {

	private static HospitalController hospitalController = new HospitalController();

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//
//		HospitalView.menu(scanner);
//		
//		scanner.close();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalView frame = new PrincipalView();
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
