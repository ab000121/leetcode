/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return null;

        Node currNode = head;
        
        while(currNode != null){

            if(currNode.child != null){
                Node next = currNode.next;
                currNode.next = flatten(currNode.child);
                currNode.child.prev = currNode;
                currNode.child = null;


                while(currNode.next != null){
                    currNode = currNode.next;
                }

                if(next != null){
                    currNode.next = next;
                    next.prev = currNode;
                }
            }
            currNode = currNode.next;
        }


        return head;
    }
}