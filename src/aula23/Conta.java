package aula23;

import java.io.File;
import java.io.Serializable;
import java.util.Random;

public class Conta implements Serializable {
    String titular;
    String identificador;
    String senha;
    float saldo;

    public Conta(String titular){
        geraidentificador();
        this.titular = titular;
    }

    void geraidentificador(){
        String texto = "";
        for(int i=0; i<4; i++){
            texto+=(char) new Random().nextInt(65,91);
        }
        int valor = new Random().nextInt(1000, 10000);
        identificador = texto+"_"+valor;
    }

    void depositar(float valor){
        saldo += valor;
    }

    boolean sacar(float valor){
        if(valor<=saldo && valor>0){
            saldo -= valor;
            return true;
        }
        return false;
    }

    String verificaSaldo(){
        return "Saldo atual R$ "
                +String.format("%.2f", saldo);
    }
}