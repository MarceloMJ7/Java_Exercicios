package desafio_2;

import javax.swing.JOptionPane;

/*
 Um professor deseja ter uma aplicação que calcule a média ponderada de seus
cinco alunos durante o bimestre. O bimestre é composto por três notas com os
seguintes pesos: Nota 1 (peso 20%), Nota 2 (peso 30%) e Nota 3 (peso 50%).
Faça um programa que leia as notas de cada aluno e calcule a média ponderada
delas. Depois, imprima na tela as notas de cada aluno e a média calculada.
Exemplo de saída
Aluno 1: 6.0, 7.0, 8.0 | Média 7.3
Aluno 2: 9.0, 8.0, 7.0 | Média 7.7
Aluno 3: 5.0, 6.0, 7.0 | Média 6.5
Aluno 4: 8.0, 9.0, 10.0 | Média 9.2
Aluno 5: 7.0, 5.0, 6.0 | Média 5.9
 */

public class Desafio_2 {

	public static void main(String[] args) {
		float[][] notasAlunos = solicitandoNotasAlunos();
		float[] peso = valorPesoProva();

		StringBuilder mensagem = new StringBuilder();

		for (int i = 0; i < notasAlunos.length; i++) {
			float mediaAluno = mediaPonderada(notasAlunos[i], peso);
			mensagem.append("Aluno ").append(i + 1).append(":\n");
			for (int j = 0; j < notasAlunos[i].length; j++) {
				mensagem.append("Prova: ").append(j + 1).append(": ").append(notasAlunos[i][j]).append("\n");
			}
			mensagem.append("Média Ponderada: ").append(mediaAluno).append("\n\n");
		}

		JOptionPane.showMessageDialog(null, mensagem);

	}

	public static float mediaPonderada(float[] notasAlunos, float[] peso) {
		float somaPesos = 0, somaNotas = 0;

		for (int i = 0; i < notasAlunos.length; i++) {
			somaNotas += notasAlunos[i] * peso[i];
			somaPesos += peso[i];
		}

		return somaNotas / somaPesos;
	}

	public static float[][] solicitandoNotasAlunos() {
		float[][] notasAlunos = new float[5][3];

		for (int i = 0; i < notasAlunos.length; i++) {
			JOptionPane.showMessageDialog(null, "Informe as notas do " + (i + 1) + " Aluno:");
			for (int j = 0; j < notasAlunos[i].length; j++) {
				while (true) {
					notasAlunos[i][j] = Float
							.parseFloat(entradaDeDados("Informe a nota da " + (j + 1) + "º prova:", "int"));
					if (notasAlunos[i][j] <= 10 && notasAlunos[i][j] >= 0) {
						break;
					} else {
						JOptionPane.showMessageDialog(null, "Informe uma nota entre 0 e 10");
					}
				}

			}
		}
		return notasAlunos;
	}

	public static float[] valorPesoProva() {
		float[] peso = { (float) 0.2, (float) 0.3, (float) 0.5 }; //cast
		return peso;
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
