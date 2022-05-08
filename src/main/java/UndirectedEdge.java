import java.awt.*;

/**
 * Undirected Edge representation. Inherits from Edge abstract class
 */
public class UndirectedEdge extends Edge{

    /**Params
     * Constructor of UndirectedEdge instance.
     *
     * @param color (String)
     * @param value (double)
     * @param ends (Vertex[])
     */
    public UndirectedEdge(Color color, double value, Vertex[] ends) {
        super(color, value, ends);
    }

    /**
     * To string
     * @return Stringified version of UndirectedEdge
     */
    @Override
    public String toString() {
        return super.toString() + ", edgeType : Undirected";
    }
}
