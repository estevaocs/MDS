package exercicio5;
    
import  java.util.Random;

/**
 *
 * @author Estevao Cristino
 */
public class Sorteio {
    final int QNT_PEDRAS = 30;
    int[] pedras = new int[QNT_PEDRAS];
    Random rand = new Random();
    Vetor v = new Vetor();
    
    /**Metodo que cria o globo com as pedras e as misturam.
     *
     */
    public Sorteio(){
        int i;
        int aux;
        int n;
        for(i = 0; i < QNT_PEDRAS; i++){
            this.pedras[i] = i + 1;
        }
        this.pedras = v.misturar(this.pedras);
    }

    /**metodo que pega o numero da pedra desejada
     *
     * @param i - int - local em que a pedra está localizada
     * @return - int - o numero da pedras desejada
     */
    public int getPedras(int i) {
        return pedras[i];
    }
    
}
