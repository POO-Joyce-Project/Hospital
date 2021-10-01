package poo.trabalho.view;

import java.util.List;
import java.util.Scanner;

import poo.trabalho.controller.Principal;
import poo.trabalho.modal.Paciente;

public class PacienteView {

	public static Paciente printCadastroPaciente(Scanner scanner) {
		Paciente paciente = new Paciente();

		char fichaMedica = 'N';

		System.out.println("-------------------------------");
		System.out.println(" \t\t Cadastro Paciente");
		System.out.println("-------------------------------");

		System.out.println("Informe o nome do paciente: ");
		paciente.setNome(scanner.nextLine());

		System.out.println("Informe o CPF:");
		paciente.setCpf(scanner.nextLine());

		System.out.println("Informe o sexo: ");
		paciente.setSexo(scanner.nextLine().toUpperCase().charAt(0));

		System.out.println("Informe a data de nascimento: ");
		// paciente.setDataNascimento(scanner.nextLine());

		System.out.println("Informe o tipo sanguineo:");
		paciente.setTipoSanguineo(scanner.nextLine().toUpperCase());

		System.out.println("Deseja adicionar uma ficha medica? ");
		System.out.println("Use 'S' para sim e 'N' para nao.");
		fichaMedica = scanner.nextLine().toUpperCase().charAt(0);

		if (fichaMedica == 'S') {
			paciente.adicionarLaudo(LaudoView.printCadastroLaudo(scanner, paciente));
		}

		return paciente;
	}

	public static void consultaPaciente(Scanner scanner) {
		System.out.println("-------------------------------");
		System.out.println(" \t\t Consulta Paciente");
		System.out.println("-------------------------------");
		System.out.println("Digite o CPF do paciente: ");

		Paciente paciente = Principal.getHospital().consultarPaciente(scanner.nextLine());

		System.out.println("-------------------------------");
		
		if (paciente != null) {
			infoPaciente(paciente);
		} else {
			System.out.println("Paciente nao encontrado... Tente novamente.");
		}
		
		scanner.nextLine();
	}

	public static void infoPaciente(Paciente paciente) {
		System.out.println("Nome: " + paciente.getNome());
		System.out.println("CPF: " + paciente.getCpf());
		System.out.println("Genero: " + paciente.getSexo());
		System.out.println("Data de nascimento: " + paciente.getDataNascimento() == null ? "N/A" : paciente.getDataNascimento());
		System.out.println("Tipo sanguineo: " + paciente.getTipoSanguineo());
		System.out.println("Ficha medica: ");
		LaudoView.printLaudos(paciente.getLaudos());
	}

	public static void infoPacientes() {
		List<Paciente> pacientes = Principal.getHospital().getPacientes();

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
