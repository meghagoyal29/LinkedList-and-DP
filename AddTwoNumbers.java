package LeetCode.linkedList;

public class AddTwoNumbers {
	
	public static void main (String[] args) {
		int[] input1 = {5};
		int[] input2 = {5};
		SinglyLinkedList list1 = new SinglyLinkedList();
		SinglyLinkedList list2 = new SinglyLinkedList();
		for(int i:input1) {
			list1.insert(i);
		}
		for(int j:input2) {
			list2.insert(j);
		}
		ListNode head3 = addTwoNumbers(list1.head,list2.head,0);
		head3.print();
			}
	
	    public static ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {

	    	if(l1==null && l2==null && carry==0)
	    		return null;
	    		int sum = (l1==null?0:l1.val)+(l2==null?0:l2.val)+carry;
	    		ListNode answerNode = new ListNode(sum%10);	
	    		carry = sum/10;
	    		answerNode.next = addTwoNumbers(l1==null?null:l1.next,l2==null?null:l2.next,carry);
	    		return answerNode;
	    			    
	    }
}

class SinglyLinkedList{
	ListNode head;
	public void insert(int x) {
		ListNode node = new ListNode(x);
		if(head == null) {
			head = node;
		}
		else{
		ListNode q = head;
			while(q.next!=null) {
				q=q.next;
			}
			q.next = node;
		}
	}
	
	
}
//* Definition for singly-linked list.
	  class ListNode implements Comparable<ListNode>{
	      int val;
	      ListNode next;
  ListNode(int x) { val = x; }
	 
	  public void print(){
			ListNode q = this;
			while(q.next!=null) {
				System.out.print(q.val+"->");
				q=q.next;
			}
			System.out.print(q.val);
		}

	@Override
	public int compareTo(ListNode o) {
		return this.val-o.val;
	}
	  }
	 