package service;

import model.*;
import util.VerificaValidadeCnhException;

import java.util.ArrayList;
import java.util.List;

import static util.TratadorDeError.tratadorDeError;

public class LocadoraService {
    private List<Veiculo> veiculos;
    private List<Cliente> clientes;
    private FormaDePagamento formaDePagamento;

    public LocadoraService() {
        veiculos = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public void realizarAluguel(String placa, String cpf) {
        try {
            Cliente cliente = buscarClientePorCpf(cpf);
            Validador.verificaCNH(cliente);
            Validador.verificaIdade(cliente);
            Veiculo veiculo = buscarVeiculoPorPlaca(placa);
            Validador.VeiculoDisponivel(veiculo);
            Aluguel aluguel = new Aluguel(cliente, veiculo);
            aluguel.setStatusAluguel(StatusAluguel.ALUGADO);
            veiculo.setDisponivel(false);
            cliente.adicionarAluguel(aluguel);
            System.out.println(veiculo.getModelo() + "alugado com sucesso, por " + cliente.getNome());

        } catch (Exception e) {
            tratadorDeError(e.getMessage());
        }
    }

    public void realizarDevolucao(String placa, String cpf) {
        try {
            Cliente cliente = buscarClientePorCpf(cpf);
            Veiculo veiculo = buscarVeiculoPorPlaca(placa);
            if (!veiculo.isDisponivel()) {
                veiculo.setDisponivel(true);
                System.out.println("Veiculo devolvido com sucesso com sucesso");
                return;
            } else {
                throw new Exception("Este veiculo nao foi alugado por voce");
            }
        }catch (Exception e){
            tratadorDeError(e.getMessage());
        }
    }

    public void cadastroCliente(Cliente cliente, FormaDePagamento formaDePagamento) {
        clientes.add(cliente);
        this.formaDePagamento = formaDePagamento;
    }

    public void cadastroVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    private Veiculo buscarVeiculoPorPlaca(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    private Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }
}
