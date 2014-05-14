import static org.junit.Assert.*;

import java.util.Collection;
import java.util.LinkedList;

import org.junit.Test;

public class BasicDynamicArrayTests {
	DynamicArrayInterface<String> myArray = new MyDynamicArray<>();
	
	@Test
	public void testAdd1(){
		DynamicArrayInterface<String> myArray = new MyDynamicArray<>();
		myArray.add("Zero");
		myArray.add("test1");
		Object[] arr = myArray.toArray();
		assertEquals("Zero",arr[0]);
		assertEquals("test1", arr[1]);
		assertEquals(myArray.contains(null),false);
	}

	
	@Test
	public void testAddAll(){
		DynamicArrayInterface<Integer> myArray = new MyDynamicArray<>();
		Collection<Integer> coll = new LinkedList<>();
		Integer[] arr = new Integer[10];
		
		for(int i=0; i<10; i++){
			coll.add(i);
			arr[i] = i;
		}
		coll.remove(5);
		
		myArray.addAll(coll);
		//assertArrayEquals(myArray.toArray(),arr);
		assertEquals(myArray.size(),9);
		assertEquals(arr.length,10);
	}
	
	@Test
	public void testRemove1(){
		DynamicArrayInterface<String> myArray = new MyDynamicArray<>();
		myArray.add("Thing");
		myArray.add("Thing");
		myArray.add("Thing");
		myArray.add("Thing");
		myArray.add("Thing");
		myArray.add("Thing");
		myArray.add("Thing");
		myArray.add("Thing");
		myArray.add("Thing");
		myArray.add("Thing1");
		assertEquals(myArray.remove("Thing1"),"Thing1");
		assertEquals(myArray.get(9), null);
		assertEquals(myArray.size(), 9);
		//assertTrue(myArray.isEmpty());
	}
	
	@Test
	public void testRemove2(){
		DynamicArrayInterface<String> myArray = new MyDynamicArray<>();
		myArray.add("Thing");
		assertEquals(myArray.remove(0),"Thing");
		assertTrue(myArray.isEmpty());
	}
	
	@Test
	public void testGet(){
		DynamicArrayInterface<String> myArray = new MyDynamicArray<>();
		assertNull(myArray.get(-3));
	}
	
	@Test
	public void testContains(){
		DynamicArrayInterface<String> myArray = new MyDynamicArray<>();
		myArray.add("Thing");
		assertTrue(myArray.contains("Thing"));
	}
	
	@Test
	public void testClearandSize(){
		DynamicArrayInterface<Integer> myArray = new MyDynamicArray<>();
		for(int i=0; i<10; i++){
			myArray.add(i);
		}
		assertTrue(myArray.size()==10);
		myArray.clear();
		assertTrue(myArray.isEmpty());
		assertTrue(myArray.size()==0);
	}
}
