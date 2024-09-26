package desafio_3;

import javax.swing.JOptionPane;

/*
 Prepare um código-fonte para um programa que verifica APENAS os números primos
de 1 a 100.
número primo é aquele que não pode ser dividido por nenhum outro número além de 1 e ele próprio sem deixar resto.
 */

public class Desafio_3 {

	public static void main(String[] args) {

		int primos = 0;

		for (int numero = 2; numero <= 100; numero++) {
			boolean isPrimo = true;

			for (int i = 2; i <= numero / 2; i++) {
				if (numero % i == 0) {
					isPrimo = false;
					break;
				}
			}

			if (isPrimo) {
				primos++;
			}
		}

		JOptionPane.showMessageDialog(null, "Quantidade de números primos: " + primos);
	}

}
