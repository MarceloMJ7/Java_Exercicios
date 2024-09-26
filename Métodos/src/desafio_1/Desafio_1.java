package desafio_1;

import javax.swing.JOptionPane;

/*
Construa um código capaz de solicitar ao usuário uma nota de 0 a 10. Se ele tirou: a
partir 7 está aprovado, entre 5 e 6 está em recuperação, abaixo de 5 está reprovado.
 */
public class Desafio_1 {

	public static void main(String[] args) {

		int nota = solicitaNota();
		String situation = situacao(nota);
		
		JOptionPane.showMessageDialog(null, "Situação do Aluno: " + situation);
		
	}

	public static int solicitaNota() {
		String zNota;
		int nota = 0;
		boolean verifica = false;

		while (!verifica) {
			zNota = JOptionPane.showInputDialog("Informe uma nota de 0 a 10");
			try {
				nota = Integer.parseInt(zNota);
				if (nota >= 0 & nota <= 10) {
					verifica = true;
				}else {
					JOptionPane.showMessageDialog(null, "Informe uma nota válida de 0 a 10");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Informe caracteres válidos");
			}
		}

		return nota;
	}

	public static String situacao(int nota) {
		String situacao = "null";
		
		if(nota > 0 & nota < 5) {
			situacao = "Reprovado";
		}else if(nota == 5 || nota == 6) {
			situacao = "Recuperação";
		}else {
			situacao = "Aprovado";
		}
		
		return situacao;
	}
		

}
