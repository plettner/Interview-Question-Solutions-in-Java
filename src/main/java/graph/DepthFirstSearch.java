package graph;

import java.util.HashMap;
import java.util.Map;

public class DepthFirstSearch {

	private static final Integer VISITED = Integer.valueOf(1);

	final Map<Node, Integer> visited = new HashMap<>();

	public DepthFirstSearch() {
	}

	/**
	 * Recursive traversal through our graph. Check if <code>node</code> is the
	 * node passed into the routine if you want to search for a particular node.
	 *
	 * @param node
	 *            starting point of our traversal/search
	 */
	public boolean dfs(Node node, Node goal) {

		boolean found = false;
		if (node.equals(goal)) {
			this.printFound(node);
			found = true;
		} else {
			this.printNode(node);
			this.visited.put(node, DepthFirstSearch.VISITED);

			for (final Node child : node.getChildren()) {
				if (!this.visited.containsKey(child)) {
					found = this.dfs(child, goal);
					if (found) {
						break;
					}
				}
			}
		}

		return found;
	}

	private void printNode(Node node) {
		System.out.println(node.getValue());
	}

	private void printFound(Node node) {
		System.out.println(node.getValue() + " -- FOUND!");
	}

}
