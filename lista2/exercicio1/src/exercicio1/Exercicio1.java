
package exercicio1;

/**
 *
 * @author Estevao
 */
public class Exercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Contador c1 = new Contador();
        System.out.println(c1.getCont());
        c1.incrementa();
        System.out.println(c1.getCont());
        c1.zerar();
    }
    
}
