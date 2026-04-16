/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        // Divide the list into 2, reach slow pointer to half.
        // Note, we are making first half greater than second half in case of odd length
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Break the links of both the lists
        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;

        // reverse the second half of the list for traversal
        while (second != null) {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        // traverse the second half of list and merge it with first half one by one
        // traversing the second half because second half could be smaller than first
        while (prev != null) {
            ListNode tmpFirst = head.next;
            ListNode tmpSecond = prev.next;
            head.next = prev;
            prev.next = tmpFirst;
            head = tmpFirst;
            prev = tmpSecond;
        }
    }
}
