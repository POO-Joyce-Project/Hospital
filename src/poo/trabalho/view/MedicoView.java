package poo.trabalho.view;

import java.util.Date;
import java.util.Scanner;

import poo.trabalho.modal.Endereco;
import poo.trabalho.modal.Medico;

public class MedicoView {

	public static void PrintMedico (){ 
		
		Scanner scanner = new Scanner(System.in);
		
		String nome;
		String endereco;
		char sexo;
		Date dataNascimento;
		String crm;
		String especialidade;

		
		System.out.println("-------------------------------");
    	System.out.println("\t\tCadastro de Medico");
    	System.out.println("-------------------------------");
    	System.out.println("Informe o nome:");
    	nome = scanner.nextLine();
    	System.out.println("Informe o endereco:");
    	endereco = scanner.nextLine();
    	System.out.println("Informe o genero");
    	sexo = scanner.nextLine().charAt(0);
    	System.out.println("Informe a data de nascimento");
    	//dataNascimento = scanner.nextLine();
    	System.out.println("Informe o CRM:");
    	crm = scanner.nextLine();
    	System.out.println("Informe a especialidade:");
    	especialidade = scanner.nextLine();
    	System.out.println("-------------------------------");
    	Medico medico = new Medico(nome, endereco, sexo, null, crm, especialidade);
    	scanner.close();
	}
}
