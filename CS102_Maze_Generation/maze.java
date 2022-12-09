public class maze {
    Integer MAZE_HEIGHT;
    Integer MAZE_WIDTH;

    Integer[] visitedXLocations;
    Integer[] visitedYLocations;

    Integer currentXLocation = 2;
    Integer currentYLocation = 2;

    char[][] maze;
    
    
    maze(Integer aMAZE_HEIGHT, Integer aMAZE_WIDTH){
        MAZE_HEIGHT = aMAZE_HEIGHT*4;
        MAZE_WIDTH = aMAZE_WIDTH*4;
        maze = generateEmptyMaze(aMAZE_HEIGHT, aMAZE_WIDTH);
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
                maze[i][j+1] = 'O';
                maze[i][j+2] = 'O';
                maze[i][j+3] = 'O';
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



    public void moveRight() {

        currentXLocation += 4;

    }

    public void moveLeft() {

        currentXLocation -= 4;

    }
    public void moveUp() {

        currentYLocation -= 4;

    }

    public void moveDown() {

        currentYLocation += 4;

    }

    public boolean isMoveRightPossible(Integer xLocation, Integer yLocation) {
        if (xLocation + 4 > 0 && yLocation > 0 && xLocation + 4 < MAZE_WIDTH && yLocation < MAZE_HEIGHT) {
            if (isXVisited(xLocation + 4) == false) {
                return true;
            }
        }
        return false;
    }
    public boolean isMoveleftPossible(Integer xLocation, Integer yLocation) {
        if (xLocation - 4 > 0 && yLocation > 0 && xLocation - 4 < MAZE_WIDTH && yLocation < MAZE_HEIGHT) {
            if (isXVisited(xLocation - 4) == false) {
                return true;
            }
        }
        return false;
    }
    public boolean isMoveUpPossible(Integer xLocation, Integer yLocation) {
        if (xLocation > 0 && yLocation - 4 > 0 && xLocation < MAZE_WIDTH && yLocation - 4 < MAZE_HEIGHT) {
            if (isXVisited(yLocation - 4) == false) {
                return true;
            }
        }
        return false;
    }
    public boolean isMoveDownPossible(Integer xLocation, Integer yLocation) {
        if (xLocation > 0 && yLocation + 4 > 0 && xLocation < MAZE_WIDTH && yLocation + 4 < MAZE_HEIGHT) {
            if (isXVisited(yLocation + 4) == false) {
                return true;
            }
        }
        return false;
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
