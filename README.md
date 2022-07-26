# 4-variations-of-QUICKSORT-implementation-and-performance-comparison

This is the first assessed exercise (out of two) of ADSE2 course in term 2 of year 2 in
Bsc Computing Science degree in the University of Glasgow that I have submitted on Friday 11th February, 2022.
This submission has received A4.

As can be seen in the pdf file called "AE1 -ADSE2 (originally provided)",
this assessed exercise is about:

1. Implementing four variants of the quicksort algorithm in Java, which are:

    - QUICKSORT with PARTITION implementing the right-most element pivot selection;
    
    - A variant of QUICKSORT which returns without sorting subarrays with fewer than k elements
      and then uses INSERTION-SORT to sort the entire nearly-sorted array;
      
    - A variant of QUICKSORT using the median-of-three partitioning scheme; and
    
    - 3-WAY-QUICKSORT.
   
   I have implemented these in the file "QuickSort.java".

2. Running empirical studies to compare the performance of each version of quicksort implemented in step 1. I have used:

    - Different cutoff values to compare each version of QuickSort;
    
    - Compared the runnning times of InsertionSort and MergeSort;
    
    - Compared running times of each version of QuickSort.
    
   I have implemented these in the file "TestSortingAlgorithms.java" and ran each algorithm with each of the
   provided text files of different sizes (intBig.txt, int1000.txt, int500k.txt, int20k.txt, dutch.txt)
   to test the running times of each algorithm in different scenarios.
   
   I have provided the explanation of comparing the performance of each algorithm in the pdf file named "Chae-Ryeong(Chloe) Yeo ADSE2 AE1".
   
3. Defining and implementing in Java an algorithm to compute adversaries for QuickSort, which involves:

    - Defining an algorithm to generate pathological input sequences for the quicksort algorithm, that
      is the instances that will require quadratic time to be sorted;
      
    - Using a median-of-three partitioning scheme (left, middle, right);
    
    - Assuming that duplicates are not allowed in the input array;
    
    - Explaining in the report how my algorithm operates and implementing it in Java.
   
   I have implemented this algorithm in "QuickSort.java" file under the function named "generateInputArray",
   and provided explanation of this implementation in the pdf file named "Chae-Ryeong(Chloe) Yeo ADSE2 AE1".
   
   
