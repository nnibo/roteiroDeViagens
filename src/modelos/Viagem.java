package modelos;

import java.util.List;

public class Viagem {
    private String nome;
    private List<Destino> listaDestinos;

    public Viagem(String nome, List<Destino> listaDestinos) {
        this.nome = nome;
        this.listaDestinos = listaDestinos;
    }

    public String getNome() {
        return nome;
    }

    public List<Destino> getListaDestinos() {
        return listaDestinos;
    }
}
