package poo.trabalho.view;

import java.util.List;
import java.util.Scanner;

import poo.trabalho.controller.Principal;
import poo.trabalho.modal.Laudo;
import poo.trabalho.modal.Medico;
import poo.trabalho.modal.Paciente;

public class LaudoView {
	
	public static Laudo printCadastroLaudo(Scanner scanner, Paciente paciente) {
		if (Principal.getHospital().getMedicos().isEmpty()) {
			System.out.println("Nenhum medico cadastrado no hospital!");
			return null;
		}
		if (Principal.getHospital().getPacientes().isEmpty() && paciente == null) {
			System.out.println("Nenhum paciente cadastrado no hospital!");
			return null;
		}
		
		Laudo laudo = new Laudo();
		Medico medico = null;
		
		System.out.println("-------------------------------");
		System.out.println(" \t\t Cadastro Laudo Medico");
		System.out.println("-------------------------------");
		
		if (paciente == null) {
			System.out.println("Informe o CPF do paciente: ");
			paciente = Principal.getHospital().consultarPaciente(scanner.nextLine());
		}
		
		System.out.println("Informe o diagnostico: ");
		laudo.setDiagnostico(scanner.nextLine());
		
		System.out.println("Informe os sintomas separados por virgula: ");
		laudo.setSintomas(scanner.nextLine());
		
		System.out.println("Informe a medicacao regular: ");
		laudo.setMedicacaoRegular(scanner.nextLine());
		
		System.out.println("Informe a observacao: ");
		laudo.setObservacao(scanner.nextLine());
		
		do {
			System.out.println("Informe o CPF/CRM do medico responsavel: ");
			
			medico = Principal.getHospital().consultarMedico(scanner.nextLine());
			
			if (medico == null) {
				System.out.println("Medico nao encontrado... Tente Novamente.");
				scanner.nextLine();
			}
		} while (medico == null);
		
		laudo.setMedicoResponsavel(medico);
		
		paciente.adicionarLaudo(laudo);
    	
    	return laudo;
	}
	
	public static void printLaudos(List<Laudo> laudos) {
		
		if (laudos == null) {
			System.out.println("N/A");
		} else {
			int count = 1;
			
			for (Laudo laudo : laudos) {
				System.out.println("  Laudo " + count + ":");
				System.out.println(laudo);
				System.out.println("");
				
				count++;
			}
		}
	}

}
