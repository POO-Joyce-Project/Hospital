package poo.trabalho.view;

import java.util.List;

import java.util.Scanner;

import poo.trabalho.controller.Principal;
import poo.trabalho.modal.Medico;

import poo.trabalho.view.MedicoView;

public class MedicoView {

	public static Medico cadastroMedico(Scanner scanner) {
		Medico medico = new Medico();

		System.out.println("-------------------------------");
		System.out.println("\tCadastro Medico");
		System.out.println("-------------------------------");

		PessoaView.cadastroPessoa(scanner, medico);

		do {
			System.out.print("Informe o CRM: ");
			medico.setCrm(scanner.nextLine());

			if (medico.getCrm().isEmpty()) {
				System.out.println("O campo nao pode ser vazio... Tente novamente\n");
			}
		} while (medico.getCrm().isEmpty());

		do {
			System.out.print("Informe a especialidade: ");
			medico.setEspecialidade(scanner.nextLine());

			if (medico.getCrm().isEmpty()) {
				System.out.println("O campo nao pode ser vazio... Tente novamente\n");
			}
		} while (medico.getCrm().isEmpty());

		System.out.println("\nMedico cadastrado com sucesso.");

		return medico;
	}

	public static void consultaMedico(Scanner scanner) {
		System.out.println("-------------------------------");
		System.out.println("\tConsulta Medica");
		System.out.println("-------------------------------");
		System.out.println("Digite o CPF/CRM do medico: ");

		Medico medico = Principal.getHospitalController().consultarMedico(scanner.nextLine());

		System.out.println("-------------------------------");

		if (medico != null) {
			infoMedico(medico);
		} else {
			System.out.println("Medico nao encontrado... Tente Novamente.");
		}

		scanner.nextLine();
	}

	public static void infoMedico(Medico medico) {
		PessoaView.infoPessoa(medico);

		System.out.println("CRM: " + medico.getCrm());
		System.out.println("Especialidade: " + medico.getEspecialidade());
	}

	public static void infoMedicos() {
		List<Medico> medicos = Principal.getHospitalController().getHospital().getMedicos();

		if (medicos.isEmpty()) {
			System.out.println("Nenhum medico cadastrado no hospital!");
		} else {
			for (Medico medico : medicos) {
				System.out.println("-------------------------------");
				infoMedico(medico);
			}
		}
	}

}
