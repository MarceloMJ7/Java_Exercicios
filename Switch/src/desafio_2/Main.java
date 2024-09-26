package desafio_2;

import javax.swing.JOptionPane;

/*
 Solicite que o usuário informe uma letra do alfabeto. Posteriormente, verifique se essa
	letra é uma vogal, uma consoante ou um caractere inválido.
 */

public class Main {

    public static void main(String[] args) {
        String continuar, usuario;
        do {
            usuario = user();
            resultado(usuario);
            continuar = JOptionPane.showInputDialog("Deseja continuar? (S / N)");
            continuar = continuar.toUpperCase();
        } while (continuar.equals("S"));
    }

    public static String user() {
        String usuario;
        boolean validacao = false;

        usuario = JOptionPane.showInputDialog("Informe uma letra do alfabeto: ");
        while (!validacao) {
            if (usuario.length() != 1) {
                JOptionPane.showMessageDialog(null, "Por favor, digite apenas UMA letra do alfabeto.");
                usuario = JOptionPane.showInputDialog("Você deve informar apenas uma letra: ");
            } else {
                usuario = usuario.toLowerCase(); 
                validacao = true;
            }
        }
        return usuario;
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

    public static void resultado(String usuario) {
        if (usuario.equals("a") || usuario.equals("e") || usuario.equals("i") || usuario.equals("o") || usuario.equals("u")) {
            JOptionPane.showMessageDialog(null, "Usuário digitou uma vogal");
        } else if (isNumeric(usuario) || !Character.isLetter(usuario.charAt(0))) {
            JOptionPane.showMessageDialog(null, "Usuário digitou um caractere inválido");
        } else {
            JOptionPane.showMessageDialog(null, "Usuário digitou uma consoante");
        }
    }
}
