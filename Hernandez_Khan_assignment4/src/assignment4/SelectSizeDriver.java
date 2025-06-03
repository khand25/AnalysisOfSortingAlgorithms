package assignment4;

import java.util.*;

/** Driver Class to test specified size array with specified sorting algorithm. */
public class SelectSizeDriver {

    public static void main(String[] args) {
        //Scanner input = new Scanner(System.in);
        printMethods();
        runningProgram();

    } // main

    /** Prints sorting alogorthim options. */
    public static void printMethods() {
        System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) quick-sort-fp (q)"
            + " quick-sort-rp (r) ");
    } // printMethods

    /**
     * Asks user for specified sorting algorithm to use.
     * @return the String represenation of specified sorting
     */
    public static String choosingSort() {
        System.out.print("Enter the algorithm: ");
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        return command;
    } // choosingSort

    /**
     * Asks user for the specified size of data they want for sorting.
     * @return the int size of array
     */
    public static int choosingInputSize() {
        System.out.print("Enter the size of input: ");
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        return size;
    } // choosingInputSize

    /**
     * Runs the program that will run a sorting algorithm speicifed by user on a specified
     * user array size and prints the number of comparisons completed.
     */
    public static void runningProgram() {
        String sortType = choosingSort();
        int size = choosingInputSize();
        int[] numberData = new int[size];
        fillArray(numberData);
        if (sortType.equals("s")) {
            int numCompared = Sort.selectionSort(numberData);
            System.out.println("#Selection-sort comparisons: " + numCompared);
        } else if (sortType.equals("m")) {
            int numCompared = Sort.mergeSort(numberData,0);
            for (int element : numberData) {
                System.out.print(element + " ");
            }
            System.out.println("\n#Merge-sort comparisons: " + numCompared);
        } else if (sortType.equals("q")) {
            Sort.quickSortFP(numberData, 0, numberData.length - 1);
            for (int element : numberData) {
                System.out.print(element + " ");
            }
            System.out.println("\n#Quick-sort-fp comparisons: " + Sort.numberOfComparisons);
        } else if (sortType.equals("h")) {
            Sort.heapSort(numberData);
            for (int element : numberData) {
                System.out.print(element + " ");
            }
            System.out.println("\n#Heap-sort comparisons: " + Sort.numberOfComparisons);
        } else if (sortType.equals("r")) {
            Sort.quickSortRP(numberData, 0, numberData.length - 1);
            for (int element : numberData) {
                System.out.print(element + " ");
            }
            System.out.println("\nQuick-sort-rp comparisons: " + Sort.numberOfComparisons);
        }
    } // runningProgram

    /**
     * Filling array with inputs of 0 to 10,000 (exclusive).
     * @param numberData - an empty array with user specified size
     */
    public static void fillArray(int[] numberData) {
        for (int i = 0; i < numberData.length; i++) {
            numberData[i] = (int) (Math.random() * 10000);
        }
    } // fillArray

} // SelectedSizeDriver
