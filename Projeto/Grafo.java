package Projeto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Grafo<T> {
    private ArrayList<Vertice<T>> vertices;
    private ArrayList<Aresta<T>> arestas;

    public Grafo() {
        this.vertices = new ArrayList<Vertice<T>>();
        this.arestas = new ArrayList<Aresta<T>>();
    }

    public void adicionarVertice(int id, T dado) {
        Vertice<T> novoVertice = new Vertice<T>(id, dado);
        this.vertices.add(novoVertice);

    }

    public void adicionarAresta(int id, double peso, int idInicio, int idFim) {
        Vertice<T> inicio = this.getVertice(idInicio);
        Vertice<T> fim = this.getVertice(idFim);
        Aresta<T> aresta = new Aresta<T>(id, peso, inicio, fim);
        inicio.adicionarAresta(aresta);
        fim.adicionarAresta(aresta);
        this.arestas.add(aresta);
    }

    // toda vez que for adicionar uma aresta
    // procura o vértice na lista de vértice ↓
    Vertice<T> getVertice(int id) {
        Vertice<T> vertice = null;
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).getId() == id) {
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }

    public void listarAdjacentes() {
        for (int i = 0; i < this.vertices.size(); i++) {
            System.out.println("------------------");
            System.out.println("Vertice ID: " + this.vertices.get(i).getId());
            System.out.println("Vertice Valor: " + this.vertices.get(i).getDado());
            System.out.println("Arestas Destino: ");
            int contVerInicio = 0;
            for (int j = 0; j < this.vertices.get(i).getAresta().size(); j++) {
                if (this.vertices.get(i).getAresta().get(j).getInicio().getId() == this.vertices.get(i).getId()) {
                    System.out.println(this.vertices.get(i).getAresta().get(j).getFim().getDado());
                    this.vertices.get(i).adicionarAdjacente(this.vertices.get(i).getAresta().get(j));
                    contVerInicio++;
                }
            }
            if (contVerInicio == 0) {
                System.out.println("Não possui nenhuma.");
            }
        }
    }

    public void buscaEmLargura(String dadoBusca) {
        Queue<Vertice<T>> fila = new LinkedList<Vertice<T>>();
        Vertice<T> atual = this.vertices.get(0);
        atual.setCor("Cinza");
        atual.setDistancia(0);
        fila.add(atual);
        while (fila.size() > 0) {
            Vertice<T> visitado = fila.peek();
            for (int i = 0; i < visitado.getAresta().size(); i++) {
                Vertice<T> proximo = visitado.getAresta().get(i).getFim();
                if (proximo.getCor().equals("Branco")) {
                    proximo.setCor("Cinza");
                    proximo.setDistancia(visitado.getDistancia() + 1);
                    proximo.setAnterior(visitado);
                    fila.add(proximo);
                    if (proximo.getDado().equals(dadoBusca)) { // se achar o vertice
                        System.out.println("Caminho encontrado.");
                        Stack<Vertice<T>> caminho = new Stack<Vertice<T>>();
                        caminho.push(proximo);
                        while (proximo.getAnterior() != null) { // faz o caminho inverso salvando o caminho
                            caminho.push(proximo.getAnterior());
                            proximo = proximo.getAnterior();
                        }
                        System.out.println("Faça esse caminho:");
                        while (caminho.size() > 0) { // imprime o caminho na ordem correta
                            System.out.println(caminho.pop().getDado());
                        }
                        return;
                    }
                }
            }
            visitado.setCor("Preto");
            fila.remove();
        }
        System.out.println("Caminho não encontrado.");
    }

    public void buscaComDijkstra(String dadoBusca) {
        ArrayList<Vertice<T>> verticesAtuais = this.vertices;
        Vertice<T> atual = verticesAtuais.get(0);
        Vertice<T> achou = null;
        atual.setPeso(0);
        while (verticesAtuais.size() > 0) {
            int index = buscaPesoMin(verticesAtuais);
            Vertice<T> visitado = verticesAtuais.get(index);
            verticesAtuais.remove(index);
            if (visitado.getDado().equals(dadoBusca)) {
                achou = visitado;
            }
            for (int i = 0; i < visitado.getAresta().size(); i++) {
                Vertice<T> proximo = visitado.getAresta().get(i).getFim();
                double peso = visitado.getPeso() + visitado.getAresta().get(i).getPeso();
                if (peso < proximo.getPeso()) {
                    proximo.setPeso(peso);
                    proximo.setAnterior(visitado);
                }
            }
        }

        if (achou != null) {
            System.out.println("Caminho encontrado.");
            Stack<Vertice<T>> caminho = new Stack<Vertice<T>>();
            caminho.push(achou);
            while (achou.getAnterior() != null) { // faz o caminho inverso salvando o caminho
                caminho.push(achou.getAnterior());
                achou = achou.getAnterior();
            }
            System.out.println("Faça esse caminho:");
            while (caminho.size() > 0) { // imprime o caminho na ordem correta
                System.out.println(caminho.pop().getDado());
            }
        } else {
            System.out.println("Caminho não encontrado.");
        }
    }

    public int buscaPesoMin(ArrayList<Vertice<T>> verticeAtual) {
        int index = 0;
        double pesoMin = Double.MAX_VALUE;
        for (int i = 0; i < verticeAtual.size(); i++) {
            if (verticeAtual.get(i).getPeso() < pesoMin) {
                pesoMin = verticeAtual.get(i).getPeso();
                index = i;
            }
        }
        return index;
    }
}
