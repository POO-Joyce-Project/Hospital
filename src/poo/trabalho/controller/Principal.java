package poo.trabalho.controller;

import java.util.ArrayList;
import java.util.Scanner;

import poo.trabalho.modal.Endereco;
import poo.trabalho.modal.Hospital;

public class Principal {
	
	private static Hospital hospital;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
    	int opcao = -1;
    	
    	Endereco enderecoHospital = new Endereco("Área Especial 8, 9, 10, St. C Norte Qnc", "Taguatinga Norte", "Brasília", "DF", "72115-700");
    	hospital = new Hospital("Anchienta", enderecoHospital, new ArrayList<>(), new ArrayList<>());
    	
    	do {
    		System.out.println("-------------------------------");
	    	System.out.println("\t\tHospital");
	    	System.out.println("1 - Cadastrar Paciente");
	    	System.out.println("2 - Cadastrar Médico");
	    	System.out.println("3 - Buscar Paciente");
	    	System.out.println("4 - Buscar Médico");
	    	System.out.println("5 - Imprimir Pacientes");
	    	System.out.println("6 - Imprimir Médicos");
	    	System.out.println("0 - Sair");
	    	System.out.println("-------------------------------");
	    	System.out.print("Escolha uma opção -> ");
	    	opcao = scanner.nextInt();

	        switch(opcao) {
		        case 1:
		        	// Cadastrar paciente
		            break;
		        case 2:
		        	// Cadastrar médico
		            break;
		        case 3:
		        	// Buscar paciente
		        	break;
		        case 4:
		        	// Buscar médico
		        	break;
		        case 5:
		        	// Imprimir pacientes
		        	break;
		        case 6:
		        	// Imprimir médicos
		        	break;
		        case 0:
		        	System.out.println("Tchau!");
		        	break;
		        default: 
		        	System.out.println("Opção inválida... Tente novamente.");
		        	scanner.next();
		        	break;
	        }
    	} while(opcao != 0);
    	
    	scanner.close();
	}
	
	public static Hospital getHospital() {
		return hospital;
	}

}
