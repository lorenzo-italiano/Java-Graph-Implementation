package mazeGame;

public class Main {
    public static void main(String[] args) {
        Maze maze = new Maze(10,0.2,0.4);
        System.out.println(maze);

        maze.findPath();
    }
}
