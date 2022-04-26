package graph.src.main;

public class Vertex {
    /**
     * ◦ ... // additional stuff but no reference to the Edge class
     */

    private int id;
    private Object info;
    private String color;

    public Vertex(int id, Object info, String color) {
        this.id = id;
        this.info = info;
        this.color = color;
    }

    public Vertex(int id, Object info) {
        this.id = id;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "id=" + id +
                ", info=" + info +
                ", color='" + color + '\'' +
                '}';
    }
}
