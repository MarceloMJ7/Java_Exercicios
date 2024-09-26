package desafio_1;

import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;

/*
 Faça um programa que leia 10 números inteiros digitados pelo usuário e armazene em um vetor. Em seguida, calcule e imprima a média desses números e informe o
2º maior e o 3º menor número.

 */

public class Desafio_1 {

	public static void main(String[] args) {
		Random random = new Random();
		int[] numeros = new int[10];
		double somaNumeros = 0, mediaNumeros = 0;

		for (int i = 0; i < 10; i++) {
			int randomInt = random.nextInt(100);
			numeros[i] = randomInt;
			somaNumeros = somaNumeros + numeros[i];
		}
		Arrays.sort(numeros);
		mediaNumeros = somaNumeros / 10;
		StringBuilder mensagem = new StringBuilder();
		for (int i = 0; i < numeros.length; i++) {
			mensagem.append(numeros[i]).append(" ");
		}
		JOptionPane.showMessageDialog(null,
				"Números gerados: \n" + mensagem + "\n" + "O resultado da média do vetor: " + mediaNumeros + "\n"
						+ "O segundo maior número: " + numeros[8] + "\n" + "O  terceiro menor número: " + numeros[2]);
	}

}
