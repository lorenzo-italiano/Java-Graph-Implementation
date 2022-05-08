import java.awt.*;

/**
 * Directed edge representation. Inherits from abstract class Edge
 */
public class DirectedEdge extends Edge{

    //Indicates which element of ends array is the source (0 or 1)
    private int source;

    /**
     * Constructor of DirectedEdge instances
     * @param color (String)
     * @param value (double)
     * @param ends (Vertex[])
     * @param source (int) 0 or 1
     */
    public DirectedEdge(Color color, double value, int source, Vertex[] ends) {
        super(color, value, ends);
        this.source = source;
    }

    /**
     * getter for source elemnt of the directed edge
     * @return the source element of the edge
     */
    public Vertex getSource(){
        return getEnds()[source];
    }

    /**
     * Sets the source element of the edge
     * @param source (int) 0 or 1 only
     */
    public void setSource(int source) {
        this.source = source;
    }

    /**
     * get the sink of the edge
     * @return the sink of the edge
     */
    public Vertex getSink(){
        return switch (this.source) {
            case 1 -> getEnds()[0];
            case 0 -> getEnds()[1];
            default -> null;
        };
    }

    /**
     * To String
     * @return Stringified version of the directedEdge instance
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
