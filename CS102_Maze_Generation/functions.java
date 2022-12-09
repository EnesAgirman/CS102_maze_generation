public class functions {

    Integer MAZE_HEIGHT;
    Integer MAZE_WIDTH;

    Integer[] visitedXLocations;
    Integer[] visitedYLocations;

    Integer currentXLocation = 0;
    Integer currentYLocation = 0;
    
    
    functions(){

    }



    public char[][] generateEmptyMaze( Integer aMAZE_HEIGHT, Integer aMAZE_WIDTH ) {


        MAZE_HEIGHT = aMAZE_HEIGHT*4;
        MAZE_WIDTH = aMAZE_WIDTH*4;

        visitedXLocations = new Integer[MAZE_WIDTH];
        visitedYLocations = new Integer[MAZE_HEIGHT];


        char[][] maze = new char[MAZE_HEIGHT + 1][MAZE_WIDTH + 1];

        int count = 0;
        for (int j = 0; j < maze[0].length; j++) {
            maze[0][j] = 'X';
        }
        

        for (int i = 1; i < maze.length; i++) {

            for (int j = 0; j < maze[0].length-1; j = j + 4) {
                maze[i][j] = 'X';
                maze[i][j+1] = '0';
                maze[i][j+2] = '0';
                maze[i][j+3] = '0';
            }
            maze[i][maze[0].length-1] = 'X';
                            
            count++;
            
            // /*
            if (count > 3) {
                count = 0;
                for (int j = 0; j < maze[0].length; j++) {
                    maze[i][j] = 'X';
                }
            }
            // */
                   
        }
        return maze;
    }


    public void turnRight( Integer xLocation, Integer yLocation) {
        if (xLocation > 0 && yLocation > 0 && xLocation < MAZE_WIDTH && yLocation < MAZE_HEIGHT) {
            if (isXVisited(xLocation) == false) {
                
            }

        }

        currentXLocation += 4;
    }


    public boolean isXVisited( Integer aXLocation ) {
        for (int i = 0; i < visitedXLocations.length; i++) {
            if (visitedXLocations[i] == aXLocation ) {
                return true;
            }
        }
        return false;
    }












}
