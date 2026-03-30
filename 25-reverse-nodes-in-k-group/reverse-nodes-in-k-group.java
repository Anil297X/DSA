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
// class Solution {
//     public ListNode reverseKGroup(ListNode head, int k) {
//         if ( k <= 1 || head == null ) return head;
//         ListNode curr = head;
//         ListNode prev = null;
//         while ( true ){
//             ListNode last = prev;
//             ListNode newEnd = curr;
//             ListNode next = curr.next;
//             for( int i = 0; curr != null && i < right - left + 1; i++){
//                 curr.next = prev;
//                 prev = curr;
//                 curr = next;
//                 if( next != null){
//                     next = next.next;
//                 }
//             }

//         }
//     }
// }
class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {

            ListNode kth = groupPrev;

            for (int i = 0; i < k && kth != null; i++)
                kth = kth.next;

            if (kth == null)
                break;

            ListNode groupStart = groupPrev.next;
            ListNode nextGroup = kth.next;

            // reverse window
            ListNode prev = nextGroup;
            ListNode curr = groupStart;

            while (curr != nextGroup) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            groupPrev.next = kth;
            groupPrev = groupStart;
        }

        return dummy.next;
    }
}