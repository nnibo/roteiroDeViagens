package modelos;

public class DadosClima {
    private double temperaturaCelsius;
    private String descricaoClima;

    public DadosClima(ClimaResponse response){
        this.temperaturaCelsius = response.current().temp_c();
        this.descricaoClima = response.current().condition().text();
    }


    public double getTemperaturaCelsius() {
        return temperaturaCelsius;
    }

    public String getDescricaoClima() {
        return descricaoClima;
    }

    
}
