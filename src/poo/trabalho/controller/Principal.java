package poo.trabalho.controller;

import java.util.Scanner;

import poo.trabalho.view.HospitalView;

public class Principal {

	private static HospitalController hospitalController = new HospitalController();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		HospitalView.menu(scanner);

		scanner.close();
	}

	public static HospitalController getHospitalController() {
		return hospitalController;
	}

}
