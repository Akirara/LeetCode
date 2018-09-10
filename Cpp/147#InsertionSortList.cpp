/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* insertionSortList(ListNode* head) {
        ListNode *fakeHead = new ListNode(0);
        
        while (head != NULL) {
            ListNode *cur = fakeHead;
            
            while (cur -> next != NULL && cur -> next -> val < head -> val) {
                cur = cur -> next;
            }
            
            ListNode *tmp = head -> next;
            head -> next = cur -> next;
            cur -> next = head;
            head = tmp;
        }
        
        return fakeHead -> next;
    }
};
