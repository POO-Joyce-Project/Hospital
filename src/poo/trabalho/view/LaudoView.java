package poo.trabalho.view;

import java.util.List;
import java.util.Scanner;

import poo.trabalho.controller.HospitalController;
import poo.trabalho.controller.Principal;
import poo.trabalho.modal.Laudo;
import poo.trabalho.modal.Medico;
import poo.trabalho.modal.Paciente;

public class LaudoView {
	
	public static Laudo cadastroLaudo(Scanner scanner, Paciente paciente) {
		HospitalController hospitalController = Principal.getHospitalController();
		
		if (hospitalController.getHospital().getMedicos().isEmpty()) {
			System.out.println("Nenhum medico cadastrado no hospital!");
			return null;
		}
		if (hospitalController.getHospital().getPacientes().isEmpty() && paciente == null) {
			System.out.println("Nenhum paciente cadastrado no hospital!");
			return null;
		}
		
		Laudo laudo = new Laudo();
		Medico medico = null;
		
		System.out.println("-------------------------------");
		System.out.println("\tCadastro Laudo Medico");
		System.out.println("-------------------------------");
		
		if (paciente == null) {
			do {
				System.out.print("Informe o CPF do paciente: ");
				paciente = hospitalController.consultarPaciente(scanner.nextLine());
				
				if (paciente == null) {
					System.out.println("Paciente nao encontrado... Tente novamente\n");
				}
			} while (paciente == null);
		}
		
		do {
			System.out.print("Informe o diagnostico: ");
			laudo.setDiagnostico(scanner.nextLine());
			
			if (laudo.getDiagnostico().isBlank()) {
				System.out.println("O campo nao pode ser vazio... Tente novamente\n");
			}
		} while (laudo.getDiagnostico().isBlank());
		
		do {
			System.out.print("Informe os sintomas: ");
			laudo.setSintomas(scanner.nextLine());
			
			if (laudo.getSintomas().isBlank()) {
				System.out.println("O campo nao pode ser vazio... Tente novamente\n");
			}
		} while (laudo.getSintomas().isBlank());
		
		do {
			System.out.print("Informe a medicacao regular: ");
			laudo.setMedicacaoRegular(scanner.nextLine());
			
			if (laudo.getMedicacaoRegular().isBlank()) {
				System.out.println("O campo nao pode ser vazio... Tente novamente\n");
			}
		} while (laudo.getMedicacaoRegular().isBlank());
		
		do {
			System.out.print("Informe a observacao: ");
			laudo.setObservacao(scanner.nextLine());
			
			if (laudo.getObservacao().isBlank()) {
				System.out.println("O campo nao pode ser vazio... Tente novamente\n");
			}
		} while (laudo.getObservacao().isBlank());
		
		do {
			System.out.print("Informe o CPF/CRM do medico responsavel: ");
			medico = hospitalController.consultarMedico(scanner.nextLine());
			
			if (medico == null) {
				System.out.println("Medico nao encontrado... Tente novamente\n");
			}
		} while (medico == null);
		
		laudo.setMedicoResponsavel(medico);
		
		paciente.adicionarLaudo(laudo);
		
		System.out.println("\nLaudo medico registrado com sucesso.");
    	
    	return laudo;
	}
	
	public static Laudo cadastroLaudo(Scanner scanner) {
    	return cadastroLaudo(scanner, null);
	}
	
	public static void infoLaudo(Laudo laudo) {
		System.out.println("    - Diagnostico: " + laudo.getDiagnostico());
		System.out.println("    - Sintomas: " +  laudo.getSintomas());
		System.out.println("    - Medicacao regular: " + laudo.getMedicacaoRegular());
		System.out.println("    - Observacao: " +  laudo.getObservacao());
		System.out.println("    - Medico responsavel: " + laudo.getMedicoResponsavel().getNome());
	}
	
	public static void infoLaudos(List<Laudo> laudos) {
		
		if (laudos == null || laudos.isEmpty()) {
			System.out.println("N/A");
		} else {
			int count = 1;
			
			for (Laudo laudo : laudos) {
				System.out.println("  Laudo " + count + ":");
				infoLaudo(laudo);
				
				count++;
			}
		}
	}

}
