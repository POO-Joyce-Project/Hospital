package poo.trabalho.view;

import java.util.Scanner;

import poo.trabalho.modal.FichaMedica;


public class FichaMedicaView {

	public static FichaMedica printCadastroFichaMedica(Scanner scanner) {
		FichaMedica fichaMedica = new FichaMedica(null, null, null, null, 0, 0, 0, null);
		
		System.out.println("-------------------------------");
		System.out.println(" \t\t Cadastro Ficha Medica");
		System.out.println("-------------------------------");
		
		System.out.println("Informe o id da ficha medica: ");
		fichaMedica.setId(scanner.nextInt());
		scanner.nextLine();
		
		System.out.println("Informe os sintomas separados por virgula:");
		fichaMedica.setSintomas(scanner.nextLine());
    	
    	System.out.println("Informe o tipo sanguineo:");
    	fichaMedica.setTipoSanguineo(scanner.nextLine());
    	
		System.out.println("Informe a altura: ");
		fichaMedica.setAltura(scanner.nextFloat());
		
		System.out.println("Informe o peso: ");
		fichaMedica.setPeso(scanner.nextFloat());
		
		System.out.println("Informe a medicacao regular:");
		fichaMedica.setMedicacaoRegular(scanner.nextLine());
		
		System.out.println("-------------------------------");
    	
    	return fichaMedica;
	}


}
