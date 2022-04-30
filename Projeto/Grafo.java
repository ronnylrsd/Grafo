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

    public void adicionarVertice(int id, T dado){
        Vertice<T> novoVertice = new Vertice<T>(id, dado);
        this.vertices.add(novoVertice);

    }

    public void adicionarAresta(int id, double peso, int idInicio, int idFim){
        Vertice<T> inicio = this.getVertice(idInicio);
        Vertice<T> fim = this.getVertice(idFim);
        Aresta<T> aresta = new Aresta<T>(id, peso, inicio, fim);
        inicio.adicionarAresta(aresta);
        fim.adicionarAresta(aresta);
        this.arestas.add(aresta);
    }
    //toda vez que for adicionar uma aresta
    //procura o vértice na lista de vértice ↓
    Vertice<T> getVertice(int id){
        Vertice<T> vertice = null;
        for(int i = 0; i < this.vertices.size(); i++){
            if(this.vertices.get(i).getId() == id){
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

    public void buscaEmLargura2(String dadoBusca){
        Queue<Vertice<T>> fila = new LinkedList<Vertice<T>>();
        Vertice<T> atual = this.vertices.get(0);
        atual.setCor("Cinza");
        atual.setDistancia(0);
        fila.add(atual);
        while(fila.size() > 0){
            Vertice<T> visitado = fila.peek();
            for(int i = 0; i < visitado.getAresta().size(); i++){
                Vertice<T> proximo = visitado.getAresta().get(i).getFim();
                if(proximo.getCor().equals("Branco")){
                    System.out.println(proximo.getDado());
                    proximo.setCor("Cinza");
                    proximo.setDistancia(visitado.getDistancia() + 1);
                    proximo.setAnterior(visitado);
                    fila.add(proximo);
                }
            }
            visitado.setCor("Preto");
            fila.remove();
        }
    }

    public void listarAdjacentes() {
        for(int i = 0; i < this.vertices.size(); i++){
            System.out.println("------------------");
            System.out.println("Vertice ID: " + this.vertices.get(i).getId());
            System.out.println("Vertice Valor: " + this.vertices.get(i).getDado());
            System.out.println("Arestas Destino: ");
            int contVerInicio = 0;
            for(int j = 0; j < this.vertices.get(i).getAresta().size(); j++){
                if(this.vertices.get(i).getAresta().get(j).getInicio().getId() == this.vertices.get(i).getId()){
                    System.out.println(this.vertices.get(i).getAresta().get(j).getFim().getDado());
                    this.vertices.get(i).adicionarAdjacente(this.vertices.get(i).getAresta().get(j));
                    contVerInicio++;
                }
            }
            if(contVerInicio == 0) {
                System.out.println("Não possui nenhuma.");
            }
        }
    }
}
