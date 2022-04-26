package graph.src.main;

public class DirectedEdge extends Edge{

    private int source; // 0 or 1

    public DirectedEdge(int id, String color, double value, Vertex[] ends, int source) {
        super(id, color, value, ends);
        this.source = source;
    }

    public Vertex getSource(){
        return getEnds()[source];
    }

    public Vertex getSink(){
        return switch (this.source) {
            case 1 -> getEnds()[0];
            case 0 -> getEnds()[1];
            default -> null;
        };
    }
}
