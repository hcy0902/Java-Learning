import java.util.*;

public class MoreBFSandDFW {


    //LC 116, 200, 547, 117, 572, 1091, 130, 797
    public static void main(String[] args) {

        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);

        List<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(2);

        List<List<Integer>> c = new ArrayList<>();
        c.add(a);
        c.add(b);

        List<Integer> d = new ArrayList<>();
        d.add(1);
        d.add(3);
        d.add(2);

        System.out.println(sort(d));

        System.out.println(c.contains(d));

    }

    public static List<Integer> sort (List<Integer> result){
        Integer[] arr = new Integer[result.size()];
        for(int i = 0; i < result.size(); i++){
            arr[i] = result.get(i);
        }

        Arrays.sort(arr);

        return Arrays.asList(arr);
    }

    //116 Populating next right pointers in Each Node
    //BFS
    public static Node connect2(Node root)
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

    //LC117 Populating Next right pointers in each Node 2
    public Node connect(Node root){

        //use bfs, queue, use null to mark every level's end

        if (root == null){
            return null;
        }

        Queue <Node> nodes = new LinkedList<>();
        nodes.add(root);
        nodes.add(null);

        while(!nodes.isEmpty()){
            Node current = nodes.poll();
            if (current != null){
                current.next = nodes.peek();
                if (current.left != null){
                    nodes.add(current.left);
                }
                if (current.right != null){
                    nodes.add(current.right);
                }
            }else{// we know we are reaching to an end, if nodes is not empty, means we need to add a null for next level
                if (!nodes.isEmpty()){
                    nodes.add(null);
                }
            }




        }
        return root;
    }

    //LC 572 Subtree of another tree
    public boolean isSubtree(TreeNode root, TreeNode subRoot){

        if (root == null){
            return false;
        }else if(isIdentical(root, subRoot)){
            return true;
        }else{
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }



    }

    public boolean isIdentical(TreeNode root, TreeNode subRoot){
        if (root == null || subRoot == null){
            return root == null && subRoot == null;
        }else if (root.val == subRoot.val){
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }else{
            return false;
        }
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


  //LC 1091 Shortest Path in Binary Matrix
    public int shortestPthBinaryMatrix(int[][] grid){

        if(grid[0][0] == 1){
            return -1;
        }

        // we need a queue to mark each block with its coordinates and steps at the block
        Queue<int[]> coordinates = new LinkedList<>();
        coordinates.add(new int[]{0,0,1}); // we add our starting block 0,0 with step 1
        //mark the current block as 1, so that we don't come back check again
        grid[0][0] = 1;
        //eight directions
        int[][] dir = {{0,1},{-1,0},{1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};

        while(!coordinates.isEmpty()){

            //poll current block
            int[] current = coordinates.poll();
            //if current block is the destination, we return the step
            if (current[0] == grid.length-1 && current[1] == grid[0].length-1){
                return current[2];
            }

            //find eight directions blocks see if they are 0
            for(int[] d:dir){
                int r = d[0] + current[0];
                int c = d[1] + current[1];
                //if within range
                if (r >= 0 && c >= 0 && r< grid.length && c<grid[0].length){
                    // if the neighbor block is value 0, we add it to the coordinates, and mark it to 1
                    if(grid[r][c] == 0){
                        coordinates.add(new int[]{r, c, current[2]+1});
                        grid[r][c] = 1;
                    }
                }
            }
        }

        // if going through the loop still not return anything, we cannot find a path
        return -1;

    }

    //LC 130. Surrounded Regions
    public void solve(char[][] board) {

        // The idea is to first find all boundry blocks that are Os, mark them to a special char, and then loop
        //through all to change rest Os to Xs, and special chars back to Os

        for (int i = 0; i < board.length;  i++){
            if (board[i][0] == 'O'){
                dfs(board, i, 0);
            }
            if (board[i][board[0].length-1] == 'O'){
                dfs(board, i, board[0].length-1);
            }
        }

        for (int j = 0; j<board[0].length; j++){
            if (board[0][j] == 'O'){
                dfs(board, 0, j);
            }
            if (board[board.length-1][j] == 'O'){
                dfs(board, board.length-1, j);
            }
        }

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j<board[0].length; j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if (board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }

    }

    public void dfs(char[][] board, int i, int j){
        if (i <0 || j<0 || i>= board.length || j>= board[0].length || board[i][j] != 'O'){
            return;
        }

        // set current block to special char
        board[i][j] = '*';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);

    }



}
