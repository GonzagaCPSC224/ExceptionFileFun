import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // exception: an event that occurs during runtime
        // that disrupts the normal program instruction flow

        // 2 types of exceptions
        // 1. unchecked exception: errors and runtime exceptions
        // 2. checked exception: an exception that you have to handle
        // or acknowledge the exception (throws)

        // runtime example
        try {
            int x = 5 / 0;
        } catch(ArithmeticException e) {
            // e is a object refrence!!
            e.printStackTrace();
        }

        // checked exception example
        Scanner inFile = null;
        // try an open an input stream to read from a file
        // that doesn't exist!!
        try {
            inFile = new Scanner(new File("dne.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } finally {
            // executes no matter what happens in the try (success or failure)
            System.out.println("Hello from finally");
        }



        // file input
        try {
            inFile = new Scanner(new File("myFile.txt"));
            // read line by line from inFile
            while(inFile.hasNextLine()) {
                System.out.println(inFile.nextLine());
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            // executes no matter what happens in the try (success or failure)
            System.out.println("Hello from finally");
        }

//        if (inFile != null) {
//
//        }



        // file output
        try {
            PrintStream outFile = new PrintStream(new File("out.txt"));
            // use just like System.out
            // task: write out 10 random numbers in [1, 6]
            Random rand = new Random();
            for (int i = 0; i < 10; i++) {
                outFile.print((rand.nextInt(6) + 1) + " \n");
            }
            outFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println("Program execution continues...");
    }
}
