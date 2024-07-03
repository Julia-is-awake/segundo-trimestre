package aula21.exemploHeranca;

public class Principal {
    public static void main(String[] args) {
        Motorista m1 = new Motorista("Jonas", "Silva");
        m1.setNome("Jonas");
        m1.setSobrenome("Silva");
        m1.setSalario(1000);

        m1.setCnh("457578");

        Engenheiro e1 = new Engenheiro("Josefina", "Souza");
        e1.setCrea("12345");
    }
}
