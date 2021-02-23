package Circular__linked_list;
import java.util.Scanner;
class Node
{
	int data;
	Node prev,next;
	Node(int data)
	{
		this.data=data;
		prev=next=null;
	}
}
class Double_ll
{
	Node head,last;
	Double_ll()
	{
		head=last=null;
		Scanner sc=new Scanner(System.in);
	}
	void creation()
	 {
		 while(true)
		 {

			 Scanner sc=new Scanner(System.in);
			 System.out.println("enter Student name");
			int n=sc.nextInt();
			 insert(n);//inserting element one by one
			 String choice;
			 System.out.println("do you want to enter more?");
			 choice=sc.next();
			 if(choice.equals("no"))
				 return ;	 
		 }
	 }
	void insert(int n)
	{
		Node temp=new Node(n);
		if(head==null)
		{
			head=last=temp;
			head.prev=null;
			last.next=null;
		}
		else
		{
			last.next=temp;
			temp.prev=last;
			last=temp;
			last.next=null;
		}
	}
	void print_list()
	{
		Node t=head;
		while(t!=null)
		{
			System.out.print(t.data+"->");
			t=t.next;
		}
		System.out.print("null");
		System.out.print(" ************************** ");
		Node t1=last;
		while(t1!=null)
		{
			System.out.print(t1.data+"->");
			t1=t1.prev;
		}
		System.out.print("null");
	}
}
public class d_linkedlist {
	public static void main(String args[])
	{
		Double_ll d=new Double_ll();
		d.creation();
		d.print_list();
	}

}
