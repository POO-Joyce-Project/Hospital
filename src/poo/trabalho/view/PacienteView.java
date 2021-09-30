package poo.trabalho.view;

import java.util.Date;
import java.util.Scanner;
import poo.trabalho.modal.Paciente;
import poo.trabalho.modal.FichaMedica;

public class PacienteView {
	
	public static void printCadastroPaciente() {
		Scanner scanner = new Scanner(System.in);
		
		Paciente paciente = new Paciente(null, null, (char) 0, null, null, null);
		
		String nome;
		String endereco;
		Date dataNascimento;
		char sexo;
		
	System.out.println("-------------------------------");
	System.out.println(" \t\t Cadastro Paciente");
	System.out.println("-------------------------------");
	System.out.println("Informe o nome do paciente: ");
	paciente.setNome(scanner.nextLine());
	System.out.println("Informe o endereco: ");
	//paciente.getEndereco(scanner.nextLine());
	System.out.println("Informe o sexo: ");
	paciente.setSexo(scanner.nextLine().charAt(0));
	System.out.println("Informe a data de nascimento: ");
	//paciente.setDataNascimento(scanner.nextLine());
	System.out.println("-------------------------------");
	
	scanner.close();
	
	return new Paciente
	
	}
	
	
	

}
