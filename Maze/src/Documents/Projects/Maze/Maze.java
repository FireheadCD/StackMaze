package Documents.Projects.Maze;

public class Maze
{
    private final int TRIED = 3; // Represents the path that it took and changes value to 3

    private final int PATH = 7; // Uses constant to show final path

    private int [][] grid = {
            {1,0,0,1,1,1,0,0},
            {1,0,1,0,0,1,0,0},
            {1,0,1,0,0,1,0,0},
            {1,0,1,1,1,1,0,0},
            {1,1,1,0,0,0,0,0},
            {1,0,1,1,1,1,1,0}
                            };

    private StackADT<Position> push_new_pos(int x, int y, StackADT<Position> stack)
    {
        Position npos = new Position();
        npos.setx(x);
        npos.sety(y);
        if (valid(npos.getx(),npos.gety()))
            stack.push(npos);
        return stack;
    }



    public boolean traverse ()
    {
        boolean done = false;   // It has to be set to true for the message to appear, so it is set as false
        Position pos = new Position();
        Object dispose;
        StackADT<Position> stack = new ArrayStack<Position>();
        stack.push(pos);

        while (!(done))
        {
            pos = stack.pop();
            grid[pos.getx()][pos.gety()] = TRIED;  // this cell has been tried
            if (pos.getx() == grid.length-6 && pos.gety() == grid[0].length-5)// the exit point is on the grid at (4,1)
                done = true;  // the maze is solved
            else
            {
                stack = push_new_pos(pos.getx(),pos.gety() - 1, stack); // Pushing locations onto the stack
                stack = push_new_pos(pos.getx(),pos.gety() + 1, stack);
                stack = push_new_pos(pos.getx() - 1,pos.gety(), stack);
                stack = push_new_pos(pos.getx() + 1,pos.gety(), stack);
            }//else
        }//while

        return done;
    }//method traverse

    //-----------------------------------------------------------------
    //  Determines if a specific location is valid.
    //-----------------------------------------------------------------
    private boolean valid (int row, int column)
    {
        boolean result = false;

        // Check if cell is in the bounds of the matrix
        if (row >= 0 && row < grid.length &&
                column >= 0 && column < grid[row].length)

            //  Check if cell is not blocked and not previously tried
            if (grid[row][column] == 1)
                result = true;

        return result;
    }//method valid





//Prints the maze as a string
    public String toString ()
    {
        String result = "\n";

        for (int row=0; row < grid.length; row++)
        {
            for (int column=0; column < grid[row].length; column++)
                result += grid[row][column] + "";
            result += "\n";
        }//for

        return result;
    }
}
