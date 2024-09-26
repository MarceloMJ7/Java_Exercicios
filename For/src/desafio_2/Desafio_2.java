package desafio_2;

import javax.swing.JOptionPane;

/*
 Construa um programa que solicita ao usuário uma frase. Ao final, indique quantas
vogais, consoantes, espaços e outros caracteres compõem essa frase.
 */
public class Desafio_2 {

	public static void main(String[] args) {
		String infoUser = user();
		char letras;
		int vogais = 0, espaco = 0, consoantes = 0;

		for (int i = 0; i < infoUser.length(); i++) {
			letras = infoUser.charAt(i);

			if (letras == 'a' || letras == 'e' || letras == 'i' || letras == 'o' || letras == 'u') {
				vogais = vogais + 1;
			} else if (Character.isLetter(letras)) {
				consoantes = consoantes + 1;
			}
			if (Character.isWhitespace(letras)) {
				espaco = espaco + 1;
			}

		}

		JOptionPane.showMessageDialog(null, "Número de vogais:  " + vogais + " \nNúmero de consoantes:  " + consoantes + " \nNúmero de espaços: " + espaco);

	}

	public static String user() { // Fiz uma pequena verificação para identificar se o user está digitando números
									// ou Strings.
		String palavra = null;
		boolean verifica = false;

		while (!verifica) {
			palavra = JOptionPane.showInputDialog(null, "Informe uma palavra: ");

			if (isNumeric(palavra)) {
				JOptionPane.showMessageDialog(null, "Digite o número corretamente");

			} else {
				verifica = true;
			}

		}
		palavra = palavra.toLowerCase();
		return palavra;
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

}
