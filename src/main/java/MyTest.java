import java.awt.*;

public class MyTest {
    public static void main(String[] args) {

        System.out.println("Hello");

        Vertex vertex = new Vertex("1", Color.BLUE);
        Vertex[] vertexArray =  new Vertex[2];
        vertexArray[0] = vertex;
        vertexArray[1] = vertex;
        Edge edge = new DirectedEdge(Color.RED,2,1, vertexArray);
        System.out.println(vertex);
        System.out.println(edge);
    }
}
