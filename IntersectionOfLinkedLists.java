package LeetCode.linkedList;

public class IntersectionOfLinkedLists {
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null|| headB==null)
			return null;
		// get to the end of both LinkedLists. If they intersect, 
		 //their end will be the same. Also count the length at the same time
		 ListNode q1 = headA;
		 ListNode q2 = headB;
		 int size1=0;
		 int size2=0;
		 while(q1.next!=null) {
			 q1=q1.next;
			 size1++;
		 }
		 while(q2.next!=null) {
			 q2=q2.next;
			 size2++;
		 }
		 
		 if(q1!=q2)
			 return null;
		 
		 int minSize  = Math.min(size1, size2);
		 ListNode newHeadA = headA;
		 ListNode newHeadB = headB;
		 for(int i=0; i<size1-minSize;i++) {
			 newHeadA=newHeadA.next;
		 }
		 for(int i=0; i<size2-minSize;i++) {
			 newHeadB=newHeadB.next;
		 }
		 while(newHeadA!=newHeadB) {
			 newHeadA=newHeadA.next;
			 newHeadB=newHeadB.next;
		 }
		return newHeadB;
	        
	    }
}
