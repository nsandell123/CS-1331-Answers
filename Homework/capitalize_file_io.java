import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class capitalize_file_io
{
    public static void main(String [] args) throws Exception
    {
        //take in command line argument and create a file with uppercase on it
        Scanner scan = new Scanner(new File(args[0]));
        File newFile = new File(args[0].substring(0,args[0].lastIndexOf(".")) + "-uppercase" + ".txt");
        PrintStream writer = new PrintStream(newFile);
        //grab the lines of the original file and converts it to uppercase then writing it to the new file
        while(scan.hasNext())
        {
            writer.println(scan.nextLine().toUpperCase());
            writer.flush();
        }

        writer.close();



    }
}