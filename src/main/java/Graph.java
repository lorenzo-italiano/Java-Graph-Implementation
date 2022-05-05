package main.java;

/**
 * a Graph interface containing the necessary methods to be used for solving a graph problem
 */
public interface Graph {

    /**Params
     * @return the number of vertices (int)
     */
    int nbOfVertices();

    /**Params
     * @return the number of edges
     */
    int nbOfEdges();

    /**Params
     * Adds a vertex to the graph
     * @param vertex (Vertex): the vertex to add
     */
    void addVertex(Vertex vertex);

    /**Params
     * Creates a new edge linking two vertices
     * @param vertex1 (Vertex): first vertex to be linked
     * @param vertex2 (Vertex): second vertex to be linked
     * @param edge (Edge): Edge linking first and second vertices (directed or undirected)
     */
    void addEdge(Vertex vertex1,Vertex vertex2,Edge edge);

    /**Params
     * Tells if the two vertices are connected by an Edge
     * @param vertex1 (Vertex): vertex n°1
     * @param vertex2 (Vertex): vertex n°2
     * @return true if they are linked, false if not
     */
    boolean isConnected(Vertex vertex1, Vertex vertex2);

    /**Params
     * says whether all vertices are interconnected
     * @return true if all vertices are connected, false if not
     */
    boolean isConnected();

    /**Params
     * give edge(s) connecting these vertices
     * @param vertex1 (Vertex): vertex n°1
     * @param vertex2 (Vertex): vertex n°2
     * @return an Edge array of all edge(s) connecting vertex1 and vertex2
     */
    Edge[] getEdges(Vertex vertex1, Vertex vertex2);

    /**Params
     * @return all edges of the graph
     */
    Edge[] getEdges();

    /**Params
     * @return all vertices of the graph
     */
    Vertex[] getVertices();

    /**Params
     * @param vertex (Vertex)
     * @return array of edge(s) connected to this vertex
     */
    Edge[] getNeighborEdges(Vertex vertex);

    /**Params
     * To string
     * @return Stringified object of Graph instance
     */
    String toString();
}
