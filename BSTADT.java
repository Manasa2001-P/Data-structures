class Node
{
	int data;
	Node left,right;
	public Node(int x)
	{
		data=x;
		left=right=null;
	}
}
class BST
{
	public Node insert(Node t,int data)
	{
		if(t==null)
		{
			t=new Node(data);
			return t;
			
		}
		else if(t.data>data)
			t.left=insert(t.left,data);
		else if(t.data<data)
			t.right=insert(t.right,data);
		else
			System.out.println("Data already exists");
		return t;
		
		
		
	}
	public void inorder(Node t)
	{
		if(t!=null)
		{
			inorder(t.left);
			System.out.print(t.data+" ");
			inorder(t.right);
		}
	}
	/*public void preorder(Node t)
	{
		if(t!=null)
		{
			System.out.println(t.data+" ");
			preorder(t.left);
			preorder(t.right);
		}
	}*/
	/*public void postorder(Node t)
	{
		if(t!=null)
		{
			preorder(t.left);
			preorder(t.right);
			System.out.println(t.data+" ");
		}
	}*/
	public int height(Node t)
	{
		if(t==null)
			return -1;
		else if((t.left==null)&&(t.right==null))
			return 0;
		else if(t.left==null)
			return 1+height(t.right);
		else if(t.right==null)
			return 1+height(t.left);
		else
			return 1+big(height(t.right),height(t.left));
	}
	public int big(int a,int b)
	{
		return(a>b?a:b);
	}
	public boolean search(Node t,int key)
	{
		if(t==null)
			return false;
		else if(t.data==key)
			return true;
		else if(t.data<key)
			return search(t.right,key);
		else if(t.data>key)
			return search(t.left,key);
		else 
			return false;
		
		
	}
	public int count(Node t)
	{
		if(t==null)
			return 0;
		else if((t.left==null)&&(t.right==null))
			return 1;
		else if(t.left==null)
			return 1+count(t.right);
		else if(t.right==null)
			return 1+count(t.left);
		else 
			return 1+count(t.left)+count(t.right);
		
		
	}
	public int leafCount(Node t)
	{
		if(t==null)
			return 0;
		else if((t.left==null)&&(t.right==null))
			return 1;
		else if(t.left==null)
			return leafCount(t.right);
		else if(t.right==null)
			return leafCount(t.left);
		else
			 return (leafCount(t.left)+leafCount(t.right));
		
		
	}
	public int findMin(Node t)
	{
		if(t==null)
			return -1;
		else
		{ 
			if(t.left==null)
			   	return t.data;
			else
			 	 return findMin(t.left);
		}
              
	}
	public int findMax(Node t)
	{
		if(t==null)
			return -1;
		else
		{
			 if(t.right==null)
			    return t.data;
			else 
			   return findMax(t.right);
		 }
	}
	
		
	
	
	
}
public class BSTADT
{
	public static void main(String args[])
	{
		Node root=null;
		BST obj=new BST();
		int a[]= {7,3,2,9,4,5,6};
		for(int i=0;i<a.length;i++)
			root=obj.insert(root,a[i]);
		obj.inorder(root);
		System.out.println();
		System.out.println(obj.height(root));
		System.out.println(obj.count(root));
		System.out.println(obj.leafCount(root));
		System.out.println(obj.findMin(root));
		System.out.println(obj.findMax(root));
		boolean k=obj.search(root,15);
		if(k)
			System.out.println("found");
		else
			System.out.println("not found");
		
		
		
		
		
		
		
		
	}
}
