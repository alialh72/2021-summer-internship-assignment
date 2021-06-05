import java.util.*; 


class FirstAlgo {
  public static void main(String args[]) { 
    int[] numbers = { 2, 4, 5, 1, 3, 5, 4 }; 
    int maxSum = 6;
    findPairs(numbers, maxSum); 
  } 

  public static void findPairs(int[] array, int sum) { 

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

    // create an empty list and hashmap
    ArrayList<Integer> pastNums = new ArrayList<>();
    HashMap<Integer, Integer> pairs = new HashMap<>();
 
    // loop through array
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


