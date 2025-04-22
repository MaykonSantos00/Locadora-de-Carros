package model;

public class Veiculo {
    private String modelo;
    private String marca;
    private String cor;
    private TipoVeiculo tipo;
    private String placa;
    private boolean disponivel = true;


    public Veiculo(String modelo, String marca, String cor,String placa ,TipoVeiculo tipo) {
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.tipo = tipo;
        this.placa = placa;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }
}
