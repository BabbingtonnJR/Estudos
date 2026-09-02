public class Prato {
    private String nome;
    private double preco;
    private int tempoPreparo; // em minutos

    public Prato(String nome, double preco, int tempoPreparo) {
        this.nome = nome;
        this.preco = preco;
        this.tempoPreparo = tempoPreparo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    @Override
    public String toString() {
        return String.format("%-25s | R$ %6.2f | %2d min", nome, preco, tempoPreparo);
    }
}