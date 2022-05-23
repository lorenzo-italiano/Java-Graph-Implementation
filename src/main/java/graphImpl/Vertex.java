package graphImpl;

import java.awt.*;
import java.io.Serializable;

/**
 * Vertices representation
 */
public class Vertex implements Serializable {

    private final int id;
    private static int currentId = 0;
    private final Object info;
    private final Color color;

    /**Params
     * Constructor
     * @param info (Object): Object indicating infos on the graphImpl.Vertex
     * @param color (String): Color of the graphImpl.Vertex
     */
    public Vertex(Object info, Color color) {
        this.id = currentId++;
        this.info = info;
        this.color = color;
    }

    /**Params
     * id getter
     * @return id (int)
     */
    public int getId() {
        return id;
    }

    /**Params
     * info getter
     * @return infos (Object)
     */
    public Object getInfo() {
        return info;
    }

    /**Params
     * color getter
     * @return color (String)
     */
    public Color getColor() {
        return color;
    }

    /**Params
     * To string
     * @return Stringified version of the graphImpl.Vertex instance
     */
    @Override
    public String toString() {
        return "graphImpl.Vertex{" +
                "id=" + id +
                ", info=" + info +
                ", color='" + color + '\'' +
                '}';
    }
}
