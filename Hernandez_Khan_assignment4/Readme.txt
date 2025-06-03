Juan Hernandez
jmh86929@uga.edu

Danyal Khan
drk46099@uga.edu

How to Compile Experiment 1

Shell Script used is "./run.sh".
It contains:
    javac -d bin src/assignment4/Sort.java
    javac -d bin -cp bin src/assignment4/SortDriver.java
    java -cp bin assignment4.SortDriver <input file>

    *NOTE: input file is specified class path to file name

Running will have user request sorting algorithm to use. It will run said algorithm on
the file decided to be entered in the command line argument.

How to Compile Experiment 2

Shell Script used is ".selectSizeDriver.sh".
It contains:
    javac -d bin src/assignment4/Sort.java
    javac -d bin -cp bin src/assignment4/SelectSizeDriver.java
    java -cp bin assignment4.SelectSizeDriver

Running will have user request sorting algorithm to use and size of data to run it on.
It will sort the data and print the number of comparisons depending on input size.
All data in the array is randomly generated in no specific order within 0 to 9999.

Group Members Contributions

Danyal Khan was responsible for the Microsoft Excel task of making graphs and data table.
    He also prepared the report that showed the analysis and complexities of the results found from both
    Experiment 1 and Experiment 2 programming applications.

Juan Hernandez was responsible for setting up the program implementation for both Experiment 1 and Experiment 2.
    Calculated the number of comparisons for a various input size arguments. Ensured to follow the specifications
    and the format sought within the project requirements.

Both parties researched to find sorting algorithms, ideas on the programs implementation, and data represenation for the report.
    A balanced collaboration between both Juan Hernandez and Danyal Khan.

External Source Citations

    Link: https://www.youtube.com/watch?v=EwjnF7rFLns "Learn Selection Sort in 8 Minutes" by Bro Code
    Link: https://www.youtube.com/watch?v=3j0SWDX4AtU "Learn Merge Sort in 13 Minutes" by Bro Code
    Link: https://gist.github.com/metajungle/62bddff55708bf7a3da7 "QuickSort with 1st Element as Pivot" by Jakob Henriksson (metajungle)
    Link: https://www.geeksforgeeks.org/heap-sort/ "Heap Sort - Data Structures and Algorithms Tutorial" by GeeksForGeeks
    Link: https://www.geeksforgeeks.org/quicksort-using-random-pivoting/ "QuickSort using Random Pivoting" by GeeksForGeeks
