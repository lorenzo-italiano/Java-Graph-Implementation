package graph.src.main;

public abstract class Edge {

    private int id;
    private String color;
    private Vertex[] ends;
    private double value;

    public Edge(int id, String color, double value, Vertex[] ends) {
        this.id = id;
        this.color = color;
        this.value = value;
        // TODO Throw exception if ends has more than two elements
        this.ends = ends;
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Vertex[] getEnds() {
        return ends;
    }

    public void setEnds(Vertex[] ends) {
        this.ends = ends;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
