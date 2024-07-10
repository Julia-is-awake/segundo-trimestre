package aula22.exemploExecao.exemplo3;

public class ExemploExcecao {
    public int divide(int n1, int n2){
        if(n2==0){
            throw new ArithmeticException("Não é possível dividir por zero");
        }
        return n1 / n2;
    }
}
