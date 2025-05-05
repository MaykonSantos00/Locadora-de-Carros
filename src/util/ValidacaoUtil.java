package util;

import domain.Carro;
import domain.Cliente;
import exception.CarroIndisponivelException;
import exception.ClienteNuloException;

public class ValidacaoUtil {

    public static void validarCarro(Carro carro) throws CarroIndisponivelException {
        if (!carro.isDisponivel()) {
            throw new CarroIndisponivelException();
        }
    }

    public static void validarCliente(Cliente cliente) throws ClienteNuloException {
        if (cliente == null){
            throw new ClienteNuloException();
        }
    }
}
