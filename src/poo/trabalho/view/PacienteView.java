package poo.trabalho.view;

import java.util.List;
import java.util.Scanner;

import poo.trabalho.controller.Principal;
import poo.trabalho.modal.Laudo;
import poo.trabalho.modal.Paciente;

public class PacienteView {

	public static Paciente cadastroPaciente(Scanner scanner) {
		Paciente paciente = new Paciente();
		
		char fichaMedica = 'N';
		
		System.out.println("-------------------------------");
		System.out.println("\tCadastro Paciente");
		System.out.println("-------------------------------");
		
		PessoaView.cadastroPessoa(scanner, paciente);
		
		System.out.println("Deseja adicionar uma ficha medica? ");
		System.out.println("Use 'S' para sim e 'N' para nao.");
		fichaMedica = scanner.nextLine().toUpperCase().charAt(0);
		
		if (fichaMedica == 'S') {
			Laudo laudo = LaudoView.cadastroLaudo(scanner, paciente);
			
			paciente.adicionarLaudo(laudo);
		} else {
			System.out.println("\nPaciente cadastrado com sucesso.");	
		}
		
		return paciente;
	}

	public static void consultaPaciente(Scanner scanner) {
		System.out.println("-------------------------------");
		System.out.println("\tConsulta Paciente");
		System.out.println("-------------------------------");
		System.out.println("Digite o CPF do paciente: ");

		Paciente paciente = Principal.getHospitalController().consultarPaciente(scanner.nextLine());

		System.out.println("-------------------------------");
		
		if (paciente != null) {
			infoPaciente(paciente);
		} else {
			System.out.println("Paciente nao encontrado... Tente novamente.");
		}
		
		scanner.nextLine();
	}

	public static void infoPaciente(Paciente paciente) {
		PessoaView.infoPessoa(paciente);
		
		System.out.println("Ficha medica: ");
		LaudoView.listarLaudos(paciente.getLaudos());
	}

	public static void infoPacientes() {
		List<Paciente> pacientes = Principal.getHospitalController().getHospital().getPacientes();

		if (pacientes.isEmpty()) {
			System.out.println("Nenhum paciente cadastrado no hospital!");
		} else {
			for (Paciente paciente : pacientes) {
				System.out.println("-------------------------------");
				infoPaciente(paciente);
			}
		}
	}

}
