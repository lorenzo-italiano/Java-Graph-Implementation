package main.java;

/**
 * Vertices representation
 */
public class Vertex {

    private int id;
    private Object info;
    private String color;

    /**Params
     * Constructor
     * @param id (int): id of the Vertex
     * @param info (Object): Object indicating infos on the Vertex
     * @param color (String): Color of the Vertex
     */
    public Vertex(int id, Object info, String color) {
        this.id = id;
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
     * id setter
     * @param id (int) to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**Params
     * info getter
     * @return infos (Object)
     */
    public Object getInfo() {
        return info;
    }

    /**Params
     * info setter
     * @param info (Object) info to set
     */
    public void setInfo(Object info) {
        this.info = info;
    }

    /**Params
     * color getter
     * @return color (String)
     */
    public String getColor() {
        return color;
    }

    /**Params
     * color setter
     * @param color (String): color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**Params
     * To string
     * @return Stringified version of the Vertex instance
     */
    @Override
    public String toString() {
        return "Vertex{" +
                "id=" + id +
                ", info=" + info +
                ", color='" + color + '\'' +
                '}';
    }
}
