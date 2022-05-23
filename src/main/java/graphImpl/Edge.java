package graphImpl;

import java.awt.*;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Abstract class graphImpl.Edge setting up common variables and methods for directed and undirected edges
 */
public abstract class Edge implements Serializable {

    private final int id;
    private static int currentId = 0;
    private Color color;
    private Vertex[] ends;
    private double value;

    /**Params
     * Constructor of graphImpl.Edge abstract class ( BEWARE !! an abstract class can't be instanced)
     * @param color (String): color of the edge
     * @param value (double): value of the edge
     * @param ends (graphImpl.Vertex []): Vertices linked by this edge
     */
    public Edge(Color color, double value, Vertex[] ends) {
        this.id = currentId++;
        this.color = color;
        this.value = value;

        if (ends.length != 2) {
            throw new RuntimeException("Invalid number of ends for an graphImpl.Edge. ");
        }
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
    public Color getColor() {
        return color;
    }

    /**Params
     * sets the color with a String input
     * @param color (String)
     */
    public void setColor(Color color) {
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
     * @param ends (graphImpl.Vertex [])
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
        return "graphImpl.Edge{" + "ends=" + ends[0].getId() + "-" +ends[1].getId() + "}\n";
    }
}
