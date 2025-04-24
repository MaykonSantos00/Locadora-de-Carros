package util;

import domain.Carro;

public class ValidacaoUtil {

    public static void validarCarro(Carro carro) {
        if (!carro.isDisponivel()) {
            throw new RuntimeException();
        }
    }
}
