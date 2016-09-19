package exercicio4;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.text.MaskFormatter;

/**
 * Classe princial, que exercita o menu do programa e suas opcoes;
 *
 * @author Estevao
 */
public class Exercicio4 {

    static final int MAX = 10;
    static int ponteiro = 0;
    static int posicao;
    static String nome;
    static String telefone = null;
    static Scanner ler = new Scanner(System.in);
    static Agenda[] novaAgenda;
    static boolean first = true;

    /**
     * Metodo principal
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (first) {
            novaAgenda = new Agenda[MAX];
            first = false;
        }// fim if
        int op = 1;
        try {
            while (op != 0) {
                op = menu();
                switch (op) {
                    case 1:
                        criarContato(novaAgenda);
                        break;
                    case 2:
                        consultaContato(novaAgenda);
                        break;
                    case 3:
                        consultaAgenda(novaAgenda);
                        break;
                    case 4:
                        mudarTelefone(novaAgenda);
                        break;
                    case 5:
                        mudarNome(novaAgenda);
                        break;
                    case 6:
                        deletarContato();
                        break;
                    case 7:
                        System.out.println("Tem certeza que deseja limpar "
                                + "toda a agenda?  (S/N)");
                        String operador = ler.next().toLowerCase();
                        switch (operador) {
                            case "s":
                            case "sim":
                                first = true;
                                System.out.println("Agenda limpa");
                                ponteiro = 0;
                                main(args);
                                break;
                            case "n":
                            case "nao":
                                break;
                            default:
                                System.out.println("entrada invalida.");
                                break;
                        }// fim swith
                        break;
                    case 0:
                        System.out.println("Obrigado por usar nosso software!");
                        break;
                    default:
                        System.out.println("codigo invalido");
                        break;
                }// fim switch
            }// fim while
            System.exit(op);
        } catch (InputMismatchException entradainvalida) {
            System.out.println("entrada invalida");
            main(args);
        }// fim try catch
    }// fim metodo main

    /**
     * Metodo que imprime as opcoes no menu
     *
     * @return int - numero da operacao a ser executada
     */
    public static int menu() {
        try {
            System.out.println("+---------------------------------+");
            System.out.println("|       O que deseja fazer?       |");
            System.out.println("+---------------------------------+");
            System.out.println("| 1 - Adicionar contato           |");
            System.out.println("| 2 - Consultar contato           |");
            System.out.println("| 3 - Consultar todos os contatos |");
            System.out.println("| 4 - Mudar telefone              |");
            System.out.println("| 5 - Mudar nome                  |");
            System.out.println("| 6 - Deletar contato             |");
            System.out.println("| 7 - Limpar agenda               |");
            System.out.println("| 0 - Exit                        |");
            System.out.println("+---------------------------------+");
            return ler.nextInt();
        } catch (NumberFormatException erro) {
            System.out.println("Entrada invalida Tente novamente");
            return menu();
        }// fim try/catch
    }// fim metodo menu

    /**
     * metodo que formata o numero do telefone
     *
     * @param mascara - String - formato para forma
     * @param tel - String - numero do telefone
     * @return
     */
    private static String formatString(String mascara, String tel) {
        try {
            MaskFormatter forma = new MaskFormatter(mascara);
            forma.setValueContainsLiteralCharacters(false);
            return forma.valueToString(tel);
        } catch (ParseException e) {
            e.printStackTrace();
        }// fim try/catch
        return "";
    }// fim metodo formatString

    /**
     * Metodo que cria um novo contato
     *
     * @param novaAgenda - Agenda - Agenda a ser inserida o novo contato;
     */
    private static void criarContato(Agenda novaAgenda[]) {
        if (ponteiro < MAX) {
            nome = null;
            System.out.println("Digite um nome:");
            nome = ler.next();
            boolean chave = false;
            while (chave == false) {
                System.out.println("Digite o numero do novo "
                        + "contato:");
                System.out.println("Exemplo: 99999999999 -> "
                        + "(99)9999-99999");
                telefone = ler.next().replaceAll("[^0-9]", "");
                switch (telefone.length()) {
                    case 11:
                        telefone = formatString("(##)####-#####",
                                telefone);
                        chave = true;
                        break;
                    case 10:
                        telefone = formatString("(##)####-####",
                                telefone);
                        chave = true;
                        break;
                    default:
                        System.out.println("Numero Invalido. "
                                + "Tente novamente");
                        break;
                }// fim switch
            }// fim while
            Agenda novoContato = new Agenda(nome, telefone);
            novaAgenda[ponteiro] = novoContato;
            ponteiro++;
        } else {
            System.out.println("Agenda Cheia");
        }// fim if/else
    }// fim metodo criarContato

    /**
     * metodo que consulta um contato em uma determinada posicao;
     *
     * @param novaAgenda - Agenda - Agenda aser consultar o contato desejado
     */
    private static void consultaContato(Agenda novaAgenda[]) {
        if (verificaAgenda()) {
            System.out.println("Digite qual posição de 1 a " + MAX
                    + " deseja consultar:");
            posicao = ler.nextInt();
            if (posicao > 0 && posicao <= MAX) {
                posicao--;
                if (novaAgenda[posicao].getContato() != null) {
                    System.out.println("posicao: " + (posicao + 1) + "\n"
                            + novaAgenda[posicao].getContato());
                    System.out.println("==============================");
                } else {
                    System.out.println("Posicao vazia.");
                }// fim if/else
            } else {
                System.out.println("Posicao nao exitente.");
            }// fim if/else
        } // fim if
    }// fim metodo consultaContato

    /**
     * metodo que mostra dos os contatos de uma agenda
     *
     * @param novaAgenda - Agenda - Agenda a ser consultada.
     * @throws ArrayIndexOutOfBoundsException
     */
    private static void consultaAgenda(Agenda novaAgenda[]) throws
            ArrayIndexOutOfBoundsException {
        if (verificaAgenda()) {
            for (int i = 0; i < ponteiro; i++) {
                System.out.println("posicao: " + (i + 1) + "\n"
                        + novaAgenda[i].getContato());
                System.out.println("==============================");
            }// fim for
        }// fim if
    }// fim metodo consultaAgenda

    /**
     * metodo que muda o telefone de um determinado contato de uma determinada
     * posicao da agenda
     *
     * @param novaAgenda - Agenda - Agenda a mudar o numero do determinado
     * contato
     */
    private static void mudarTelefone(Agenda novaAgenda[]) {
        if (verificaAgenda()) {
            System.out.println("Digite qual posição de 1 a " + ponteiro
                    + " do contato que deseja mudar o telefone:");
            posicao = ler.nextInt();
            if (posicao > 0 && posicao <= MAX) {
                posicao--;
                boolean chave = false;
                while (chave == false) {
                    System.out.println("Digite o novo numero do "
                            + "contato:");
                    System.out.println("Exemplo: 99999999999 -> "
                            + "(99)9999-99999");
                    telefone = ler.next().replaceAll("[^0-9]", "");
                    switch (telefone.length()) {
                        case 11:
                            telefone = formatString("(##)####-#####",
                                    telefone);
                            chave = true;
                            break;
                        case 10:
                            telefone = formatString("(##)####-####",
                                    telefone);
                            chave = true;
                            break;
                        default:
                            System.out.println("Numero Invalido. "
                                    + "Tente novamente");
                            break;
                    }// fim switch
                }// fim while
                novaAgenda[posicao].setTelefone(telefone);
            } else {
                System.out.println("Posicao invalida");
            }// fim if/else
        } // fim if
    }// fim metodo MudarTelefone 

    /**
     * metodo que muda o nome de um contato um determinada posicao de uma agenda
     *
     * @param novaAgenda - Agenda - Agenda a ser setado o nome do contato
     */
    private static void mudarNome(Agenda novaAgenda[]) {
        if (verificaAgenda()) {
            System.out.println("Digite qual posição de 1 a " + ponteiro
                    + " do contato que deseja mudar o nome:");
            posicao = ler.nextInt();
            if (posicao > 0 && posicao <= ponteiro) {
                posicao--;
                System.out.println("Digite um nome:");
                nome = (ler.next());
                novaAgenda[posicao].setNome(nome);
            } else {
                System.out.println("posicao invalida:");
            }// fim if/else
        }//fim if
    }//fim metodo mudarNome

    /**
     * metodo que verifica se a agenda esta vazia ou nao.
     *
     * @return - boolean - true - se tiver algum contato
     * @return - boolean - false - se a Agenda estiver vazia;
     */
    private static boolean verificaAgenda() {
        if (ponteiro > 0) {
            return true;
        } else {
            System.out.println("Agenda vazia");
            return false;
        }// fim if/else
    }// fim metodo verificaAgenda

    /**
     * metodo que deleta um contato em uma determinada posicao
     *
     */
    private static void deletarContato() {
        if (verificaAgenda()) {
            System.out.println("Digite qual posição de 1 a " + ponteiro
                    + " do contato que deseja deletar ou 0 para cancelar:");
            posicao = ler.nextInt();
            if (posicao > 0 && posicao <= ponteiro) {
                posicao--;
                System.out.println("deseja msm deletar o contato "
                        + novaAgenda[posicao].getNome() + "?\n(S/N)");
                String op = ler.next().toLowerCase();
                switch (op) {
                    case "s":
                    case "sim":
                        for (; novaAgenda[posicao] != null; posicao++) {
                            novaAgenda[posicao] = novaAgenda[posicao + 1];
                        }// fim for
                        novaAgenda[posicao - 1] = null;
                        ponteiro--;
                        break;
                    case "n":
                    case "nao":
                        break;
                    default:
                        System.out.println("entrada invalida.");
                        break;
                }// fim switch
            } else if (posicao == 0) {
            } else {
                System.out.println("entrada invalida");
            }//fim if/else
        }//fim if
    }// fim metodo deletarContato
}//fim classe Exercicio4
