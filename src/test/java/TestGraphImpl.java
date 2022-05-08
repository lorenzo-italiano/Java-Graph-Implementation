import java.awt.*;
import java.util.Arrays;

public class TestGraphImpl {

    public static void main(String[] args) {
        Graph graph = new IncidenceArrayGraph(3);

        Vertex vertex1 = new Vertex("Vertex 1. ", Color.BLUE);
        Vertex vertex2 = new Vertex("Vertex 2. ", Color.BLUE);
        Vertex vertex3 = new Vertex("Vertex 3. ", Color.BLUE);

        graph.addVertex(vertex1);
        graph.addVertex(vertex2);

        graph.addEdge(vertex1, vertex2, EdgeKind.UNDIRECTED);
        graph.addEdge(vertex1, vertex3, EdgeKind.UNDIRECTED);   // Should also do : graph.addVertex(vertex3);

        Vertex[] graphVertices = graph.getVertices();
        System.out.println(graphVertices[0] == vertex1);
        System.out.println(graphVertices[1] == vertex2);
        System.out.println(graphVertices[2] == vertex3);

        System.out.println(! graph.isConnected());

        System.out.println(graph.isConnected(vertex1, vertex2));
        System.out.println(graph.isConnected(vertex1, vertex3));
        System.out.println(! graph.isConnected(vertex2, vertex3));
    }
}