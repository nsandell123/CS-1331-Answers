package Homework_2;
import Exercises.Array.ArrayUtil;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class SourceModel
{
    //name is for the name of source model
    public String name;
    //filename is for the file they are giving me
    public String fileName;
    //this is to hold the probabilities established by the given file
    double [][] arr;
    public SourceModel(String name, String fileName) throws IOException {
        arr = new double[26][26];
        System.out.println("Training " + name + " model");
        //the FileReader takes in the File
        FileReader f = new FileReader(new File("english.corpus"));
        //These are your two tracker variables
        int j = 0;
        int y = 0;
        //You want to "eat" in one of the characters so that j can be the follower person
        j= Character.toUpperCase(f.read()) - 65;
        int counter = 0;
        //We are scaling down so anytime we can't read we will get -66
        while(j != -66)
        {
            //We read in a new character
            y= Character.toUpperCase(f.read()) - 65;
            //This says "if we have consecutive characters, please increment the corresponding"
            if(j >= 0 && y >= 0)
            {
                arr[j][y]++;
            }
            //We need to shift one up for our j
            j = y;
        }
        //This nested for loop allows us to convert to a probability matrix
        for(int i = 0; i < 26; i++)
        {
            for(int l = 0; l < 26; l++)
            {
                arr[i][l] = arr[i][l] / 26;
                if(arr[i][l] == 0)
                {
                    arr[i][l] = 0.01;
                }

            }
        }
    }
    public String getName()
    {

        return this.name;
    }

    public String toString()
    {
        //We can print out our 2D array
        return Arrays.deepToString(arr);
    }
    public double probability(String input)
    {
        //We need to take in a given String
        Scanner scan = new Scanner(input);
        //We need to take in the next Line so we can analyze it character by character
        String nodes = scan.nextLine();
        //initializing probability to 1
        double counter = 1;
        for(int i = 0; i < nodes.length() - 1; i++)
        {
            if((int)Character.toUpperCase(nodes.charAt(i)) - 65 >= 0 && (int)Character.toUpperCase(nodes.charAt(i)) - 65 >= 0)
            {
                //we are multiplying the corresponding section of the array by our counter
                counter *= arr[(int)Character.toUpperCase(nodes.charAt(i)) - 65][(int)Character.toUpperCase(nodes.charAt(i)) - 65];
            }

        }
        return counter;
    }
    public static void main(String [] args) throws Exception
    {
        //We need to loop through our command line arguments
        for(int i = 0; i < args.length - 1; i++)
        {
            //We have established our probability matrix for the given source file
            SourceModel model = new SourceModel(args[i], args[i]);
            //This prints out our corresponding probability of that input given our model
            System.out.println(model.probability(args[args.length-1]));
        }
    }

}