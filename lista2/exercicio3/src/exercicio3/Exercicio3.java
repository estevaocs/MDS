package exercicio3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Estevao
 */
public class Exercicio3 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int dia, mes, ano, op = 1;
        Scanner leitor = new Scanner(System.in);
        try {
                System.out.println("Digite um uma data:");
                System.out.println("dia:");
                dia = leitor.nextInt();
                System.out.println("mes:");
                mes = leitor.nextInt();
                System.out.println("ano:");
                ano = leitor.nextInt();
                Data data = new Data(ano, dia, mes);
            while (op != 0) {
                op = menu();
                switch (op) {
                    case 1:
                        System.out.println(data.getData());
                        break;
                    case 2:
                        System.out.println("Digite uma nova data:");
                        System.out.println("dia:");
                        dia = leitor.nextInt();
                        System.out.println("mes:");
                        mes = leitor.nextInt();
                        System.out.println("ano:");
                        ano = leitor.nextInt();
                        data.setData(dia, mes, ano);
                        break;
                    case 3:
                        System.out.println("Digite o novo dia:");
                        dia = leitor.nextInt();
                        data.setDia(dia);
                        break;
                    case 4:
                        System.out.println("Digite um novo mes:");
                        mes = leitor.nextInt();
                        data.setMes(mes);
                        break;
                    case 5:
                        System.out.println("Digite o novo ano:");
                        ano = leitor.nextInt();
                        data.setAno(ano);
                        break;
                    case 6:
                        data.setDataAtual();
                    default:
                        System.out.println("Entrada invalida");
                        break;
                }
            }
        } catch (InputMismatchException erro1) {
            System.out.println("entrada invalida");
            main(args);
        }
    }

    public static int menu() {
        try {
            Scanner leitor = new Scanner(System.in);
            System.out.println("##############################");
            System.out.println("#        O que fazer:        #");
            System.out.println("#----------------------------#");
            System.out.println("# 1 - Ver Data               #");
            System.out.println("# 2 - Mudar data             #");
            System.out.println("# 3 - Mudar dia              #");
            System.out.println("# 4 - Mudar mes              #");
            System.out.println("# 5 - Mudar ano              #");
            System.out.println("# 6 - Pegar data atual       #");
            System.out.println("# 0 - exit                   #");
            System.out.println("##############################");
            return leitor.nextInt();
        } catch (NumberFormatException erro2) {
            System.out.println("entrada invalida");
            return menu();
        }

    }

}
