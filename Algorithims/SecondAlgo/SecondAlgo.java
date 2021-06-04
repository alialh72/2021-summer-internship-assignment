
import java.util.Arrays;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

public class SecondAlgo {
    
    public static void main(String[] args) {
        int[] arr1 = {5, 2, 1, 7, 9, 19};
        int[] arr2 = {5, 2, 1, 7, 9, 10, 15};

        reconcileHelper(arr1, arr2);
    }

    public static void reconcileHelper(int[] a, int[] b) {
        
        /*
        1. Initialize the lists by converting the array to a list
            a. Also creating a templist that is a duplicate of listA
        2. Remove listB from listA
            a. listA will now only contain the variables that are in A and not in B
        3. Remove tempA from listB
            a. listB will now only contain the variables that are in B and not in A
            (the temp list was created as we already modified listA so we needed a duplicate)
        4. Convert the list to a string and remove the square brackets and commas
        5. Ouput the formatted String
        */

        // Initialize the lists using stream
        // Using .asList() on the arrays wouldnt work as it would return a List<int[]>
        List<Integer> listA = Arrays.stream(a).boxed().collect(Collectors.toList());  // converts the arrays into lists and assigns it to listA
        List<Integer> tempA = new ArrayList<>(listA);  // making a copy of listA and assigning it to tempA
        List<Integer> listB = Arrays.stream(b).boxed().collect(Collectors.toList());  // converts the arrays into lists and assigns it to listB

        // remove listB from listA
        listA.removeAll(listB);
        // remove the temp listA from listB
        listB.removeAll(tempA);

        // format string and output
        System.out.println("Numbers in array a that aren't in array b: ");
        System.out.println(listA.toString().replace("[", "").replace("]", "").replace(",", ""));  // remove brackets and commas from list as string
        System.out.println("\nNumbers in array b that aren't in array a: ");
        System.out.println(listB.toString().replace("[", "").replace("]", "").replace(",", ""));  // remove brackets and commas from list as string
    }

}
