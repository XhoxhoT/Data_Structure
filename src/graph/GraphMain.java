package graph;

public class GraphMain {

    public static void main(String[] args){

        Graph myGraph = new Graph();
        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.printGraph();

        myGraph.addEdge("A", "B");
        myGraph.printGraph();

        myGraph.removeEdge("A", "B");
        myGraph.printGraph();
    }
}
