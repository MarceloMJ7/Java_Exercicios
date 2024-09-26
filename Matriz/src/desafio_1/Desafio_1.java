package desafio_1;

import java.util.Random;

/*
O professor "Beico Zito" está em busca de uma solução que possa calcular a soma
de cada linha e a soma total de uma matriz 4x5. Para isso, ele precisa de um algoritmo
que possa realizar esses cálculos.
 */

public class Desafio_1 {

    public static void main(String[] args) {
        Random random = new Random();

        int[][] numeros = new int[4][5];
        int somaTotal = 0;

        for (int i = 0; i < numeros.length; i++) {
            int somaLinha = 0;  // Inicializa a soma da linha para cada nova linha
            for (int j = 0; j < numeros[i].length; j++) {
                // Gera um número aleatório entre 0 e 20 e atribui à posição na matriz
                numeros[i][j] = random.nextInt(21);
                somaLinha += numeros[i][j];  // Adiciona o valor à soma da linha
            }
            somaTotal += somaLinha;  // Adiciona a soma da linha à soma total
            System.out.println("Soma da linha " + (i + 1) + ": " + somaLinha);
        }

        System.out.println("Soma total da matriz: " + somaTotal);
    }
}
