
public class MyOwnQueue {
	private MyOwnLinkedList queue;
	
	public MyOwnQueue()
	{
		queue = new MyOwnLinkedList();
	}
	
	public String toString()
	{
		return queue.toString();
	}
	
	public void enqueue(int value)
	{
		queue.addEnd(value);
	}
	
	public static void main(String[] args) {
		MyOwnQueue mq = new MyOwnQueue();
		mq.enqueue(0);
		mq.enqueue(1);
		System.out.println(mq);
	}
}
