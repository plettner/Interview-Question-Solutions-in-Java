package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * This class performs a breadth first search (BFS) on a directed graph. The
 * compute() method returns true if, given a starting node of the graph, it
 * finds the node you're looking for, the goalNode.
 *
 * Basically, the algorithm is to take the starting node, and assuming it's not
 * the goal node, then put it into the queue and mark it visited. Now, loop on
 * the queue as long as it's not empty. If it's not empty, take a node out of
 * the queue. If this node is our goal node, we're done so we return true. If
 * it's not, mark it visited, and add all of its children to the queue. Continue
 * looping. If you finish the loop (exhausting the queue) then return false
 * because you never found your goal node. It must not be part of the same
 * component of the graph as the start node.
 */
public class BreadthFirstSearch {

	private static final Integer VISITED = Integer.valueOf(1);

	public BreadthFirstSearch() {
	}

	public boolean compute(Node startNode, Node goalNode) {
		if (startNode.equals(goalNode)) {
			return true;
		}

		final Queue<Node> queue = new LinkedList<>();
		final Map<Node, Integer> visited = new HashMap<>();

		queue.add(startNode);
		visited.put(startNode, BreadthFirstSearch.VISITED);

		while (!queue.isEmpty()) {
			final Node node = queue.remove();
			if (node.equals(goalNode)) {
				return true; // found our goal node
			}

			final List<Node> children = node.getChildren();
			for (final Node child : children) {
				if (!visited.containsKey(child)) {
					queue.add(child);
					visited.put(child, BreadthFirstSearch.VISITED);
				}
			}
		}
		return false; // never found the matching node
	}

}
