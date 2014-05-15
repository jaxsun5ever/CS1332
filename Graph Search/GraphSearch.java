import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Implementation of graph search algorithms general
 * graph search, DFS, BFS and djikstra shortest path
 * 
 * @author Jackson Chan
 */
public class GraphSearch {

	/**
	 * Searches the Graph passed in as an AdjcencyList(adjList) to find if a path exists from the start node to the goal node
	 * using General Graph Search.
	 *
	 * Assume the AdjacencyList contains adjacent nodes of each node in the order they should be visited.
	 *
	 * The structure(struct) passed in is an empty structure may behave as a Stack or Queue and the
	 * correspondingly search function should execute DFS(Stack) or BFS(Queue) on the graph.
	 *
	 * @param start
	 * @param struct
	 * @param adjList
	 * @param goal
	 * @return true if path exists false otherwise
	 */
	public static <T> boolean generalGraphSearch(T start, Structure<T> struct, Map<T, List<T>> adjList, T goal) {
		if (start == null || struct == null || adjList == null || goal == null) {
			throw new IllegalArgumentException();
		}
		Set<T> visited = new HashSet<>();
		struct.add(start);
		while (!struct.isEmpty()) {
			T frontVertex = struct.remove();
			if (!visited.contains(frontVertex)) {
				if (frontVertex.equals(goal)) {
					return true;
				}
				visited.add(frontVertex);
				List<T> neighbors = adjList.get(frontVertex);
				for (T neighbor : neighbors) {
					struct.add(neighbor);
				}
			}
		}
		return false;
	}
	
	/**
	 * Searches the Graph passed in as an AdjcencyList(adjList) to find if a path exists from the start node to the goal node
	 * using Bredth First Search.
	 *
	 * Assume the AdjacencyList contains adjacent nodes of each node in the order they should be visited.
	 *
	 * @param start
	 * @param adjList
	 * @param goal
	 * @return true if path exists false otherwise
	 */
	public static <T> boolean breadthFirstSearch(T start, Map<T, List<T>> adjList, T goal) {
		return generalGraphSearch(start, new StructureQueue<T>(), adjList, goal);
	}
	
	/**
	 * Searches the Graph passed in as an AdjcencyList(adjList) to find if a path exists from the start node to the goal node
	 * using Depth First Search.
	 *
	 * Assume the AdjacencyList contains adjacent nodes of each node in the order they should be visited.
	 *
	 * @param start
	 * @param adjList
	 * @param goal
	 * @return true if path exists false otherwise
	 */
	public static <T> boolean depthFirstSearch(T start, Map<T, List<T>> adjList, T goal) {
		return generalGraphSearch(start, new StructureStack<T>(), adjList, goal);
	}
	
	/**
	 * Find the shortest distance between the start node and the goal node in the given a weighted graph
	 * in the form of an adjacency list where the edges only have positive weights
	 * Return the aforementioned shortest distance if there exists a path between the start and goal,-1
	 * otherwise.
	 *
	 * Assume the AdjacencyList contains adjacent nodes of each node in the order they should be visited.
	 * There are no negative edge weights in the graph.
	 *
	 * @param start
	 * @param adjList
	 * @param goal
	 * @return the shortest distance between the start and the goal node
	 */
	public static <T> int djikstraShortestPathAlgorithm(T start, Map<T, List<Pair<T, Integer>>> adjList, T goal) {
		if (start == null || adjList == null || goal == null) {
			throw new IllegalArgumentException();
		}
		Set<T> visited = new HashSet<>();
		PairComparator comparator = new PairComparator();
		PriorityQueue<Pair<T, Integer>> queue = new PriorityQueue<>(10, comparator);
		queue.add(new Pair<>(start, new Integer(0)));
		while (!queue.isEmpty()) {
			Pair<T, Integer> frontVertex = queue.poll();
			if (frontVertex.a.equals(goal)) {
				return frontVertex.b;
			}
			visited.add(frontVertex.a);
			List<Pair<T, Integer>> neighbors = adjList.get(frontVertex.a);
			for (Pair<T, Integer> pair : neighbors) {
				if (!visited.contains(pair.a)) {
					Integer distance = frontVertex.b + pair.b;
					queue.add(new Pair<>(pair.a, distance));
				}
			}
		}
		return -1;
	}
	
	private static class PairComparator implements Comparator<Pair<?, Integer>> {

		@Override
		public int compare(Pair<?, Integer> arg0, Pair<?, Integer> arg1) {
			return arg0.b - arg1.b;
		}
	}
	
}