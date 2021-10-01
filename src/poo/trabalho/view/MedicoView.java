package poo.trabalho.view;

import java.util.List;
import java.util.Scanner;

import poo.trabalho.controller.Principal;
import poo.trabalho.modal.Medico;
import poo.trabalho.view.MedicoView;

public class MedicoView {

	public static Medico printMedico(Scanner scanner) {
		Medico medico = new Medico();
		
		System.out.println("-------------------------------");
    	System.out.println("\t\tCadastro de Medico");
    	System.out.println("-------------------------------");
    	
    	System.out.println("Informe o nome:");
    	medico.setNome(scanner.nextLine());
    	
    	System.out.println("Informe a rua do endereco:");
    	medico.getEndereco().setRua(scanner.nextLine());
    	
    	System.out.println("Informe o bairro:");
    	medico.getEndereco().setBairro(scanner.nextLine());
    	
    	System.out.println("Informe o genero");
    	medico.setSexo(scanner.nextLine().charAt(0));
    	
    	System.out.println("Informe a data de nascimento");
    	//dataNascimento = scanner.nextLine();
    	
    	System.out.println("Informe o CPF:");
    	medico.setCpf(scanner.nextInt());
    	
    	System.out.println("Informe o CRM:");
    	medico.setCrm(scanner.nextLine());
    	
    	System.out.println("Informe a especialidade:");
    	medico.setEspecialidade(scanner.nextLine());
    	
    	System.out.println("-------------------------------");
    	
    	return medico;
	}
	
	public static void printConsultaMedico(Scanner scanner) {
		
		int opcao = 0;
		
		System.out.println("-------------------------------");
		System.out.println("\t\t Consulta Medica");
		System.out.println("-------------------------------");
		System.out.println("1 - Consultar pelo CPF.");
		System.out.println("2 - Consultar pelo ID");
		System.out.println("-------------------------------");
		System.out.println("Escolha uma opcao: ");
		opcao = scanner.nextInt();
		scanner.nextLine();
		
		switch (opcao) {
		case 1: 
			System.out.println("-------------------------------");
			System.out.println("Digite o CPF do medico: ");
			System.out.println("-------------------------------");

		
			Medico medicoCrm = Principal.getHospital().consultarMedicoCpf(scanner.nextInt());
			
				do {
					System.out.println("-------------------------------");
					System.out.println("Informacoes do medico: ");
					printInfoMedico(medicoCrm);
					System.out.println("-------------------------------");
					scanner.nextLine();
				
					if(medicoCrm == null) {
						System.out.println("Medico nao encontrado... Tente Novamente.");
						scanner.nextLine();
					}
				} while (medicoCrm == null);
			break;
		case 2: 
			System.out.println("-------------------------------");
			System.out.println("Digite o Id do medico: ");
			System.out.println("-------------------------------");

		
			Medico medicoId = Principal.getHospital().consultarMedico(scanner.nextInt());
			
				do {
					System.out.println("-------------------------------");
					System.out.println("Informacoes do medico: ");
					printInfoMedico(medicoId);
					System.out.println("-------------------------------");
					scanner.nextLine();
				
					if(medicoId == null) {
						System.out.println("Medico nao encontrado... Tente Novamente.");
						scanner.nextLine();
					}
				} while (medicoId == null);
			break;
		default: 
			System.out.println("Opcao invalida... Tente Novamente.");
			break;
		
		}
	
}
	
	public static void printInfoMedico(Medico medico) {
		System.out.println("ID: " + medico.getId());
		System.out.println("Nome: " + medico.getNome());
		System.out.println("Endereco: " + medico.getEndereco());
		System.out.println("Genero: " + medico.getSexo());
		System.out.println("Data de nascimento: " + medico.getDataNascimento() == null ? "N/A" : medico.getDataNascimento());
		System.out.println("CRM: " + medico.getCrm());
		System.out.println("Especialidade: " + medico.getEspecialidade());
		
	}
	
	
	public static void printInfoMedico() {
		List<Medico> medicos = Principal.getHospital().getMedicos();
		
		if (medicos.isEmpty()) {
			System.out.println("Nenhum medico cadastrado no hospital!");
		} else {
			medicos.forEach(paciente -> printInfoMedico(paciente));
		}
	
	}
	
	
}
