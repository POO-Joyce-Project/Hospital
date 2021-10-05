package poo.trabalho.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import poo.trabalho.controller.Principal;
import poo.trabalho.modal.Pessoa;

public class PessoaView {

	public static Pessoa printCadastroPaciente(Scanner scanner, Pessoa pessoa) {
		do {
			System.out.print("Informe o nome: ");
			pessoa.setNome(scanner.nextLine());
			
			if (pessoa.getNome().isBlank()) {
				System.out.println("O campo nao pode ser vazio... Tente novamente\n");
			}
		} while (pessoa.getNome().isBlank());
		 
		do {
			System.out.print("Informe o CPF: ");
			pessoa.setCpf(scanner.nextLine());
			
			if (pessoa.getNome().isBlank() || pessoa.getCpf().length() != 11) {
				System.out.println("O CPF tem que ter 11 caracteres... Tente novamente\n");
			}
		} while (pessoa.getNome().isBlank() || pessoa.getCpf().length() != 11);
		
		do {
			System.out.print("Informe o sexo: ");
			pessoa.setSexo(scanner.nextLine().toUpperCase().charAt(0));
			
			if (pessoa.getSexo() != 'F' && pessoa.getSexo() != 'M') {
				System.out.println("Sexo Invalido... Tente novamente\n");
			}
		} while (pessoa.getSexo() != 'F' && pessoa.getSexo() != 'M');

		boolean isInvalid;
		do {
			isInvalid = false;
			
			System.out.print("Informe a data de nascimento (dd/mm/yyyy): ");
			String dataNascimento = scanner.nextLine();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	        sdf.setLenient(false);
	        
	        try {
	        	Date date = sdf.parse(dataNascimento);
	        	
	        	pessoa.setDataNascimento(date);
	        } catch (ParseException ex) {
	        	if (dataNascimento.isBlank()) {
	        		System.out.println("O campo nao pode ser vazio... Tente novamente\n");
	        	} else {
	        		System.out.println("Data de nascimento com formatacao invalida... Tente novamente\n");
	        	}
	        	
	        	isInvalid = true;
	        }
		} while (isInvalid);
		
		do {
			System.out.print("Informe o tipo sanguineo: ");
			
			pessoa.setTipoSanguineo(scanner.nextLine().toUpperCase());
			
			if (pessoa.getTipoSanguineo().isBlank()) {
				System.out.println("O campo nao pode ser vazio... Tente novamente\n");
			}
		} while (pessoa.getTipoSanguineo().isBlank());

		return pessoa;
	}

	public static void consultaPaciente(Scanner scanner) {
		System.out.println("-------------------------------");
		System.out.println("\tConsulta");
		System.out.println("-------------------------------");
		System.out.println("Digite o CPF: ");
		
		Pessoa pessoa = Principal.getHospital().consultarPessoa(scanner.nextLine());
		
		System.out.println("-------------------------------");
		
		if (pessoa != null) {
			infoPessoa(pessoa);
		} else {
			System.out.println("Individuo nao encontrado... Tente novamente.");
		}
		
		scanner.nextLine();
	}

	public static void infoPessoa(Pessoa pessoa) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateFormatted = sdf.format(pessoa.getDataNascimento());
        String cpfFormatted = pessoa.getCpf().substring(0, 3) + "." + pessoa.getCpf().substring(3, 6) + "." + pessoa.getCpf().substring(6, 9) + "-" + pessoa.getCpf().substring(9, 11);
  
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("CPF: " + cpfFormatted);
		System.out.println("Genero: " + pessoa.getSexo());
		System.out.println("Data de nascimento: " + dateFormatted);
		System.out.println("Tipo sanguineo: " + pessoa.getTipoSanguineo());
	}
	
	public static void infoPessoas() {
		List<Pessoa> pessoas = new ArrayList<>();
		
		pessoas.addAll(Principal.getHospital().getMedicos());
		pessoas.addAll(Principal.getHospital().getPacientes());
		
		if (pessoas.isEmpty()) {
			System.out.println("Nenhum individuo cadastrado no hospital!");
		} else {
			System.out.println("-------------------------------");
			System.out.println("\tIndividuos");
			
			for (Pessoa paciente : pessoas) {
				System.out.println("-------------------------------");
				infoPessoa(paciente);
			}
		}
	}

}
