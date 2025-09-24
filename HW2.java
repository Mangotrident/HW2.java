import java.util.Stack;

public class HW2 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        int[] pushed1 = {2, 1, 3};
        int[] popped1 = {3, 2, 1};
        System.out.println(sol.isSameEventSequence(pushed1, popped1)); // false

        int[] pushed2 = {1, 2, 3};
        int[] popped2 = {1, 2, 3};
        System.out.println(sol.isSameEventSequence(pushed2, popped2)); // true

        int[] pushed3 = {1};
        int[] popped3 = {1};
        System.out.println(sol.isSameEventSequence(pushed3, popped3)); // true

        int[] pushed4 = {1, 2, 3, 4};
        int[] popped4 = {3, 4, 2, 1};
        System.out.println(sol.isSameEventSequence(pushed4, popped4)); // true
    }
}

class Solution {
    public boolean isSameEventSequence(int[] events_pushed, int[] events_popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0; 

        for (int x : events_pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < events_popped.length 
                   && stack.peek() == events_popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
