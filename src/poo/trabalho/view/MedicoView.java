package poo.trabalho.view;

import java.util.Scanner;

import poo.trabalho.modal.Medico;

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
    	
    	System.out.println("Informe o CRM:");
    	medico.setCrm(scanner.nextLine());
    	
    	System.out.println("Informe a especialidade:");
    	medico.setEspecialidade(scanner.nextLine());
    	
    	System.out.println("-------------------------------");
    	
    	return medico;
	}
}
