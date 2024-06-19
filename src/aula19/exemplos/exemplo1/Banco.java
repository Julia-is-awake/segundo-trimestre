package aula19.exemplos.exemplo1;

import java.util.Scanner;

public class Banco {
    public static Conta cadastrarConta(){
        Scanner ler = new Scanner(System.in);
        System.out.print("Informe o nome do titular: ");
        String titular = ler.nextLine();
        Conta c1 = new Conta(titular);
        System.out.println("A nova conta tem o identificador "+c1.identificador);
        System.out.print("Informe sua senha: ");
        c1.senha = ler.nextLine();
        System.out.print("Informe o saldo atual da sua conta: ");
        c1.saldo = ler.nextFloat();

        return c1;
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
                    contas[countContas] = cadastrarConta();
                    System.out.println("Conta cadastrado obteve o identificador "+contas[countContas].identificador);
                    countContas++;
                }
                case 'a'->{
                    System.out.print("Digite o identificador: ");
                    String id = ler.next();
                    System.out.print("Digite a senha: ");
                    String senha = ler.next();
                    int posicao = -1;
                    for (int i = 0; i< countContas; i++) {
                        if (contas[i].identificador.equals(id) && contas[i].senha.equals(senha)) {
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
                        System.out.println("Títular: "+contas[i].titular);
                        System.out.println("Identificador: "+contas[i].identificador);
                        System.out.println("-----------------------");
                    }
                }
            }
        }while(resp!='e');

        /*
        do{
            System.out.print("e - entrar\nc - cadastrar\ns - sair\nopção: ");
            resp = ler.next().toLowerCase().charAt(0);
            if(resp=='c'){
                if (countContas < contas.length){
                    contas[countContas] = cadastrarConta();
                    System.out.println("Conta "+contas[countContas].identificador+" de "+contas[countContas].titular+".");
                    countContas++;
                }else{
                    System.out.println("Limite de contas atingido!");
                }
            }else if(resp=='e'){
                if(countContas==0){
                    System.out.println("Ainda não há contas criadas, por favor, crie uma conta.");
                }else{
                    for(int i = 0; i<1;){
                        System.out.print("Digite o seu titular: ");
                        String titular = ler.nextLine();
                        for(int j = 0; j<countContas; j++){
                            if (titular.equals(contas[j].titular)){
                                i++;
                                System.out.print("Digite a sua senha: ");
                                String senha = ler.nextLine();
                                if (senha.equals(contas[j].senha)){
                                    System.out.println("Login realizado com sucesso!\n");
                                    j++;
                                }else{
                                    System.out.println("Senha incorreta! Tente novamente!");
                                }
                                char op;
                                do {
                                    System.out.println("Selecione uma opção:");
                                    System.out.print("v - ver saldo da conta\nd - depositar\nc - sacar\ns - sair\nopção: ");
                                    op = ler.next().toLowerCase().charAt(0);
                                    if(op == 'v'){
                                        System.out.println(contas[j].verificaSaldo());
                                    }else if(op == 'd'){
                                        System.out.print("Informe o valor que deseja depositar: ");
                                        contas[j].depositar(ler.nextFloat());
                                    }else if(op == 'c'){
                                        System.out.print("Informe o valor que deseja sacar: ");
                                        int valor = ler.nextFloat();
                                        if(contas[j].sacar(valor)){
                                            contas[j]
                                        }else{
                                            System.out.println("Saldo insuficiente!");
                                        }
                                    }
                                }while(op!='s');
                            }else{
                                System.out.println("Conta não encontrada! Tente outro titular!");
                            }
                        }
                    }
                }
            }
        }while(resp!='s');



        Conta c1 = new Conta();
        c1.geraidentificador();
        System.out.println("A nova conta tem o identificador "+c1.identificador);
        c1.titular = "Jonas";
        c1.depositar(1000);
        if(c1.sacar(1500)){
            System.out.println("Saque realizado");
        }else{
            System.out.println("Saldo insuficiente ");
        }
        System.out.println(c1.verificaSaldo());
         */
    }
}
