import java.util.Stack;


public class test {
    public static void main(String[] args) {
        

        // write the height and width of the maze you want to generate
        Integer MAZE_HEIGHT = 10;
        Integer MAZE_WIDTH = 10;

        // maze from the Maze class is generated. This is currently an empty maze
        maze myMaze = new maze(MAZE_HEIGHT, MAZE_WIDTH);
        char[][] maze = myMaze.maze;


        // this function generates the actual filled maze
        myMaze.generateMaze();


        // displaying the maze
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        


    }
}
