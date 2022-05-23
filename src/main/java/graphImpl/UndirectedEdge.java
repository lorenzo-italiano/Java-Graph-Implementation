package graphImpl;

import java.awt.*;

/**
 * Undirected graphImpl.Edge representation. Inherits from graphImpl.Edge abstract class
 */
public class UndirectedEdge extends Edge {

    /**Params
     * Constructor of graphImpl.UndirectedEdge instance.
     *
     * @param color (String)
     * @param value (double)
     * @param ends (graphImpl.Vertex[])
     */
    public UndirectedEdge(Color color, double value, Vertex[] ends) {
        super(color, value, ends);
    }

    /**
     * To string
     * @return Stringified version of graphImpl.UndirectedEdge
     */
    @Override
    public String toString() {
        return super.toString() + ", edgeType : Undirected";
    }
}
