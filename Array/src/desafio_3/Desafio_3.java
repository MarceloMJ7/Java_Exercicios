package desafio_3;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/*
 Uma turma do curso de programação da escola X é formada por 30 alunos. Faça um
programa que leia as notas de cada aluno em uma avaliação e armazene-as em um
vetor. O programa deve calcular e imprimir a média da turma e a quantidade de
alunos que ficaram acima da média .

 */

public class Desafio_3 {

	public static void main(String[] args) {

		double[] notas = solicitaNotas();
		double mediaNotas = mediaAlunos(notas), notaCorte = 6.0;
		int alunosAcimaMedia = 0;
		ArrayList<Double> notasGerais = new ArrayList<>();

		JOptionPane.showMessageDialog(null,
				"Programa vai calcular a média dos alunos da classe e a quantidade de alunos acima da média");

		for (int i = 0; i < notas.length; i++) {
			notasGerais.add(notas[i]);
			if (notas[i] > notaCorte) {
				alunosAcimaMedia++;
			}
		}

		StringBuilder mensagem = new StringBuilder();
		for (Double nota : notasGerais) {
			mensagem.append(nota).append(" / ");
		}

		System.out.println("Notas Alunos: \n" + mensagem);
		JOptionPane.showMessageDialog(null, "Média dos alunos: \n" + String.format("%.2f", mediaNotas) + "\n"
				+ "Qtd Alunos acima da média: \n" + alunosAcimaMedia); // Exibe a mensagem final

	}

	public static double[] solicitaNotas() {
		Random random = new Random();
		double[] notasAlunos = new double[30];

		for (int i = 0; i < notasAlunos.length; i++) {
			int randomInt = random.nextInt(11);
			notasAlunos[i] = randomInt;
		}

		return notasAlunos;
	}

	public static double mediaAlunos(double[] notas) {
		double somaNotas = 0;

		for (int i = 0; i < notas.length; i++) {
			somaNotas += notas[i];
		}

		return somaNotas / 30;
	}

}
