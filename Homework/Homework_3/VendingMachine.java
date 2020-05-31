package Homework_3;

import com.sun.source.util.SourcePositions;

import java.sql.SQLOutput;
import java.util.Random;

public class VendingMachine
{
    private static double totalSales;
    private final VendingItem[][][] shelf;
    private int luckyChance;
    private Random rand;

    public VendingMachine()
    {

        totalSales = 0;
        shelf = new VendingItem[6][3][5];
        restock();
        luckyChance = 0;

    }
    public VendingItem vend(String code)
    {
        //check the code for validity
        if(!(Character.isAlphabetic(code.charAt(0)) && Character.isDigit(code.charAt(1))))
        {
            return null;
        }
        //check if there is an item
        if(!(shelf[(int)(code.charAt(0) - 65)][(int)(code.charAt(1) - '0')] != null))
        {
            return null;
        }
        if(!free())
        {
            totalSales += shelf[(int)(code.charAt(0) - 65)][(int)(code.charAt(1) - '0')][0].getPrice();
        }
        else
        {
            System.out.println("Your item is free.");
        }
        VendingItem item = shelf[(int)(code.charAt(0) - 65)][(int)(code.charAt(1) - '0')][0];
        //Push the previous item into the front row


        for(int i = 0; i < 4; i++)
        {
            System.out.println((int)(code.charAt(0) - 65));
            System.out.println((int)(code.charAt(1) - '0'));
            System.out.println(i);
            System.out.println((int)(code.charAt(0) - 65));

            shelf[(int)(code.charAt(0) - 65)][(int)(code.charAt(1) - '0')][i] = shelf[(int)(code.charAt(0) - 65)][(int)(code.charAt(1) - '0')][i+1];

        }
        shelf[(int)(code.charAt(0) - 65)][(int)(code.charAt(1) - '0')][4] = null;

        return item;
    }
    private boolean free()
    {
        if(rand.nextInt(100) < luckyChance)
        {
            return true;
        }
        else
        {
            luckyChance++;
        }
        return false;

    }
    public void restock()
    {
        rand = new Random();
        VendingItem[] arr = VendingItem.values();
        for(int i = 0; i < 6;i++)
        {
            for(int j = 0; j < 3; j++)
            {
                for(int k = 0; k < 5;k++)
                {
                    shelf[i][j][k] = arr[rand.nextInt(arr.length)];
                }
            }
        }
    }
    public static double getTotalSales()
    {
        return totalSales;
    }
    public int getNumberOfItems()
    {
        int counter = 0;
        for(int i = 0; i < 6;i++)
        {
            for(int j = 0; j < 3; j++)
            {
                for(int k = 0; k < 5;k++)
                {
                    if(shelf[i][j][k] != null)
                    {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
    public double getTotalValue()
    {
        int counter = 0;
        for(int i = 0; i < 6;i++)
        {
            for(int j = 0; j < 3; j++)
            {
                for(int k = 0; k < 5;k++)
                {
                    if(shelf[i][j][k] != null)
                    {
                        counter += shelf[i][j][k].getPrice();
                    }
                }
            }
        }
        return counter;
    }
    public int getLuckyChance()
    {
        return luckyChance;
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("----------------------------------------------------------"
                + "------------\n");
        s.append("                            VendaTron 9000                "
                + "            \n");
        for (int i = 0; i < shelf.length; i++) {
            s.append("------------------------------------------------------"
                    + "----------------\n");
            for (int j = 0; j < shelf[0].length; j++) {
                VendingItem item = shelf[i][j][0];
                String str = String.format("| %-20s ",
                        (item == null ? "(empty)" : item.name()));
                s.append(str);
            }
            s.append("|\n");
        }
        s.append("----------------------------------------------------------"
                + "------------\n");
        s.append(String.format("There are %d items with a total "
                + "value of $%.2f.%n", getNumberOfItems(), getTotalValue()));
        s.append(String.format("Total sales across vending machines "
                + "is now: $%.2f.%n", getTotalSales()));
        return s.toString();
    }
}