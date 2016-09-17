/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio2;

/**
 *
 * @author Estevao
 */
public class Conta {
    private float saldo;
    final float VALOR_PADRAO = 20;
    

    public Conta() {
        this.saldo = VALOR_PADRAO;
    }
    
    public float getSaldo() {
        return saldo;
    }

    public void deposita(float saldo) {
        this.saldo += saldo;
        System.out.println("vc depositou " + saldo + "R$ em sua conta");
    }
    
    public void sacar(float saldo) {
        if(this.saldo >= saldo) {
            this.saldo -= saldo;
            System.out.println("vc sacou " + saldo + "R$ de sua conta");
        }
        else{
            System.out.println("Saldo insuficiente.");
        }
    }
    
    
    
}


