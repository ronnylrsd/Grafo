import Projeto.Grafo;

public class main {
    public static void main(String[] args){
        Grafo<String> grafo = new Grafo<String>();
        grafo.adicionarVertice(1, "João");
        grafo.adicionarVertice(2, "Lorenzo");
        grafo.adicionarVertice(3, "Creuza");
        grafo.adicionarVertice(4, "Créber");
        grafo.adicionarVertice(5, "Cráudio");

        grafo.adicionarAresta(1, 2, "João", "Lorenzo");
        grafo.adicionarAresta(2, 3, "Lorenzo", "Créber");
        grafo.adicionarAresta(3, 1, "Créber", "Creuza");
        grafo.adicionarAresta(4, 1, "João", "Creuza");
        grafo.adicionarAresta(5, 2, "Cráudio", "Lorenzo");
        grafo.adicionarAresta(6, 3, "Cráudio", "João");

    grafo.buscaEmLargura();
    }
}
