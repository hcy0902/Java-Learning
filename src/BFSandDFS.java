import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSandDFS {

    //LC 733, 695, 559
    public static void main(String[] args) {

        //LC 733

        //695
        int [][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        //System.out.println(maxAreaOfIsland(grid));

        String n1 = "11";
        int n2 = Integer.parseInt(n1);
        System.out.println(n2);

    }

    //695 Find maxArea of Island
    static boolean seen [][];

    public static int maxAreaOfIsland(int[][] grid) {

        seen = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for (int i =0; i < grid.length; i++)
        {
            for (int j = 0; j< grid[0].length; j++)
            {
                if (grid[i][j] == 1)
                {
                    maxArea = Math.max(maxArea,findArea(grid, i, j) );
                }
            }
        }


        return maxArea;
    }


    public static int findArea (int[][] grid, int sr, int sc)
    {

        if (sr < 0 || sc< 0 || sr >= grid.length || sc >= grid[0].length
               || seen[sr][sc] || grid[sr][sc] != 1)
        {
            return 0;
        }

        seen[sr][sc] = true;

        return (1+ findArea(grid, sr-1, sc) + findArea(grid, sr+1, sc) + findArea(grid, sr, sc+1) + findArea(grid, sr, sc-1));


    }

    //LC 733 FloodFill
    public static int[][] floodFill (int[][] image, int sr, int sc, int newColor){

        if (image[sr][sc] == newColor)
        {
            return image;
        }
        fill(image, sr, sc, 1, 2);
        return image;


    }

    public static void fill(int[][] image, int sr, int sc, int color, int newColor)
    {

        // first we do a check on what situations we will skip the recursive fill
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length
            || image[sr][sc] != color)
        {
            return;
        }

        //first set the target to be new color
        image[sr][sc] = newColor;

        //do recursive fill on top, down, left, right directional fill
        fill(image, sr-1, sc, color, newColor);
        fill(image, sr+1, sc, color, newColor);
        fill(image, sr, sc-1, color, newColor);
        fill(image, sr, sc+1, color, newColor);
    }


    //LC 559 Find depth of the tree
    //BFS
    public static int bfsFindDepth(Node root)
    {
        //in BFS, we wanna loop through the tree and add each level into the queue

        //first create a queue, and define a int depth
        int depth = 0;
        Queue<Node> queue = new LinkedList<>();

        //Initially add root in it
        queue.offer(root);
        //Until it is empty, we keep looping
        while(!queue.isEmpty())
        {
            int size = queue.size();
            //loop through the size of the queue add all children to the queue
            for (int i =0; i < size; i++)
            {
                //get the currenNode from the queue
                Node currentNode = queue.poll();
                for (Node child:currentNode.children)
                {
                    queue.offer(child);
                }
            }

            //add depth by one for every level
            depth++;
        }

        return depth;

    }

    //DFW
    private static int max_Depth;
    public static int dfsFindDepth(Node root)
    {

        findDepth(root, 1);

        return max_Depth;
    }
    public static void findDepth(Node node, int depth)
    {
        //this will stop the recursive looping when find a leaf which does not have any children
        if (node == null)
        {
            return;
        }
        //loop through the node's children
        for (Node child:node.children)
        {
            findDepth(child, depth+1);
        }
        max_Depth = Math.max(max_Depth, depth);
    }





    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
