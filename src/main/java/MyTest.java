package main.java;

public class MyTest {
    public static void main(String[] args) {

        System.out.println("Hello");

        Vertex vertex = new Vertex(1,new String("1"), "Blue");
        Vertex[] v =  new Vertex[2];
        v[0] = vertex;
        v[1] = vertex;
        Edge edge = new DirectedEdge(1,"red",2,v,1);
        System.out.println(vertex);
        System.out.println(edge);
    }
}
