package desafio_4;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/*
Foi conduzida uma pesquisa com "N" indivíduos sobre suas opiniões em relação à
pré-estreia de um filme. Os dados coletados incluíram sexo, idade e uma nota de 0 a
10 referente à opinião sobre o filme. As perguntas foram feitas repetidamente até que
todas as pessoas disponíveis tivessem respondido.
Com base nos resultados da pesquisa, podemos calcular e apresentar as seguintes
informações:
● A média de idade das pessoas que responderam ao questionário;
● Lista de pessoas que deram nota igual a 10;
● A quantidade de homens cujas opiniões sobre o filme foram inferiores a 5;
● A quantidade de mulheres cujas opiniões sobre o filme foram inferiores a 5;
● A quantidade de homens cujas opiniões sobre o filme foram superiores a 7;
● A quantidade de mulheres cujas opiniões sobre o filme foram superiores a 7;
● Média das notas informadas.
Essas informações podem ajudar a compreender melhor a recepção do público em
relação ao filme e a orientar decisões futuras da equipe responsável pela sua
promoção.
Obs.: não esqueça de validar se a nota está entre 0 e 10.
 */
public class Desafio_4 {

	public static void main(String[] args) {
		int qtdPessoas = 0, homensNotaInferior5 = 0, mulheresNotaInferior5 = 0, homensNotaSuperior7 = 0,
				mulheresNotaSuperior7 = 0, valorTotalIdade = 0, escolha;
		String sexo, pesquisa, nome;
		float nota, totalNotas = 0;
		ArrayList<String> nomes10 = new ArrayList();

		do {
			qtdPessoas = contadorQtdPessoas(qtdPessoas);
			nome = entradaDeDados("Qual é o seu nome: ", "string");
			int idade = Integer.parseInt(entradaDeDados("Informe sua idade: ", "int"));
			valorTotalIdade = acumuladorDeIdade(valorTotalIdade, idade);
			sexo = validandoSexo();
			nota = validandoNota();
			totalNotas = acumuladorDeNotas(totalNotas, nota);

			if (sexo.equals("m")) {
				homensNotaInferior5 += solicitaNotaInferior5(nota);
				homensNotaSuperior7 += solicitaNotaSuperior7(nota);
				if (nota == 10) {
					nomes10.add(nome);
				}

			} else if (sexo.equals("f")) {
				mulheresNotaInferior5 += solicitaNotaInferior5(nota);
				mulheresNotaSuperior7 += solicitaNotaSuperior7(nota);
				if (nota == 10) {
					nomes10.add(nome);
				}
			}

			pesquisa = JOptionPane.showInputDialog("Quer responder a pesquisa? (s/n)");
			pesquisa = pesquisa.toLowerCase();

		} while (pesquisa.equals("s"));

		StringBuilder nomesPessoasNota10 = new StringBuilder();

		for (String nomesDeram10 : nomes10) {
			nomesPessoasNota10.append(nomesDeram10).append("\n");
		}

		while (true) {
			escolha = Integer.parseInt(entradaDeDados("Escolha uma das opções disponíveis: "
					+ "\n[1] Média de idade das pessoas que responderam ao questionário \n[2] Lista de pessoas que deram nota 10 "
					+ "\n[3] Quantidade de pessoas que deram notas inferiores a 5 \n[4] Quantidade de pessoas que deram notas superiores a 7 "
					+ "\n[5] Média das notas informadas \n" + "[6] Quantidade de pessoas que responderam: " , "int"));

			switch (escolha) {
			case 1:
				JOptionPane.showMessageDialog(null,
						"Média de idade das pessoas: " + mediaIdade(qtdPessoas, valorTotalIdade));
				break;
			case 2:
				JOptionPane.showMessageDialog(null,
						"Lista de pessoas que deram nota 10: \n" + nomesPessoasNota10.toString());
				break;
			case 3:
				JOptionPane.showMessageDialog(null,
						"Quantidade de homens que deram notas inferiores a 5: " + homensNotaInferior5
								+ "\nQuantidade de mulheres que deram notas inferiores a 5: " + mulheresNotaInferior5);
				break;
			case 4:
				JOptionPane.showMessageDialog(null,
						"Quantidade de homens que deram notas superiores a 7: " + homensNotaSuperior7
								+ "\nQuantidade de mulheres que deram notas superiores a 7: " + mulheresNotaSuperior7);
				break;
			case 5:
				JOptionPane.showMessageDialog(null,
						"Média das notas informadas: " + mediaNotas(qtdPessoas, totalNotas));
				break;
				
			case 6:
				JOptionPane.showMessageDialog(null,
						"Quantidade de pessoas que responderam a pesquisa: " + qtdPessoas);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção escolhida inválida");
				break;
			}

			String novamente = entradaDeDados("Quer fazer uma nova consulta? (s / n) ", "string").toLowerCase();
			if (novamente.equals("n")) {
				break;
			}
		}
	}

	public static float mediaNotas(int qtdPessoas, float totalNota) {
		float media = 0;

		media = qtdPessoas > 0 ? totalNota / qtdPessoas : 0;

		return media;
	}

	public static float acumuladorDeNotas(float totalNotas, float nota) {
	    totalNotas += nota;
	    return totalNotas;
	}

	public static int acumuladorDeIdade(int valorTotalIdade, int idade) {
	    valorTotalIdade += idade;
	    return valorTotalIdade;
	}

	public static float mediaIdade(int qtdPessoas, int totalIdade) {
		float media = 0;

		media = qtdPessoas > 0 ? totalIdade / qtdPessoas : 0;

		return media;
	}

	public static int solicitaNotaSuperior7(float nota) {
		return nota > 7 ? 1 : 0;
	}

	public static int solicitaNotaInferior5(float nota) {
		return nota < 5 ? 1 : 0;
	}

	public static int contadorQtdPessoas(int qtdPessoas) {
		qtdPessoas += 1;
		return qtdPessoas;
	}

	public static String validandoSexo() {
		String sexo;

		while (true) {
			sexo = entradaDeDados("Informe seu sexo: (f / m) ", "string").toLowerCase();

			sexo.charAt(0);
			if (sexo.equals("f") || sexo.equals("m")) {
				break;
			} else {
				JOptionPane.showMessageDialog(null, "Informe os dados corretamente");
			}

		}

		return sexo;
	}

	public static float validandoNota() {
		float nota;
		while (true) {
			nota = Float.parseFloat(entradaDeDados("Informe a nota de 0 a 10: ", "float"));
			if (nota <= 10 && nota >= 0) {
				break;
			} else {
				JOptionPane.showMessageDialog(null, "Informe uma nota correta!");
			}
		}

		return nota;
	}

	public static String entradaDeDados(String mensagem, String tipo) {
		String entradaDados = "";
		boolean valida = false;

		do {
			entradaDados = JOptionPane.showInputDialog(mensagem);

			switch (tipo) {
			case "int":
				try {
					Integer.parseInt(entradaDados);
					valida = true;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Informe os números corretamente!");
				}
				break;

			case "float":
				try {
					Float.parseFloat(entradaDados);
					valida = true;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Informe os números corretamente!");
				}
				break;

			case "string":
				valida = true;

				break;

			default:
				JOptionPane.showMessageDialog(null, "Tipo informado é inválido");
				break;
			}

		} while (!valida);

		return entradaDados;
	}

}

/*
 * reescreever oódigo sem usar contadores globais - entrada de dados - menu de
 * usuário - para cada opção que usuário selecionar, vc calcula o que ele pediu
 */

// escrever um método generalista para entrada de dados que receba como
// argumento uma mensagem e retorne o objeto (pode ser string, double ou int)
