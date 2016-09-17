package exercicio3;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Estevao
 */
public final class Data {

    private int ano;
    private int dia;
    private int mes;

    public Data(int ano, int dia, int mes) {
        if (verificaData(dia, mes, ano)) {
            this.ano = ano;
            this.dia = dia;
            this.mes = mes;
        }// fim if
        else {
            System.out.println("data invalida");
            System.out.println("iremos pegar a data atual");
            setDataAtual();
        }// fim else 
    }// fim metodo construtura data

    public void setDataAtual() {
        GregorianCalendar calendar = new GregorianCalendar();
        this.dia = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        this.mes = calendar.get(GregorianCalendar.MONTH);
        this.ano = calendar.get(GregorianCalendar.YEAR);
    }

    private boolean verificaData(int dia, int mes, int ano) {
        int qntDias;

        if (ano > 0) {

            if (mes >= 1 && mes <= 12) {

                qntDias = qntDiasNoMes(mes, ano);

                return dia >= 1 && dia <= qntDias;

            }// fim if
            else {
                return false;
            }// fim else

        }// fim if
        else {
            return false;
        }//fim else

    }// fim metodo verificaData

    private int qntDiasNoMes(int mes, int ano) {
        int qntDias = 0;
        switch (mes) {
            case 1:
                qntDias = 31;
                break;
            case 2:
                if ((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0))) {
                    qntDias = 29;
                }// fim if
                else {
                    qntDias = 28;
                }
                break;
            case 3:
                qntDias = 31;
                break;
            case 4:
                qntDias = 30;
                break;
            case 5:
                qntDias = 31;
                break;
            case 6:
                qntDias = 30;
                break;
            case 7:
                qntDias = 31;
                break;
            case 8:
                qntDias = 31;
                break;
            case 9:
                qntDias = 30;
                break;
            case 10:
                qntDias = 31;
                break;
            case 11:
                qntDias = 30;
                break;
            case 12:
                qntDias = 31;
                break;
            default:
                System.out.println("mês nao existe");
                break;
        }// fim switch
        return (qntDias);
    }// fim metodo qntDiasNoMes

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        if (ano > 0) {
            this.ano = ano;
        } else {
            System.out.println("Ano invalido!");
        }
    }

    public int getDia() {
        return this.dia;
    }

    public void setDia(int dia) {
        if (verificaData(dia, this.mes, this.ano)) {
            this.dia = dia;
        } else {
            System.out.println("Dia Invlida");
        }
    }

    public int getMes() {
        return this.mes;
    }

    public void setMes(int mes) {
        if (verificaData(this.dia, mes, this.ano)) {
            this.mes = mes;
        }// fim if
        else if (this.dia > qntDiasNoMes(mes, this.ano)) {
            while (this.dia > qntDiasNoMes(mes, this.ano)) {
                this.dia--;
            }// fim while
            this.mes = mes;
        }// fim if
        else {
            while (this.dia < 0) {
                this.dia++;
            }// fim while
        }// fim else// fim else
    }// fim setMes

    public String getData() {
        return (this.dia + "/" + this.mes + "/" + this.ano);
    }

    public void setData(int dia, int mes, int ano) {
        if (verificaData(dia, mes, ano)) {
            setDia(dia);
            setMes(mes);
            setAno(ano);
        } else {
            System.out.println("Data invalida");
        }
    }

}// fim classe Data
