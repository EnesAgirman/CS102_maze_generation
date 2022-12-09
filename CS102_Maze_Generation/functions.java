import java.util.ArrayList;
import java.util.Random;

public class maze {
    Integer MAZE_HEIGHT;
    Integer MAZE_WIDTH;

    //Integer[] visitedXLocations;
    //Integer[] visitedYLocations;
    
    ArrayList<Integer> visitedXLocations;
    ArrayList<Integer> visitedYLocations; 

    ArrayList<Integer> v = new ArrayList<Integer>();

    Integer currentXLocation;
    Integer currentYLocation;

    char[][] maze;

    Random rand = new Random();
    
    
    
    maze(Integer aMAZE_HEIGHT, Integer aMAZE_WIDTH){
        MAZE_HEIGHT = aMAZE_HEIGHT*4;
        MAZE_WIDTH = aMAZE_WIDTH*4;
        maze = generateEmptyMaze(aMAZE_HEIGHT, aMAZE_WIDTH);
        visitedXLocations = new ArrayList<Integer>();
        visitedYLocations = new ArrayList<Integer>();
        currentXLocation = 2;
        currentYLocation = 2;
        visitedXLocations.add(currentXLocation);
        visitedYLocations.add(currentYLocation);
        
    }



    public char[][] generateEmptyMaze( Integer aMAZE_HEIGHT, Integer aMAZE_WIDTH ) {


        MAZE_HEIGHT = aMAZE_HEIGHT*4;
        MAZE_WIDTH = aMAZE_WIDTH*4;


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

        if (isMoveRightPossible(currentXLocation, currentYLocation)) {
            maze[currentYLocation-1][currentXLocation + 2] = 'O';
            maze[currentYLocation][currentXLocation + 2] = 'O';
            maze[currentYLocation+1][currentXLocation + 2] = 'O';
    
            currentXLocation += 4;

            visitedXLocations.add(currentXLocation);
            visitedYLocations.add(currentYLocation);

        }


    }

    public void moveLeft() {

        if (isMoveLeftPossible(currentXLocation, currentYLocation)) {
            maze[currentYLocation-1][currentXLocation - 2] = 'O';
            maze[currentYLocation][currentXLocation - 2] = 'O';
            maze[currentYLocation+1][currentXLocation - 2] = 'O';
    
            currentXLocation -= 4;

            visitedXLocations.add(currentXLocation);
            visitedYLocations.add(currentYLocation);
        }



    }
    public void moveUp() {

        if (isMoveUpPossible(currentXLocation, currentYLocation)) {
            maze[currentYLocation-2][currentXLocation - 1] = 'O';
            maze[currentYLocation-2][currentXLocation] = 'O';
            maze[currentYLocation-2][currentXLocation + 1] = 'O';
    
            currentYLocation -= 4;  
            
            visitedXLocations.add(currentXLocation);
            visitedYLocations.add(currentYLocation);
        }


    }

    public void moveDown() {

        if (isMoveDownPossible(currentXLocation, currentYLocation)) {
            maze[currentYLocation+2][currentXLocation - 1] = 'O';
            maze[currentYLocation+2][currentXLocation] = 'O';
            maze[currentYLocation+2][currentXLocation + 1] = 'O';
    
            currentYLocation += 4;

            visitedXLocations.add(currentXLocation);
            visitedYLocations.add(currentYLocation);
        }



    }

    public boolean isMoveRightPossible(Integer xLocation, Integer yLocation) {
        if (xLocation + 4 > 0 && yLocation > 0 && xLocation + 4 < MAZE_WIDTH && yLocation < MAZE_HEIGHT) {
            if (isXVisited(xLocation + 4) == false || isYVisited(yLocation) == false) {
                return true;
            }
        }
        return false;
    }
    public boolean isMoveLeftPossible(Integer xLocation, Integer yLocation) {
        if (xLocation - 4 > 0 && yLocation > 0 && xLocation - 4 < MAZE_WIDTH && yLocation < MAZE_HEIGHT) {
            if (isXVisited(xLocation - 4) == false || isYVisited(yLocation) == false) {
                return true;
            }
        }
        return false;
    }
    public boolean isMoveUpPossible(Integer xLocation, Integer yLocation) {
        if (xLocation > 0 && yLocation - 4 > 0 && xLocation < MAZE_WIDTH && yLocation - 4 < MAZE_HEIGHT) {
            if (isYVisited(yLocation - 4) == false || isXVisited(xLocation) == false) {
                return true;
            }
        }
        return false;
    }
    public boolean isMoveDownPossible(Integer xLocation, Integer yLocation) {
        if (xLocation > 0 && yLocation + 4 > 0 && xLocation < MAZE_WIDTH && yLocation + 4 < MAZE_HEIGHT) {
            if (isYVisited(yLocation + 4) == false || isXVisited(xLocation) == false) {
                return true;
            }
        }
        return false;
    }


    // checks if the given x or y posisition is visited before

    public boolean isXVisited( Integer aXLocation ) {
        for (int i = 0; i < visitedXLocations.size(); i++) {
            if (visitedXLocations.get(i) == aXLocation ) {
                return true;
            }
        }
        return false;
    }

    public boolean isYVisited( Integer aYLocation ) {
        for (int i = 0; i < visitedYLocations.size(); i++) {
            if (visitedYLocations.get(i) == aYLocation ) {
                return true;
            }
        }
        return false;
    }

    public void moveRandomly() {
        
        ArrayList<Character> choices = new ArrayList<Character>();

        if (isMoveRightPossible(currentXLocation, currentYLocation)) {
            choices.add('R');
        }
        if (isMoveLeftPossible(currentXLocation, currentYLocation)) {
            choices.add('L');
        }
        if (isMoveUpPossible(currentXLocation, currentYLocation)) {
            choices.add('U');
        }
        if (isMoveDownPossible(currentXLocation, currentYLocation)) {
            choices.add('D');
        }

        Character choice = choices.get(rand.nextInt(choices.size()));

        if (choice == 'R') {
            moveRight();
        }
        else if (choice == 'L') {
            moveLeft();
        }
        else if (choice == 'U') {
            moveUp();;
        }
        else if (choice == 'D') {
            moveDown();;
        }
                
    }



}
