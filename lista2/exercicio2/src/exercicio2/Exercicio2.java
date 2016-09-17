package exercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Estevao
 */
public class Exercicio2 {

    public static void main(String[] args) {
        Conta c1 = new Conta();
        menu(c1);
    }

    /**
     *
     * @param c1
     */
    public static void menu(Conta c1) {
        int op;
        float qnt;

        Scanner leitor = new Scanner(System.in);

        try {
            System.out.println("##############################");
            System.out.println("#    O que deseja Fazer?     #");
            System.out.println("#----------------------------#");
            System.out.println("# 1 - Verificar saldo        #");
            System.out.println("# 2 - Sacar                  #");
            System.out.println("# 3 - Depositar              #");
            System.out.println("# 0 - sair                   #");
            System.out.println("##############################");
            op = leitor.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Seu saldo é de: "
                            + c1.getSaldo() + "R$");
                    menu(c1);
                    break;
                case 2:
                    System.out.println("Digite o valor que deseja sacar:");
                    qnt = leitor.nextFloat();
                    c1.sacar(qnt);
                    menu(c1);
                    break;
                case 3:
                    System.out.println("Digite o valor que deseja depositar:");
                    qnt = leitor.nextFloat();
                    c1.deposita(qnt);
                    menu(c1);
                case 0:
                    System.exit(0);
                default:
                    System.out.println("entrada invalida. tente novamente.");
                    menu(c1);
            }// fim switch
        }// fim try
        catch (InputMismatchException erro) {
            System.out.println("entre apenas com os operadores corretos");
            menu(c1);
        }// fim catch

    }// fim menu

}// fim classe
