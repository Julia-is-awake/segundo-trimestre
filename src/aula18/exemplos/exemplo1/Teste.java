package aula18.exemplos.exemplo1;

public class Teste {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        p1.nome = "Jonas";
        p1.sobrenome = "Silva";
        p1.altura = 180;
        p1.idade = 25;

        p1.andar();
        p1.correr();
        p1.parar();
        System.out.println(p1.obterDados());
    }
}