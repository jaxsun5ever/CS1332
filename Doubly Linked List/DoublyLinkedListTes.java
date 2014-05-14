import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;


public class DoublyLinkedListTest {
	private static DoublyLinkedList<String> llist;
	
	@Before
	public void setUp() throws Exception {
		llist = new DoublyLinkedList<>();
		llist.add(0, "case0");
		llist.add(0, "case1");
		llist.add(0, "case2");
		llist.add(0, "case3");
	}

	@Test
	public void testAdd() {
		assertTrue(llist.add(0, "case4"));
		assertFalse(llist.add(100, "case100"));
		assertFalse(llist.add(0, null));
		assertEquals(llist.size(), 5);
		assertTrue(llist.add(llist.size(), "case5"));
		
		llist.clear();
		assertTrue(llist.add(0,"case0"));
		assertTrue(llist.add(1,"case1"));
		assertEquals(llist.size(),2);
		assertEquals(llist.get(1),"case1");
		llist.add(2,"case2");
		llist.add(2, "case3");
		assertEquals(llist.get(2),"case3");
	}

	@Test
	public void testClear() {
		assertEquals(llist.size(), 4);
		llist.clear();
		assertEquals(llist.size(), 0);
	}

	@Test
	public void testContains() {
		assertTrue(llist.contains("case0"));
		assertFalse(llist.contains("case4"));
		assertFalse(llist.contains(4));
		assertFalse(llist.contains(null));
		assertFalse(llist.contains(new Object()));
		assertFalse(llist.contains(new DoublyLinkedList<String>()));
		llist.clear();
		assertFalse(llist.contains("case0"));
	}

	@Test
	public void testGet() {
		assertEquals(llist.get(0), "case3");
		assertEquals(llist.get(1), "case2");
		assertEquals(llist.get(2), "case1");
		assertEquals(llist.get(3), "case0");
		assertEquals(llist.get(-1), null);
		assertEquals(llist.get(4), null);
		
		llist.clear();
		
		assertEquals(llist.get(0),null);
		assertEquals(llist.get(20),null);
		assertEquals(llist.get(-10),null);
	}

	@Test
	public void testIndexOf() {
		assertEquals(llist.indexOf("case3"), 0);
		assertEquals(llist.indexOf("case2"), 1);
		assertEquals(llist.indexOf("case1"), 2);
		assertEquals(llist.indexOf("case0"), 3);
		assertEquals(llist.indexOf("case4"), -1);
		llist.clear();
		assertEquals(llist.indexOf(""+4),-1);
		assertEquals(llist.indexOf("case0"),-1);
	}

	@Test
	public void testIsEmpty() {
		assertFalse(llist.isEmpty());
		llist.clear();
		assertTrue(llist.isEmpty());
	}

	@Test
	public void testRemoveObject() {
		assertEquals(llist.remove("case2"),"case2");
		assertEquals(llist.remove("case4"), null);
		llist.clear();
		assertEquals(llist.remove("case1"),null);
		llist.add(0,"case0");
		llist.add(0, "case1");
		assertEquals(llist.get(1),"case0");
		assertEquals(llist.size(),2);
	}

	@Test
	public void testRemoveInt() {
		assertEquals(llist.remove(0),"case3");
		assertEquals(llist.remove(2), "case0");
		assertEquals(llist.remove(2), null);
		llist.clear();
		llist.add(0,"case0");
		llist.add(1,"case1");
		assertEquals(llist.remove(1),"case1");
		assertEquals(llist.remove(-5),null);
		assertEquals(llist.remove(5),null);
	}

	@Test
	public void testReplace() {
		assertEquals(llist.replace(0, "case4"), "case3");
		assertEquals(llist.get(0), "case4");
		assertEquals(llist.size(), 4);
		assertEquals(llist.replace(4, "case5"), null);
		llist.clear();
		assertEquals(llist.replace(5,"case0"),null);
		llist.add(0,"case0");
		llist.add(1,"case1");
		assertEquals(llist.replace(1,"case0"),"case1");
		assertEquals(llist.get(1),"case0");
		assertEquals(llist.get(0),"case0");
	}

	@Test
	public void testSize() {
		assertEquals(llist.size(),4);
		llist.clear();
		assertEquals(llist.size(), 0);
	}

	@Test
	public void testGetHead() {
		System.out.println(llist.getHead().toString());
		llist.remove(0);
		System.out.println(llist.getHead().toString());
	}

	@Test
	public void testReverseList() {
		System.out.println("reversed");
		llist.reverseList();
		System.out.println(llist.getHead().toString());
		llist.remove(0);
		System.out.println(llist.getHead().toString());
		llist.remove(0);
		System.out.println(llist.getHead().toString());
		llist.remove(0);
		System.out.println(llist.getHead().toString());
	}

	@Test
	public void testIterator() {
		System.out.println("Iterator");
		Iterator<String> myIterator = llist.iterator();
		System.out.println(myIterator.next());
		System.out.println(myIterator.next());
		System.out.println(myIterator.next());
		System.out.println(myIterator.next());
		assertFalse(myIterator.hasNext());
	}

}
