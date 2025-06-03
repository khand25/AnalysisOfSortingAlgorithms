package assignment4;

import java.util.Random;

/** Methods for Sorting Algorthims. */
public class Sort {

    public static long numberOfComparisons;

    /**
     * Sorts data using selection sort algorithm.
     * Credit to Youtuber Bro Code - Learn Selection Sort in 8 Minutes
     * @param unsortedData - hold elements of the input file chosen
     * @return the number of comparisons
     */
    public static int selectionSort(int[] unsortedData) {
        int numberOfComparisons = 0; // variable used to keep track of comparisons
        for (int i = 0; i < unsortedData.length - 1; i++) {
            int min = i; // stores index of min element
            for (int j = i + 1; j < unsortedData.length; j++) {
                numberOfComparisons++; // regardless if we finad a new min a comparison is made
                if (unsortedData[min] > unsortedData[j]) {
                    min = j; // this is used to update new minimum index found
                } // if
            } // innerLoop
            int temp = unsortedData[i]; // used to store old value that will be swapped
            unsortedData[i] = unsortedData[min];
            unsortedData[min] = temp;
        } // outerLoop

        // Loop used to print out all elements in the current sorted array
        for (int element: unsortedData) {
            System.out.print(element + " ");
        } // forLoop
        System.out.println();
        return numberOfComparisons;
    } // selectionSort

    /**
     * Sorts data using merge sort algorithm.
     * Credits to Youtuber Bro Code - Learn Merge Sort in 13 Minutes
     * @param unsortedData - holds elements of the input file chosen
     * @param numberOfComparisons - number of comparisons
     * @return the number of comparisons
     */
    public static int mergeSort(int[] unsortedData, int numberOfComparisons) {
        int length = unsortedData.length;
        if (length <= 1) {
            return numberOfComparisons;
        }
        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];
        int i = 0; // i is used for indexes of left array
        int j = 0; // j is used for indexes of right array
        for (; i < length; i++) {
            if (i < middle) {
                leftArray[i] = unsortedData[i];
            } else {
                rightArray[j] = unsortedData[i];
                j++;
            }
        }
        numberOfComparisons = mergeSort(leftArray, numberOfComparisons);
        numberOfComparisons = mergeSort(rightArray, numberOfComparisons);
        numberOfComparisons = merge(leftArray, rightArray, unsortedData, numberOfComparisons);
        return numberOfComparisons;
    } // mergeSort

    /**
     * Merge two separate arrays together.
     * @param leftArray - data of left array
     * @param rightArray - data of right array
     * @param unsortedData - unsorted data
     * @param numberOfComparisons - number of comparisons
     * @return numberOfComparisons completed
     * Credits to Youtuber Bro Code - Learn Merge Sort in 13 minutes
     */
    private static int merge(int[] leftArray, int[] rightArray, int[] unsortedData,
                             int numberOfComparisons) {
        int leftSize = unsortedData.length / 2;
        int rightSize = unsortedData.length - leftSize;
        int i = 0; // original array index
        int l = 0; // left array index
        int r = 0; // right array index
        while (l < leftSize && r < rightSize) {
            if (leftArray[l] < rightArray[r]) {
                numberOfComparisons++;
                unsortedData[i] = leftArray[l];
                i++;
                l++;
            } else {
                unsortedData[i] = rightArray[r];
                i++;
                r++;
                numberOfComparisons++;
            }
        }
        while (l < leftSize) {
            unsortedData[i] = leftArray[l];
            i++;
            //numberOfComparisons++;
            l++;
        }
        while (r < rightSize) {
            unsortedData[i] = rightArray[r];
            i++;
            r++;
            //numberOfComparisons++;
        }
        return numberOfComparisons;
    } // merge

    /**
     * Quick sort the given array starting from index
     * {@code l} to {@code r}.
     *
     * Uses the first element in the array as the pivot
     *
     * @param array
     * @param l
     * @param r
     * Credit to Jakob Henriksson (metajungle) GitHub QuickSort.java
     */
    public static void quickSortFP(int[] array, int l, int r) {
        if (l < r) {
            // select pivot element (left-most)
            int pivot = array[l];
            // partition and shuffle around pivot
            int i = l;
            int j = r;
            while (i < j) {
                numberOfComparisons++;
                // move right to avoid pivot element
                i += 1;
                // scan right: find elements greater than pivot
                while (i <= r && array[i] < pivot) {
                    numberOfComparisons++;
                    i += 1;
                }
                // scan left: find elements smaller than pivot
                while (j >= l && array[j] > pivot) {
                    numberOfComparisons++;
                    j -= 1;
                }
                if (i <= r && i < j) {
                    // swap around pivot
                    swap(array, i, j);
                }
            }
            // put pivot in correct place
            swap(array, l, j);
            // sort partitions
            quickSortFP(array, l, j - 1);
            quickSortFP(array, j + 1, r);
        }
    }

    /**
     * Swap elements at indexes {@code i} and {@code j}
     * in the give array.
     *
     * @param array
     * @param i
     * @param j
     * Credit to Jakob Henriksson (metajungle) GitHub QuickSort.java
     */
    private static void swap(int[] array, int i, int j) {
        if (i >= 0 && j >= 0 && i < array.length && j < array.length) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }

    /**
     * To heapify a subtree rooted with node i which is
     * an index in arr[]. n is size of heap.
     * @param arr - data
     * @param N - size of heap
     * @param i - node of subtree to heapify
     * Credit to GeeksForGeeks Heap Sort - Data Structures and Algorithms Tutorials
     */
    public static void heapify(int[] arr, int N, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < N && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            numberOfComparisons++;
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest);
            numberOfComparisons++;
        }
    }

    /**
     * Main function to do heap sort.
     * @param arr - data
     * Credit to GeeksForGeeks Heap Sort - Data Structures and Algorithms Tutorials
     */
    public static void heapSort(int[] arr) {
        int N = arr.length;

        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--) {
            numberOfComparisons++;
            heapify(arr, N, i);
        }
        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            numberOfComparisons++;
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    /**
     * This Function helps in calculating
     * random numbers between low(inclusive)
     * and high(inclusive).
     * @param arr - data
     * @param low - the smallest index
     * @param high - the highest index
     * Credit to GeeksForGeeks QuickSort using Random Pivoting
     */
    static void random(int[] arr,int low,int high) {

        Random rand = new Random();
        int pivot = rand.nextInt(high - low) + low;

        int temp1 = arr[pivot];
        arr[pivot] = arr[high];
        arr[high] = temp1;
    }

    /**
     * This function takes last element as pivot,
     * places the pivot element at its correct
     * position in sorted array, and places all
     * smaller (smaller than pivot) to left of
     * pivot and all greater elements to right
     * of pivot.
     * @param arr - data
     * @param low - smallest index in data
     * @param high - highest index in data
     * @return the partition index
     * Credit to GeeksForGeeks QuickSort using Random Pivoting
     */
    static int partitionRP(int[] arr, int low, int high) {
        // pivot is chosen randomly
        random(arr,low,high);
        int pivot = arr[high];


        int i = (low - 1); // index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            numberOfComparisons++;
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * The main function that implements QuickSort()
     * arr[] -- Array to be sorted,
     * low -- Starting index,
     * high -- Ending index.
     * @param arr - data
     * @param low - smallest index of data
     * @param high - highest index of data
     * Credit to GeeksForGeeks QuickSort using Random Pivoting
     */
    public static void quickSortRP(int[] arr, int low, int high) {

        if (low < high) {
            /* pi is partitioning index, arr[pi] is
            now at right place */
            int pi = partitionRP(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSortRP(arr, low, pi - 1);
            quickSortRP(arr, pi + 1, high);
        }
    }

} // Sort
