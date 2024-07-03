package aula21.exercicioBanco;

import java.util.Scanner;

public class Banco {
    public static Conta cadastrarConta(char op){

        Scanner ler = new Scanner(System.in);
        System.out.print("Informe o nome do titular: ");
        String titular = ler.nextLine();
        System.out.print("Informe sua senha: ");
        String senha = ler.nextLine();

        switch (op) {

            case 'c' -> {
                System.out.print("Informe o limite da conta: ");
                float limite = ler.nextFloat();
                Conta c1 = new ContaCorrente(titular, senha, limite);
                System.out.println("A nova conta tem o identificador " + c1.getIdentificador());
                System.out.print("Informe o saldo atual da sua conta: ");
                c1.saldo = ler.nextFloat();
                return c1;
            }

            case 'p' -> {
                System.out.print("Insira o deposito inicial: ");
                float deposito = ler.nextFloat();
                Conta c1 = new ContaPoupanca(titular, senha, deposito);
                System.out.println("A nova conta tem o identificador " + c1.getIdentificador());
                return c1;
            }

        }

        return null;
    }

    public static Conta acessandoConta(Conta c1){
        char op;
        do{
            System.out.print("d - depositar\ns - sacar\nv - ver saldo\ne - sair\nopção: ");
            op = new Scanner(System.in).next().toLowerCase().charAt(0);
            switch(op){
                case 'd' -> {
                    System.out.print("Qual o valor deseja depositar: ");
                    float valor = new Scanner(System.in).nextFloat();
                    c1.depositar(valor);
                    System.out.println("Depósito realizado!");
                }
                case 's' -> {
                    System.out.print("Qual valor deseja sacar: ");
                    float valor = new Scanner(System.in).nextFloat();
                    if(c1.sacar(valor)){
                        System.out.println("Saque realizado!");
                    }else{
                        System.out.println("Saldo insifuciente.");
                    }
                }
                case 'v' -> System.out.println(c1.verificaSaldo());
            }
        }while(op != 'e');

        return c1;
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Conta[] contas = new Conta[10];

        int countContas = 0;
        char resp;

        do{
            System.out.print("c - cadastrar uma nova conta\na - acessar uma conta\nl - listar as contas\ne - sair\nopção: ");
            resp = ler.next().toLowerCase().charAt(0);
            switch (resp){
                case 'c' -> {
                    System.out.print("Qual o tipo de conta:\nc - conta corrente\np - conta poupança\nOpção: ");
                    char option = ler.next().toLowerCase().charAt(0);
                    contas[countContas] = cadastrarConta(option);
                    System.out.println("Conta cadastrado obteve o identificador "+contas[countContas].getIdentificador());
                    countContas++;
                }
                case 'a'->{
                    System.out.print("Digite o identificador: ");
                    String id = ler.next();
                    System.out.print("Digite a senha: ");
                    String senha = ler.next();
                    int posicao = -1;
                    for (int i = 0; i< countContas; i++) {
                        if (contas[i].getIdentificador().equals(id) && contas[i].getSenha().equals(senha)) {
                            posicao = i;
                        }
                    }
                    if (posicao >= 0) {
                        contas[posicao] = acessandoConta(contas[posicao]);
                    } else {
                        System.out.println("Dados de acesso inválidos!");
                    }
                }
                case 'l' -> {
                    System.out.println("Listagem de contas...");
                    for(int i = 0; i < countContas; i++){
                        System.out.println("Títular: "+contas[i].getTitular());
                        System.out.println("Identificador: "+contas[i].getIdentificador());
                        System.out.println("-----------------------");
                    }
                }
            }
        }while(resp!='e');
    }
}
