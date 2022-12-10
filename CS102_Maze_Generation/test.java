import java.util.Stack;


public class test {
    public static void main(String[] args) {
        

        System.out.println("\n@@@@@@@@@@@@@@\nlerolerolerolerolerolero\n@@@@@@@@@@@@@@\n");

        Integer MAZE_HEIGHT = 10;
        Integer MAZE_WIDTH = 10;

        Stack<Integer> XStack = new Stack<Integer>();
        Stack<Integer> YStack = new Stack<Integer>();

        maze myMaze = new maze(MAZE_HEIGHT, MAZE_WIDTH);
        char[][] maze = myMaze.maze;

        System.out.println("\n@@@@@@@@@@@@@@\nlerolerolerolerolerolero\n@@@@@@@@@@@@@@\n");

        

        System.out.println(myMaze.isMoveLeftPossible(myMaze.currentXLocation, myMaze.currentYLocation));
        System.out.println(myMaze.isMoveRightPossible(myMaze.currentXLocation, myMaze.currentYLocation));

        System.out.println(myMaze.isMoveUpPossible(myMaze.currentXLocation, myMaze.currentYLocation));
        System.out.println(myMaze.isMoveDownPossible(myMaze.currentXLocation, myMaze.currentYLocation));

        myMaze.generateMaze();

        System.out.println(" is there a move possible: " + myMaze.movingPossible());


        System.out.println(myMaze.currentXLocation);
        System.out.println(myMaze.currentYLocation);

        System.out.println(myMaze.isMoveLeftPossible(myMaze.currentXLocation, myMaze.currentYLocation));
        System.out.println(myMaze.isMoveRightPossible(myMaze.currentXLocation, myMaze.currentYLocation));

        System.out.println(myMaze.isMoveUpPossible(myMaze.currentXLocation, myMaze.currentYLocation));
        System.out.println(myMaze.isMoveDownPossible(myMaze.currentXLocation, myMaze.currentYLocation));


        // displaying the maze
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        
        /*
        //Integer[] intArray = new Integer[]{ 1,2,3,4,5,6,7,8,9,10 }; 
        XStack.push(12);
        YStack.push(43);
        System.out.println(XStack.peek());
        System.out.println(YStack.peek());
        XStack.push(65);
        YStack.push(98);
        System.out.println(XStack.peek());
        System.out.println(YStack.peek());
        XStack.push(0);
        YStack.push(0);
        System.out.println(XStack.peek());
        System.out.println(YStack.peek());
        */



    }
}
