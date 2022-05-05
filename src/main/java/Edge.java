package main.java;

import java.util.Arrays;

/**
 * Abstract class Edge setting up common variables and methods for directed and undirected edges
 */
public abstract class Edge {

    private int id;
    private String color;
    private Vertex[] ends;
    private double value;

    /**Params
     * Constructor of Edge abstract class ( BEWARE !! an abstract class can't be instanced)
     * @param id (int): id of the edge
     * @param color (String): color of the edge
     * @param value (double): value of the edge
     * @param ends (Vertex []): Vertices linked by this edge
     */
    public Edge(int id, String color, double value, Vertex[] ends) {
        this.id = id;
        this.color = color;
        this.value = value;
        // TODO Throw exception if ends has more than two elements
        this.ends = ends;
    }

    /**Params
     * get the id of the edge
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**Params
     * get the color of the edge
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**Params
     * sets the color with a String input
     * @param color (String)
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**Params
     * get the array of Vertices connected by this edge
     * @return array of end Vertices
     */
    public Vertex[] getEnds() {
        return ends;
    }

    /**
     * sets the Vertices array connected by this edge
     * @param ends (Vertex [])
     */
    public void setEnds(Vertex[] ends) {
        this.ends = ends;
    }

    /**Params
     * get the value of the edge
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**Params
     * Sets the value of the edge
     * @param value (double)
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Convert instance information to a String variable and returns it
     * @return Stringified edge instance
     */
    @Override
    public String toString() {
        return "Edge{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", ends=" + Arrays.toString(ends) +
                ", value=" + value +
                '}';
    }
}
