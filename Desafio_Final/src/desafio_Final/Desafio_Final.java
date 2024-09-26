package desafio_Final;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/*
		Você deverá controlar as adoções de um tipo de animal a sua escolha (como cão, gato,
		Pássaro ou peixe, por exemplo). Para isso, você deve:
		• Deixar pré-cadastrados os dados de 3 raças;
		• Realizar o cadastro de 3 animais por raça, tendo como dados:
		o Nome;
		o Informações sobre o comportamento (Ex.: cão calmo, gato brincalhão);
		o Indicar se o animal foi adotado ou não.
		• Criar as seguintes listas para visualização:
		o Todos os animais;
		o Animais por raça;
		o Animais disponíveis para adoção.
 */
public class Desafio_Final {

    public static void main(String[] args) {
        String[] racas = racas();
        String[][] nomesAnimais = new String[3][3];
        String[][] sexoAnimal = new String[3][3];
        String[][] comportamento = new String[3][3];
        String[][] adotado = new String[3][3]; // Mantemos como String
        String[][] vacinado = new String[3][3];
        String continuar;

        cadastrandoInformacoes(racas, nomesAnimais, sexoAnimal, comportamento, adotado, vacinado);
        consultarMenu(racas, nomesAnimais, sexoAnimal, comportamento, adotado, vacinado);
        continuar = JOptionPane.showInputDialog(null, "Quer continuar?");
    }

    public static void exibirTodosOsAnimais(String[] racas, String[][] nome) {
        StringBuilder mensagem = new StringBuilder();
        for (int i = 0; i < racas.length; i++) {
            for (int j = 0; j < 3; j++) {
                mensagem.append(" - Raça: ").append(racas[i]).append(" / Nome: ").append(nome[i][j])
                        .append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public static void mostrarAnimaisPorRaca(String[] racas, String[][] nomes) {
        String[] animaisPorRaca = { racas[0], racas[1], racas[2] };
        JComboBox<String> alternativa = new JComboBox<>(animaisPorRaca);
        JOptionPane.showOptionDialog(null, alternativa, "Escolha uma opção",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, null, null);
        int indiceSelecionado = alternativa.getSelectedIndex();

        StringBuilder mensagemRaca = new StringBuilder();
        for (int j = 0; j < 3; j++) {
            mensagemRaca.append(" - Raça: ").append(racas[indiceSelecionado])
                    .append(" / Nome: ").append(nomes[indiceSelecionado][j])
                    .append("\n");
        }
        JOptionPane.showMessageDialog(null, mensagemRaca);
    }

    public static void listarAnimaisNaoAdotados(String[] racas, String[][] nomes, String[][] adotado) {
        StringBuilder mensagem = new StringBuilder("Animais Disponíveis para Adoção:\n");
        for (int i = 0; i < racas.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (adotado[i][j].equalsIgnoreCase("Não")) {
                    mensagem.append("Raça: ").append(racas[i]).append(" / Nome: ").append(nomes[i][j]).append("\n");
                }
            }
        }
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public static void listarAnimaisVacinados(String[] racas, String[][] nomes, String[][] vacinado) {
        StringBuilder mensagemVacinados = new StringBuilder("Animais Vacinados:\n");
        for (int i = 0; i < racas.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (vacinado[i][j].equalsIgnoreCase("Sim")) {
                    mensagemVacinados.append("Raça: ").append(racas[i]).append(" / Nome: ").append(nomes[i][j])
                            .append("\n");
                }
            }
        }
        JOptionPane.showMessageDialog(null, mensagemVacinados);
    }

    public static void consultarMenu(String[] racas, String[][] nomes, String[][] sexoAnimal,
            String[][] comportamentos, String[][] adotado, String[][] vacinado) {
        String[] opcoes = { "Todos os Animais", "Animais por Raça", "Animais Disponíveis para Adoção",
                "Animais Vacinados", "Animais Fêmeas", "Animais Machos" };
        JComboBox<String> box = new JComboBox<>(opcoes);
        JOptionPane.showOptionDialog(null, box, "Escolha uma opção", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, null, null);
        switch (box.getSelectedIndex()) {
            case 0:
                exibirTodosOsAnimais(racas, nomes);
                break;
            case 1:
                mostrarAnimaisPorRaca(racas, nomes);
                break;
            case 2:
                listarAnimaisNaoAdotados(racas, nomes, adotado);
                break;
            case 3:
                listarAnimaisVacinados(racas, nomes, vacinado);
                break;
            case 4:
                exibirSexoAnimal("Fêmea", racas, nomes, sexoAnimal);
                break;
            case 5:
                exibirSexoAnimal("Macho", racas, nomes, sexoAnimal);
                break;
        }
    }

    public static void exibirSexoAnimal(String mensagem, String[] racas, String[][] nomes, String[][] sexoAnimal) {
        StringBuilder mensagemSexoAnimal = new StringBuilder();
        for (int i = 0; i < racas.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (sexoAnimal[i][j].equalsIgnoreCase(mensagem)) {
                    mensagemSexoAnimal.append("Raça: ").append(racas[i]).append(" / Nome: ").append(nomes[i][j])
                            .append(" / Sexo: ").append(sexoAnimal[i][j])
                            .append("\n");
                }
            }
        }
        JOptionPane.showMessageDialog(null, mensagemSexoAnimal);
    }

    public static void cadatroSexoAnimal(String[] racas, String[][] nomes, String[][] sexoAnimal, int i, int j) {
        int selecione;
        String[] opcoes = { "Macho", "Fêmea" };
        do {
            selecione = JOptionPane.showOptionDialog(null, "Escolha o sexo do animal", "Escolha a opção correta",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, null);

            if (selecione == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(null, "Você deve responder a pergunta.");
            }
        } while (selecione == JOptionPane.CLOSED_OPTION);
        if (selecione == 0) {
            sexoAnimal[i][j] = "Macho";
        } else if (selecione == 1) {
            sexoAnimal[i][j] = "Fêmea";
        }

    }

    public static void obterRespostaSimNao(String mensagem, int i, int j, String[][] verifica) {
        int selecione;
        String[] opcoes = { "Sim", "Não" };
        do {
            selecione = JOptionPane.showOptionDialog(null, mensagem, "Escolha a opção correta",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, null);

            // Verifica se o usuário pressionou "ESC" ou fechou a janela
            if (selecione == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(null, "Você deve responder a pergunta.");
            }
        } while (selecione == JOptionPane.CLOSED_OPTION);
        if (selecione == 0) {
            verifica[i][j] = "Sim";
        } else if (selecione == 1) {
            verifica[i][j] = "Não";
        }
    }

    public static void cadastrandoInformacoes(String[] racas, String[][] nomes, String[][] sexoAnimal,
            String[][] comportamentos, String[][] adotado, String[][] vacinado) {
        for (int i = 0; i < racas.length; i++) {
            for (int j = 0; j < 3; j++) {
                String nomeAnimal = entradaDeDados("Animal N" + (j + 1) + "º / Raça: " + racas[i] + "\nInforme o nome:",
                        "string");
                while (nomeAnimal == null || nomeAnimal.trim().isEmpty()) {
                    nomeAnimal = entradaDeDados("Nome inválido. Informe o nome do animal:", "string");
                }
                nomes[i][j] = nomeAnimal;
                cadatroSexoAnimal(racas, nomes, sexoAnimal, i, j);
                obterRespostaSimNao("O animal foi adotado?", i, j, adotado);
                obterRespostaSimNao("O animal foi vacinado?", i, j, vacinado);
                /*
                 * comportamentos[i][j] = entradaDeDados(
                 * "Animal N" + (j + 1) + "º / Raça: " + racas[i] +
                 * "\nInforme o comportamento do animal:",
                 * "string");
                 */
            }
        }
    }

    public static String[] racas() {
        String[] racas = { "Pastor Alemão", "Pitbull", "Husky Siberiano" };
        return racas;
    }

    public static String entradaDeDados(String mensagem, String tipo) {
        String entradaDados = "";
        boolean valida = false;

        do {
            entradaDados = JOptionPane.showInputDialog(mensagem);
            if (entradaDados == null || entradaDados.trim().isEmpty()) {
                return null;
            } else {
                switch (tipo) {
                    case "int":
                        try {
                            Integer.parseInt(entradaDados);
                            valida = true;
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Valor inválido. Informe um número inteiro.");
                        }
                        break;
                    case "string":
                        if (!entradaDados.trim().isEmpty()) {
                            valida = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Valor inválido. Informe uma string válida.");
                        }
                        break;
                    default:
                        break;
                }
            }

        } while (!valida);
        return entradaDados;
    }
}
