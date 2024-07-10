package aula22.exemploPolimorfismo.overload;

public class Teste {
    public static void main(String[] args) {
        Operacoes op = new Operacoes();

        System.out.println("Somando dois números "+op.soma(5, 2));
        System.out.println("Somando três números "+op.soma(5, 3, 10));
        System.out.println("Somando duas String "+op.soma("Programação","Java"));

    }
}
