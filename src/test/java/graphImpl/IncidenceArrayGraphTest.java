package graphImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class IncidenceArrayGraphTest {

    private IncidenceArrayGraph graph;
    private Vertex vertex1;
    private Vertex vertex2;
    private Vertex vertex3;

//       +-----------------------------------------------+
//       |               Initialisation                  |
//       +-----------------------------------------------+
    /**
     *
     * @throws GraphException
     */
    @BeforeEach
    void init () throws GraphException {
        graph = new IncidenceArrayGraph(3, EdgeKind.UNDIRECTED);

        vertex1 = new Vertex("Vertex 1. ", Color.BLUE);
        vertex2 = new Vertex("Vertex 2. ", Color.BLUE);
        vertex3 = new Vertex("Vertex 3. ", Color.BLUE);

        graph.addVertex(vertex1);
        graph.addVertex(vertex2);

        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex1, vertex3);   // Should also do : graph.addVertex(vertex3);
    }

//       +-----------------------------------------------+
//       |               Test constructor                |
//       +-----------------------------------------------+

    /**
     * Test if the constructor throws an exception when parameter n is negative
     */
    @Test
    public void testConstructorThrowsExceptionWhenNumberOfVerticesIsNegative() {
        Exception exception = assertThrows(GraphException.class, () -> {
            Graph graph = new IncidenceArrayGraph(-1,EdgeKind.UNDIRECTED);
        });
    }

    /**
     * Test if the constructor throws an exception when parameter n is null
     */
    @Test
    public void testConstructorThrowsExceptionWhenNumberOfVerticesIsNull() {
        Exception exception = assertThrows(GraphException.class, () -> {
            Graph graph = new IncidenceArrayGraph(0,EdgeKind.UNDIRECTED);
        });
    }

//       +-----------------------------------------------+
//       |               Test getVertices()              |
//       +-----------------------------------------------+

    @Test
    public void test_getVertices(){
        Vertex[] graphVertices = graph.getVertices();

        assertEquals(vertex1, graphVertices[0]);
        assertEquals(vertex2, graphVertices[1]);
        assertEquals(vertex3, graphVertices[2]);
    }

//       +-----------------------------------------------+
//       |               Test isConnected()              |
//       +-----------------------------------------------+

    @Test
    public void test_isConnected() throws GraphException {
        assertFalse(graph.isConnected());

        // then we link the vertices that were not linked to test if the function works when the graph is connected
        graph.addEdge(vertex2, vertex3);

        assertTrue(graph.isConnected());
    }

    @Test
    public void testIsConnectedWithParameters() throws GraphException {
        assertTrue(graph.isConnected(vertex1,vertex2));
        assertTrue(graph.isConnected(vertex2,vertex1));

        // it should also work when the vertices are not directly connected but still connected by other vertices
        assertTrue(graph.isConnected(vertex2,vertex3));

        Graph graph2 = new IncidenceArrayGraph(2,EdgeKind.UNDIRECTED);
        Vertex vertex4 = new Vertex("Vertex 4.", Color.BLUE);
        Vertex vertex5 = new Vertex("Vertex 5.", Color.BLUE);
        graph2.addVertex(vertex4);
        graph2.addVertex(vertex5);

        assertFalse(graph2.isConnected(vertex5, vertex4));
    }

//       +-----------------------------------------------+
//       |          Test nbVertices() & nbEdges()        |
//       +-----------------------------------------------+

    @Test
    public void test_nbVertices_nbEdges(){
        assertEquals(4, graph.nbOfEdges());
        assertEquals(3, graph.nbOfVertices());
    }

//       +-----------------------------------------------+
//       |             Test addVertex                    |
//       +-----------------------------------------------+

    @Test
    public void test_exceptionVertices () {
        Vertex vertex4 = new Vertex("Vertex 3. ", Color.BLUE);
        Exception exception = assertThrows(GraphException.class, () -> {
            graph.addVertex(vertex4);
        });
        String expectedMessage = "The graph has already the maximum number of vertices. ";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testAddVertex() throws GraphException {
        Graph graph2 = new IncidenceArrayGraph(2,EdgeKind.UNDIRECTED);
        Vertex vertex4 = new Vertex("Vertex 4.", Color.BLUE);
        graph2.addVertex(vertex4);

        assertSame(graph2.getVertices()[0], vertex4);
    }

//       +-----------------------------------------------+
//       |                Test addEdge()                 |
//       +-----------------------------------------------+

    @Test
    public void testExceptionAddEdge(){
        Exception exception = assertThrows(GraphException.class, () -> {
            graph.addEdge(vertex1,vertex2);
            graph.addEdge(vertex1,vertex2);
            graph.addEdge(vertex1,vertex2);
        });
    }

    @Test
    public void testAddEdge() throws Exception {
        int nbEdges = graph.nbOfEdges();
        graph.addEdge(vertex2,vertex3);

        switch (graph.getEdgeKind()){
            case UNDIRECTED -> assertEquals(nbEdges+2,graph.nbOfEdges());
            case DIRECTED -> assertEquals(nbEdges+1,graph.nbOfEdges());
            default -> throw new Exception("Illegal value for edgeKind");
        }

        int indexVertex2 = graph.findOrAddVertex(vertex2);
        int indexVertex3 = graph.findOrAddVertex(vertex3);

        Edge[][] incidence = graph.getIncidenceArray();

        assertNotNull(incidence[indexVertex2][indexVertex3]);
        assertNotNull(incidence[indexVertex3][indexVertex2]);
    }

//       +-----------------------------------------------+
//       |             Test containVertex()              |
//       +-----------------------------------------------+

    @Test
    public void testContainVertex(){
        Vertex vertex4 = new Vertex("Vertex 4.", Color.BLUE);
        assertEquals(-1,graph.containVertex(vertex4));

        assertEquals(2, graph.containVertex(vertex3));
    }

//       +-----------------------------------------------+
//       |             Test findOrAddVertex()            |
//       +-----------------------------------------------+

    @Test
    public void testFindOrAddVertex() throws GraphException {
        IncidenceArrayGraph graph2 = new IncidenceArrayGraph(3,EdgeKind.UNDIRECTED);
        Vertex vertex4 = new Vertex("Vertex 4.", Color.BLUE);
        assertEquals(-1, graph2.containVertex(vertex4));
        graph2.findOrAddVertex(vertex4);
        assertEquals(0, graph2.containVertex(vertex4));
    }

//       +-----------------------------------------------+
//       |            Test searchConnection()            |
//       +-----------------------------------------------+

    @Test
    public void testSearchConnection(){
        assertTrue(graph.searchConnection(0,1, new ArrayList<>()));
        assertTrue(graph.searchConnection(1,2, new ArrayList<>()));
    }

//       +-----------------------------------------------+
//       |                Test getEdges()                |
//       +-----------------------------------------------+

    @Test
    public void testGetEdges(){
        Edge[] edges = graph.getEdges(vertex1, vertex2);
        int size = 0;
        for (Edge edge:edges) {
            if (edge!=null){
                size++;
            }
        }
        assertEquals(2, size);
    }

//       +-----------------------------------------------+
//       |             Test getNeighborEdges()           |
//       +-----------------------------------------------+

    @Test
    public void testGetNeighborEdges(){
        Edge[] edges = graph.getNeighborEdges(vertex1);
        int size = 0;
        for (Edge edge:edges) {
            if (edge!=null){
                size++;
            }
        }
        assertEquals(2,size);
    }

}
