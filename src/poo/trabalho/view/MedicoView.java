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
		
		 
		do {
			System.out.println("Informe o CPF:");
		
			
			medico.setCpf(scanner.nextLine());
			
			if (medico.getCpf().length() != 11) {
				System.out.println("O CPF tem que ter 11 caracteres... Tente novamente");
				scanner.nextLine();
			}
		} while (medico.getCpf().length() != 11);
		
		do {
			System.out.println("Informe o sexo: ");
		
			
			medico.setSexo(scanner.nextLine().toUpperCase().charAt(0));
			
			if (medico.getSexo() != 'F' && medico.getSexo() != 'M') {
				System.out.println("Sexo Inválido... Tente novamente");
				scanner.nextLine();
			}
		} while (medico.getSexo() != 'F' && medico.getSexo() != 'M');

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
			
			medico.setCrm(scanner.nextLine());
			
			if (medico.getCrm().isEmpty()) {
				System.out.println("O campo não pode ser vazio... Tente novamente");
				scanner.nextLine();
			}
		} while (medico.getCrm().isEmpty());
		
		do {
			
			System.out.println("Informe a especialidade:");
			
			medico.setEspecialidade(scanner.nextLine());
			
			if (medico.getCrm().isEmpty()) {
				System.out.println("O campo não pode ser vazio... Tente novamente");
				scanner.nextLine();
			}
		} while (medico.getCrm().isEmpty());

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
