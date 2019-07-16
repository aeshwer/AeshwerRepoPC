//https://www.youtube.com/watch?v=2tpcqDmvJBU
//SOLUTION
//https://hackerranksolutionc.blogspot.com/2017/08/evaluate-expression-tree.html

//Go to leaf nodes get their values and then check for expression (*/-+) evaluate and then return it.
package July15;

public class ExpressionTreeSolution {
	
	Node root;
	public static class Node
	{
	    String data;
	    Node left,right;
	    Node(String data)
	     {
		 this.data = data;
		 this.left = null;
		 this.right = null;
	     }
	}
	
    public int evalTree(Node root)
    {
        if(root==null)
        return 0;
        //check leaf node
        if(root.left==null && root.right==null)
        {
            return Integer.parseInt(root.data);
        }
        int left=evalTree(root.left);
        int right=evalTree(root.right);
        //Till here we got both root node, now check for the operator on the root of these leaf node
        if(root.data.equals("+"))
       {
          // System.out.println(left+right);
           return left+right;
       }
        if(root.data.equals("-"))
        {
           
          // System.out.println(left-right);
            return left-right;}
        if(root.data.equals("*"))
        {
           
          // System.out.println(left*right);
            return left*right;}
        return left/right;
    }
	
	
    public static void main(String[] args) {
    	ExpressionTreeSolution tree = new ExpressionTreeSolution();
    	tree.root =new Node("+");
    	tree.root.left=new Node("*");
    	tree.root.right=new Node("-");
    	tree.root.left.left=new Node("5");
    	tree.root.left.right=new Node("4");
    	tree.root.right.left=new Node("100");
    	tree.root.right.right=new Node("20");
    	
    	System.out.println(tree.evalTree(tree.root));
	}
	

}
