import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    static ArrayList<String> enArray;
    static ArrayList<String> esArray;

    // Method to determine if a character belongs to a language we have.
    public static Boolean isLang(String character) {
        if (enArray.contains(character) || esArray.contains(character)) {
            return true;
        }
        return false;
    }

    // Method to read a CSV file into an ArrayList
    public static ArrayList<String> parseCSV(String filename) {

        var scannerIn = new Scanner(System.in);
        var csvArray = new ArrayList<String>();

        try {
            // Read the CSV file into an array
            var fileScanner = new Scanner(new File(filename));
            fileScanner.useDelimiter(",");
            while (fileScanner.hasNext()) {
                csvArray.add(fileScanner.next());
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist!!!");
        } finally {
            // Close the scanners
            scannerIn.close();
        }

        return csvArray;
    }

    public static void main(String[] args) throws FileNotFoundException {
        esArray = parseCSV("../spanish.csv");
        enArray = parseCSV("../english.csv");
        var inputArray = parseCSV("../input.csv");

        Boolean yesno = true;
        for (String c : inputArray) {
            if (!isLang(c)) {
                yesno = false;
            }
        }

        System.out.println("" + yesno);
    }
}