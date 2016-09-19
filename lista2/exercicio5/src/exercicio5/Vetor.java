package exercicio5;

import java.util.Random;

/**
 *
 * @author Estevao Cristino
 */
public class Vetor {

    Random rand = new Random();
    int numeroSortiado;
   
    /**Metodo que mistura um vetor
     *
     * @param v - int[] - vetor a ser misturado.
     * @return - int[] - vetor misturado/embaralhado
     */
    public int[] misturar(int[] v) {
        int tam = v.length;
        int n, i, aux;
        for (i = 0; i < tam; i++) {
            n = rand.nextInt(tam);
            if (i != n) {
                aux = v[i];
                v[i] = v[n];
                v[n] = aux;
            } else {
                i--;
            }
        }
        return v;
    }

    /**Metodo que oderna de forma crescente um vetor
     *
     * @param v - int[] - vetor a ser odernado
     * @return - int[] - vetor ordenado
     */
    public int[] odernar(int[] v) {
        int i, j, atual;
        for (i = 1; i < v.length; i++) {
            atual = v[i];
            j = i - 1;
            while ((j >= 0) && (atual < v[j])) {
                v[j + 1] = v[j];
                j = j - 1;
            }
            v[j + 1] = atual;
        }
        return v;
    }

}

