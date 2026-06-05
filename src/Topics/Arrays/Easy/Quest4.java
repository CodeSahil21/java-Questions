package Topics.Arrays.Easy;

import java.util.*;

//
//contain duplicate
public class Quest4 {
    public static void main(String[] args) {
        int[] arr = {1,3,2,1};
        System.out.println(containsDuplicate(arr));
    }
    public static boolean containsDuplicate(int[] nums) {
        //for this problem we sort the array
        Arrays.sort(nums);
//we check if nums[i] == nums[i-1] return true if it's there
        for (int i = 1; i < nums.length; i++) {
            //1,1,2,3
            if(nums[i]==nums[i-1]){
                return true;
            }
        }
        return false;
    }
    public static boolean containsDuplicate1(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // duplicate found
            }
            seen.add(num);
        }
        return false; // no duplicates
    }
    public static boolean containsDuplicateBrute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true; // duplicate found
                }
            }
        }
        return false; // no duplicates
    }
}
/*
1. The Brute Force: $O(n^2)$ Time, $O(1)$ SpaceAlways start here to establish the baseline logic.The Logic: "The simplest way is to compare every element with every other element using two nested loops."The Code (Mental or Snippet):Javafor (int i = 0; i < nums.length; i++) {
    for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] == nums[j]) return true;
    }
}
The Critique: "While this uses no extra memory, the quadratic time complexity makes it unusable for large arrays."2. The "Better" (Sorting): $O(n \log n)$ Time, $O(1)$ SpaceThis is a great "middle ground" to mention if the interviewer asks, "Can you do this without using extra space?"The Logic: "If we sort the array first, any duplicates will be forced to sit right next to each other."The Code:Java    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; i++) {
        if (nums[i] == nums[i + 1]) return true;
    }
    ```
*   **The Pitch:** "This improves our time to $O(n \log n)$. It's a great choice if memory is extremely limited, but we can still do better on time if we are willing to use a little space."

---

### 3. The Optimal (HashSet): $O(n)$ Time, $O(n)$ Space
Now, present the code you wrote as the final, most efficient time-based solution.

*   **The Narrative:** "To reach linear time, we need a way to 'remember' what we've seen before instantly. A **HashSet** is perfect for this because it gives us $O(1)$ average time complexity for both adding and checking elements."

```java
public static boolean containsDuplicate(int[] nums) {
    // We use a Set because it only stores unique elements
    HashSet<Integer> seen = new HashSet<>();

    for (int num : nums) {
        // If the number is already in the set, we found our duplicate
        if (seen.contains(num)) {
            return true;
        }
        // Otherwise, "remember" this number for later
        seen.add(num);
    }
    return false;
}
4. The Interviewer "Deep Dive"To wrap up, mention these two technical details to show you aren't just memorizing:Early Exit: Mention that your code is efficient because it returns true the moment it finds the first duplicate, rather than processing the entire array.The Set Add Trick: You can actually make the code slightly cleaner by using the boolean return of the .add() method.Pro Tip: if (!seen.add(num)) return true; (The add method returns false if the element was already present).
 */