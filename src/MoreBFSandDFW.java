import java.util.LinkedList;
import java.util.Queue;

public class MoreBFSandDFW {


    //LC 116, 200, 547
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

    //LC 200 Number of Islands
    boolean seen[][];
    public int numIslands(char[][] grid) {

        int count = 0;
        seen = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1' && !seen[i][j]){
                    findIslands (grid, i,j );
                    count++;
                }
            }

        }

        return count;


    }

    private void findIslands(char[][] grid, int i, int j) {
        if (i<0 || j<0 || i>= grid.length || j>= grid[0].length || grid[i][j] == '0' || seen[i][j]) {
            return;
        }

        seen[i][j] = true;

        findIslands(grid, i+1, j);
        findIslands(grid, i-1, j);
        findIslands(grid, i, j+1);
        findIslands(grid, i, j-1);

    }


    //LC 547 Number of provinces
    boolean visited[];
    public int findCircleNum(int[][] isConnected) {

        int count = 0;
        visited = new boolean[isConnected.length];
        // we wanna first loop through each person
        for (int i = 0; i < isConnected.length; i++){
            if (!visited[i]){
                dfs(isConnected, i);
                count++;
            }
        }


        return count;

    }

    private void dfs(int[][] isConnected, int currentPerson) {
        // if we already visited this person, no need to find his connections
        if (visited[currentPerson] ){
            return;
        }

        visited[currentPerson] = true;

        // loop through this person's connections
        for (int j = 0; j < isConnected.length; j++){
            // if that node is 1, means we have a connection, keep finding this connected person's connections
            if (!visited[j] && isConnected[currentPerson][j] == 1){
                dfs(isConnected, j);
            }
        }

        return;

    }


}
