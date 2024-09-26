package desafio_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JOptionPane;

/*
Um professor deseja ter uma aplicação que calcule a média ponderada de seus
alunos durante o bimestre. O bimestre é composto por várias notas com pesos que
podem variar.
Escreva um programa que permita ao usuário calcular a média ponderada de um
número variável de alunos, com um número variável de avaliações e pesos definidos
pelo usuário. O programa deve solicitar ao usuário a quantidade de avaliações e os
pesos correspondentes para cada uma delas. Em seguida, o programa deve solicitar
as notas de cada avaliação para um aluno. Permita o usuário cadastrar quantos
alunos forem necessários.
Após obter esses dados, o programa deve calcular e imprimir a média ponderada de
cada aluno, informando se o aluno passou ou não, considerando a média 6.0 como
nota de aprovação. Além disso, o programa deve calcular e imprimir a média da
turma e a quantidade de alunos que ficaram acima da média. Para cada aluno, o
programa deve também ordenar as notas em ordem crescente e imprimir as notas
ordenadas, além de identificar a maior e a menor notas.
Exemplo de saída
Quantidade de Avaliações: 3
Pesos: 2, 3, 5
--------------------------------------------
Notas do Aluno 1: 6, 7, 8
Maior Nota: 8
Menor Nota: 6
Média Ponderada Aluno 1: 7.1
Situação: Passou
--------------------------------------------
Notas do Aluno 2: 9, 8, 7
Notas Ordenadas Aluno 2: 7, 8, 9
Maior Nota: 9
Menor Nota: 7
Média Ponderada Aluno 2: 7.7
Situação: Passou
--------------------------------------------
Média da Turma: 7.4
Alunos Acima da Média: 2

 */
public class Desafio_5 {

	public static void main(String[] args) {
		int qtdAlunos = solicitandoQuantidaDeAlunos(), qtdAvaliacoes = solicitandoQuantidadeDeAvaliacoes();
		float[] pesoAvaliacao = solicitandoPesoAvaliacao(qtdAvaliacoes);
		float[][] notaAlunos = solicitandoNotasAlunos(qtdAvaliacoes, qtdAlunos);

		StringBuilder mensagem = new StringBuilder();
		float[] mediasPonderadas = new float[qtdAlunos];

		for (int i = 0; i < notaAlunos.length; i++) {
			mensagem.append("Aluno ").append(i + 1).append("\n");
			float maiorNota = calculandoMaiorNota(notaAlunos[i]);
			float menorNota = calculandoMenorNota(notaAlunos[i]);
			mensagem.append("Peso Avaliações: ");
			for (int j = 0; j < pesoAvaliacao.length; j++) {
				mensagem.append(pesoAvaliacao[j]).append(" ");
			}
			mensagem.append("\n");
			mensagem.append("Notas Ordenadas: ");
			for (int j = 0; j < notaAlunos[i].length; j++) {
				mensagem.append(notaAlunos[i][j]).append(" ");
			}
			mensagem.append("\n");
			mensagem.append("Maior Nota: ").append(maiorNota).append("\n");
			mensagem.append("Menor Nota: ").append(menorNota).append("\n");
			float mediaPonderadaAluno = mediaPonderada(notaAlunos[i], pesoAvaliacao);
			mensagem.append("Média Ponderada: ").append(mediaPonderadaAluno).append("\n");
			mediasPonderadas[i] = mediaPonderadaAluno;
			String situacaoAluno = situacao(notaAlunos[i]);
			mensagem.append("Situação: ").append(situacaoAluno).append("\n");
			mensagem.append("----------------------------------------- \n");

		}

		float mediaTurma = mediaturma(mediasPonderadas, qtdAlunos);
		int qtdAlunosAcimaMedia = verificarQtdAlunosAcimaMedia(mediaTurma, notaAlunos);

		mensagem.append("Média da Turma: ").append(mediaTurma).append("\n");
		mensagem.append("Alunos Acima da Média: ").append(qtdAlunosAcimaMedia).append("\n");

		System.out.println(mensagem);

	}

	public static int verificarQtdAlunosAcimaMedia(float mediaTurma, float[][] notasAlunos) {
		int qtdAlunosAcimaMedia = 0;

		for (int i = 0; i < notasAlunos.length; i++) {
			float mediaAluno = 0;

			for (int j = 0; j < notasAlunos[i].length; j++) {
				mediaAluno += notasAlunos[i][j];
			}

			mediaAluno = mediaAluno / notasAlunos[i].length;

			if (mediaAluno > mediaTurma) {
				qtdAlunosAcimaMedia += 1;
			}
		}

		return qtdAlunosAcimaMedia;
	}

	public static String situacao(float[] notasAlunos) {
		float somaNotas = 0, notaCorte = 6, situacaoAluno;

		for (int i = 0; i < notasAlunos.length; i++) {
			somaNotas += notasAlunos[i];
		}

		situacaoAluno = somaNotas / notasAlunos.length;

		return situacaoAluno >= notaCorte ? "Aluno Passou" : "Aluno Não Passou";
	}

	public static float mediaturma(float[] mediasPonderadas, int qtdAlunos) {
        float somaMedias = 0;

        for (float media : mediasPonderadas) {
            somaMedias += media;
        }

        return somaMedias / qtdAlunos;
    }

	public static float mediaPonderada(float[] notasAlunos, float[] peso) {
		float somaPesos = 0, somaNotas = 0;

		for (int i = 0; i < notasAlunos.length; i++) {
			somaNotas += notasAlunos[i] * peso[i];
			somaPesos += peso[i];
		}

		return somaNotas / somaPesos;
	}

	public static float calculandoMenorNota(float[] nota) {
		float menorNota = 11;

		for (int i = 0; i < nota.length; i++) {
			if (nota[i] < menorNota) {
				menorNota = nota[i];
			}
		}
		return menorNota;
	}

	public static float calculandoMaiorNota(float[] nota) {
		float maiorNota = 0;

		for (int i = 0; i < nota.length; i++) {
			if (nota[i] > maiorNota) {
				maiorNota = nota[i];
			}
		}
		return maiorNota;
	}

	public static int solicitandoQuantidaDeAlunos() {
		int qtdAlunos = Integer.parseInt(entradaDeDados("Informe a quantidade de alunos", "int"));

		return qtdAlunos;
	}

	public static int solicitandoQuantidadeDeAvaliacoes() {
		int qtdAvaliacao = Integer.parseInt(entradaDeDados("Informe a quantidade de avaliações", "int"));

		return qtdAvaliacao;
	}

	public static float[] solicitandoPesoAvaliacao(int qtdAvaliacao) {
		float[] peso = new float[qtdAvaliacao];
		for (int i = 0; i < qtdAvaliacao; i++) {
			peso[i] = Float.parseFloat(entradaDeDados("Informe o peso da prova " + (i + 1) + ":", "float"));

		}

		return peso;

	}

	public static float[][] solicitandoNotasAlunos(int qtdAvaliacao, int qtdAlunos) {
		float[][] notasAlunos = new float[qtdAlunos][qtdAvaliacao];

		for (int i = 0; i < qtdAlunos; i++) {
			JOptionPane.showMessageDialog(null, "Informe as notas do " + (i + 1) + "º Aluno:");
			for (int j = 0; j < qtdAvaliacao; j++) {
				while (true) {
					notasAlunos[i][j] = Float
							.parseFloat(entradaDeDados("Informe a nota da " + (j + 1) + "º prova:", "float"));
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

	public static String entradaDeDados(String mensagem, String tipo) {
		String entradaDados;
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
