package exercicio5;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Estevao Cristino
 */
public class Cartela {

    final int MAX = 9; // qnt de numeros em cada cartela
    int[] numeros = new int[MAX];
    String[] cartela = new String[MAX];
    Vetor vet = new Vetor();
    private final int[] espelho = new int[MAX];
    Scanner ler = new Scanner(System.in);

    /**Metodo que cria uma nova cartela
     *
     */
    public void gerarCartela() {
        int i;
        Sorteio sortiar = new Sorteio();
        for (i = 0; i < MAX; i++) {
            this.numeros[i] = sortiar.getPedras(i);
        }
        vet.odernar(numeros);
        for (i = 0; i < MAX; i++) {
            if (this.numeros[i] < 10) {
                this.cartela[i] = "0" + this.numeros[i];
            } else {
                this.cartela[i] = "" + this.numeros[i];
            }
        }
    }

    /**Metodo que mostra a cartela
     *
     * @return - String - retorna a cartela
     */
    public String mostrarCartela() {
        return "+----------+\n| " + this.cartela[0] + " " + this.cartela[1]
                + " " + this.cartela[2] + " |\n| " + this.cartela[3] + " "
                + this.cartela[4] + " " + this.cartela[5] + " |\n| "
                + this.cartela[6] + " " + this.cartela[7]
                + " " + this.cartela[8] + " |\n+----------+";
    }

    /**Metodo que veridica se a cartela fez um bingo!
     *
     * @param n - int -  ultimo numero sortiado
     * @return - boolean - se a cartela foi vitoriosa
     * @throws InterruptedException
     * @throws IOException
     */
    public boolean verificaCartela(int n) throws InterruptedException, IOException {
        int comp = 0;
        boolean vitoria = false;
        for (int i = 0; i < this.MAX; i++) {
            if (this.numeros[i] == this.espelho[i]) {
                comp++;
            }
        }
        if (comp == this.MAX) {
            vitoria = true;
        }
        return vitoria;
    }
    
    /**Metodo que marca o numero na tabela
     *
     * @param n - int - caso o numero exista na cartela ele sera marcado
     */
    public void marcaCartela(int n) {
        for (int i = 0; i < this.MAX; i++) {
            if (n == this.numeros[i]) {
                this.espelho[i] = n;
                this.cartela[i] = "@@";
            }
        }
    }

}
