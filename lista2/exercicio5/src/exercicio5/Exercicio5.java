package exercicio5;

import java.io.IOException;
import java.util.Scanner;

/**Program que simula um jogo de bingo
 *
 * @author Estevao Cristino
 */
public class Exercicio5 {

    static Sorteio globo = new Sorteio();
    static Vetor v = new Vetor();
    static Scanner ler = new Scanner(System.in);
    static Cartela c1 = new Cartela();
    static Cartela pc = new Cartela();

    /**Metodo que inicializa o jogo
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws InterruptedException,
            IOException {
        menu();
    }

    /**Metodo que mostraa o menu  e executa as açoes desejadas
     *
     * @throws InterruptedException
     * @throws IOException
     */
    public static void menu() throws InterruptedException, IOException {
        System.out.println("###########################");
        System.out.println("#   O que deseja fazer?   #");
        System.out.println("#-------------------------#");
        System.out.println("# 1 - Comecar Bingo       #");
        System.out.println("# 2 - Manual do jogo      #");
        System.out.println("# 0 - sair                #");
        System.out.println("###########################");
        int op = ler.nextInt();
        switch (op) {
            case 1:
                c1.gerarCartela();
                pc.gerarCartela();
                jogo(c1, pc);
            case 2:
                manual();
            case 0:
                System.exit(0);
                break;
            default:
                System.err.println("entrada invalida!");
                menu();
        }
    }

    /**Metodo que roda o jogo
     *
     * @param c1 - Cartela - Cartela do jogador
     * @param pc - Cartela - Cartela do Computador
     * @throws IOException
     * @throws InterruptedException
     */
    private static void jogo(Cartela c1, Cartela pc) throws IOException,
            InterruptedException {
        System.out.println("     YOU");
        System.out.println(c1.mostrarCartela());
        System.out.println("      PC");
        System.out.println(pc.mostrarCartela());
        System.out.println("Sempre que quiser ver Cartel aperte ENTER:");
        System.out.println("Proto para começar? PRESS ENTER");
        System.in.read();
        System.out.println("Começou");
        for (int i = 0; i < globo.QNT_PEDRAS; i++) {
            System.out.print("e a pedra sortiada é!");
            Thread.sleep(800);
            System.out.print(".");
            Thread.sleep(800);
            System.out.print(".");
            Thread.sleep(800);
            System.out.println(".");
            Thread.sleep(600);
            System.out.println(globo.getPedras(i));
            c1.marcaCartela(globo.getPedras(i));
            pc.marcaCartela(globo.getPedras(i));
            System.out.println("    YOU");
            System.out.println(c1.mostrarCartela());
            System.out.println("     PC");
            System.out.println(pc.mostrarCartela());
            if (c1.verificaCartela(globo.getPedras(i))) {
                System.out.println("############");
                System.out.println("# BINGO!!! #");
                System.out.println("############");
                System.out.println("VOCE GANHOU!!");
                System.in.read();
                menu();
            } else if (pc.verificaCartela(globo.getPedras(i))) {
                System.out.println("############");
                System.out.println("# BINGO!!! #");
                System.out.println("############");
                System.out.println("O PC GANHOU");
                System.in.read();
                menu();
            }
        }
    }

    /**Metodo que exibe o manual do jogo
     *
     * @throws IOException
     * @throws InterruptedException
     */
    private static void manual() throws IOException, InterruptedException {
        int op;
        boolean key = false;
        System.out.println("#################################################");
        System.out.println("#                    MANUAL                     #");
        System.out.println("#################################################");
        System.out.println("#    O jogo Bingo é bem simples, no inicio do   #");
        System.out.println("#jogo irá mostrar duas cartelas iguais as logo  #");
        System.out.println("#de baixo:                                      #");
        System.out.println("#          YOU   <--- INDICE                    #");
        System.out.println("#      +----------+                             #");
        System.out.println("#      | 01 02 03 |                             #");
        System.out.println("#      | 04 05 06 | <--- Seus numeros           #");
        System.out.println("#      | 07 08 09 |                             #");
        System.out.println("#      +----------+                             #");
        System.out.println("#   As cartelas são divididas em duas partes(In-#");
        System.out.println("#dice e os numeros).                            #");
        System.out.println("#   O Indice serve para Indicar de quem é a car-#");
        System.out.println("#tela, sendo YOU a sua e PC a do computador.    #");
        System.out.println("#   Os numeros serão sorteados a cada nova car- #");
        System.out.println("#tela nova.                                     #");
        System.out.println("#   Quando o Jogo começar à cada rodada um nume-#");
        System.out.println("#ro será sortiado. Caso esse numero esteja pre- #");
        System.out.println("#sente em umas das tabelas irá aparecer novamen-#");
        System.out.println("#te as cartelas, mas no local do numero irá apa-#");
        System.out.println("#recer o seguinte simbolos @@ demostrando a mar-#");
        System.out.println("#cação do numero na cartela.                    #");
        System.out.println("#   Ganha quem preencher a cartela primeiro     #");
        System.out.println("#################################################");
        System.out.println("Press Enter para voltar ao menu..");
        System.in.read();
        menu();
    }

}
