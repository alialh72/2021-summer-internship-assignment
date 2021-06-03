import java.io.*;
import java.util.*; 
import java.util.HashSet;
import java.util.stream.Collectors;

class FirstAlgo {
  public static void main(String args[]) { 
    int[] numbers = { 2, 4, 5, 1, 3, 5, 4 }; 
    int maxSum = 6;
    findPairsTest(numbers, maxSum); 
  } 
  
 
  public static void findPairs(int[] array, int sum) { 

    /*
    1. Initialise Hashmap
    2. Loop through the array
      a. for each element, loop through all the elements ahead of it
      b. if the 2 elements selected add up to sum, assign them to smallNum and bigNum 
      c. put the elements into the hashmap, smallNum then bigNum (this makes it easier to check for duplicates)
      d. the hashmap will automatically not allow any duplicates to be added
    3. Loop through the hashmap entryset
      a. Output the pairs in the correct format
    */


    HashMap<Integer, Integer> pairs = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        // check if the 2 selected elements add up to the sum
        if ((array[i] + array[j]) == sum) {
          // assign the 2 elements to their respective variables by their size
          int smallNum = Math.min(array[i], array[j]);  // returns the smaller of the 2 numbers
          int bigNum = Math.max(array[i], array[j]);  // returns the larger of the 2 numbers
          pairs.put(smallNum, bigNum);  // add it to the hashmap
          //the hashmap wont allow any duplicates to be added
        }
      }
    }

    // loop through the hashmap entryset
    // looping through the entryset instead of using the keyset saves time when outputting values (you dont have to use .get() on the hashmap)
    for (Map.Entry<Integer, Integer> entry : pairs.entrySet()) {
      System.out.println("("+entry.getKey() + ", " + entry.getValue() + ")");  // output the string in the correct format
    }
          
  } 



  public static void findPairsTest(int[] array, int sum) { 

    /*
    1. Create arraylist 'pastNums' and hashmap 'pairs'
    2. loop through 'array'
      a. assign the current number to 'currentNum'
      b. assign the required matching pair to 'difference' by subtracting 'currentNum' from 'sum'
      c. check if the array 'pastNums' already contains the matching pair
        i. assign 'difference' and 'currentNum' to smallNum and bigNum depending on which is bigger/smaller
        ii. input 'smallNum' and 'bigNum' into the hashmap (ordering them makes it easier to check for duplicates as the hashmap can remove them automatically)
      d. add the currentNum to the arrayList 'pastNums'
    3. loop through the entrySet of the hashmap 'pairs'
      a. output the entrykey and entryvalue formatted correctly
      (iterating through entryset instead of keyset is more efficient as you dont have to call .get() on the hashmap)
    */

    // create an empty set and hashmap
    ArrayList<Integer> pastNums = new ArrayList<>();
    HashMap<Integer, Integer> pairs = new HashMap<>();
 
    // do for each element
    for (int i = 0; i < array.length; i++) {
      int currentNum = array[i];
      int difference = sum - array[i];

      // if the difference is seen before, add the pair to the hashmap
      if (pastNums.contains(difference)) {
        // assign the currentNum and difference to the respective variables based on their value
        int smallNum = Math.min(difference, currentNum);  // returns the smaller of the 2 nums
        int bigNum = Math.max(difference, currentNum);  // returns the larger of the 2 nums
        pairs.put(smallNum, bigNum);  //adds the numbers to the hashmaps (smaller, bigger)

        // ordering the pairs by size makes it easier to check for duplicates 
      }

      // store the currentNum in the arraylist
      pastNums.add(currentNum);
    }

    // loop through the hashmap entryset
    // looping through the entryset instead of using the keyset saves time when outputting values (you dont have to use .get() on the hashmap)
    for (Map.Entry<Integer, Integer> entry : pairs.entrySet()) {
      System.out.println("("+entry.getKey() + ", " + entry.getValue() + ")");  // output the string in the correct format
    }
          
  } 

}


