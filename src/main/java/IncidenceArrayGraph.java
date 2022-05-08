import org.jetbrains.annotations.NotNull;

import java.awt.Color;
import java.util.Arrays;

public class IncidenceArrayGraph implements Graph {

    private final Vertex[] vertexArray;
    private final Edge[] edgeArray;

    private final Edge[][] incidenceArray;

    private int currentNumberOfVertices;
    private int currentNumberOfEdges;


    /**
     * Constructor.
     *
     * @param n Maximum number of vertices. Must be positive.
     */
    public IncidenceArrayGraph(int n) {
        if (n <= 0) {
            throw new RuntimeException("Number of vertices must be positive. ");
        }
        vertexArray = new Vertex[n];
        edgeArray = new Edge[n * n];
        incidenceArray = new Edge[n][n];

        currentNumberOfVertices = 0;
        currentNumberOfEdges = 0;
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
    public void addEdge(Vertex vertex1, Vertex vertex2, @NotNull EdgeKind edgeKind) {
        if (nbOfEdges() == edgeArray.length) {
            throw new RuntimeException("Maximum number of edges hit. ");
        }

        double value = 3;
        Color color = Color.RED;

        Edge edge;
        switch (edgeKind) {
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
     * @param vertex : Vertex
     * @return The index of the vertex in vertexArray, or -1.
     */
    private int containVertex (Vertex vertex) {
        for (int i = 0; i < nbOfVertices(); i++) {
            if (vertex.getId() == vertexArray[i].getId()) {
                return i;
            }
        }
        return -1;
    }

    /**
     * If the vertex in params isn't in the list vertexArray, add it.
     * @param vertex : Vertex
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

    @Override
    public boolean isConnected(Vertex vertex1, Vertex vertex2) {
        return incidenceArray[containVertex(vertex1)][containVertex(vertex2)] != null;
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
        throw new RuntimeException("Not implemented. ");
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

    @Override
    public String toString() {
        return "IncidenceArrayGraph{" +
                "vertexArray=" + Arrays.toString(vertexArray) +
                ", edgeArray=" + Arrays.toString(edgeArray) +
                ", incidenceArray=" + Arrays.toString(incidenceArray) +
                '}';
    }
}
