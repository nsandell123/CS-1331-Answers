package Homework_4;

public class Coordinates
{
    final double lattitude;
    final double longitude;
    public Coordinates(double lattitude, double longitude)
    {
        this.lattitude = lattitude;
        this.longitude = longitude;
    }
    public boolean equals(Coordinates other)
    {
        if(this.lattitude == other.lattitude && this.longitude == other.longitude)
        {
            return true;
        }
        return false;
    }
    public String toString()
    {
        return "Lattitude: " + lattitude + "Longitude: " + longitude;
    }

}