package aula18.exemplos.exemplo3;

import java.util.Random;
import java.util.Scanner;

public class Teste {
    public static void mostraAluno(Aluno a1){
        System.out.println("Nome: " + a1.nome + " " + a1.sobrenome);
        System.out.println("Código: " + a1.codigo);
        System.out.println("Média: " + a1.obterMedia());
        System.out.println("O aluno " + a1.obterStatus());
        System.out.println("-------------------------------------------");
    }

    public static Aluno cadastrarAluno() {
        Scanner ler = new Scanner(System.in);
        Aluno a1 = new Aluno();
        System.out.print("Informe o nome do aluno: ");
        String nome = ler.next();
        System.out.print("Informe o sobrenome do aluno: ");
        String sobrenome = ler.next();
        System.out.print("Informe o e-mail do aluno: ");
        String eMail = ler.next();
        int codigo = new Random().nextInt(1000, 100000);
        a1.nome = nome;
        a1.sobrenome = sobrenome;
        a1.eMail = eMail;
        a1.codigo = codigo;

        return a1;
    }



    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Aluno[] turma = new Aluno[10];
        int countAluno = 0;
        char resp;
        do {
            System.out.println("c - cadastro de aluno");
            System.out.println("l - listar os alunos");
            System.out.println("p - pesquisar um aluno");
            System.out.println("s - sair");
            System.out.print(": ");
            resp = ler.next().toLowerCase().charAt(0);
            if (resp == 'c') {
                if (countAluno < turma.length) {
                    turma[countAluno] = cadastrarAluno();
                    System.out.println("Aluno " + turma[countAluno].nome + " " + turma[countAluno].sobrenome +
                            " cadastrado obteve o código " + turma[countAluno].codigo);
                    System.out.print("Qual a primeira nota do " + turma[countAluno].nome + ": ");
                    turma[countAluno].notaUm = ler.nextFloat();
                    System.out.print("Qual a segunda nota do " + turma[countAluno].nome + ": ");
                    turma[countAluno].notaDois = ler.nextFloat();
                    countAluno++;
                }


            } else if (resp == 'l') {
                for (int i = 0; i < countAluno; i++) {
                    mostraAluno(turma[i]);
                }
            } else if (resp == 'p') {
                System.out.println("Digite o código da matrícula: ");
                int codigo = ler.nextInt();
                int i;
                boolean achou = false;
                for (i = 0; i < countAluno; i++) {
                    if (turma[i].codigo == codigo) {
                        mostraAluno(turma[i]);
                        achou = true;
                        i = countAluno;
                    } else {
                        i++;
                    }
                }
                if (!achou) {
                    System.out.println("Aluno não foi encontrado!");
                }
            }
        } while (resp != 's');
    }
}