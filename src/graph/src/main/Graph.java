package graph.src.main;

public interface Graph {

    /**
     * a Graph abstract class or interface (choose the best one!) containing the necessary
     * methods to be used for solving a graph problem such as
     * ◦ nbOfVertices():int
     * ◦ nbOfEdges():int
     * ◦ addVertex(Vertex)
     * ◦ addEdge(Vertex,Vertex,EdgeKind) // EdgeKind: ‘directed’ or ‘undirected’
     * ◦ isConnected(Vertex,Vertex):boolean // whether there is a path between the
     * two vertices (without accounting for the edge directions)
     * ◦ isConnected(): boolean // says whether all vertices are interconnected
     * ◦ getEdges(Vertex, Vertex): Edge[] // give edge(s) connecting these vertices
     * ◦ getEdges(): Edge [] // give all edges of the graph
     * ◦ getVertices(): Vertex [] // give all vertices of the graph
     * ◦ getNeighborEdges(Vertex): Edge [] // give edges connected to this vertex
     */
}
