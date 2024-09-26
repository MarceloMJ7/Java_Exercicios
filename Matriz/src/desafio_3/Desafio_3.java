package desafio_3;

import javax.swing.JOptionPane;

public class Desafio_3 {

	public static void main(String[] args) {
		int linhas = 3;
		int colunas = 2;
		int[][] matriz = { { 17, 27 }, { 37, 47 }, { 57, 67 } };
		int[][] matrizT = new int[colunas][linhas];

		// Exibe a matriz original
		StringBuilder matrizPrime = new StringBuilder("Matriz Original:\n"); //StringBuilder vai receber os valores do Array
		for (int i = 0; i < linhas; i++) { //loop para iniciar o array
			for (int j = 0; j < colunas; j++) {
				matrizPrime.append(matriz[i][j]).append("  "); //Adicionando valores na StringBuilder junto com -
			}
			matrizPrime.append("\n"); // Adiciono um "pula Linha" fora do loop interno para pular linha
		}

		
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				matrizT[j][i] = matriz[i][j];
			}
		}

		// Exibe a matriz transposta
		StringBuilder matrizTranspostaStr = new StringBuilder("Matriz Transposta:\n");
		for (int i = 0; i < colunas; i++) {
			for (int j = 0; j < linhas; j++) {
				matrizTranspostaStr.append(matrizT[i][j]).append(" ");
			}
			matrizTranspostaStr.append("\n");
		}
		JOptionPane.showMessageDialog(null,matrizPrime.toString()+ "\n" +matrizTranspostaStr.toString() );
	}
}
