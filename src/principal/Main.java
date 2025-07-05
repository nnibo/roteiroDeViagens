package principal;

import modelos.DadosClima;
import modelos.Destino;
import modelos.Viagem;
import services.ConsultaWeatherAPI;
import services.GeradorJson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaWeatherAPI consultaClima = new ConsultaWeatherAPI();
        GeradorJson geradorJson = new GeradorJson();
        List<Destino> destinos = new ArrayList<>();

        System.out.println("==== Roteiro de Viagem ====");
        System.out.print("Digite o nome da sua viagem: ");
        String nomeViagem = scanner.nextLine();

        try {
            while (true) {
                System.out.print("Digite o nome de uma cidade para visitar (ou digite 'sair' para finalizar): ");
                String cidade = scanner.nextLine();

                if (cidade.equalsIgnoreCase("sair")) {
                    break;
                }

                DadosClima dados = consultaClima.consultarClima(cidade);
                Destino destino = new Destino(dados);
                destinos.add(destino);
                System.out.println("✅ Cidade adicionada: " + dados.getNomeCidade() + ", " + dados.getNomePais());
            }

            Viagem viagem = new Viagem(nomeViagem, destinos);
            List<Viagem> listaViagens = new ArrayList<>();
            listaViagens.add(viagem);
            geradorJson.gerarJson(listaViagens);
            System.out.println("📁 Viagem salva com sucesso no arquivo 'viagens.json'");
        } catch (Exception e) {
            System.out.println("❌ Ocorreu um erro durante o processo: " + e.getMessage());
        }
    }
}
