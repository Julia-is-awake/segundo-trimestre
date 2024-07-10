package aula22.exemploFinal;

public class Teste {
    public static void main(String[] args) {
        //Acesso a uma constante
        System.out.println(Operacoes.PI);
        Operacoes op = new Operacoes();
        //Acessar um atributo final
        System.out.println(op.pi);
        //Não é possível alterar o valor de um atributo final
        //op.pi = 3.14;
    }
}
