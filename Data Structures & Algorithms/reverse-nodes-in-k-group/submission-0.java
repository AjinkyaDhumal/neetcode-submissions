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

 /**
 Few imp things to do here -
 0. Mark dummy to -1th and groupPrev to dummy
 1. Get Kth element
 2. Mark groupNext to kth.next
 3. Reverse kth group. Mark prev to kth.next and curr to groupPrev.next
    while (curr != groupNext) .. reverse;
 4. Mark groupPrev.next to kth after inversion 
    & shift group.Prev to earlier GroupPrev.next
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
    // create dummy node and point its next to head
    // save groupPrev to dummy
    ListNode dummy = new ListNode(0, head);
    ListNode groupPrev = dummy;

    while (true) {

        // take kth node getKth(groupPrev, k), if k == null break;
        ListNode kth = getKth(groupPrev, k);
        if (kth == null) break;
        
        ListNode groupNext = kth.next;

        // reverse k nodes -> prev = kth.next, curr = groupPrev.next
        ListNode prev = kth.next;
        ListNode curr = groupPrev.next;
        while (curr != groupNext) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        // Point groupPrev.next to k
        // move groupPrev to k
        ListNode tmp = groupPrev.next;
        groupPrev.next = kth;
        groupPrev = tmp;
    }
    return dummy.next;
}

    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
