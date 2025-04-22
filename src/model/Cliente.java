package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private int idade;
    private boolean cnhValida;
    private List<Aluguel> alugueis = new ArrayList<>();

    public Cliente(String nome, String cpf, int idade, boolean cnhValida) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.cnhValida = cnhValida;
    }

    public void adicionarAluguel(Aluguel aluguel) {
        alugueis.add(aluguel);
    }

    public void removerAluguel(Aluguel aluguel) {
        alugueis.remove(aluguel);
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public boolean isCnhValida() {
        return cnhValida;
    }

    public int getIdade() {
        return idade;
    }
}

