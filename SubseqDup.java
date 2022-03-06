package com.questions.hard;

import java.io.*;
import java.util.*;

public class SubseqDup {
// Iterative subSeq for duplicate number
    //for this program we have 2 key points.
//--In this program we have to add the duplicate number to the newly created subset of the previous steps
// --because of above step duplicates have to be together.
// -* If you want to make the duplicates together you can sort the  array
public static void main(String[] args) {
    int[] arr = {1,2,2};
    List<List<Integer>> ans = pull(arr);// adding outer list to it
    System.out.println(ans);
}


    //In this program we are going to take a list inside list in order to create a subset
    //At first  we are going to have an empty list called outer list
    static List<List<Integer>> pull(int[] arr) {

    Arrays.sort(arr);


    List<List<Integer>> outer = new ArrayList<>();// creating an empty list <outer> *imagine* ( [] )

    outer.add(new ArrayList<>());// This statement adds the new empty list to our <outer> list *imagine* ( [ [] ] )
    int start = 0;
    int end = 0;

    for (int i = 0; i < arr.length; i++) {
        start = 0;
        //if current and previous element is same then, s = e + 1
        if (i > 0 && arr[i] == arr[i - 1]) {
            start = end + 1;
        }
        end = outer.size() - 1;
        int n = outer.size();// taking size of the <outer> list that will be 1 at the start

        for (int j = start; j < n; j++)// loop for further adding elements and previous <outer> list to it
        {
            List<Integer> internal = new ArrayList<>(outer.get(j)); // creating an <internal> List and adding the copy of the previous outer list to it

            internal.add(arr[i]); //adding new  elements to the internal list
            outer.add(internal);// now adding that internal list to the main outer list

        }


    }

    return outer; // returning the list
    //for more understanding try to debug the program
}
}
