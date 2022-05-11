package graphImpl;

import org.jetbrains.annotations.NotNull;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class IncidenceArrayGraph implements Graph {

    private final Vertex[] vertexArray;
    private final Edge[] edgeArray;

    private final Edge[][] incidenceArray;

    private int currentNumberOfVertices;
    private int currentNumberOfEdges;

    private final EdgeKind edgeKind;


    /**
     * Constructor.
     *
     * @param n Maximum number of vertices. Must be positive.
     */
    public IncidenceArrayGraph(int n, EdgeKind edgeKind) {
        if (n <= 0) {
            throw new RuntimeException("Number of vertices must be positive. ");
        }
        vertexArray = new Vertex[n];
        edgeArray = new Edge[n * n];
        incidenceArray = new Edge[n][n];

        currentNumberOfVertices = 0;
        currentNumberOfEdges = 0;
        this.edgeKind = edgeKind;
    }

    @Override
    public int nbOfVertices() {
        return currentNumberOfVertices;
    }

    @Override
    public int nbOfEdges() {
        return currentNumberOfEdges;
    }

    @Override
    public void addVertex(Vertex vertex) {
        if (currentNumberOfVertices == vertexArray.length) {
            throw new RuntimeException("The graph has already the maximum number of vertices. ");
        }

        vertexArray[nbOfVertices()] = vertex;
        currentNumberOfVertices++;
    }

    @Override
    public void addEdge(Vertex vertex1, Vertex vertex2) {
        if (nbOfEdges() == edgeArray.length) {
            throw new RuntimeException("Maximum number of edges hit. ");
        }

        double value = 3;
        Color color = Color.RED;

        Edge edge;
        switch (this.edgeKind) {
            case DIRECTED -> {
                int source = 0;
                edge = new DirectedEdge(color, value, source, new Vertex[]{vertex1, vertex2});
            }
            case UNDIRECTED -> edge = new UndirectedEdge(color, value, new Vertex[]{vertex1, vertex2});
            default -> throw new IllegalStateException("Unexpected value: " + edgeKind);
        }
        edgeArray[nbOfEdges()] = edge;


        int indexVertex1 = findOrAddVertex(vertex1);
        int indexVertex2 = findOrAddVertex(vertex2);

        incidenceArray[indexVertex1][indexVertex2] = edge;
        incidenceArray[indexVertex2][indexVertex1] = edge;


        currentNumberOfEdges++;
    }

    /**
     * @param vertex : graphImpl.Vertex
     * @return The index of the vertex in vertexArray, or -1.
     */
    public int containVertex (Vertex vertex) {
        for (int i = 0; i < nbOfVertices(); i++) {
            if (vertex.getId() == vertexArray[i].getId()) {
                return i;
            }
        }
        return -1;
    }

    /**
     * If the vertex in params isn't in the list vertexArray, add it.
     * @param vertex : graphImpl.Vertex
     * @return The index of the vertex in vertexArray
     */
    private int findOrAddVertex (Vertex vertex) {
        int indexVertex = containVertex(vertex);
        if (indexVertex < 0) {
            indexVertex = nbOfVertices();
            addVertex(vertex);
        }

        return indexVertex;
    }

    public boolean searchConnection(int idVertex1, int idVertex2, ArrayList<Integer> seen){
        if(incidenceArray[idVertex1][idVertex2]!=null){
            return true;
        }
        else{
            for (int i = 0; i < currentNumberOfVertices; i++) {
                if(incidenceArray[idVertex1][i]!=null){
                    if(!seen.contains(i)){
                        seen.add(i);
                        if(searchConnection(i,idVertex2, seen)){
                            return true;
                        }
                    }

                }
            }
            return false;
        }
    }

    @Override
    public boolean isConnected(Vertex vertex1, Vertex vertex2) {
        if(incidenceArray[containVertex(vertex1)][containVertex(vertex2)] != null){
            return true;
        }
        else{
            int indexVertex1 = containVertex(vertex1);
            int indexVertex2 = containVertex(vertex2);
            return searchConnection(indexVertex1,indexVertex2, new ArrayList<>());
        }
    }

    @Override
    public boolean isConnected() {
        for (int i = 0; i < nbOfVertices(); i++) {
            for (int j = i + 1; j < nbOfVertices(); j++) {
                if (incidenceArray[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public Edge[] getEdges(Vertex vertex1, Vertex vertex2) {
        int indexVertex1 = containVertex(vertex1);
        int indexVertex2 = containVertex(vertex2);

        if (indexVertex1 == -1 && indexVertex2 == -1) {
            return null;
        }
        else {
            Edge[] edges = new Edge[2];

            edges[0] = incidenceArray[indexVertex1][indexVertex2];
            edges[1] = incidenceArray[indexVertex2][indexVertex1];

            if (edges[0] == null && edges[1] == null) {
                return null;
            }

            return edges;
        }
    }

    @Override
    public Edge[] getEdges() {
        return edgeArray;
    }

    @Override
    public Vertex[] getVertices() {
        return vertexArray;
    }

    @Override
    public Edge[] getNeighborEdges(Vertex vertex) {
        Edge[] edges = new Edge[edgeArray.length];

        int vertexIndex = containVertex(vertex);
        if (vertexIndex < 0) {
            return edges;
        }

        int currentEdgeIndex = 0;
        for (int i = 0; i < nbOfVertices(); i++) {
            if (incidenceArray[vertexIndex][i] != null) {
                edges[currentEdgeIndex] = incidenceArray[vertexIndex][i];
                currentEdgeIndex++;
            }
        }
        return edges;
    }

    public EdgeKind getEdgeKind() {
        return edgeKind;
    }

    public Edge[][] getIncidenceArray() {
        return incidenceArray;
    }

    @Override
    public String toString() {
        return "graphImpl.IncidenceArrayGraph{" +
                "vertexArray=" + Arrays.toString(vertexArray) + "\n" +
                ", edgeArray=" + Arrays.toString(edgeArray) +
                '}';
    }
}
