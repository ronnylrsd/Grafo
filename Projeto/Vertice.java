package Projeto;

import java.util.ArrayList;

public class Vertice<T> {
    private int id;
    private T dado;
    private ArrayList<Aresta<T>> arestas;

    public Vertice(int id, T valor){
        this.id = id;
        this.dado = valor;
        this.arestas = new ArrayList<Aresta<T>>();
    }

    public int getId(){
        return id;
    }

    public T getDado(){
        return dado;
    }

    public void setDado(T dado){
        this.dado = dado;
    }

    public void adicionarAresta(Aresta<T> aresta){
        this.arestas.add(aresta);
    }

    public ArrayList<Aresta<T>> getAresta(){
        return arestas;
    }

    public void setDado(ArrayList<Aresta<T>> arestas){
        this.arestas = arestas;
    }
}
