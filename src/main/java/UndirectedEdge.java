
/**
 * Undirected Edge representation. Inherits from Edge abstract class
 */
public class UndirectedEdge extends Edge{

    /**Params
     * Constructor of UndirectedEdge instance
     * @param id (int)
     * @param color (String)
     * @param value (double)
     * @param ends (Vertex[])
     */
    public UndirectedEdge(int id, String color, double value, Vertex[] ends) {
        super(id, color, value, ends);
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
