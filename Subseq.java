package com.questions.hard;
import java.util.*;

public class Subseq {
    public static void main(String[] args) {
        // Iterative program to print subsequences
        //In main we have the array and now start reading it from pull function


        int[] arr = {1,2,3};
         List<List<Integer>> ans = pull(arr);// adding outer list to it
        System.out.println(ans);

    }
    static List<List<Integer>> pull(int[] arr){
        //In this program we are going to take a list inside list in order to create a subset
        //At first  we are going to have an empty list called outer list


        List<List<Integer>> outer = new ArrayList<>();// creating an empty list <outer> *imagine* ( [] )

        outer.add(new ArrayList<>());// This statement adds the new empty list to our <outer> list *imagine* ( [ [] ] )

        for(int num : arr){
            int n = outer.size();// taking size of the <outer> list that will be 1 at the start

            for(int i =0; i<n; i++)// loop for further adding elements and previous <outer> list to it
            {
                List<Integer> internal = new ArrayList<>(outer.get(i)); // creating an <internal> List and adding the copy of the previous outer list to it

                internal.add(num); //adding new  elements to the internal list
                outer.add(internal);// now adding that internal list to the main outer list

            }



        }

        return outer; // returning the list
        //for more understanding try to debug the program



    }
}
