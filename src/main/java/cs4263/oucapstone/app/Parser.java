package cs4263.oucapstone.app;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        // Get the file path
        var scannerIn = new Scanner(System.in);
        System.out.println("Enter the path of the CSV file to be parsed.");
        var filename = scannerIn.nextLine();

        // Read the CSV file into an array
        var csvArray = new ArrayList<String>();
        var fileScanner = new Scanner(new File(filename));
        fileScanner.useDelimiter(",");
        while (fileScanner.hasNext()) {
            csvArray.add(fileScanner.next());
        }

        // Print out the array
        for (String s : csvArray) {
            System.out.println(s);
        }

        // Close the scanners
        scannerIn.close();
        fileScanner.close();
    }
}
