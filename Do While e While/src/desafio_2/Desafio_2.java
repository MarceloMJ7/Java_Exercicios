package desafio_2;

import javax.swing.JOptionPane;

/*
 Você deverá desenvolver um algoritmo que solicite a idade, o gênero e o salário de 
um grupo de pessoas. Para encerrar o programa, o usuário deve digitar "Finalizar". 
Certifique-se de validar para que o usuário digite exatamente "Finalizar". Ao término 
da execução do programa, será apresentado ao usuário as seguintes informações:
● A média de idade geral;
● A média de idade de pessoas do gênero feminino;
● A média de idade de pessoas do gênero masculino;
● A média salarial geral;
● A média salarial do gênero feminino;
● A média salarial do gênero masculino.
● O maior salário;
● O menor salário.
 */

public class Desafio_2 {

	public static void main(String[] args) {
		String continuar;
		int totalHomens = 0, totalMulheres = 0, totalPessoas = 0;
		double totalIdadeGeral = 0, totalIdadeFem = 0, totalIdadeMasc = 0;
		double somaSalarioGeral = 0, somaSalarioFeminino = 0, somaSalarioMasculino = 0;
		double maiorSalario = Double.MIN_VALUE, menorSalario = Double.MAX_VALUE; // maior salario set com o menor valor
																					// possível / assim como o maior
																					// salário.

		do {
			int idade = solicitaIdade();
			totalPessoas++;
			totalIdadeGeral += idade;

			char genero = solicitaGenero();

			if (genero == 'f') {
				totalMulheres++;
				totalIdadeFem += idade;
			} else {
				totalHomens++;
				totalIdadeMasc += idade;
			}

			double salario = solicitaSalario();
			somaSalarioGeral += salario;

			if (salario > maiorSalario) {
				maiorSalario = salario;
			}
			if (salario < menorSalario) {
				menorSalario = salario;
			}

			if (genero == 'f') {
				somaSalarioFeminino += salario;
			} else {
				somaSalarioMasculino += salario;
			}

			continuar = JOptionPane.showInputDialog("Digite 'Finalizar' para parar de responder!");

		} while (!continuar.equals("Finalizar"));

		// Condicional Ternária
		double mediaIdadeGeral = totalPessoas > 0 ? totalIdadeGeral / totalPessoas : 0;
		double mediaIdadeFem = totalMulheres > 0 ? totalIdadeFem / totalMulheres : 0;
		double mediaIdadeMasc = totalHomens > 0 ? totalIdadeMasc / totalHomens : 0;
		double mediaSalarioGeral = totalPessoas > 0 ? somaSalarioGeral / totalPessoas : 0;
		double mediaSalarioFem = totalMulheres > 0 ? somaSalarioFeminino / totalMulheres : 0;
		double mediaSalarioMasc = totalHomens > 0 ? somaSalarioMasculino / totalHomens : 0;

		// Formatar a bagunça dos 0

		String resultados = String.format( //mensagem e argumento
				"Média de idade geral: %.0f\n" + "Média de idade de pessoas do gênero feminino: %.0f\n"
						+ "Média de idade de pessoas do gênero masculino: %.0f\n" + "Média salarial geral: %.0f\n"
						+ "Média salarial do gênero feminino: %.0f\n" + "Média salarial do gênero masculino: %.0f\n"
						+ "Maior salário: %.0f\n" + "Menor salário: %.0f\n",
				mediaIdadeGeral, mediaIdadeFem, mediaIdadeMasc, mediaSalarioGeral, mediaSalarioFem, mediaSalarioMasc,
				maiorSalario, menorSalario);

		JOptionPane.showMessageDialog(null, resultados);
	}

	public static int solicitaIdade() {
		String xIdade;
		int idade = 0;
		boolean verifica = false;

		while (!verifica) {
			try {

				do {
					xIdade = JOptionPane.showInputDialog("Informe sua idade: ");
					idade = Integer.parseInt(xIdade);

					if (idade < 18) {
						JOptionPane.showMessageDialog(null, "Você precisa ser mais de 18 anos");
					}
				} while (idade < 18);

				verifica = true;

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Informe sua idade corretamente");
			}
		}

		return idade;
	}

	public static char solicitaGenero() {
		String cGenero;
		char genero = 0;
		boolean verifica = false;

		while (!verifica) {
			cGenero = JOptionPane.showInputDialog("Informe seu Gênero: (F / M)");
			cGenero = cGenero.toLowerCase();

			if (cGenero.equals("f") || cGenero.equals("m")) {
				verifica = true;
			} else {
				JOptionPane.showMessageDialog(null, "Informe os dados corretamente!");
			}
		}

		return genero;
	}

	public static double solicitaSalario() { 
		String cSalario;
		double salario = 0;
		boolean verifica = false;

		while (!verifica) {
			cSalario = JOptionPane.showInputDialog("Informe seu salário:");

			try {
				salario = Double.parseDouble(cSalario);
				verifica = true;
			} catch (NumberFormatException e) { 
												
												
				JOptionPane.showMessageDialog(null, "Informe o salário corretamente!");
			}
		}

		return salario;
	}
}
