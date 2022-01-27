import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {
    private static ArrayList<String> enArray;
    private static ArrayList<String> esArray;
    static {
        esArray = parseCSV("spanish.csv");
        enArray = parseCSV("english.csv");
    }

    // Method to read a CSV file into an ArrayList
    private static ArrayList<String> parseCSV(String filename) {
        ArrayList<String> characters = new ArrayList<String>();

        try {
            Scanner sc = new Scanner(new File(filename));
            sc.useDelimiter(",");
            try {
                while (sc.hasNext()) {
                    characters.add(sc.next().toLowerCase());
                }
            } catch (Exception e) {
                System.out.println("Error: No clue man, you really screwed up. I only read characters.");
            } finally {
                sc.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file '" + filename + "' was not found in " +
                    "Working Directory '" + System.getProperty("user.dir") + "'");
        }

        return characters;
    }

    // Method to determine if a character belongs to a language we have.
    public static Boolean isLang(String character) {
        return enArray.contains(character.toLowerCase()) || esArray.contains(character.toLowerCase());
    }

    // Method determines if an ArrayList of characters
    public static boolean checkAll(List<String> characters) {
        boolean yn = true;
        for (String c : characters)
            if (!isLang(c))
                yn = false;
        return yn;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(checkAll(parseCSV("input.csv")));
    }
}