package aula22.exemploExecao.exemplo1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class exemploExecao {
    public static int leInteiro(){
        Scanner ler = new Scanner(System.in);
        int num = 0;
        boolean valido;
        do{
            try {
                System.out.println("Digite um número: ");
                num = ler.nextInt();
                valido = true;
            }
            catch (InputMismatchException e){
                System.out.println("O valor precisa ser um número!");
                ler.next();
                valido = false;
            }
        }while(!valido);
        return num;
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        try {
            int n1 = leInteiro();
            int n2 = leInteiro();
            int resposta = n1 / n2;
            System.out.println(n1+ " / " + n2 + " = " + resposta);
        }
        catch (InputMismatchException e){
            System.out.println("Os valores precisam ser números.");
            ler.next();
        }
        catch (ArithmeticException e){
            System.out.println("Não é possível dividir por zero.");
        }
        finally{
            System.out.println("Sempre sou executado!");
        }
    }
}
