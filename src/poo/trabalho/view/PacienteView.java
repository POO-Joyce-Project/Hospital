package poo.trabalho.view;

import java.util.List;
import java.util.Scanner;

import poo.trabalho.controller.Principal;
import poo.trabalho.modal.Paciente;

public class PacienteView {

	public static Paciente printCadastroPaciente(Scanner scanner) {
		Paciente paciente = new Paciente();
		
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
		//paciente.setDataNascimento(scanner.nextLine());
		
		System.out.println("Informe o CPF:");
    	paciente.setCpf(scanner.nextInt());
    	
		
		System.out.println("-------------------------------");
		
		return paciente;
	}
	
	
	
	
	public static void printInfoPaciente(Paciente paciente) {
		System.out.println("ID: " + paciente.getId());
		System.out.println("Nome: " + paciente.getNome());
		System.out.println("Endereco: " + paciente.getEndereco());
		System.out.println("Genero: " + paciente.getSexo());
		System.out.println("Data de nascimento: " + paciente.getDataNascimento() == null ? "N/A" : paciente.getDataNascimento());
		System.out.println("Ficha m�dica: " + paciente.getFichaMedica() == null ? "N/A" : paciente.getDataNascimento());
	}
	
	public static void printInfoPacientes() {
		List<Paciente> pacientes = Principal.getHospital().getPacientes();
		
		if (pacientes.isEmpty()) {
			System.out.println("Nenhum paciente cadastrado no hospital!");
		} else {
			pacientes.forEach(paciente -> printInfoPaciente(paciente));
		}
		
//		for (Paciente paciente : pacientes) {
//			printInfoPaciente(paciente);
//		}
		
	}

}
