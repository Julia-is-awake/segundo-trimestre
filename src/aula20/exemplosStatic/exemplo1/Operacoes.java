package aula20.exemplosStatic.exemplo1;

public class Operacoes {
    static int soma(int n1, int n2) {
        return n1 + n2;
    }

    static float potencia(float base, float expoente) {
        float mult = base;
        for (int i = 0; i < expoente; i++) {
            mult *= base;
        }
        return mult;
    }
}
