import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;


public class HW3JUnits {

	/*
	 * LinkedList Tests
	 */
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListAddToFront1() {
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToFront(new Integer(1));
		Object[] result = list.toList();
		assertEquals(result[0], new Integer(1));
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListAddToFront2() {
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToFront(new Integer(0));
		list.addToFront(new Integer(1));
		list.addToFront(new Integer(2));
		list.addToFront(new Integer(3));
		list.addToFront(new Integer(4));
		list.addToFront(new Integer(5));
		Object[] result = list.toList();
		for(int i = 0; i < result.length; i++){
			assertEquals(result[i], new Integer(result.length - i - 1));
		}
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListAddToBack1() {
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToBack(new Integer(1));
		Object[] result = list.toList();
		assertEquals(result[0], new Integer(1));
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListAddToBack2() {
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToBack(new Integer(0));
		list.addToBack(new Integer(1));
		list.addToBack(new Integer(2));
		list.addToBack(new Integer(3));
		list.addToBack(new Integer(4));
		list.addToBack(new Integer(5));
		Object[] result = list.toList();
		for(int i = 0; i < result.length; i++){
			assertEquals(result[i], new Integer(i));
		}
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListAdds1() {
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToBack(new Integer(2));
		list.addToFront(new Integer(1));
		list.addToBack(3);
		list.addToFront(0);
		Object[] result = list.toList();
		for(int i = 0; i < result.length; i++){
			assertEquals(result[i], new Integer(i));
		}
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListRemoveFromFront1(){
		LinkedListInterface<Integer> list = new LinkedList();
		assertEquals(list.removeFromFront(), null);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListRemoveFromFront2(){
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToFront(new Integer(1));
		assertEquals(list.removeFromFront(), new Integer(1));
		Object[] result = list.toList();
		assertEquals(result, new Integer[0]);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListRemoveFromFront3(){
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToFront(new Integer(0));
		list.addToFront(new Integer(1));
		list.addToFront(new Integer(2));
		list.addToFront(new Integer(3));
		list.addToFront(new Integer(4));
		list.addToFront(new Integer(5));
		list.removeFromFront();
		Object[] result = list.toList();
		for(int i = 0; i < result.length; i++){
			assertEquals(result[i], new Integer(result.length - i - 1));
		}
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListRemoveFromFront4(){
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToFront(new Integer(0));
		list.addToFront(new Integer(1));
		list.addToFront(new Integer(2));
		list.addToFront(new Integer(3));
		list.addToFront(new Integer(4));
		list.addToFront(new Integer(5));
		list.removeFromFront();
		list.removeFromFront();
		list.removeFromFront();
		list.removeFromFront();
		list.removeFromFront();
		list.removeFromFront();
		list.removeFromFront();
		Object[] result = list.toList();
		for(int i = 0; i < result.length; i++){
			assertEquals(result[i], new Integer(result.length - i - 1));
		}
		assertEquals(result, new Integer[0]);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListRemoveFromFront5(){
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToFront(new Integer(1));
		assertEquals(list.removeFromFront(), new Integer(1));
		assertEquals(list.removeFromFront(), null);
		Object[] result = list.toList();
		assertEquals(result, new Integer[0]);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListRemoveFromFront6(){
		LinkedListInterface<Integer> list = new LinkedList();
		assertEquals(list.removeFromFront(), null);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListRemoveFromFront7(){
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToBack(new Integer(1));
		assertEquals(list.removeFromFront(), new Integer(1));
		Object[] result = list.toList();
		assertEquals(result, new Integer[0]);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListRemoveFromFront8(){
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToBack(new Integer(0));
		list.addToBack(new Integer(1));
		list.addToBack(new Integer(2));
		list.addToBack(new Integer(3));
		list.addToBack(new Integer(4));
		list.addToBack(new Integer(5));
		list.removeFromFront();
		Object[] result = list.toList();
		for(int i = 0; i < result.length; i++){
			assertEquals(result[i], new Integer(i+1));
		}
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListRemoveFromFront9(){
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToBack(new Integer(0));
		list.addToBack(new Integer(1));
		list.addToBack(new Integer(2));
		list.addToBack(new Integer(3));
		list.addToBack(new Integer(4));
		list.addToBack(new Integer(5));
		list.removeFromFront();
		list.removeFromFront();
		list.removeFromFront();
		list.removeFromFront();
		list.removeFromFront();
		list.removeFromFront();
		list.removeFromFront();
		Object[] result = list.toList();
		for(int i = 0; i < result.length; i++){
			assertEquals(result[i], new Integer(result.length - i - 1));
		}
		assertEquals(result, new Integer[0]);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListRemoveFromFront10(){
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToBack(new Integer(1));
		assertEquals(list.removeFromFront(), new Integer(1));
		assertEquals(list.removeFromFront(), null);
		Object[] result = list.toList();
		assertEquals(result, new Integer[0]);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListRemoveFromBack1(){
		LinkedListInterface<Integer> list = new LinkedList();
		assertEquals(list.removeFromBack(), null);
	}	
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListRemoveFromBack2(){
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToFront(new Integer(1));
		assertEquals(list.removeFromBack(), new Integer(1));
		Object[] result = list.toList();
		assertEquals(result, new Integer[0]);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListRemoveFromBack3(){
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToFront(new Integer(0));
		list.addToFront(new Integer(1));
		list.addToFront(new Integer(2));
		list.addToFront(new Integer(3));
		list.addToFront(new Integer(4));
		list.addToFront(new Integer(5));
		list.removeFromBack();
		Object[] result = list.toList();
		for(int i = 0; i < result.length; i++){
			assertEquals(result[i], new Integer(result.length - i));
		}
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListRemoveFromBack4(){
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToFront(new Integer(0));
		list.addToFront(new Integer(1));
		list.addToFront(new Integer(2));
		list.addToFront(new Integer(3));
		list.addToFront(new Integer(4));
		list.addToFront(new Integer(5));
		list.removeFromBack();
		list.removeFromBack();
		list.removeFromBack();
		list.removeFromBack();
		list.removeFromBack();
		list.removeFromBack();
		list.removeFromBack();
		Object[] result = list.toList();
		for(int i = 0; i < result.length; i++){
			assertEquals(result[i], new Integer(result.length - i - 1));
		}
		assertEquals(result, new Integer[0]);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListRemoveFromBack5(){
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToFront(new Integer(1));
		assertEquals(list.removeFromBack(), new Integer(1));
		assertEquals(list.removeFromBack(), null);
		Object[] result = list.toList();
		assertEquals(result, new Integer[0]);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListRemoveFromBack6(){
		LinkedListInterface<Integer> list = new LinkedList();
		assertEquals(list.removeFromBack(), null);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListRemoveFromBack7(){
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToBack(new Integer(1));
		assertEquals(list.removeFromBack(), new Integer(1));
		Object[] result = list.toList();
		assertEquals(result, new Integer[0]);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListRemoveFromBack8(){
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToBack(new Integer(0));
		list.addToBack(new Integer(1));
		list.addToBack(new Integer(2));
		list.addToBack(new Integer(3));
		list.addToBack(new Integer(4));
		list.addToBack(new Integer(5));
		list.removeFromBack();
		Object[] result = list.toList();
		for(int i = 0; i < result.length; i++){
			assertEquals(result[i], new Integer(i));
		}
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListRemoveFromBack9(){
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToBack(new Integer(0));
		list.addToBack(new Integer(1));
		list.addToBack(new Integer(2));
		list.addToBack(new Integer(3));
		list.addToBack(new Integer(4));
		list.addToBack(new Integer(5));
		list.removeFromBack();
		list.removeFromBack();
		list.removeFromBack();
		list.removeFromBack();
		list.removeFromBack();
		list.removeFromBack();
		list.removeFromBack();
		Object[] result = list.toList();
		for(int i = 0; i < result.length; i++){
			assertEquals(result[i], new Integer(result.length - i - 1));
		}
		assertEquals(result, new Integer[0]);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListRemoveFromBack10(){
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToBack(new Integer(1));
		assertEquals(list.removeFromBack(), new Integer(1));
		assertEquals(list.removeFromBack(), null);
		Object[] result = list.toList();
		assertEquals(result, new Integer[0]);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListRemoves1() {
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToBack(new Integer(1));
		list.addToFront(new Integer(0));
		list.addToBack(new Integer(3));
		list.addToFront(new Integer(2));
		list.removeFromBack();
		list.removeFromFront();
		Object[] result = list.toList();
		for(int i = 0; i < result.length; i++){
			assertEquals(result[i], new Integer(i));
		}
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testLinkedListRemoves2() {
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToBack(new Integer(1));
		list.addToFront(new Integer(0));
		list.addToBack(new Integer(3));
		list.addToFront(new Integer(2));
		list.removeFromBack();
		list.removeFromFront();
		list.removeFromBack();
		list.removeFromFront();
		Object[] result = list.toList();
		assertEquals(result, new Integer[0]);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testIsEmpty1(){
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToBack(new Integer(1));
		assertFalse(list.isEmpty());
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testIsEmpty2(){
		LinkedListInterface<Integer> list = new LinkedList();
		assertTrue(list.isEmpty());
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testIsEmpty3(){
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToBack(new Integer(1));
		list.removeFromFront();
		assertTrue(list.isEmpty());
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testSize1(){
		LinkedListInterface<Integer> list = new LinkedList();
		assertEquals(list.size(), 0);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testSize2(){
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToBack(new Integer(1));
		assertEquals(list.size(), 1);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testSize3(){
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToFront(new Integer(1));
		assertEquals(list.size(), 1);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testSize4(){
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToBack(new Integer(1));
		list.removeFromFront();
		assertEquals(list.size(), 0);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testSize5(){
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToFront(new Integer(1));
		list.removeFromBack();
		assertEquals(list.size(), 0);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testClear1(){
		LinkedListInterface<Integer> list = new LinkedList();
		list.addToBack(new Integer(0));
		list.addToBack(new Integer(1));
		list.addToBack(new Integer(2));
		list.addToBack(new Integer(3));
		list.addToBack(new Integer(4));
		list.addToBack(new Integer(5));
		list.clear();
		Object[] result = list.toList();
		assertEquals(result, new Integer[0]);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testClear2(){
		LinkedListInterface<Integer> list = new LinkedList();
		list.clear();
		Object[] result = list.toList();
		assertEquals(result, new Integer[0]);
	}
	
	/*
	 * Stack Tests
	 */
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testStackPushPop1(){
		StackInterface<Integer> stack = new Stack();
		stack.push(new Integer(1));
		assertEquals(stack.pop(), new Integer(1));
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testStackPushPop2(){
		StackInterface<Integer> stack = new Stack();
		stack.push(new Integer(1));
		stack.push(new Integer(2));
		stack.push(new Integer(3));
		stack.push(new Integer(4));
		stack.push(new Integer(5));
		assertEquals(stack.pop(), new Integer(5));
		assertEquals(stack.pop(), new Integer(4));
		assertEquals(stack.pop(), new Integer(3));
		assertEquals(stack.pop(), new Integer(2));
		assertEquals(stack.pop(), new Integer(1));
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testStackPop1(){
		StackInterface<Integer> stack = new Stack();
		assertEquals(stack.pop(), null);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testStackPop2(){
		StackInterface<Integer> stack = new Stack();
		stack.push(new Integer(1));
		stack.pop();
		assertEquals(stack.pop(), null);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testStackSize1(){
		StackInterface<Integer> stack = new Stack();
		assertEquals(stack.size(), 0);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testStackSize2(){
		StackInterface<Integer> stack = new Stack();
		stack.push(new Integer(1));
		stack.push(new Integer(2));
		stack.push(new Integer(3));
		stack.push(new Integer(4));
		stack.push(new Integer(5));
		stack.pop();
		assertEquals(stack.size(), 4);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testStackSize3(){
		StackInterface<Integer> stack = new Stack();
		stack.push(new Integer(1));
		stack.push(new Integer(2));
		stack.push(new Integer(3));
		stack.push(new Integer(4));
		stack.push(new Integer(5));
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		assertEquals(stack.size(), 0);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testStackIsEmpty1(){
		StackInterface<Integer> stack = new Stack();
		assertTrue(stack.isEmpty());
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testStackIsEmpty2(){
		StackInterface<Integer> stack = new Stack();
		stack.push(new Integer(1));
		assertFalse(stack.isEmpty());
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testStackIsEmpty3(){
		StackInterface<Integer> stack = new Stack();
		stack.push(new Integer(1));
		stack.pop();
		assertTrue(stack.isEmpty());
	}
	
	
	/*
	 * Queue Tests
	 */
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testQueueEnqueueDequeue1(){
		QueueInterface<Integer> queue = new Queue();
		queue.enqueue(new Integer(1));
		assertEquals(queue.dequeue(), new Integer(1));
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testQueueEnqueueDequeue2(){
		QueueInterface<Integer> queue = new Queue();
		queue.enqueue(new Integer(1));
		queue.enqueue(new Integer(2));
		queue.enqueue(new Integer(3));
		queue.enqueue(new Integer(4));
		queue.enqueue(new Integer(5));
		assertEquals(queue.dequeue(), new Integer(1));
		assertEquals(queue.dequeue(), new Integer(2));
		assertEquals(queue.dequeue(), new Integer(3));
		assertEquals(queue.dequeue(), new Integer(4));
		assertEquals(queue.dequeue(), new Integer(5));
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testQueueDequeue1(){
		QueueInterface<Integer> queue = new Queue();
		assertEquals(queue.dequeue(),null);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testQueueDequeue2(){
		QueueInterface<Integer> queue = new Queue();
		queue.enqueue(new Integer(1));
		queue.dequeue();
		assertEquals(queue.dequeue(),null);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testQueueSize1(){
		QueueInterface<Integer> queue = new Queue();
		assertEquals(queue.size(), 0);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testQueueSize2(){
		QueueInterface<Integer> queue = new Queue();
		queue.enqueue(new Integer(1));
		queue.enqueue(new Integer(2));
		queue.enqueue(new Integer(3));
		queue.enqueue(new Integer(4));
		queue.enqueue(new Integer(5));
		assertEquals(queue.size(), 5);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testQueueSize3(){
		QueueInterface<Integer> queue = new Queue();
		queue.enqueue(new Integer(1));
		queue.enqueue(new Integer(2));
		queue.enqueue(new Integer(3));
		queue.enqueue(new Integer(4));
		queue.enqueue(new Integer(5));
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		assertEquals(queue.size(), 0);
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testQueueIsEmpty1(){
		QueueInterface<Integer> queue = new Queue();
		assertTrue(queue.isEmpty());
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testQueueIsEmpty2(){
		QueueInterface<Integer> queue = new Queue();
		queue.enqueue(new Integer(1));
		assertFalse(queue.isEmpty());
	}
	
	@Test (timeout = 200)
	//@Worth (points = 1)
	public void testQueueIsEmpty3(){
		QueueInterface<Integer> queue = new Queue();
		queue.enqueue(new Integer(1));
		queue.dequeue();
		assertTrue(queue.isEmpty());
	}
}