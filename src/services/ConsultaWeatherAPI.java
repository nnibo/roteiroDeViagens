package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.ClimaResponse;
import modelos.DadosClima;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaWeatherAPI {
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public DadosClima consultarClima(String cidade){
        String apiKey = "036642e634d84d4da7b34931250507";
        String url = "https://api.weatherapi.com/v1/current.json?key="+apiKey+"&q="+cidade.replace(" ", "%20")+"&lang=pt";
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ClimaResponse climaResponse = gson.fromJson(response.body(), ClimaResponse.class);
            DadosClima dadosClima = new DadosClima(climaResponse);
            return dadosClima;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
