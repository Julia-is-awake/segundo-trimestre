package aula21.exemploHeranca.exemploEncapsulamento;

public class Banco {
    public static void main(String[] args) {
        Conta c1 = new Conta("Jonas", "123456");
        System.out.println("identificador = " + c1.getIdentificador());
        c1.depositar(100);
        if(c1.sacar(20)){
            System.out.println("Saque realizado.");
        }else{
            System.out.println("Saldo insuficiente.");
        }
        System.out.println(c1.verificaSaldo());
    }
}
