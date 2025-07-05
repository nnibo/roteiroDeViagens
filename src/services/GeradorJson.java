package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.Viagem;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorJson {
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public void gerarJson(List<Viagem> listaViagens) {
        try{
            FileWriter fw = new FileWriter("viagens.json");
            fw.write(gson.toJson(listaViagens));
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
