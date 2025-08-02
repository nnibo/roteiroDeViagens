package principal;

import modelos.DadosCep;
import modelos.DadosClima;
import modelos.Destino;
import modelos.Viagem;
import services.ConsultaViaCepAPI;
import services.ConsultaWeatherAPI;
import services.GeradorJson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaWeatherAPI consultaClima = new ConsultaWeatherAPI();
        ConsultaViaCepAPI consultaCep = new ConsultaViaCepAPI();
        GeradorJson geradorJson = new GeradorJson();
        List<Destino> destinos = new ArrayList<>();

        System.out.println("==== Roteiro de Viagem ====");
        System.out.print("Digite o nome da sua viagem: ");
        String nomeViagem = scanner.nextLine();

        try {
            while (true) {
                System.out.print("Digite o cep de algum lugar para visitar (ou digite 'sair' para finalizar): ");
                var cep = scanner.nextLine();

                if (cep.equalsIgnoreCase("sair")) {
                    break;
                }

                DadosCep dadosCep = consultaCep.consultaCep(cep);
                DadosClima dadosClima = consultaClima.consultarClima(dadosCep);

                Destino destino = new Destino(dadosCep, dadosClima);
                System.out.println(destino);

                System.out.println("Voce deseja adicionar esse lugar a sua lista de viagens? (S/N)");
                var opcaoAdicionar = scanner.nextLine();

                if(opcaoAdicionar.equalsIgnoreCase("s")) {
                    destinos.add(destino);
                    System.out.println("✅ Cidade adicionada: " + dadosCep.localidade() + ", " + dadosCep.regiao());

                    Viagem viagem = new Viagem(nomeViagem, destinos);
                    List<Viagem> listaViagens = new ArrayList<>();
                    listaViagens.add(viagem);
                    geradorJson.gerarJson(listaViagens);
                    System.out.println("📁 Viagem salva com sucesso no arquivo 'viagens.json'");
                }
            }

        } catch (Exception e) {
            System.out.println("❌ Ocorreu um erro durante o processo: " + e.getMessage());
        }
    }
}
