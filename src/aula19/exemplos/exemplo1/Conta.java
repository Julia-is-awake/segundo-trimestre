package aula19.exemplos.exemplo1;

import java.util.Random;

public class Conta {
    String titular;
    String identificador;
    String senha;
    float saldo;

    /* public Conta(String titular, float saldo){
        geraidentificador();
        this.titular = titular;
        this.saldo = saldo;
    } */
    public Conta(String titular){
        geraidentificador();
        this.titular = titular;
    }

    void geraidentificador(){
        char letra = (char) new Random().nextInt(65, 91);
        int valor = new Random().nextInt(1000, 10000);
        identificador = letra+"_"+valor;
    }

    void depositar(float valor){
        saldo += valor;
    }

    boolean sacar(float valor){
        if(valor<=saldo && valor<0)
            return true;
        return false;
    }

    String verificaSaldo(){
        return "Saldo atual R$ "+String.format("%.2f", saldo);
    }
}