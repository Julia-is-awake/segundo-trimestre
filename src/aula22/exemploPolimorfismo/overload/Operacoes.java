package aula22.exemploPolimorfismo.overload;

public class Operacoes {
    public int soma(int n1, int n2){
        return n1 + n2;
    }

    public int soma(int n1, int n2, int n3){
        return n1 + n2 + n3;
    }

    public String soma(String s1, String s2){
        return s1 + " " + s2;
    }

    public float soma(float[] vetor){
        float soma = 0;
        for ( int i = 0; i < vetor.length; i++){
            soma += vetor[i];
        }
        return soma;
    }
}
