package graph.src.main;

public class UndirectedEdge extends Edge{

    public UndirectedEdge(int id, String color, double value, Vertex[] ends) {
        super(id, color, value, ends);
    }

    public Vertex[] getEnds(){
        return super.getEnds();
    }

}
