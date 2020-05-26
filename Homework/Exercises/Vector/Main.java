package Exercises.Vector;

public class Main
{
    public static void main(String [] args)
    {
        Vector x = new Vector(5, 6);
        Vector y = new Vector(1,2);
        //Add the vectors
        System.out.println(x.plus(y).toString());
        //Subtract the Vectors
        System.out.println(x.minus(y).toString());
        //Find the dot product of the vectors
        System.out.println(x.dot(y));
    }
}