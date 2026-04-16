/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        HashMap<Node, Node> nodeMap = new HashMap<>();
        // nodeMap.put(null, null);
        Node tmp = head;
        while (tmp != null) {
            Node newNode = new Node(tmp.val);
            nodeMap.put(tmp, newNode);
            tmp = tmp.next;
        }

        tmp = head;
        while (tmp != null) {
            Node newNode = nodeMap.get(tmp);
            newNode.next = nodeMap.get(tmp.next);
            newNode.random = nodeMap.get(tmp.random);
            tmp = tmp.next;
        }
        return nodeMap.get(head);
    }
}
