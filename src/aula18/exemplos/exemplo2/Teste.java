package aula18.exemplos.exemplo2;

public class Teste {
    public static void main(String[] args) {
        Aluno a1 = new Aluno();
        a1.nome = "Jonas";
        a1.sobrenome = "Silva";
        a1.eMail = "jonassilva@gmail.com";
        a1.codigo = 123;
        a1.notaUm = 9;
        a1.notaDois = 8;

        System.out.println("O aluno "+a1.nome+" "+ a1.sobrenome+" tirou "+a1.obterMedia()+" e "+ a1.obterStatus());
    }
}