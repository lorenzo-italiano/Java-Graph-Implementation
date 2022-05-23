package graphImpl;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MyTest {
    public static void main(String[] args) throws GraphException, IOException, ClassNotFoundException {
        Graph graph = new IncidenceArrayGraph(3, EdgeKind.UNDIRECTED);

        Vertex vertex1 = new Vertex("Vertex 1. ", Color.BLUE);
        Vertex vertex2 = new Vertex("Vertex 2. ", Color.BLUE);
        Vertex vertex3 = new Vertex("Vertex 3. ", Color.BLUE);

        graph.addVertex(vertex1);
        graph.addVertex(vertex2);

        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex1, vertex3);   // Should also do : graph.addVertex(vertex3);

        System.out.println(graph);
        System.out.println();


        String fileName = "graphSerialized.bin";
        graph.serialize(fileName);
        Graph graph1 = graph.deserialize(fileName);
        System.out.println(graph1);
    }
}
