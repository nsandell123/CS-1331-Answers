package Exercises.Array;
public class ArrayUtil
{
    public static int[] take(int n, int[] xs)
    {
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = xs[i];
        }
        return arr;
    }
    //which returns a new array containing the first n elements of xs
    public static int[] drop(int n, int[] xs)
    {
        int [] arr = new int[n];
        int counter = 0;
        for(int i = xs.length - 1; i >= xs.length - n; i--)
        {
            arr[counter] = xs[i];
            counter++;
        }
        return arr;
    }
    // which returns a new array containing the last n elements of xs
    public static boolean equals(int[] xs, int[] ys)
    {
        if(xs.length != ys.length)
        {
            return false;
        }
        for(int i = 0; i < xs.length; i++)
        {
            if(xs[i] != ys[i])
            {
                return false;
            }
        }
        return true;
    }
    //which returns true if xs.length == ys.length and xs[i] == ys[i] for 0 <=i < xs.length
    public static int[] concat(int[] xs, int[] ys)
    {
        int counter= 0 ;
        int [] arr = new int[xs.length + ys.length];
        for(int i = 0; i < xs.length; i++)
        {
            arr[i] = xs[i];
        }
        for(int k = xs.length; k < ys.length + xs.length; k++)
        {

            arr[k] = ys[counter];
            counter++;
        }
        return arr;
    }
    //which returns a new array containing the elements of ys after the elements of xs
    public static String toString(int[] xs)
    {
        String insides = "";
        for(int i = 0; i < xs.length;i++)
        {
            if(i == xs.length - 1)
            {
                insides += xs[i];
            }
            else
            {
                insides += xs[i] + ",";
            }

        }
        return "[" + insides + "]";
    }
    public static String toString(int[][] as) {
        String toBeReturned = "[";
        for (int i = 0; i < as.length; i++)
        {
            if(i == as.length-1)
            {
                toBeReturned += ArrayUtil.toString(as[i]);
            }
            else
            {
                toBeReturned += ArrayUtil.toString(as[i]) + "\n";
            }

        }
        toBeReturned+= "]";
        return toBeReturned;
    }


    public static int[][] identity(int n)
    {
        int[][]arr = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(i == j)
                {
                    arr[i][j] = 1;
                }
                else
                {
                    arr[i][j] = 0;
                }

            }
        }
        return arr;
    }
}