package poo.trabalho.view;

import java.util.List;
import java.util.Scanner;

import poo.trabalho.controller.Principal;
import poo.trabalho.modal.Medico;

public class MedicoView {

	public static Medico printMedico(Scanner scanner) {
		Medico medico = new Medico();
		
		System.out.println("-------------------------------");
    	System.out.println("\t\tCadastro de Medico");
    	System.out.println("-------------------------------");
    	
    	System.out.println("Informe o nome: ");
    	medico.setNome(scanner.nextLine());
    	
    	System.out.println("Informe o genero: ");
    	medico.setSexo(scanner.nextLine().toUpperCase().charAt(0));
    	
    	System.out.println("Informe a data de nascimento: ");
    	//dataNascimento = scanner.nextLine();
    	
    	System.out.println("Informe o CRM: ");
    	medico.setCrm(scanner.nextLine());
    	
    	System.out.println("Informe a especialidade: ");
    	medico.setEspecialidade(scanner.nextLine());
    	
    	System.out.println("-------------------------------");
    	
    	return medico;
	}
	
	public static void printInfoMedico(Medico medico) {
		System.out.println("ID: " + medico.getId());
		System.out.println("Nome: " + medico.getNome());
		System.out.println("Genero: " + medico.getSexo());
		System.out.println("Data de nascimento: " + medico.getDataNascimento() == null ? "N/A" : medico.getDataNascimento());
		System.out.println("CRM: " + medico.getCrm());
		System.out.println("Especialidade: " + medico.getEspecialidade());
	}
	
	public static void printInfoMedico() {
		List<Medico> medicos = Principal.getHospital().getMedicos();
		
		if (medicos.isEmpty()) {
			System.out.println("Nenhum medico cadastrado no hospital!");
		} else {
			for (Medico medico : medicos) {
				printInfoMedico(medico);
			}
		}
	}
	
	
}
