package desafio_4;

import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;

/*
Faça um programa que leia 5 números inteiros digitados pelo usuário e armazene-os
em um vetor. Em seguida, o programa deve ordenar os números em ordem
crescente e imprimir o vetor ordenado
 */
public class Desafio_4 {

	public static void main(String[] args) {
		int[] numeroUser = numerosUser();
		Arrays.sort(numeroUser);

		StringBuilder mensagem = new StringBuilder();
		for(int i = 0; i < numeroUser.length; i++) {
			mensagem.append(numeroUser[i]);
			if (i < numeroUser.length - 1) { //Se a posição não for a última, vai acrescentar um " / "
                mensagem.append(" / "); 
            }
		}
		
		JOptionPane.showMessageDialog(null, "O programa vai mostrar os números em ordem crescente" + "\n" + mensagem);
	}

	public static int[] numerosUser() {
		Random random = new Random();
		int[] numerosUser = new int[5];

		 for (int i = 0; i < numerosUser.length; i++) {
		        int randomInt = random.nextInt(100) + 1;
		        numerosUser[i] = randomInt;
 
		}
		 return numerosUser;
	
	}
}

