import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Driver {
	public static void main(String[] args) {
		Map<Character, List<Character>> adjList = new HashMap<>();
		
		List<Character> aNeighbors = new LinkedList<>();
		aNeighbors.add(new Character('b'));
		aNeighbors.add(new Character('c'));
		aNeighbors.add(new Character('f'));
		
		List<Character> bNeighbors = new LinkedList<>();
		bNeighbors.add(new Character('a'));
		bNeighbors.add(new Character('c'));
		bNeighbors.add(new Character('d'));
		
		List<Character> cNeighbors = new LinkedList<>();
		cNeighbors.add(new Character('a'));
		cNeighbors.add(new Character('b'));
		cNeighbors.add(new Character('d'));
		cNeighbors.add(new Character('f'));
		
		List<Character> dNeighbors = new LinkedList<>();
		dNeighbors.add(new Character('b'));
		dNeighbors.add(new Character('c'));
		dNeighbors.add(new Character('e'));
		
		List<Character> eNeighbors = new LinkedList<>();
		eNeighbors.add(new Character('f'));
		eNeighbors.add(new Character('d'));
		
		List<Character> fNeighbors = new LinkedList<>();
		fNeighbors.add(new Character('a'));
		fNeighbors.add(new Character('c'));
		fNeighbors.add(new Character('e'));
		
		
		adjList.put(new Character('a'), aNeighbors);
		adjList.put(new Character('b'), bNeighbors);
		adjList.put(new Character('c'), cNeighbors);
		adjList.put(new Character('d'), dNeighbors);
		adjList.put(new Character('e'), eNeighbors);
		adjList.put(new Character('f'), fNeighbors);
		
		if (GraphSearch.breadthFirstSearch(new Character('a'), adjList, new Character('a'))) {
			System.out.println("Found");
		}
		else {
			System.out.println("Not Found");
		}
		
		
		
		Map<Character, List<Pair<Character, Integer>>> adjList2 = new HashMap<>();
		List<Pair<Character, Integer>> aNeighbors2 = new LinkedList<>();
		aNeighbors2.add(new Pair(new Character('b'), new Integer(7)));
		aNeighbors2.add(new Pair(new Character('c'), new Integer(9)));
		aNeighbors2.add(new Pair(new Character('f'), new Integer(14)));
		
		List<Pair<Character, Integer>> bNeighbors2 = new LinkedList<>();
		bNeighbors2.add(new Pair(new Character('a'), new Integer(7)));
		bNeighbors2.add(new Pair(new Character('c'), new Integer(10)));
		bNeighbors2.add(new Pair(new Character('d'), new Integer(15)));
		
		List<Pair<Character, Integer>> cNeighbors2 = new LinkedList<>();
		cNeighbors2.add(new Pair(new Character('a'), new Integer(9)));
		cNeighbors2.add(new Pair(new Character('b'), new Integer(10)));
		cNeighbors2.add(new Pair(new Character('d'), new Integer(11)));
		cNeighbors2.add(new Pair(new Character('f'), new Integer(2)));
		
		List<Pair<Character, Integer>> dNeighbors2 = new LinkedList<>();
		dNeighbors2.add(new Pair(new Character('b'), new Integer(15)));
		dNeighbors2.add(new Pair(new Character('c'), new Integer(11)));
		dNeighbors2.add(new Pair(new Character('e'), new Integer(6)));
		
		List<Pair<Character, Integer>> eNeighbors2 = new LinkedList<>();
		eNeighbors2.add(new Pair(new Character('d'), new Integer(6)));
		eNeighbors2.add(new Pair(new Character('f'), new Integer(9)));
		
		List<Pair<Character, Integer>> fNeighbors2 = new LinkedList<>();
		fNeighbors2.add(new Pair(new Character('a'), new Integer(14)));
		fNeighbors2.add(new Pair(new Character('c'), new Integer(2)));
		fNeighbors2.add(new Pair(new Character('e'), new Integer(9)));
		
		
		adjList2.put(new Character('a'), aNeighbors2);
		adjList2.put(new Character('b'), bNeighbors2);
		adjList2.put(new Character('c'), cNeighbors2);
		adjList2.put(new Character('d'), dNeighbors2);
		adjList2.put(new Character('e'), eNeighbors2);
		adjList2.put(new Character('f'), fNeighbors2);
		
		System.out.print("Distance is: ");
		System.out.println(GraphSearch.djikstraShortestPathAlgorithm(new Character('a'), adjList2, new Character('e')));
		
	}
}
