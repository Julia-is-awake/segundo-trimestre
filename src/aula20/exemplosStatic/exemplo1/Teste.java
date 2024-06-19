package aula20.exemplosStatic.exemplo1;

public class Teste {
    public static void main(String[] args) {
        Conta c1 = new Conta("Jonas", "123", 1000);
        c1.depositar(0);
        System.out.println(c1.verificaSaldo());

//        c1.nomeBanco = "Banco Cimol";
//        Conta c2 = new Conta("Ana", "123", 100);
//        System.out.println("Nome do banco de c1 "+c1.nomeBanco);
//        System.out.println("Nome do banco de c2 "+c2.nomeBanco);
//
//        //Acesso diretamente da classe
//        Conta.nomeBanco = "Teste";
//        System.out.println("\nNome do banco de c1 "+c1.nomeBanco);
//        System.out.println("Nome do banco de c2 "+c2.nomeBanco);
    }
}
