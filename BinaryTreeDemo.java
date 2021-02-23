import java.util.Scanner;
class  BTNode
{
	BTNode left;
	int data;
	BTNode right;
}
class BinaryTree
{
	Scanner s=new Scanner(System.in);
	BTNode root;
	BinaryTree()
	{
		root=null;
	}
	void insert(int e)
	{
		BTNode temp,parent;
		int pdata;
		char side;
		temp=new BTNode();
		temp.data=e;
		temp.left=temp.right=null;
		if(root==null)
			root=temp;
		else
		{
			System.out.println("enter the parent");
			pdata=s.nextInt();
			parent=search(root,pdata);
			if(parent==null)
				System.out.println("there is no such parent");
			else
			{
				System.out.println("enter child info");
				side=s.next().charAt(0);
				if(side=='l')
				{
					if(parent.left==null)
						parent.left=temp;
					else
						System.out.println("parent left exist");
				}
				else if(side=='r')
				{
					if(parent.right==null)
						parent.right=temp;
					else
						System.out.println("parent right exist");
				}
				else
					System.out.println("you have entered a wrong choice");
			}
		}
	}
	BTNode search(BTNode t,int p)
	{
		BTNode stk[]=new BTNode[10];
		int top=-1;
		if(t==null)
			return null;
		else
		{
			while(true)
			{
				while(t!=null)
				{
					stk[++top]=t;
					t=t.left;
				}
				if(top==-1)
					return null;
				else
				{
					t=stk[top--];
					if(p==t.data)
						return t;
					t=t.right;
				}
			}
		}
	}
	void inOrder(BTNode t)
	{
		if(t!=null)
		{
			inOrder(t.left);
			System.out.print(t.data+" ");
			inOrder(t.right);
		}
	}
	void preOrder(BTNode t)
	{
		if(t!=null)
		{
			System.out.print(t.data+" ");
			preOrder(t.left);
			preOrder(t.right);
		}
	}
	void postOrder(BTNode t)
	{
		if(t!=null)
		{
			postOrder(t.left);
			postOrder(t.right);
			System.out.print(t.data+" ");
		}
	}
}
class BinaryTreeDemo
{
	public static void main(String[] args) 
	{
		BinaryTree b=new BinaryTree();
		Scanner s=new Scanner(System.in);
		BTNode x;
		int ch;
		int se;
		while (true)
		{
			System.out.println("enter your choice");
			ch=s.nextInt();
			switch(ch)
			{
				case 1: System.out.println("enter the element");
							b.insert(s.nextInt());
							break;
				case 2: b.inOrder(b.root);
							System.out.println("");
							break;
				case 3: b.preOrder(b.root);
							System.out.println("");
							break;
				case 4: b.postOrder(b.root);
							System.out.println("");
							break;
				case 5: System.out.println("enter the searching element"); 
					        se=s.nextInt();
						    x=b.search(b.root,se);
						    if(x!=null)
							   System.out.println("element found");
						    else
							   System.out.println("element not found");
						   break;
				default:return;
			}
		}
		
	}
}