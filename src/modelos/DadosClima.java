package modelos;

public class DadosClima {
    private String nomeCidade;
    private String nomePais;
    private double temperaturaCelsius;
    private String descricaoClima;

    public DadosClima(ClimaResponse response){
        this.nomeCidade = response.location().name();
        this.nomePais = response.location().country();
        this.temperaturaCelsius = response.current().temp_c();
        this.descricaoClima = response.current().condition().text();
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public String getNomePais() {
        return nomePais;
    }

    public double getTemperaturaCelsius() {
        return temperaturaCelsius;
    }

    public String getDescricaoClima() {
        return descricaoClima;
    }
}
