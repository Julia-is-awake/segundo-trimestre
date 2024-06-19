package aula20.exemplosStatic.exemplo1;

import java.util.Random;

public class Conta {
    String titular;
    private String identificador;
    String senha;
    private float saldo;
    static String nomeBanco;

    public Conta(String titular, float saldo){
        geraidentificador();
        this.titular = titular;
        this.saldo = saldo;
    }
    public Conta(){

    }

    public Conta(String titular, String senha, float saldo){
        geraidentificador();
        this.titular = titular;
        this.senha = senha;
        this.saldo = saldo;
    }

    public Conta(String titular){
        geraidentificador();
        this.titular = titular;
    }

    public String getIdentificador(){
        return identificador;
    }

    private void geraidentificador(){
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
        return "Saldo atual R$ "+String.format("%.2f", saldo);
    }
}