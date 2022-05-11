package graphImpl;

import org.jetbrains.annotations.NotNull;

/**
 * a graphImpl.Graph interface containing the necessary methods to be used for solving a graph problem
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
     * @param vertex (graphImpl.Vertex): the vertex to add
     */
    void addVertex(Vertex vertex);

    /**Params
     * Creates a new edge linking two vertices
     * @param vertex1 (graphImpl.Vertex): first vertex to be linked
     * @param vertex2 (graphImpl.Vertex): second vertex to be linked
     * @param edgeKind (graphImpl.EdgeKind): graphImpl.Edge directed or undirected
     */
    void addEdge(Vertex vertex1, Vertex vertex2);

    /**Params
     * Tells if the two vertices are connected by an graphImpl.Edge
     * @param vertex1 (graphImpl.Vertex): vertex n°1
     * @param vertex2 (graphImpl.Vertex): vertex n°2
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
     * @param vertex1 (graphImpl.Vertex): vertex n°1
     * @param vertex2 (graphImpl.Vertex): vertex n°2
     * @return an graphImpl.Edge array of all edge(s) connecting vertex1 and vertex2
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
     * @param vertex (graphImpl.Vertex)
     * @return array of edge(s) connected to this vertex
     */
    Edge[] getNeighborEdges(Vertex vertex);

    /**Params
     * To string
     * @return Stringified object of graphImpl.Graph instance
     */
    String toString();
}
