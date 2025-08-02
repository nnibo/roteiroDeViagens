package modelos;

public class Destino {
    private DadosCep dadosCep;
    private DadosClima dadosClima;


    public Destino(DadosCep dadosCep, DadosClima dadosClima) {
        this.dadosCep = dadosCep;
        this.dadosClima = dadosClima;
    }

    @Override
    public String toString() {
        return """
            🌍 Informações do Destino:
            ─────────────────────────────
            📍 Estado     : %s
            🏙️  Cidade     : %s
            🏘️  Bairro     : %s
            🌎 Região     : %s

            ☁️  Clima Atual:
            🌡️  Temperatura: %.1f°C
            📖 Descrição  : %s
            """.formatted(
                dadosCep.estado(),
                dadosCep.localidade(),
                dadosCep.bairro(),
                dadosCep.regiao(),
                dadosClima.getTemperaturaCelsius(),
                dadosClima.getDescricaoClima()
        );
    }
}
