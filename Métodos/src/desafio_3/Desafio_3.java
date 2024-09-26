package desafio_3;

import javax.swing.JOptionPane;

/*
 Primeiramente, peça uma medida em metros ao usuário. Depois pergunte para qual
unidade de medida ele deseja converter: centímetros, polegadas, pés ou quilômetros.
Ao final, apresente o valor da conversão
 */
public class Desafio_3 {

	public static void main(String[] args) {

		double medida = solicitarMedida();
		System.out.println(medida);
		int resultado = showChoice();
	}

	public static Double solicitarMedida() {
		String zMedida;
		double medida = 0;
		boolean verifica = false;

		while (!verifica) {
			try {
				do {
					zMedida = JOptionPane.showInputDialog("Informe uma médida em metros:");
					if (zMedida == null || zMedida.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Campo vazio");
					}
				} while (zMedida == null || zMedida.isEmpty());

				medida = Double.parseDouble(zMedida);
				verifica = true;

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Informe apenas números");
			}

		}
		return medida;
	}

	public static int showChoice() {
		int selecione;
		String [] opcoes = { "Centímetro" , "Polegadas" ,  "Pés" ,  "Quilômetros"};
		selecione = JOptionPane.showOptionDialog(null, "Para qual unidade você gostaria de converter?", "Conversão",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, null);
		
		switch(selecione) {
		
		}
		return selecione;
	}
	
}
