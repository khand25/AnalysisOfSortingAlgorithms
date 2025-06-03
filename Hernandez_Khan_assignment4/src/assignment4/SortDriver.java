package assignment4;

import java.util.Scanner;
import java.io.*;

/** Class Driver to run such sorting algorithms with user input on a array of ints. */
public class SortDriver {

    public static void main(String[] args) {
        runningProgram(args);
    } // main

    /**
     * Runs the program to test sorting algorithms on data.
     * @param args - String array holding name of file to take info from
     */
    public static void runningProgram(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("selection-sort (s) merge-sort (m) heap-sort (h) quick-sort-fp (q) ");
        System.out.println("quick-sort-rp (r)");
        int[] numberData = readFile(args);
        if (numberData == null) {
            System.exit(0);
        }
        System.out.print("Enter the algorithm: ");
        String command = userInput.next();
        if (command.equals("s")) {
            int numberOfComparisons = Sort.selectionSort(numberData);
            System.out.println("#Selection-sort comparisons: " + numberOfComparisons);
        } else if (command.equals("m")) {
            //int[] test = {8,2,5,3,4,7,6,1};
            int numberOfComparisons = Sort.mergeSort(numberData,0);
            //System.out.println("PRINTING RESULTS OF MERGE SORT");
            for (int element: numberData) {
                System.out.print(element + " ");
            }
            System.out.println();
            System.out.println("#Merge-sort comparisons: " + numberOfComparisons);
        } else if (command.equals("q")) {
            Sort.quickSortFP(numberData, 0, numberData.length - 1);
            for (int element: numberData) {
                System.out.print(element + " ");
            }
            System.out.println();
            System.out.println("#Quick-sort-fp comparisons: " + Sort.numberOfComparisons);
        } else if (command.equals("h")) {

            Sort.heapSort(numberData);
            for (int element: numberData) {
                System.out.print(element + " ");
            }
            System.out.println();
            System.out.println("#Heap-sort comparisons: " + Sort.numberOfComparisons);


        } else if (command.equals("r")) {
            Sort.quickSortRP(numberData, 0, numberData.length - 1);
            for (int element: numberData) {
                System.out.print(element + " ");
            }
            System.out.println();
            System.out.println("#Quick-sort-rp comparisons: " + Sort.numberOfComparisons);
        }
    }

    /**
     * Reads the information within file.
     * @param arguments - String array with name of file to take info from
     * @return an array with the data from file
     */
    public static int[] readFile(String[] arguments) {
        int[] unsortedData = new int[10000];
        try {
            Scanner reader = new Scanner(new FileInputStream(arguments[0]));
            int index = 0;
            while (reader.hasNext() && index < unsortedData.length) {
                int x = reader.nextInt();
                unsortedData[index] = x;
                index++;
            }
            reader.close();
            return unsortedData;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Not able to read and open input file correctly!");
            return null;
        } catch (Exception e) {
            System.out.println("Something went wrong with your file!");
            return null;
        }
    } // readFile

} // SortDriver
