package aula21.exercicioBanco;

public class ContaCorrente extends Conta{
    private float limite;

    public ContaCorrente(String titular, String senha, float limite){
        super(titular, senha);
        this.limite = limite;
    }

    public boolean sacar(float valor){
        if(valor<=limite+saldo){
            saldo -= valor;
            return true;
        }
        return false;
    }

    public String verificaSaldo(){
        return String.format("Seu saldo é de R$%.2f", saldo);
    }
}
