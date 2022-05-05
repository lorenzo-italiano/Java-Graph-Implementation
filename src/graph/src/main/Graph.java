package graph.src.main;

public interface Graph {

    /**
     * a Graph interface containing the necessary methods to be used for solving a graph problem
     */

    int nbOfVertices();

    int nbOfEdges();

    void addVertex(Vertex vertex);

    // Directed or undirected
    void addEdge(Vertex vertex1,Vertex vertex2,Edge edge);

    // whether there is a path between the
    boolean isConnected(Vertex vertex1, Vertex vertex2);

    // says whether all vertices are interconnected
    boolean isConnected();

    // give edge(s) connecting these vertices
    Edge[] getEdges(Vertex vertex1, Vertex vertex2);

    // give all edges of the graph
    Edge[] getEdges();

    // give all vertices of the graph
    Vertex[] getVertices();

    // give edges connected to this vertex
    Edge[] getNeighborEdges(Vertex vertex);

    String toString();
}
