package graph;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private final String value;
	private final Node left;
	private final Node right;

	public Node(String value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public String getValue() {
		return this.value;
	}

	public Node getLeft() {
		return this.left;
	}

	public Node getRight() {
		return this.right;
	}

	public List<Node> getChildren() {
		final List<Node> list = new ArrayList<>(2);
		if (this.left != null) {
			list.add(this.left);
		}
		if (this.right != null) {
			list.add(this.right);
		}
		return list;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Node={");
		sb.append("value=").append(this.value == null ? "<null>" : this.value);
		sb.append("}");
		return sb.toString();
	}
}
