package modelos;

public class Destino {
    private DadosClima dadosClima;

    public Destino(DadosClima dadosClima) {
        this.dadosClima = dadosClima;
    }

    public DadosClima getDadosClima() {
        return dadosClima;
    }

    @Override
    public String toString() {
        return "Destino{" +
                "Pais: " + dadosClima.getNomePais() +
                "Cidade: " + dadosClima.getNomeCidade() +
                "Temperatura: " + dadosClima.getTemperaturaCelsius() + "Descrição: " + dadosClima.getDescricaoClima();
    }
}
