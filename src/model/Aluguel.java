package model;

import java.time.LocalDate;

public class Aluguel {
    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate dataDeEmprestimo;
    private LocalDate dataDeDevolucao;
    private StatusAluguel statusAluguel;

    public Aluguel(Cliente cliente,Veiculo veiculo) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataDeEmprestimo = LocalDate.now();
        this.dataDeDevolucao = dataDeEmprestimo.plusDays(30);
    }

    public StatusAluguel getStatusAluguel() {
        return statusAluguel;
    }

    public void setStatusAluguel(StatusAluguel statusAluguel) {
        this.statusAluguel = statusAluguel;
    }
}
