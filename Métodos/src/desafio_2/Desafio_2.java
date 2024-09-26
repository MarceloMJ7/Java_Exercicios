package desafio_2;

import javax.swing.JOptionPane;

/*
 Construa um programa que solicite ao usuário apenas os números de seu telefone.
(ex.: 47987654321). Em seguida, por meio de um método, você construirá uma
máscara para esse número (ex.: (47) 98765-4321).
 */
public class Desafio_2 {

	public static void main(String[] args) {
		String numero = solicitaNumero();
		
		numeroCompleto(numero);
	}

	public static String solicitaNumero() {
		String zNumero;

		do {
			zNumero = JOptionPane.showInputDialog("Informe o número de telefone com DDD (11 Caracteres)");
			if (zNumero.length() != 11) {
				JOptionPane.showMessageDialog(null, "Informe o número de telefone corretamente");
			}

		} while (zNumero.length() != 11);

		return zNumero;
	}

	public static void numeroCompleto(String num) {
		
		JOptionPane.showMessageDialog(null, "O seu número de telefone é " + "(" + num.substring(0,2) + ") " + num.substring(2,7) + " - " + num.substring(7,11) );
	}
}
