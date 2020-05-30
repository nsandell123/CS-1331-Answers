package Homework_1;
import java.util.*;
import java.io.*;
public class Histogram {

    public static void main(String[] args) throws Exception {
        int numBins = 0;
        Scanner scan = new Scanner(new File(args[0]));
        Scanner bins = new Scanner(System.in);
        if (args.length == 2) {
            numBins = Integer.parseInt(args[1]);
        } else {
            System.out.println("How many bins do you want? ");
            numBins = bins.nextInt();
        }
        int leftOver = 101 % numBins;
        int increment = 101 / numBins;
        int[] arr = new int[numBins];
        while (scan.hasNextLine()) {

            String line = scan.nextLine();
            String[] regex = line.split(",");
            for (int i = 0; i < numBins; i++) {
                if (Integer.parseInt(regex[1].strip()) <= (increment) * (i+1)) {
                    arr[i]++;
                    break;
                }
            }
        }
        displayHistogram(arr, numBins, increment, leftOver);


    }

    //display my histogram
    public static void displayHistogram(int[] input, int num, int demarcation, int left) {
        int firstNum = 0;
        int secondNum = demarcation;
        for (int i = 0; i < num; i++) {
            System.out.print(String.valueOf(firstNum) + "-" + String.valueOf(secondNum));
            System.out.println(" "  + input[i]);
            if(i==0)
            {
                //guarantees no overlap
                firstNum+=1;
            }
            //lets jump up by the increment
            firstNum += demarcation;
            secondNum += demarcation;
        }
    }
}
