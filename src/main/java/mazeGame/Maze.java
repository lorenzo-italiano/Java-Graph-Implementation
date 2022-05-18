package mazeGame;

import graphImpl.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    private IncidenceArrayGraph graph;
    private Vertex[] cells;
    private Edge[] links;
    private Vertex departure;
    private Vertex arrival;

    public Maze(int size, double density,double dangerousness) throws GraphException{
        this.graph = new IncidenceArrayGraph(size, EdgeKind.UNDIRECTED);
        for (int i = 0; i < size; i++) {
            double random = Math.random();
            boolean hasMonster = false;
            if(random<=dangerousness){
                hasMonster = true;
            }
            graph.addVertex(new CellDescription(Color.BLUE,1 + (int)(Math.random() * 10),1 + (int)(Math.random() * 5),hasMonster,1 + (int)(Math.random() * 4)));
        }

        this.cells = graph.getVertices();

        int possibleLinks = (size*(size-1))/2;

//        System.out.println(possibleLinks);

        int nbOfLinks = (int) (possibleLinks*density);

//        System.out.println(nbOfLinks);

        int i = 0;
        while (i < nbOfLinks) {
            int randomVertex1 = (int) (Math.random() * this.cells.length);
            int randomVertex2 = (int) (Math.random() * this.cells.length);

            Edge[] edgesBetween1and2 = graph.getEdges(cells[randomVertex1],cells[randomVertex1]);

            if (edgesBetween1and2==null) {
                graph.addEdge(cells[randomVertex1], cells[randomVertex2]);
                graph.addEdge(cells[randomVertex2], cells[randomVertex1]);
                i++;
            }

        }
        this.links = graph.getEdges();

        int randomDeparture = (int) (Math.random()*cells.length);
        this.departure = cells[randomDeparture];

        int randomArrival = (int) (Math.random()*cells.length);

        while(randomDeparture==randomArrival){
            randomArrival = (int) (Math.random()*cells.length);
        }
        this.arrival = cells[randomArrival];

        System.out.println(this.departure.getId() + " " + this.arrival.getId() + ": " + graph.isConnected(this.departure, this.arrival));
        if(!graph.isConnected(this.departure, this.arrival)){
            System.out.println("Connecting");

            int base = graph.containVertex(this.departure);
            for (int j = 0; j < cells.length/2; j++) {
                if(j==(cells.length/2)-1){
                    System.out.println("connecting to arrival");
                    graph.addEdge(cells[base],this.arrival);
                    graph.addEdge(this.arrival,cells[base]);
                }
                else{
                    int randomCell = (int) (Math.random()*cells.length);
                    while(this.arrival==cells[randomCell] || this.departure==cells[randomCell]){
                        randomCell = (int) (Math.random()*cells.length);
                    }
                    graph.addEdge(cells[base],cells[randomCell]);
                    graph.addEdge(cells[randomCell],cells[base]);
                    base = randomCell;
                }
            }
        }
    }

    private boolean findPathAux(int departure, int arrival, ArrayList<Integer> path){
        CellDescription cellDeparture = (CellDescription) cells[departure];
        CellDescription cellArrival = (CellDescription) cells[arrival];
        Edge[][] array = graph.getIncidenceArray();
        if(array[departure][arrival]!=null){
            path.add(arrival);
            cellArrival.setVisited(true);
            System.out.println("found path : ");
            System.out.println(path);
            return true;
        }
        else{
            for (int i = 0; i < cells.length; i++) {
                if(array[departure][i]!=null){
                    CellDescription currentCell = (CellDescription) cells[i];
                    if(!currentCell.isVisited()){
                        path.add(i);
                        currentCell.setVisited(true);
                        if(findPathAux(i,arrival, path)){
                            return true;
                        }
                    }

                }
            }
            return false;
        }
    }

    public boolean findPath(){
        Edge[][] incidenceArray = graph.getIncidenceArray();
        int indexVertex1 = graph.containVertex(this.departure);
        int indexVertex2 = graph.containVertex(this.arrival);
        if (incidenceArray[indexVertex1][indexVertex2]!=null){
            System.out.println("departure and arrival are directly connected");
            return true;
        }
        else{
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(indexVertex1);
            CellDescription departureCell = (CellDescription) cells[indexVertex1];
            departureCell.setVisited(true);
            return findPathAux(indexVertex1,indexVertex2,arrayList);
        }
    }

    @Override
    public String toString() {
        return "Maze{" + "\n" +
                "graph=" + graph + "\n" +
                ", cells=" + cells.length + " " + Arrays.toString(cells) + "\n" +
                ", links=" + links.length + " " + Arrays.toString(links) + "\n" +
                ", departure=" + departure + "\n" +
                ", arrival=" + arrival + "\n" +
                '}';
    }
}
