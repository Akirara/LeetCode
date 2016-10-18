/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
    	int len = lists.length;
    	if(len == 0) {
    		return null;
    	}
    	if(len == 1) {
    		return lists[0];
    	}
    	if(len > 2) {
    		ListNode[] lists1 = new ListNode[len / 2];
    		ListNode[] lists2 = new ListNode[len - len / 2];
    		for(int i = 0; i < len / 2; ++i) {
    			lists1[i] = lists[i];
    		}
    		for(int j = 0, i = len / 2; i < len; ++i, ++j) {
    			lists2[j] = lists[i];
    		}
    		ListNode[] lists3 = new ListNode[2];
    		lists3[0] = mergeKLists(lists1);
    		lists3[1] = mergeKLists(lists2);
    		return mergeKLists(lists3);
    	}
    	ListNode head = new ListNode(0);
    	ListNode cur = head;
    	ListNode node1 = lists[0];
    	ListNode node2 = lists[1];
    	while(node1 != null && node2 != null) {
    		if(node1.val < node2.val) {
    			cur.next = node1;
    			node1 = node1.next;
    		}
    		else {
    			cur.next = node2;
    			node2 = node2.next;
    		}
    		cur = cur.next;
    	}
    	if(node1 != null) {
    		cur.next = node1;
    	}
    	else if(node2 != null){
    		cur.next = node2;
    	}
    	return head.next;
    }
}