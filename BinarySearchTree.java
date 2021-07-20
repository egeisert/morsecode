package mypackage;

public class BinarySearchTree {
	
	class Node
	{
		char key;
		String code;
		Node left, right;
		
		public Node(char k, String c)
		{
			this.key = k;
			this.code = c;
			left = right = null;
		}
		
		public String getCode()
		{
			return this.code;
		}
		
	}
	
	Node root;
	
	BinarySearchTree()
	{
		root = null;
	}
	
	void insert(char k, String c)
	{
		root = insertRec(root, k, c);
	}
	
	Node insertRec(Node root, char k, String c)
	{
		if (root == null)
		{
			root = new Node(k, c);
			return root;
		}
		
		if (k < root.key)
		{
			root.left = insertRec(root.left, k, c);
		}
		else if (k > root.key)
		{
			root.right = insertRec(root.right, k, c);
		}
		
		return root;
	}
	void inOrder()
	{
		inOrderRec(root);
	}
		
	void inOrderRec(Node root)
	{
		if (root != null)
		{
			inOrderRec(root.left);
			System.out.println(root.key + " " + root.code);
			inOrderRec(root.right);
		}
	}
	void translate(String c)
	{
		translate(root, c);
		
	}
	void translate(Node root, String c)
	{
		if (root != null)
		{
			translate(root.left, c);
			if (root.code.compareTo(c) == 0)
			{
				int tmp = (int) root.key;
				tmp = tmp - 32;
				char ch = (char) tmp;
				System.out.print(ch);
			}
			translate(root.right, c);
			//return null;
		}
	}
	
	Node search(Node root, char k)
	{
		if (root == null || root.key == k)
		{
			return root;
		}
		
		if (root.key < k)
		{
			return search(root.right, k);
		}
		
		if (root.key > k)
		{
			return search(root.left, k);
		}
		
		return null;
	}
	
}
