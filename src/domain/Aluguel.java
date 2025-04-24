package domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Aluguel {
    private Carro carro;
    private Cliente cliente;
    private LocalDate dataAluguel;
    private LocalTime dataDevolucao;

    public Aluguel(Carro carro, Cliente cliente) {
        this.carro = carro;
        this.cliente = cliente;
        this.dataAluguel = LocalDate.now();
        this.dataDevolucao = null;
    }

    public void devolucao(){
        this.dataDevolucao = LocalTime.now();
        this.dataAluguel = null;
    }
}
