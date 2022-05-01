package Projeto;

import java.util.ArrayList;

public class Vertice<T> {
    private int id;
    private T dado;
    private ArrayList<Aresta<T>> arestas;
    private ArrayList<Aresta<T>> adjacentes;

    private Vertice<T> anterior;
    private String cor;
    private int distancia;
    private double peso;

    public Vertice(int id, T valor){
        this.id = id;
        this.dado = valor;
        this.arestas = new ArrayList<Aresta<T>>();
        this.adjacentes = new ArrayList<Aresta<T>>();

        this.anterior = null;
        this.cor = "Branco";
        this.distancia = Integer.MAX_VALUE;
        this.peso = Integer.MAX_VALUE;
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

    public void adicionarAdjacente(Aresta<T> aresta){
        this.adjacentes.add(aresta);
    }

    public ArrayList<Aresta<T>> getAdjacentes(){
        return adjacentes;
    }

    public void setDado(ArrayList<Aresta<T>> arestas){
        this.arestas = arestas;
    }

    public Vertice<T> getAnterior() {
        return this.anterior;
    }

    public void setAnterior(Vertice<T> anterior) {
        this.anterior = anterior;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getDistancia() {
        return this.distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
