package poo.trabalho.view;

import java.util.List;
import java.util.Scanner;

import poo.trabalho.controller.Principal;
import poo.trabalho.modal.FichaMedica;
import poo.trabalho.modal.Paciente;

public class PacienteView {

	public static Paciente printCadastroPaciente(Scanner scanner) {
		Paciente paciente = new Paciente();
		
		char fichaMedica = 'o';
		
		System.out.println("-------------------------------");
		System.out.println(" \t\t Cadastro Paciente");
		System.out.println("-------------------------------");

		System.out.println("Informe o nome do paciente: ");
		paciente.setNome(scanner.nextLine());

		System.out.println("Informe a rua do endereco:");
		paciente.getEndereco().setRua(scanner.nextLine());

		System.out.println("Informe o bairro:");
		paciente.getEndereco().setBairro(scanner.nextLine());

		System.out.println("Informe o sexo: ");
		paciente.setSexo(scanner.nextLine().charAt(0));

		System.out.println("Informe a data de nascimento: ");
		// paciente.setDataNascimento(scanner.nextLine());
		
		System.out.println("Deseja adicionar uma ficha medica? ");
		System.out.println("Use 's' para sim e 'n' para nao ");
		fichaMedica = scanner.nextLine().charAt(0);
			if(fichaMedica == 's' || fichaMedica =='S') { 
				paciente.setFichaMedica(FichaMedicaView.printCadastroFichaMedica(scanner));
			}
		System.out.println("-------------------------------");

		return paciente;
	}

	public static void printMenuConsultaPaciente(Scanner scanner) {
		int opcao = -1;

		System.out.println("-------------------------------");
		System.out.println(" \t\t Consulta Paciente");
		System.out.println("-------------------------------");

		System.out.println("1- Consultar pelo nome");
		System.out.println("2- Consultar pela ficha medica");
		System.out.println("3- Consultar pelo ID");

		System.out.println("-------------------------------");
		System.out.print("Escolha uma opcao -> ");
		opcao = scanner.nextInt();
		scanner.nextLine();
		System.out.println("-------------------------------");

		switch (opcao) {
		case 1:
			System.out.println("Digite o nome do paciente: ");
			
			Paciente pacienteNome = Principal.getHospital().consultarPaciente(scanner.nextLine());
			
			printConsultaPaciente(pacienteNome, scanner);
			break;
		case 2:
			System.out.println("Digite o ID da ficha medica do paciente: ");
			
			Paciente paciente = Principal.getHospital().consultarPaciente(scanner.nextInt());
			scanner.nextLine();
			
			printConsultaPaciente(paciente, scanner);
			break;
		case 3:
			System.out.println("Digite o ID do paciente: ");
			
			Paciente pacienteID = Principal.getHospital().consultarPaciente(scanner.nextInt());
			scanner.nextLine();
			
			printConsultaPaciente(pacienteID, scanner);
			break;
		default:
			System.out.println("Opcao invalida... Tente novamente.");
        	
        	scanner.nextLine();
			break;
		}
	}
	
	private static void printConsultaPaciente(Paciente paciente, Scanner scanner) {
		do {
			System.out.println("-------------------------------");
			printInfoPaciente(paciente);
			System.out.println("-------------------------------");
			scanner.nextLine();
			
			if (paciente == null) {
				System.out.println("Paciente nao encontrado... Tente novamente.");
				
				scanner.nextLine();
			}
		} while (paciente == null);
	}

	public static void printInfoPaciente(Paciente paciente) {
		System.out.println("ID: " + paciente.getId());
		System.out.println("Nome: " + paciente.getNome());
		System.out.println("Endereco: " + paciente.getEndereco());
		System.out.println("Genero: " + paciente.getSexo());
		System.out.println("Data de nascimento: " + paciente.getDataNascimento() == null ? "N/A" : paciente.getDataNascimento());
		FichaMedicaView.printFichaMedica(paciente);
	}

	public static void printInfoPacientes() {
		List<Paciente> pacientes = Principal.getHospital().getPacientes();

		if (pacientes.isEmpty()) {
			System.out.println("Nenhum paciente cadastrado no hospital!");
		} else {
			for (Paciente paciente : pacientes) {
				System.out.println("-------------------------------");
				printInfoPaciente(paciente);
				System.out.println("-------------------------------");
			}
		}
	}

}
