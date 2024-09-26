
package desafio_1;

import javax.swing.JOptionPane;

/*
				 Crie um programa que peça para o usuário selecionar uma figura geométrica de sua
				escolha: ok
				● Círculo;
				● Quadrado;
				● Retângulo;
				● Triângulo.
				Em seguida, peça os dados necessários para calcular e exibir a área da figura
				selecionada.
 */
public class Main {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null,
				"O programa vai te ajudar a selecionar uma figura geométrica e vai calcular sua área");

		int escolhaUsuario = usuario();
		double circulo = calculosCirculo(escolhaUsuario);
		resultadoFinal(circulo, escolhaUsuario);

	}

	public static int usuario() {
		String escolhaUsuario;
		int escolhaUsuarioInt = 0;
		boolean verificacao = false;
		while (!verificacao) {
			escolhaUsuario = JOptionPane.showInputDialog("Escolha uma figura geométrica: \n" + "(1) Círculo; \n"
					+ "(2) Quadrado; \n" + "(3) Retângulo; \n" + "(4) Triângulo. \n");
			if (isNumeric(escolhaUsuario)) {
				escolhaUsuarioInt = Integer.parseInt(escolhaUsuario);
				verificacao = true;
			} else {
				JOptionPane.showMessageDialog(null, "Informe um número válido");
			}

		}
		return escolhaUsuarioInt;
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

	public static double calculosCirculo(int escolhaUsuario) {
		final int circulo = 1, quadrado = 2, retangulo = 3, triangulo = 4;

		double resultado = 0;
		switch (escolhaUsuario) {
		case circulo:
			String raio;
			double raio1;
			raio = JOptionPane.showInputDialog("Informe a Área do Círculo: ");
			raio1 = Double.parseDouble(raio);
			resultado = Math.PI * Math.pow(raio1, 2);
			break;

		case quadrado:
			String lado;
			double lado1;

			lado = JOptionPane.showInputDialog("Informe o lado do quadrado:");
			lado1 = Double.parseDouble(lado);

			resultado = lado1 * lado1;
			break;

		case retangulo:
			String base, altura;
			double base1, altura1;

			base = JOptionPane.showInputDialog("Informe o valor da base:");
			altura = JOptionPane.showInputDialog("Informe o valor da altura");

			base1 = Double.parseDouble(base);
			altura1 = Double.parseDouble(altura);

			resultado = base1 * altura1;

			break;

		case triangulo:
			String basex, alturax;
			double basey, alturay;

			basex = JOptionPane.showInputDialog("Informe o valor da base:");
			alturax = JOptionPane.showInputDialog("Informe o valor da altura");

			basey = Double.parseDouble(basex);
			alturay = Double.parseDouble(alturax);

			resultado = 0.5 * basey * alturay;
			break;
		}

		return resultado;
	}

	public static void resultadoFinal(double resultado, int usuario) {
		String usuario1;
		
		if (usuario == 1) {
			 usuario1 = "Círculo";
		}else if(usuario == 2) {
			 usuario1 = "Quadrado";
		}else if(usuario == 3) {
			 usuario1 = "Retângulo";
		}else {
			 usuario1 = "Triângulo";
		}
		JOptionPane.showMessageDialog(null, "A figura geométrica escolhida pelo usuário foi o " + usuario1 + " e a sua área é de " + resultado);
	}

}
