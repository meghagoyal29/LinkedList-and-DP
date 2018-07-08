package LeetCode.linkedList;

public class MergekLists {

	public static void main (String[] args) {
		int[] input1 = {1,4,5};
		int[] input2 = {1,3,4};
		int[] input3 = {2,6};
		SinglyLinkedList list1 = new SinglyLinkedList();
		SinglyLinkedList list2 = new SinglyLinkedList();
		SinglyLinkedList list3 = new SinglyLinkedList();
		for(int i:input1) {
			list1.insert(i);
		}
		for(int j:input2) {
			list2.insert(j);
		}
		for(int j:input3) {
			list3.insert(j);
		}
		ListNode[] arr = new ListNode[3];
		arr[0]= list1.head;
		arr[1] = list2.head;
		arr[2] = list3.head;
		ListNode head3 = mergeKLists2(arr);
		if(head3!=null)
				head3.print();
			}
	
	public static ListNode mergeKLists(ListNode[] lists ) {
		ListNode answerNode = null;
		int min = Integer.MAX_VALUE;
		for(ListNode node: lists){
            if(node!=null && node.val < min) {
            	min=node.val;
            }
		}
            for(int i=0;i<lists.length;i++){
                if(lists[i]!= null && min == lists[i].val) {
               ListNode smallestNode = lists[i];
                answerNode = new ListNode(smallestNode.val);
                	lists[i]=smallestNode.next;
                	answerNode.next=(mergeKLists(lists));
                }
        }
		return answerNode;
}
	public static ListNode mergeKLists2(ListNode[] lists) {
		
		ListNode answerNode = null;
		ListNode head = answerNode;
		
		for(int i= 1;i<lists.length;i++) {
			ListNode node = lists[i];
			if(node.val>answerNode.val) {
				answerNode.next = node;
				node = node.next;
			}
		}
		return head;
	}
}
	
