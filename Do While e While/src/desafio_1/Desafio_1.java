package desafio_1;

import javax.swing.JOptionPane;

/*
 Criar um programa que solicita ao usuário dois números e, em seguida, pergunta qual
é o resultado da multiplicação desses dois números. Enquanto o usuário não acertar
a resposta, o programa deve informar que ele está errado e pedir para tentar
novamente. Quando o usuário acertar, o programa deve informar que o número está
correto e mostrar quantas vezes o usuário tentou até acertar.
 */

public class Desafio_1 {

	public static void main(String[] args) {
		int valor_equacao;
		boolean continuar = true;
		String resultado;
		int resultadoInteiro, cont = 1;
		int[] user = userNumeros();

		do {
			valor_equacao = user[0] * user[1]; // Guarda o valor da equação

			resultado = JOptionPane.showInputDialog(
					"Qual é o resultado da multiplicação entre os números " + user[0] + " * " + user[1] + ":");

			resultadoInteiro = Integer.parseInt(resultado); // converte o valor que o usuário digitar

			if (resultadoInteiro != valor_equacao) { // Se resultado informado pelo usuário for diferente do valor da
				JOptionPane.showMessageDialog(null, "Você errou, tente novamente"); // variável multiplica, vamos
																					// acrescentar +1 no cont
				cont = cont + 1;

			} else {
				JOptionPane.showMessageDialog(null,
						"Sua resposta está correta, você precisou de " + cont + "º tentativas");
				continuar = false;
			}

		} while (continuar);
	}

	public static int[] userNumeros() { // função que recebe os números que o usuário digitar e manda para um Array
		String num;
		int[] numerosUser = new int[2];

		for (int pergunta = 0; pergunta < 2; pergunta++) {
			num = JOptionPane.showInputDialog(null, "Digite o número " + (pergunta + 1) + "º");
			numerosUser[pergunta] = Integer.parseInt(num); // converte a String para número inteiro

		}

		return numerosUser;

	}

}
