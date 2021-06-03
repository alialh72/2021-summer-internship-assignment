# Game of Apps Development Intern Interview 2021

Thanks for your interest in the Game of Apps developer intern position! This repo contains a list of tasks for you to do, so we can get a gauge of your skill and abilities for the position.

You're expected to know the basics of the Git development workflow. If you would like a review, check out this [tutorial](https://www.raywenderlich.com/179717/open-source-collaboration-using-git-and-github).

## Instructions

Clone this repository to begin. 

The Algorithm section is mandatory for all applicants.

You need to complete at LEAST one of Android or HTML sections. You may attempt both sections and submit both, you will **not** be penalized if one language is weaker than the other. We are using it to gauge how we should spread the projects amongst the interns. If you are uncertain which section to complete, we recommend you to attempt both.

Commit your work to each section in a separate sub folder to your cloned repo, the submit your Git repo link (make sure its public!) to this [Google Form](https://forms.gle/W6NRZYwk936nEmvY6)

We expect each section to take around 1 hour to complete. Therefore should you complete all three sections, it may take around 3-4 hours. You may be faster or slower depending on your skillset. 


## Challenge 1: Algorithms (Required)

Your first challenge is to solve two algorithm questions. You'll be judged based on correctness, performance, and code readability. 

Please complete this section in Java.

Before each code block, please outline your approach/algorithm to solving the problem.
---
### Example of how each algorithm should be submitted: 

*Sample Question*: Write a GetNth() function that takes a linked list and an integer index and returns the data value stored in the node at that index position. 

#### You will be expected to submit something like the following:
*Algorithm*:
```
1. Initialize count = 0
2. Loop through the link list
     a. if count is equal to the passed index then return current
         node
     b. Increment count
     c. change current to point to next of the current.
```
*Implementation:*
```
...

static int GetNth(Node head, int n)
    {
        int count = 0;
        if (head == null) // edge case - if head is null
            return -1;
        // if count equal to n return node.data
        if (count == n)
            return head.data;
 
        // recursively decrease n and increase
        // head to next pointer
        return GetNth(head.next, n - 1);
    }

...
```
---
### Question 1: Find all pairs for a given sum

Create a function that accepts an array of integers and a target sum. The function will print all pairs of integers in the array whose sum is equal to the target sum. 

Feel free to expand the test cases and think of any edge cases.

Here's an example:

```java
int[] testArray = {2, 4, 5, 1, 3, 5, 4};
int targetSum = 6;
// Expected pairs are (to be printed on the console):
// (2, 4)
// (1, 5)

findPairs(testArray, targetSum);
```

Here's a function signature to start you off:

```java
void findPairs(int[] testArray, int targetSum) {
  // your code here
}
```

### Question 2: Reconcile Arrays

Given two unsorted integer arrays, print out the numbers that are NOT contained in the other array

*Input*: Two unique integer arrays, unsorted

*Output*: String in the format of 
```
Numbers in array a that aren't in array b: 
5

Numbers in array b that aren't in array a: 
6 10
```

Starting Code:
```java
void reconcileHelper(int[] a, int[] b) {
  // your code here
}
```

## Challenge 2: Android (Must complete at least one of challenge 2 or 3)

Your second challenge is to develop a small app from scratch. Here are the requirements:

- It should show a list of images.
- Tapping on an image should navigate to a new screen that shows the selected picture

### Notes:

- A good developer tries to write code that is easy to understand. The industry has a set of best practices that focus on writing easy to maintain code. Here's a set of guidelines on these best practices: [Java Style Guide](https://github.com/raywenderlich/java-style-guide).

## Challenge 3: HTML (Must complete at least challenge 2 or 3)

Convert the following figma design to a functioning webpage: [Figma](https://www.figma.com/file/cjFsTTzlsFnjW90fkbxloW/GOA-Front-End-Test-Mocks)

Files are located in a zip file in the git repo

### Requirements
* You can use any front end framework you choose, but we have a slight preference towards React, Angular, or Vanilla HTML/JS/CSS. However, use whatever framework you are comfortable with.
* Make it responsive using your best judgement.
* Create a simple transparent overlay for photos - use only vanilla JavaScript or what is built into the framework, do not import jQuery or any other external libraries for it.
* If you are using a framework, make sure you compile it down to static files and include that alongside your code with the submission.

Optional Extras: 
* Create some hover effect for the image thumbnails.
* Make the page the smallest possible size - ensure that images are properly optimized, resources minified, etc.
* Make images responsive as well.
* Add basic routing – make browser's back button work properly; open overlay based on URL.
* Any other flourishes you want to show off without compromising the original design.