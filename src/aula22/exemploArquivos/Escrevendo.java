package aula22.exemploArquivos;

import java.io.*;

public class Escrevendo {
    public static void main(String[] args) {
        File caminho = new File(
                "C:\\Users\\Usuário\\Pictures\\buya");
        if(caminho.exists()){
            System.out.println("O caminho existe!");
        }
        else{
            System.out.println(
                    "O caminho não existe, tentando criar...");
            caminho.mkdirs();
        }

        //Tentando escrever uma pessoa em um arquivo
        Pessoa p1 = new Pessoa();
        p1.setNome("Jonas");
        p1.setSobrenome("Silva");
        File arquivo = new File(caminho, "dadosPessoa.db");
        try{
            System.out.println(arquivo.getAbsolutePath());
            ObjectOutputStream objEscrita = new ObjectOutputStream(
                    new FileOutputStream(arquivo.getAbsolutePath()));
            objEscrita.writeObject(p1);
            objEscrita.close();
            System.out.println(p1+" salvo com sucesso!");
        }
        catch (FileNotFoundException e){
            System.out.println("Erro ao ler o arquivo!");
        }
        catch (IOException e){
            System.out.println("Erro ao gravar as informações!");
        }
    }
}
