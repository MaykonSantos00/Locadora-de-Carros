package service;

import model.Cliente;
import model.Veiculo;
import util.VeiculoIndisponivelException;
import util.VerificaIdadeException;
import util.VerificaValidadeCnhException;

public class Validador {

    public static void VeiculoDisponivel(Veiculo veiculo) throws VeiculoIndisponivelException {
        if (!veiculo.isDisponivel()) {
            throw new VeiculoIndisponivelException("Veiculo Indisponivel");
        }
    }

    public static void verificaCNH(Cliente cliente) throws VerificaValidadeCnhException {
        if(!cliente.isCnhValida()){
            throw new VerificaValidadeCnhException("Sua CNH esta invalida " + cliente.getNome());
        }
    }

    public static void verificaIdade(Cliente cliente) throws VerificaIdadeException {
        if (cliente.getIdade() <= 17 || cliente.getIdade() >= 100) {
            throw new VerificaIdadeException("Sua idade esta invalida " + cliente.getNome());
        };
    }
}
