package poo.trabalho.view;

import java.util.List;
import java.util.Scanner;

import poo.trabalho.modal.Laudo;
import poo.trabalho.modal.Medico;

public class LaudoView {

	public static Laudo printCadastroLaudo(Scanner scanner, Medico medico) {
		Laudo laudo = new Laudo();
		
		System.out.println("-------------------------------");
		System.out.println(" \t\t Cadastro Laudo Medico");
		System.out.println("-------------------------------");
		
		System.out.println("Informe os sintomas separados por virgula: ");
		laudo.setSintomas(scanner.nextLine());
		
		System.out.println("Informe a observacao: ");
		laudo.setObservacao(scanner.nextLine());
		
		System.out.println("Informe o diagnostico: ");
		laudo.setDiagnostico(scanner.nextLine());
		
		System.out.println("Informe a medicacao regular: ");
		laudo.setMedicacaoRegular(scanner.nextLine());
		
		System.out.println("-------------------------------");
    	
    	return laudo;
	}
	
	public static void printLaudos(List<Laudo> laudos) {
		
		if (laudos == null) {
			System.out.println("N/A");
		} else {
			for (Laudo laudo : laudos) {
				System.out.println(laudo);
			}
		}
	}

}
