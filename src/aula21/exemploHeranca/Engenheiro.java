package aula21.exemploHeranca;

public class Engenheiro extends Funcionario{
    private String crea;

    Engenheiro(String nome, String sobrenome){
        super(nome, sobrenome);
    }

    public String getCrea() {
        return crea;
    }

    public void setCrea(String crea) {
        this.crea = crea;
    }
}
