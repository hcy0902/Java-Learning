import java.util.LinkedList;
import java.util.Queue;

public class MoreBFSandDFW {

    public static void main(String[] args) {

    }

    //116 Populating next right pointers in Each Node
    //BFS
    public static Node connect(Node root)
    {
        if(root == null)
        {
            return root;
        }

        //have a queue to store every level of nodes

        Queue<Node> queue = new LinkedList<>();

        // add first node root
        queue.offer(root);

        while(!queue.isEmpty())
        {
            int size = queue.size();
            //initiate a node as previous to null
            Node previous = null;
            //loop through all nodes at a level
            for (int i = 0; i < size; i++)
            {
                //take the node from queue as current
                Node current = queue.poll();
                //for first round, the previous node is null, so this would get skipped
                if (previous != null)
                {
                    previous.next = current;
                }

                //Update previous as current
                previous = current;

                //if not the last level, offer the next level to queue. don't worry about last level
                // they are sorted by the level before them
                if (current.left != null)
                {
                    queue.offer(current.left);
                }
                if (current.right != null)
                {
                    queue.offer(current.right);
                }

            }

        }
        return root;

    }

    //116 DFS
    public static Node connectDFS(Node root)
    {
        // if root is null, or if at the last level, we don't care, just return
        if (root == null || root.left == null || root.right == null)
        {
            return root;
        }

        //this would always be true
        root.left.next = root.right;

        if (root.next != null)
        {
            root.right.next = root.next.left;
        }

        connectDFS(root.left);
        connectDFS(root.right);

        return root;


    }



    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


}
