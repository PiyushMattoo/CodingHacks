/*
https://leetcode.com/problems/add-two-numbers/description/
 */
package linkedlist;

/**
 *
 * @author mattoop
 */
public class AddTwoNumbers {
    
    public static void main(String[] str) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next = new ListNode(3);
        
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next = new ListNode(4);
        printNode(addTwoNumbers.addTwoNumbers(l1, l2));
    }
    
    private static void printNode(ListNode head) {
        while(head != null) {
            System.out.println(head.val + " ");
            head = head.next;
        }
        System.out.println(" ");
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode outputNode = null;    ListNode temp = null;
        int carry=0;    int firstVal=0; int secondVal = 0;  int sum = 0;
        
        while(l1 != null || l2 != null) {
            sum = (l1 != null? l1.val:0) + (l2 != null ? l2.val: 0) + carry;
            if(sum >10) 
                carry=1;
            sum = sum % 10;
            temp = new ListNode(sum);
            if(outputNode == null) {
                outputNode = temp;
            } else {
                outputNode.next = temp;
            }
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2.next != null) {
                l2 = l2.next;
            }
        }
        
        if(carry > 0) {
            outputNode.next = new ListNode(carry);
        }
        
        return outputNode;
    }
}
