package desafio_4;

import javax.swing.JOptionPane;

/*
		Desenvolva um programa que permita calcular o imposto de renda de uma pessoa. O
		usuário informa o valor do salário bruto mensal e o programa deve calcular o valor do
		imposto de acordo com a seguinte tabela:
		● Salário até R$1.903,98: isento de imposto
		● Salário de R$1.903,99 até R$2.826,65: 7,5% de imposto
		● Salário de R$2.826,66 até R$3.751,05: 15% de imposto
		● Salário de R$3.751,06 até R$4.664,68: 22,5% de imposto
		● Salário acima de R$4.664,68: 27,5% de imposto
		Calcule o valor do imposto de acordo com o salário informado pelo usuário e exiba o
		resultado. Lembre-se de que o valor do imposto deve ser calculado apenas sobre a
		diferença entre o salário e o limite inferior de cada faixa de imposto. Por exemplo, se
		o salário for R$2.000,00, o valor do imposto será 7,5% sobre R$96,01 (R$2.000,00 -
		R$1.903,99). Caso o valor do imposto seja igual a zero, exiba a mensagem "Isento de
		imposto". Caso contrário, exiba o valor do imposto calculado.
 */
public class Main {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "O programa vai calcular o imposto de renda");
		double salario = salario();
		int retornarValor = retornarValor(salario);
		double imposto = impostoRenda(retornarValor, salario);

		if (imposto == 0.0) {
			JOptionPane.showMessageDialog(null, "Isento de imposto");
		} else {
			JOptionPane.showMessageDialog(null, String.format("O imposto ficou em R$ %.2f", imposto));
		}
	}

	public static double salario() {
		String salario;
		double salarioReal = 0;
		boolean verifica = false;

		while (!verifica) {

			salario = JOptionPane.showInputDialog("Informe o seu salário atual: ");

			if (isNumeric(salario)) {
				salarioReal = Double.parseDouble(salario);
				verifica = true;
			} else {
				JOptionPane.showMessageDialog(null, "Digite o número corretamente");
			}
		}

		return salarioReal;

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

	public static int retornarValor(double salario) {
		if (salario <= 1903.98) {
			return 1;
		} else if (salario <= 2826.65) {
			return 2;
		} else if (salario <= 3751.05) {
			return 3;
		} else if (salario <= 4664.68) {
			return 4;
		} else {
			return 5;
		}

	}

	public static double impostoRenda(int numero, double salario) {
		double resultado = 0;

		switch (numero) {
		case 1:
			resultado = 0.0;
			break;
		case 2:
			resultado = (salario - 1903.99) * 0.075;
			break;
		case 3:
			resultado = (2826.65 - 1903.99) * 0.075 + (salario - 2826.65) * 0.15;
			break;
		case 4:
			resultado = (3751.05 - 1903.99) * 0.075 + (salario - 3751.05) * 0.225;
			break;
		case 5:
			resultado = (4664.68 - 1903.99) * 0.075 + (salario - 4664.68) * 0.275;
			break;
		}

		return resultado;
	}

}
