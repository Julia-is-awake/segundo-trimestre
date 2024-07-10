package aula21.exercicioBanco;

import java.util.Scanner;

public class Banco {
    public static ContaCorrente cadastrarContaCorrente(){

        Scanner ler = new Scanner(System.in);
        System.out.print("Informe o nome do titular: ");
        String titular = ler.nextLine();
        System.out.print("Informe sua senha: ");
        String senha = ler.nextLine();

        System.out.print("Informe o limite da conta: ");
        float limite = ler.nextFloat();
        ContaCorrente c1 = new ContaCorrente(titular, senha, limite);
        System.out.println("A nova conta tem o identificador " + c1.getIdentificador());
        System.out.print("Informe o saldo atual da sua conta: ");
        c1.saldo = ler.nextFloat();

        return c1;
    }

    public static ContaPoupanca cadastrarContaPoupanca(){

        Scanner ler = new Scanner(System.in);
        System.out.print("Informe o nome do titular: ");
        String titular = ler.nextLine();
        System.out.print("Informe sua senha: ");
        String senha = ler.nextLine();

        System.out.print("Insira o deposito inicial: ");
        float deposito = ler.nextFloat();
        ContaPoupanca c1 = new ContaPoupanca(titular, senha, deposito);
        System.out.println("A nova conta tem o identificador " + c1.getIdentificador());
        return c1;
    }

    public static Conta acessandoContaCorrente(ContaCorrente c1){
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

    public static Conta acessandoContaPoupanca(ContaPoupanca c1){
        char op;
        do{
            System.out.print("d - depositar\nv - ver saldo\ne - sair\nopção: ");
            op = new Scanner(System.in).next().toLowerCase().charAt(0);
            switch(op){
                case 'd' -> {
                    System.out.print("Qual o valor deseja depositar: ");
                    float valor = new Scanner(System.in).nextFloat();
                    c1.depositar(valor);
                    System.out.println("Depósito realizado!");
                }
                case 'v' -> System.out.println(c1.verificaSaldo());
            }
        }while(op != 'e');

        return c1;
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        ContaCorrente[] contasCorrente = new ContaCorrente[10];
        ContaPoupanca[] contasPoupanca = new ContaPoupanca[10];

        int countContasCorrente = 0;
        int countContasPoupanca = 0;
        char resp;

        do{
            System.out.print("c - cadastrar uma nova conta\na - acessar uma conta\nl - listar as contas\ne - sair\nopção: ");
            resp = ler.next().toLowerCase().charAt(0);
            switch (resp){
                case 'c' -> {
                    System.out.print("Qual o tipo de conta:\nc - conta corrente\np - conta poupança\nOpção: ");
                    char option = ler.next().toLowerCase().charAt(0);
                    if(option == 'c'){
                        contasCorrente[countContasCorrente] = cadastrarContaCorrente();
                        countContasCorrente++;
                        System.out.println("Conta cadastrado obteve o identificador "+contasCorrente[countContasCorrente].getIdentificador());
                    }else if(option == 'p'){
                        contasPoupanca[countContasPoupanca] = cadastrarContaPoupanca();
                        countContasPoupanca++;
                    }
                    System.out.println("Conta cadastrado obteve o identificador "+contasPoupanca[countContasPoupanca].getIdentificador());
                }
                case 'a'->{
                    System.out.print("Digite o identificador: ");
                    String id = ler.next();
                    System.out.print("Digite a senha: ");
                    String senha = ler.next();
                    System.out.print("c - conta corrente\np - conta poupança\nDigite a opção de conta: ");
                    char contaOp = ler.next().toLowerCase().charAt(0);
                    int posicao = -1;
                    if(contaOp == 'c'){
                        for (int i = 0; i< countContasCorrente; i++) {
                            if (contasCorrente[i].getIdentificador().equals(id) && contasCorrente[i].getSenha().equals(senha)) {
                                posicao = i;
                            }
                        }
                    }else if(contaOp == 'p'){
                        for (int i = 0; i< countContasPoupanca; i++) {
                            if (contasPoupanca[i].getIdentificador().equals(id) && contasPoupanca[i].getSenha().equals(senha)) {
                                posicao = i;
                            }
                        }
                    }
                    if (posicao >= 0) {
                        if(contaOp == 'c'){
                            contasCorrente[posicao] = (ContaCorrente) acessandoContaCorrente(contasCorrente[posicao]);
                        }else if(contaOp == 'p'){
                            contasPoupanca[posicao] = (ContaPoupanca) acessandoContaPoupanca(contasPoupanca[posicao]);
                        }
                    } else {
                        System.out.println("Dados de acesso inválidos!");
                    }
                }
                case 'l' -> {
                    System.out.println("Listagem de contas...");
                    for(int i = 0; i < countContasCorrente; i++){
                        System.out.println("Títular: "+contasCorrente[i].getTitular());
                        System.out.println("Identificador: "+contasCorrente[i].getIdentificador());
                        System.out.println("-----------------------");
                    }
                    for(int i = 0; i < countContasPoupanca; i++){
                        System.out.println("Títular: "+contasPoupanca[i].getTitular());
                        System.out.println("Identificador: "+contasPoupanca[i].getIdentificador());
                        System.out.println("-----------------------");
                    }
                }
            }
        }while(resp!='e');
    }
}
