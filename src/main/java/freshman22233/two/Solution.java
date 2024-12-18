package freshman22233.two;

/**
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order,
 * and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Initialize a dummy node, which will help us easily return the result
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;

            carry = sum / 10;           // Compute carry for next iteration
            int digit = sum % 10;       // Compute the digit to store

            current.next = new ListNode(digit);
            current = current.next;     // Move forward

            // Advance the pointers of l1 and l2 if they exist
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // The dummy node's next pointer points to the head of the result list
        return dummy.next;
    }

    // Helper method: convert an array of digits into a linked list
    // The array is assumed to be in the order of least-significant digit first (as per problem statement)
    private ListNode buildList(int[] digits) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int d : digits) {
            current.next = new ListNode(d);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method: print the linked list in a readable format
    private void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }

    // Helper method to compare the linked list with an expected array.
    // Returns true if they represent the same sequence of digits; false otherwise.
    private boolean isEqual(ListNode node, int[] arr) {
        int i = 0;
        while (node != null && i < arr.length) {
            if (node.val != arr[i]) {
                return false;
            }
            node = node.next;
            i++;
        }
        // Both the linked list and array should end at the same time
        return (node == null && i == arr.length);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1:
        // Input: l1 = [2,4,3], l2 = [5,6,4]
        // Expected output: [7,0,8]
        int[] arr1 = {2,4,3};
        int[] arr2 = {5,6,4};
        int[] expected1 = {7,0,8};
        ListNode l1 = solution.buildList(arr1);
        ListNode l2 = solution.buildList(arr2);
        ListNode result = solution.addTwoNumbers(l1, l2);
        System.out.println(solution.isEqual(result, expected1)); // should print true

        // Test case 2:
        // Input: l1 = [0], l2 = [0]
        // Expected output: [0]
        int[] arr3 = {0};
        int[] arr4 = {0};
        int[] expected2 = {0};
        l1 = solution.buildList(arr3);
        l2 = solution.buildList(arr4);
        result = solution.addTwoNumbers(l1, l2);
        System.out.println(solution.isEqual(result, expected2)); // should print true

        // Test case 3:
        // Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        // Expected output: [8,9,9,9,0,0,0,1]
        int[] arr5 = {9,9,9,9,9,9,9};
        int[] arr6 = {9,9,9,9};
        int[] expected3 = {8,9,9,9,0,0,0,1};
        l1 = solution.buildList(arr5);
        l2 = solution.buildList(arr6);
        result = solution.addTwoNumbers(l1, l2);
        System.out.println(solution.isEqual(result, expected3)); // should print true

        // Additional test case:
        // Input: l1 = [1,8], l2 = [0]
        // Expected output: [1,8]
        int[] arr7 = {1,8};
        int[] arr8 = {0};
        int[] expected4 = {1,8};
        l1 = solution.buildList(arr7);
        l2 = solution.buildList(arr8);
        result = solution.addTwoNumbers(l1, l2);
        System.out.println(solution.isEqual(result, expected4)); // should print true

        // A failing test for demonstration:
        // Input: l1 = [2], l2 = [5]
        // sum = [7]
        // but we will compare to [8] to see it print false
        int[] arr9 = {2};
        int[] arr10 = {5};
        int[] expected5 = {8};
        l1 = solution.buildList(arr9);
        l2 = solution.buildList(arr10);
        result = solution.addTwoNumbers(l1, l2);
        System.out.println(solution.isEqual(result, expected5)); // should print false
    }
}
