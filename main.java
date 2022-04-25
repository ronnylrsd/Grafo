import java.io.FileNotFoundException;
import java.io.IOException;

import Projeto.Arquivo;
import Projeto.Grafo;

public class main {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Grafo<String> grafo = new Grafo<String>();
        Arquivo arquivo = new Arquivo();
        
        // Lendo os vertices
        arquivo.lerVertices(grafo);
        // Lendo as arestas
        arquivo.lerArestas(grafo);

        System.out.println("=====================");
        // Lista de adjarcencia
        System.out.println("Lista de Adjacentes");
        grafo.listarAdjacentes();

        System.out.println("=====================");
        // Imprimindo o grafo
        System.out.println("Busca em Largura:");
        grafo.buscaEmLargura();
    }
}
