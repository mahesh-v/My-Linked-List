import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyOwnLinkedList implements Iterable<Object> {
	private Node head;
	private Node tail;
	
	public void addFront(int value)
	{
		if(head == null)
		{
			head = new Node(value, head);
			tail = head;
		}
		else
			head = new Node(value, head);
	}
	
	public void addEnd(int value)
	{
		if(tail == null)
		{
			head = new Node(value, head);
			tail = head;
		}
		else
		{
			tail.next = new Node(value, null);
			tail = tail.next;
		}
	}

	@SuppressWarnings("unused")
	private void reverse() {
		if(head == null)
			return;
		Node p1 = head;
		Node p2 = head.next;
		Node p3 = null;
		while(p2 != null)
		{
			//p3 = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p3;
			
		}
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		Node p = head;
		while(p!= null)
		{
			sb.append(p.data+" ");
			p = p.next;
		}
		sb.append("]");
		return new String(sb);
	}
	
	private static class Node
	{
		private int data;
		private Node next;
		
		private Node(int d, Node n)
		{
			data = d;
			next = n;
		}
	}
	
	@Override
	public Iterator<Object> iterator() {
		
		return new MyOwnLinkedListIterator();
	}
	
	private class MyOwnLinkedListIterator implements Iterator<Object>
	{
		Node currentNode;
		Node prevNode;
		public MyOwnLinkedListIterator() {
			currentNode = head;
		}
		@Override
		public boolean hasNext() {
			return (currentNode != null);
		}

		@Override
		public Object next() {
			if(!hasNext())
				throw new NoSuchElementException();
			prevNode = currentNode;
			currentNode = prevNode.next;
			return prevNode.data;
		}

		@Override
		public void remove() {
			if(currentNode.next != null)
				prevNode.next = currentNode.next;
		}
		
	}
	
	public static void main(String[] args) {
		MyOwnLinkedList ll = new MyOwnLinkedList();
		for (int i = 0; i < 10; i++) {
			ll.addFront(i);
		}
//		System.out.println(ll);
//		ll.reverse();
//		System.out.println(ll);
		for (Object x : ll) {
			System.out.println(x+" ");
		}
	}
}
