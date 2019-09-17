package Documents.Projects.Maze;

public class Position
{

    private int x; // Setting up the variables
    private int y;

    public int getx() //gets value for x
    {
        return x;
    }//method getx

    public int gety()
    {
        return y;
    }//method gety

    public void setx(int a)
    {
        x = a;
    }//method setx

    public void sety(int a)
    {
        y = a;
    }//method sety

    Position ()
    {
        x = 0;
        y = 0;
    }

}//class Position
