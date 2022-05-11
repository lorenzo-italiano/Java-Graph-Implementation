package mazeGame;

import graphImpl.Vertex;

import java.awt.*;

public class CellDescription extends Vertex {

    private int width;
    private int length;
    private boolean containsMonster;
    private int maxNbPerson; // field indicating how many person can be in the cell simultaneously
    private boolean visited; // wether the cell has been visited or not

    /**
     * Constructor
     *
     * @param width: of the cell
     * @param length: of the cell
     * @param containsMonster: true if it contains one
     * @param maxNbPerson: how many person can be in the cell simultaneously
     */
    public CellDescription(Color color,int width, int length, boolean containsMonster, int maxNbPerson) {
        super("width: "+ width+", length: "+length, color);
        this.width = width;
        this.length = length;
        this.containsMonster = containsMonster;
        this.maxNbPerson = maxNbPerson;
        this.visited = false;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isContainsMonster() {
        return containsMonster;
    }

    public void setContainsMonster(boolean containsMonster) {
        this.containsMonster = containsMonster;
    }

    public int getMaxNbPerson() {
        return maxNbPerson;
    }

    public void setMaxNbPerson(int maxNbPerson) {
        this.maxNbPerson = maxNbPerson;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "CellDescription{" +
                "id: " + super.getId() +
                ", width=" + width +
                ", length=" + length +
                ", containsMonster=" + containsMonster +
                ", maxNbPerson=" + maxNbPerson +
                '}';
    }
}
