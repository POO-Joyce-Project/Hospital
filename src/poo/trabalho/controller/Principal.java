package poo.trabalho.controller;

import java.util.Scanner;

import poo.trabalho.modal.Hospital;
import poo.trabalho.modal.Medico;
import poo.trabalho.modal.Paciente;
import poo.trabalho.view.LaudoView;
import poo.trabalho.view.MedicoView;
import poo.trabalho.view.PacienteView;

public class Principal {
	
	private static Hospital hospital = new Hospital();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
    	int opcao = -1;
    	
    	do {
    		System.out.println("-------------------------------");
	    	System.out.println("\tHospital " + hospital.getNome());
	    	System.out.println("1 - Cadastrar Paciente");
	    	System.out.println("2 - Cadastrar Medico");
	    	System.out.println("3 - Consultar Paciente");
	    	System.out.println("4 - Consultar Medico");
	    	System.out.println("5 - Listar Pacientes");
	    	System.out.println("6 - Listar Médicos");
	    	System.out.println("7 - Registrar laudo medico");
	    	System.out.println("0 - Sair");
	    	System.out.println("-------------------------------");
	    	System.out.print("Escolha uma opcao -> ");
	    	opcao = scanner.nextInt();
	    	scanner.nextLine();

	        switch(opcao) {
		        case 1: // Cadastrar Paciente
		        	Paciente cadastroPaciente = PacienteView.printCadastroPaciente(scanner);
		        	
		        	hospital.cadastrarPaciente(cadastroPaciente);
		            break;
		        case 2: // Cadastrar Medico
		        	Medico medico = MedicoView.cadastroMedico(scanner);
		        	
		        	hospital.cadastrarMedico(medico);
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
					LaudoView.printCadastroLaudo(scanner, null);
					
					scanner.nextLine();
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
	
	public static Hospital getHospital() {
		return hospital;
	}

}
