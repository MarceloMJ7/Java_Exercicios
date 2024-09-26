package desafio_4;

import javax.swing.JOptionPane;
import java.util.Random;

/*
			Você simulará aqui um jogo de cartas chamado 21, porém, por enquanto, será um
			jogo de uma só pessoa. O jogador/usuário deve puxar cartas, somando o valor das
			mesmas. O objetivo é chegar o mais próximo possível de 21 sem ultrapassá-lo. Para
			isso, a cada rodada pergunte se o jogador deseja mais uma carta para seu jogo ou se
			deseja parar. Caso ele ultrapasse 21 na sua contagem, ele perde o jogo. Ao final,
			mostre qual sua pontuação final.
			Obs. 1: as cartas são dadas de maneira aleatória.
			Obs. 2: pesquise o valor de cada carta em um jogo de 21.
 */

public class Desafio_4 {

	public static void main(String[] args) {
		int totalPontos = 0;
		boolean continuar = true;
		Random random = new Random();

		JOptionPane.showMessageDialog(null, "O programa simula o jogo de cartas 21");

		while (continuar) {
			for(int rodada = 1; rodada < 10 && continuar == true; rodada++) {
				int carta = random.nextInt(11) + 1;
				totalPontos += carta;

				if (totalPontos > 21) {
					JOptionPane.showMessageDialog(null, "Derrota, você fez mais de 21 pontos!");
					continuar = false;
				} else {
					int resposta = JOptionPane.showConfirmDialog(null,
							"Sua pontuação é " + totalPontos + " na rodada " + rodada + " Quer puxar outra carta?", "Jogo 21",
							JOptionPane.YES_NO_OPTION);
					if (resposta == JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null, "Jogo finalizado! Sua pontuação final é " + totalPontos);
						continuar = false;
					}
				}
			}
			

		}
	}
}