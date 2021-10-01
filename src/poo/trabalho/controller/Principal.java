package poo.trabalho.controller;

import java.util.Scanner;

import poo.trabalho.modal.Hospital;
import poo.trabalho.modal.Medico;
import poo.trabalho.modal.Paciente;
import poo.trabalho.view.MedicoView;
import poo.trabalho.view.PacienteView;

public class Principal {
	
	private static Hospital hospital = new Hospital();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
    	int opcao = -1;
    	
    	do {
    		System.out.println("-------------------------------");
	    	System.out.println("\t\tHospital");
	    	System.out.println("1 - Cadastrar Paciente");
	    	System.out.println("2 - Cadastrar M�dico");
	    	System.out.println("3 - Buscar Paciente");
	    	System.out.println("4 - Buscar M�dico");
	    	System.out.println("5 - Imprimir Pacientes");
	    	System.out.println("6 - Imprimir M�dicos");
	    	System.out.println("0 - Sair");
	    	System.out.println("-------------------------------");
	    	System.out.print("Escolha uma op��o -> ");
	    	opcao = scanner.nextInt();
	    	scanner.nextLine();

	        switch(opcao) {
		        case 1:
		        	Paciente paciente = PacienteView.printCadastroPaciente(scanner);
		        	
		        	hospital.cadastrarPaciente(paciente);
		            break;
		        case 2:
		        	Medico medico = MedicoView.printMedico(scanner);
		        	
		        	hospital.cadastrarMedico(medico);
		            break;
		        case 3:
		        	// Buscar paciente
		        	break;
		        case 4:
		        	MedicoView.printConsultaMedico(scanner);
		        	
		        	scanner.nextLine();
		        	break;
		        case 5:
		        	PacienteView.printInfoPacientes();
		        	
		        	scanner.nextLine();
		        	break;
		        case 6:
		        	MedicoView.printInfoMedico();
		        	
		        	scanner.nextLine();
		        	break;
		        case 0:
		        	System.out.println("Tchau!");
		        	break;
		        default: 
		        	System.out.println("Op��o inv�lida... Tente novamente.");
		        	
		        	scanner.nextLine();
		        	break;
	        }
    	} while(opcao != 0);
    	
    	scanner.close();
	}
	
	public static Hospital getHospital() {
		return hospital;
	}

}
