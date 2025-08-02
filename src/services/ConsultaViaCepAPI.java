package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.DadosCep;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaViaCepAPI {
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public DadosCep consultaCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            return gson.fromJson(json, DadosCep.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
