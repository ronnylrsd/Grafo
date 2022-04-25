package Projeto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Arquivo {

    public Grafo<String> lerVertices(Grafo<String> grafo) throws FileNotFoundException, IOException {
        int id;
        String nome;
        String arquivo = "C:\\Users\\djalm\\Documents\\GitKraken\\Grafo\\Entrada\\vertices.txt";
        BufferedReader buffer = new BufferedReader(new FileReader(arquivo));
        for (int i = 0; i < 100; i++) {
            String linha = buffer.readLine();
            if (linha == null) {
                return grafo;
            }
            String info[] = new String[100];
            info = linha.split(",");
            id = Integer.parseInt(info[0]);
            nome = info[1];

            grafo.adicionarVertice(id, nome);
        }

        return grafo;
    }

    public Grafo<String> lerArestas(Grafo<String> grafo) throws FileNotFoundException, IOException {
        int id, origem, destino;
        double peso;
        String arquivo = "C:\\Users\\djalm\\Documents\\GitKraken\\Grafo\\Entrada\\arestas.txt";
        BufferedReader buffer = new BufferedReader(new FileReader(arquivo));
        for (int i = 0; i < 100; i++) {
            String linha = buffer.readLine();
            if (linha == null) {
                return grafo;
            }

            String info[] = new String[100];
            info = linha.split(",");
            id = Integer.parseInt(info[0]);
            origem = Integer.parseInt(info[1]);
            destino = Integer.parseInt(info[2]);
            peso = Double.parseDouble(info[3]);

            grafo.adicionarAresta(id, peso, origem, destino);
        }

        return grafo;
    }
}
