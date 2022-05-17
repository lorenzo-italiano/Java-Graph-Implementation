package graphImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;

import static org.junit.Assert.*;


public class IncidenceArrayGraphTest {

    private Graph graph;
    private Vertex vertex1;
    private Vertex vertex2;
    private Vertex vertex3;

    @BeforeEach
    void init () {
        graph = new IncidenceArrayGraph(3, EdgeKind.UNDIRECTED);

        vertex1 = new Vertex("Vertex 1. ", Color.BLUE);
        vertex2 = new Vertex("Vertex 2. ", Color.BLUE);
        vertex3 = new Vertex("Vertex 3. ", Color.BLUE);

        graph.addVertex(vertex1);
        graph.addVertex(vertex2);

        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex1, vertex3);   // Should also do : graph.addVertex(vertex3);
    }

    @Test
    public void test_getVertices(){
        Vertex[] graphVertices = graph.getVertices();

        assertEquals(vertex1, graphVertices[0]);
        assertEquals(vertex2, graphVertices[1]);
        assertEquals(vertex3, graphVertices[2]);
    }

    @Test
    public void test_isConnected () {
        assertTrue(! graph.isConnected());
    }

    @Test
    public void test_nbVertices_nbEdges(){
        assertEquals(2, graph.nbOfEdges());
        assertEquals(3, graph.nbOfVertices());
    }
}
