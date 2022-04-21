package Projeto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Grafo<T> {
    private ArrayList<Vertice<T>> vertices;
    private ArrayList<Aresta<T>> arestas;

    public Grafo(){
        this.vertices = new ArrayList<Vertice<T>>();
        this.arestas = new ArrayList<Aresta<T>>();
    }

    public void adicionarVertice(T dado){
        Vertice<T> novoVertice = new Vertice<T>(dado);
        this.vertices.add(novoVertice);

    }

    public void adicionarAresta(int peso, T dadoInicio, T dadoFim){
        Vertice<T> inicio = this.getVertice(dadoInicio);
        Vertice<T> fim = this.getVertice(dadoFim);
        Aresta<T> aresta = new Aresta<T>(peso, inicio, fim);
        inicio.adicionarAresta(aresta);
        fim.adicionarAresta(aresta);
        this.arestas.add(aresta);
    }
    //toda vez que for adicionar uma aresta
    //procura o vértice na lista de vértice ↓
    private Vertice<T> getVertice(T dado){
        Vertice<T> vertice = null;
        for(int i = 0; i < this.vertices.size(); i++){
            if(this.vertices.get(i).getDado().equals(dado)){
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }

    public void buscaEmLargura(){
        ArrayList<Vertice<T>> marcados = new ArrayList<Vertice<T>>();
        Queue<Vertice<T>> fila = new LinkedList<Vertice<T>>();
        Vertice<T> atual = this.vertices.get(0);
        marcados.add(atual);
        System.out.println(atual.getDado());
        fila.add(atual);
        while(fila.size() > 0){
            Vertice<T> visitado = fila.peek();
            for(int i = 0; i < visitado.getAresta().size(); i++){
                Vertice<T> proximo = visitado.getAresta().get(i).getFim();
                if(!marcados.contains(proximo)){//se o próximo ainda não foi marcado
                    marcados.add(proximo);
                    System.out.println(proximo.getDado());
                    fila.add(proximo);
                }
            }
            fila.remove();
        }
    }
}
