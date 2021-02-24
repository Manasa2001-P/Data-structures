import java.util.*;
class BNode
{
BNode left;
int data;
BNode right;
}
class BST
{
BNode insert(BNode t, int x)
{
if(t==null)
{
t=new BNode();
t.data=x;
t.left=t.right=null;
}
else if(x<t.data)
{
t.left=insert(t.left,x);
}
else
{
t.right=insert(t.right,x);
}
return t;
}
void search(BNode t,int x)
{
if(t==null)
{
System.out.println("there is no such element");
}
else if(x<t.data)
{
search(t.left,x);
}
else if(x>t.data)
{
search(t.right,x);
}
else
System.out.println("element found");
}
int height(BNode t)
{
if(t==null)
return -1;
else if(t.left==null&&t.right==null)
 return 0;
else if(t.left!=null)
 return (1+height(t.left));
else if(t.right!=null)
  return (1+height(t.right));
else
 return (1+max(height(t.left),height(t.right)));
}
int max(int a,int b)
{
if(a>b)
 return a;
else
 return b;
}
BNode findMin(BNode t)
{
if(t==null||t.left==null)
  return t;
else
 return findMin(t.left);
}
BNode delete(BNode t,int x)
{
BNode temp;
if(t==null)
System.out.println("there is no such element");
else 
{
  if(x<t.data)
    t.left=delete(t.left,x);
  else if(x>t.data)
    t.right=delete(t.right,x);
  else
  {
   if(t.left==null&&t.right==null)
    {
      t=null;
      return null;
    }
    else if(t.left!=null&&t.right!=null)
    {
     temp=findMin(t.right);
     t.data=temp.data;
     t.right=delete(t.right,temp.data);
    }
    else
    {
      if(t.left==null)
          t=t.right;
       else
           t=t.right;
    }
  }
}
return t;
}
void display(BNode t)
{
if(t!=null)
{
display(t.left);
System.out.print(t.data+" ");
display(t.right);
}
}
}
class BSTDemo
{
public static void main(String ar[])
{
BNode root=null;
BST bst=new BST();
Scanner s=new Scanner(System.in);
int ch,e;
while(true)
{
System.out.println("enter ur choice");
ch=s.nextInt();
switch(ch)
{
case 1 :System.out.println("enter the ele to be inserted");
        e=s.nextInt();
        root=bst.insert(root, e);
        break;
case 2 :bst.display(root);
        break;
case 3 :System.out.println("enter element to be searched");
        e=s.nextInt();
        bst.search(root,e);
        break;
case 4:System.out.println("the height of tree is"+bst.height(root));
       break;
case 5:System.out.println("element to be deleted");
       e=s.nextInt();
       root=bst.delete(root,e);
       break;
default : return;
}
}
}
}

        



