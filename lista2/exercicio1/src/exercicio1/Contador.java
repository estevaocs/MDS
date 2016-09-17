
package exercicio1;

/**
 *
 * @author Estevao
 */
public class Contador {
    private int cont;
    
    /**Metodo que zera o contador;
     * 
     */
    public void zerar(){
        this.cont = 0;
    }// fim zerar
    
    /**Metodo que incrementa em uma unidade o contador.
     * 
     */
    public void incrementa(){
        this.cont++;
    }// fim incrementa
    
    /**Metodo que retorna a qnt de unidades no contador.
     * 
     * @return cont - int - o valor do cont
     */
    public int getCont(){
        return this.cont;
    }// fim getCont
    
}// fim classe Contador
