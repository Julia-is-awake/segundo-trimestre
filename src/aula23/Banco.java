package aula23;

import aula22.exemploArquivos.Pessoa;

import java.io.*;
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

    public static File criarCaminho(){
        File caminho = new File(
                "C:\\Users\\usuário\\Documents\\Contas");
        if(!caminho.exists()){
            caminho.mkdirs();
        }
        return caminho;
    }

    public static Conta[] lendoContas(){
        Conta[] contas = new Conta[10];

        File caminho = criarCaminho();

        File arquivo = new File(caminho, "dadosContas.db");

        try{
            ObjectInputStream objLeitura = new ObjectInputStream(new FileInputStream(arquivo.getAbsoluteFile()));
            contas = (Conta[]) objLeitura.readObject();
            return contas;
        }
        catch (FileNotFoundException e){
            System.out.println("Arquivo não existe!");
        }
        catch (IOException e){
            System.out.println("Erro ao ler o arquivo!");
        }
        catch (ClassNotFoundException e){
            System.out.println("Classe não encontrada!");
        }
        return contas;
    }

    public static int countContas(Conta[] contas){
        int i = 0;
        int count = 0;
        do {
            if(contas[i] == null){
                i = -1;
            }else{
                i++;
                count++;
            }
        }while(i!=-1);
        return count;
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Conta[] contas;
        contas = lendoContas();

        File caminho = new File(
                "C:\\Users\\usuário\\Documents\\Contas");
        if(!caminho.exists()){
            System.out.println(
                    "O caminho não existe, tentando criar...");
            caminho.mkdirs();
        }
        File arquivo = new File(caminho, "dadosContas.db");

        int countContas = countContas(contas);
        char resp;

        do{
            System.out.print("c - cadastrar uma nova conta\na - acessar uma conta\nl - listar as contas\ne - sair\nopção: ");
            resp = ler.next().toLowerCase().charAt(0);
            switch (resp){
                case 'c' -> {
                    contas[countContas] = cadastrarConta();
                    System.out.println("Conta cadastrado obteve o identificador "+contas[countContas].identificador);
                    try{
                        System.out.println(arquivo.getAbsolutePath());
                        ObjectOutputStream objEscrita = new ObjectOutputStream(
                                new FileOutputStream(arquivo.getAbsolutePath()));
                        objEscrita.writeObject(contas);
                        objEscrita.close();
                        System.out.println(contas[countContas]+" salvo com sucesso!");
                        countContas++;
                        contas = lendoContas();
                    }
                    catch (FileNotFoundException e){
                        System.out.println("Erro ao ler o arquivo!");
                    }
                    catch (IOException e){
                        System.out.println("Erro ao gravar as informações!");
                    }
                }
                case 'a'->{

                    System.out.print("Digite o identificador: ");
                    String id = ler.next();
                    System.out.print("Digite a senha: ");
                    String senha = ler.next();
                    System.out.println(countContas);
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
                    System.out.println("-----------------------");
                    for(int i = 0; i < countContas; i++){
                        System.out.println("Títular: "+contas[i].titular);
                        System.out.println("Identificador: "+contas[i].identificador);
                        System.out.println("-----------------------");
                    }
                }
            }
        }while(resp!='e');
    }
}
