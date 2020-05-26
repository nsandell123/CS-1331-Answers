package Exercises.Vector;
public class Vector
{
    public final double x;
    public final double y;
    public Vector(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    public String toString()
    {
        return "(" + String.valueOf((int)this.x) + ", " + String.valueOf((int)this.y) + ")";
    }
    public Vector plus(Vector vec)
    {
        Vector vec1 = new Vector(vec.x + this.x,vec.y+this.y);
        return vec1;
    }
    public Vector minus(Vector vec)
    {
        Vector vec1 = new Vector(this.x - vec.x,this.y-vec.y);
        return vec1;
    }
    public double dot(Vector vec)
    {
        return this.x * vec.x + this.y * vec.y;
    }



}