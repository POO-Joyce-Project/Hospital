package poo.trabalho.view;

import java.util.List;

import java.util.Scanner;

import poo.trabalho.controller.Principal;
import poo.trabalho.modal.Medico;

import poo.trabalho.view.MedicoView;

public class MedicoView {

	public static Medico cadastroMedico(Scanner scanner) {
		Medico medico = new Medico();

		System.out.println("-------------------------------");
		System.out.println(" \t\t Cadastro Medico");
		System.out.println("-------------------------------");

		do {
			System.out.println("Informe o nome do medico: ");
			
			medico.setNome(scanner.nextLine());
			
			if (medico.getNome().isEmpty()) {
				System.out.println("O campo não pode ser vazio... Tente novamente");
				scanner.nextLine();
			}
		} while (medico.getNome().isEmpty());
		
		 

		System.out.println("Informe o CPF:");
		medico.setCpf(scanner.nextLine());

		System.out.println("Informe o sexo: ");
		medico.setSexo(scanner.nextLine().toUpperCase().charAt(0));

		System.out.println("Informe a data de nascimento: ");
		// dataNascimento = scanner.nextLine();

		do {
			System.out.println("Informe o tipo sanguineo:");
			
			medico.setTipoSanguineo(scanner.nextLine().toUpperCase());
			
			if (medico.getTipoSanguineo().isEmpty()) {
				System.out.println("O campo não pode ser vazio... Tente novamente");
				scanner.nextLine();
			}
		} while (medico.getTipoSanguineo().isEmpty());
		
		do {
			System.out.println("Informe o CRM:");
			
			medico.setCrm(scanner.nextLine().toUpperCase());
			
			if (medico.getCrm().isEmpty()) {
				System.out.println("O campo não pode ser vazio... Tente novamente");
				scanner.nextLine();
			}
		} while (medico.getCrm().isEmpty());

		
		do {
			System.out.println("Informe a especialidade:");
			
			medico.setEspecialidade(scanner.nextLine().toUpperCase());
			
			if (medico.getEspecialidade().isEmpty()) {
				System.out.println("O campo não pode ser vazio... Tente novamente");
				scanner.nextLine();
			}
		} while (medico.getEspecialidade().isEmpty());
		
		
		
		
		

		return medico;
	}

	public static void consultaMedico(Scanner scanner) {
		System.out.println("-------------------------------");
		System.out.println(" \t\t Consulta Medica");
		System.out.println("-------------------------------");
		System.out.println("Digite o CPF/CRM do medico: ");
		
		Medico medico = Principal.getHospital().consultarMedico(scanner.nextLine());
		
		System.out.println("-------------------------------");
		
		if (medico != null) {
			infoMedico(medico);
		} else {
			System.out.println("Medico nao encontrado... Tente Novamente.");
		}
		
		scanner.nextLine();
	}

	public static void infoMedico(Medico medico) {
		System.out.println("Nome: " + medico.getNome());
		System.out.println("CPF: " + medico.getCpf());
		System.out.println("Genero: " + medico.getSexo());
		System.out.println("Data de nascimento: " + medico.getDataNascimento() == null ? "N/A" : medico.getDataNascimento());
		System.out.println("Tipo sanguineo: " + medico.getTipoSanguineo());
		System.out.println("CRM: " + medico.getCrm());
		System.out.println("Especialidade: " + medico.getEspecialidade());
	}

	public static void infoMedicos() {
		List<Medico> medicos = Principal.getHospital().getMedicos();

		if (medicos.isEmpty()) {
			System.out.println("Nenhum medico cadastrado no hospital!");
		} else {
			for (Medico medico : medicos) {
				System.out.println("-------------------------------");
				infoMedico(medico);
			}
		}
	}

}
