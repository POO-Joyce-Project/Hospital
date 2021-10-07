package poo.trabalho.view;

import java.util.Scanner;

import poo.trabalho.controller.HospitalController;
import poo.trabalho.controller.Principal;
import poo.trabalho.modal.Medico;
import poo.trabalho.modal.Paciente;

public class HospitalView {
	
	public static void menu(Scanner scanner) {
		HospitalController hospitalController = Principal.getHospitalController();
		int opcao = -1;
		
		do {
    		System.out.println("-------------------------------");
	    	System.out.println("\tHospital " + hospitalController.getHospital().getNome() + "\n");
	    	System.out.println("1 - Cadastrar Paciente");
	    	System.out.println("2 - Cadastrar Medico");
	    	System.out.println("3 - Consultar Paciente");
	    	System.out.println("4 - Consultar Medico");
	    	System.out.println("5 - Listar Pacientes");
	    	System.out.println("6 - Listar Medicos");
	    	System.out.println("7 - Registrar laudo medico");
	    	System.out.println("0 - Sair");
	    	System.out.println("-------------------------------");
	    	System.out.print("Escolha uma opcao -> ");
	    	opcao = scanner.nextInt();
	    	scanner.nextLine();

	        switch(opcao) {
		        case 1: // Cadastrar Paciente
		        	Paciente cadastroPaciente = PacienteView.cadastroPaciente(scanner);
		        	
		        	hospitalController.cadastrarPaciente(cadastroPaciente);
		            break;
		        case 2: // Cadastrar Medico
		        	Medico medico = MedicoView.cadastroMedico(scanner);
		        	
		        	hospitalController.cadastrarMedico(medico);
		            break;
		        case 3: // Consultar paciente
		        	PacienteView.consultaPaciente(scanner);
		        	break;
		        case 4:
		        	MedicoView.consultaMedico(scanner);
		        	break;
		        case 5: // Listar Pacientes
		        	PacienteView.infoPacientes();
		        	
		        	scanner.nextLine();
		        	break;
		        case 6:
		        	MedicoView.infoMedicos();
		        	
		        	scanner.nextLine();
		        	break;
				case 7:
					LaudoView.cadastroLaudo(scanner);
					break;
		        case 0:
		        	System.out.println("Tchau!");
		        	break;
		        default:
		        	System.out.println("Opcao invalida... Tente novamente.");
		        	
		        	scanner.nextLine();
		        	break;
	        }
    	} while(opcao != 0);
    	
    	scanner.close();
	}

}
