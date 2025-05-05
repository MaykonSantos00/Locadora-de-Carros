package domain;

public class Carro {
    private String modelo;
    private String marca;
    private String placa;
    private String cor;
    private boolean disponivel = true;
    private TipoCarro tipoCarro;

    public Carro(String modelo, String marca, String placa, String cor, TipoCarro tipoCarro) {
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.cor = cor;
        this.tipoCarro = tipoCarro;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", placa='" + placa + '\'' +
                ", cor='" + cor + '\'' +
                ", disponivel=" + disponivel +
                ", tipoCarro=" + tipoCarro +
                '}';
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
