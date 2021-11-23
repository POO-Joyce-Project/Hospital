package poo.trabalho.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	public static String formatarCPF(String cpf) {
		return cpf.replaceAll("([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})", "$1.$2.$3-$4");
	}

	public static String formatarNascimento(Date nascimento) {
		return new SimpleDateFormat("dd/MM/yyyy").format(nascimento);
	}

}
