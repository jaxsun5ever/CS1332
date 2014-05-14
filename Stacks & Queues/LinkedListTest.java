import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class LinkedListTest {

	LinkedListInterface<Integer> list;
	
	@Before
	public void setUp() throws Exception {
		list = new LinkedList<>();
	}

	@Test
	public void testAddToFront() {
		list.addToFront(0);
		assertEquals(list.size(),1);
		list.addToFront(1);
		assertEquals(list.size(),2);
		
	}

	@Test
	public void testAddToBack() {
		
	}

	@Test
	public void testRemoveFromFront() {

	}

	@Test
	public void testRemoveFromBack() {
		list.addToFront(0);
		list.addToFront(1);
		//list.addToFront(2);
		//list.addToBack(3);
		
		list.removeFromBack();
	//Object[] temp = list.toList();
		//for (Object i : temp) {
		//	System.out.println(""+i);
	//	}
		//assertEquals(list.size(),2);
		//System.out.println(list.getTail());
		//list.addToBack(4);
		//System.out.println(list.getTail());
	//	list.removeFromBack();
		//System.out.println(list.getTail());
	}

	@Test
	public void testToList() {
/*		list.addToFront(0);
		list.addToFront(1);
		list.addToFront(2);
		Object[] temp = list.toList();
		for (Object i : temp) {
			System.out.println(""+i);
		}
		System.out.println("---------");
		assertEquals(list.size(),3);	
		list.addToBack(3);
		list.addToBack(4);
		list.addToBack(5);
		temp = list.toList();
		for (Object i : temp) {
			System.out.println(""+i);
		}
		
		
		System.out.println("---------");
		list.removeFromBack();
		list.removeFromFront();
		list.removeFromBack();
		list.removeFromFront();
		temp = list.toList();
		for (Object i : temp) {
			System.out.println(""+i);
		}
		
		assertEquals(list.size(),6);
		list.clear();
		assertTrue(list.isEmpty());
		assertEquals(list.size(),0);*/
		assertEquals(list.size(),0);
		assertTrue(list.isEmpty());
		list.clear();
		Object[] temp = list.toList();
		assertEquals(temp.length,0);
		LinkedListInterface<Integer> list2 = new LinkedList<>();
		Object[] temp2 = list2.toList();
		//Object[] temp3 = null;
		assertFalse(temp2 == null);
		//assertEquals(temp2, temp3);
	}

	@Test
	public void testIsEmpty() {
	}

	@Test
	public void testSize() {

	}

	@Test
	public void testClear() {
	}

}
