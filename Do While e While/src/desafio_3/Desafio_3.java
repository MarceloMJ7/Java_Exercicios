package desafio_3;

import javax.swing.JOptionPane;
import java.util.ArrayList;
/*
 A prefeitura de "Araquachussets" planeja conduzir uma pesquisa entre seus cidadãos,
a fim de coletar informações sobre seus nomes, idades, salários e número de filhos.
Para alcançar esse objetivo, sugiro a criação de um formulário online, que possa ser
preenchido pelos moradores da cidade.
Uma vez que a pesquisa tenha sido concluída, podemos utilizar os dados coletados
para gerar algumas informações estatísticas relevantes, tais como:
● A média de salário da população, que pode ser calculada dividindo-se a soma
de todos os salários pelo número total de respondentes.
● A média do número de filhos, que pode ser calculada dividindo-se a soma de
todos os filhos pelo número total de respondentes.
● O maior salário entre os habitantes, que pode ser identificado através da
comparação dos salários individuais.
● Uma lista com os nomes das pessoas cujo salário é inferior a R$ 1000,00. Essa
lista pode ser gerada filtrando-se os respondentes cujo salário é menor que
esse valor e extraindo seus nomes.
● A média de idade da população, que pode ser calculada da mesma forma que
a média de salário e a média de número de filhos.
Com essas informações em mãos, a prefeitura de "Araquachussets" poderá ter uma
melhor compreensão da situação econômica e demográfica de sua cidade, o que pode
ajudá-la a planejar políticas públicas mais eficazes.

 */

public class Desafio_3 {

	public static void main(String[] args) {
		String continuar;
		int contTotalPessoas = 0, somaIdade = 0, somaFilhos = 0;
		double somaSalario = 0, mediaSalarioPopu = 0, maiorSalario = Double.MIN_VALUE, mediaFilhos = 0,
				contPessoasFilhos = 0, salarioLimite = 1000.0, mediaIdadePop = 0;
		ArrayList<String> nomesMenorSalario = new ArrayList<>();

		do {
			String nome = solicitaNome();
			contTotalPessoas++;

			int idade = solicitaIdade();
			somaIdade = somaIdade + idade;

			int qtdFilhos = solicitaQtdFilhos();
			if (qtdFilhos > 0) {
				contPessoasFilhos++;
			}
			somaFilhos = somaFilhos + qtdFilhos;

			double salario = solicitaSalario();
			somaSalario = somaSalario + salario;

			continuar = JOptionPane.showInputDialog("Quer responder a pesquisa? (S / N)");
			continuar = continuar.toUpperCase();

			mediaSalarioPopu = contTotalPessoas > 0 ? somaSalario / contTotalPessoas : 0;
			mediaFilhos = contPessoasFilhos > 0 ? somaFilhos / contPessoasFilhos : 0;
			mediaIdadePop = contTotalPessoas > 0 ? somaIdade / contTotalPessoas : 0;

			if (salario > maiorSalario) {
				maiorSalario = salario;
			}
			if (salario < salarioLimite) {
				nomesMenorSalario.add(nome); //adicionando nome da pessoa com salario menor para o nomesMenorSalario que é um ArrayList 
			}

		} while (continuar.equals("S"));

		String resultado = String.format( 
				"Média salário da população: %.0f\n " + "Média número de filhos: %.0f\n "
						+ "Média da Idade população: %.0f\n " + "Maior Salário: %.0f\n",
				mediaSalarioPopu, mediaFilhos, mediaIdadePop, maiorSalario);

		StringBuilder mensagem = new StringBuilder(
				String.format("Lista de pessoas que ganham um sálario menor que %.0f \n", salarioLimite));
		
		for (String nome : nomesMenorSalario) { //Loop que percorre os nomes adicionados dentro do arrayList
			mensagem.append(nome).append("\n");// adiciona os nomes do arrayList para o StringBuilder
		}

		JOptionPane.showMessageDialog(null, "Informação da População \n" + resultado + "\n" + mensagem);
	}

	public static int solicitaQtdFilhos() { // Quantidade de filhos
		String cFilhos;
		int filhos = 0;
		boolean verifica = false;

		while (!verifica) {
			cFilhos = JOptionPane.showInputDialog("Informe a quantidade de filhos que você tem: ");

			try {
				filhos = Integer.parseInt(cFilhos);
				verifica = true;
			} catch (NumberFormatException e) {

				JOptionPane.showMessageDialog(null, "Informe os dados corretamente!");
			}
		}

		return filhos;
	}

	public static String solicitaNome() {
		String nome = null;
		boolean verifica = false;

		while (!verifica) {
			nome = JOptionPane.showInputDialog("Informe seu nome: ");

		}

		return nome;
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

	public static int solicitaIdade() {
		String lidade;
		int idade = 0;
		boolean verifica = false;

		while (!verifica) {
			try {
				lidade = JOptionPane.showInputDialog("Informe sua idade:");
				idade = Integer.parseInt(lidade);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Informe sua idade corretamente");
			}

		}

		return idade;
	}
}
