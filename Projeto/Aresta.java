package Projeto;

public class Aresta<T>{
    private int id;
    private int peso;
    private Vertice<T> inicio;
    private Vertice<T> fim;

    public Aresta(int id, int peso, Vertice<T> inicio, Vertice<T> fim){
        this.id = id;
        this.peso = peso;
        this.inicio = inicio;
        this.fim = fim;
    }

    public int getPeso(){
        return peso;
    }

    public void setPeso(int peso){
        this.peso = peso;
    }

    public Vertice<T> getInicio(){
        return inicio;
    }

    public void setInicio(Vertice<T> inicio){
        this.inicio = inicio;
    }

    public Vertice<T> getFim(){
        return fim;
    }

    public void setFim(Vertice<T> fim){
        this.fim = fim;
    }
}