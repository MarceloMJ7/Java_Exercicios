package desafio_3;

import javax.swing.JOptionPane;

/*
		Desenvolva um sistema de votação para uma eleição. O programa terá um menu que
		deve permitir ao usuário digitar o número do candidato de sua escolha, que varia de
		1 a 5, e em seguida, exibir uma mensagem informando o nome e a plataforma política
		do candidato escolhido.
		Após o usuário digitar o número do candidato, deve-se verificar o número digitado e
		exibir uma mensagem com o nome e a plataforma política do candidato escolhido.
		Caso o número digitado não corresponda a nenhum candidato válido, o programa
		deve exibir uma mensagem de erro.
 */
public class Main {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null,
				"Sistema de votação para eleição do maior clube de futebol Brasileiro São Paulo F.C");

		while (true) {
			int candidatos = numeroCandidato();
			candidatosInformacoes(candidatos);
			int continuar = JOptionPane.showConfirmDialog(null, "Deseja continuar a votação?", "Continuar?",
					JOptionPane.YES_NO_OPTION);
			if (continuar != JOptionPane.YES_OPTION) {
				break;
			}
		}
	}

	public static int numeroCandidato() { // Retorna o número do candidato
		String candidato;
		int candidatoNumero = 0;
		boolean validacao = false;

		while (!validacao) {
			candidato = JOptionPane.showInputDialog(null, "Candidados para eleição do Clube São Paulo F.C \n"
					+ "(1) Rogério Ceni \n" + "(2) Kaká \n" + "(3) Raí \n" + "(4) Calleri \n" + "(5) Lugano \n");
			if (isNumeric(candidato)) {
				candidatoNumero = Integer.parseInt(candidato);
			}if (candidatoNumero >= 1 && candidatoNumero <= 5) {
				validacao = true;
			}
			else {
				JOptionPane.showMessageDialog(null, "Escolha uma opção válida entre 1 e 5");
			}
		}
		return candidatoNumero;
	}

	public static boolean isNumeric(String str) {

		if (str == null || str.isEmpty()) {
			return false;
		}
		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

	public static void candidatosInformacoes(int numeroCandidato) {

		switch (numeroCandidato) {
		case 1:
			JOptionPane.showMessageDialog(null,
					"Rogério Ceni \n" + "- Promete que os goleiros sejam qualificados e que aprendam a bater faltas.");
			break;
		case 2:
			JOptionPane.showMessageDialog(null,
					"Kaká \n" + "- Promete fazer com que os novos jogadores da base comecem a ir para igreja.");
			break;
		case 3:
			JOptionPane.showMessageDialog(null, "Raí \n" + "- Promete uma melhora no ataque tricolor.");
			break;
		case 4:
			JOptionPane.showMessageDialog(null, "Calleri \n"
					+ "- Promete que a nova geração de atacantes façam gols principalmente no Corinthians.");
			break;
		case 5:
			JOptionPane.showMessageDialog(null,
					"Lugano \n" + "- Promete que a nova geração de zagueiros sejam mais raçudos.");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Número de candidato inválido!");
			break;

		}
	}
}
