package binarytree;

public class Node {

	private int value;
	private Node left;
	private Node right;

	public Node(int value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public void set(int value, Node leftNode, Node rightNode) {
		this.setValue(value);
		this.setLeft(leftNode);
		this.setRight(rightNode);
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return this.left;
	}

	public void setLeft(Node node) {
		this.left = node;
	}

	public Node getRight() {
		return this.right;
	}

	public void setRight(Node node) {
		this.right = node;
	}

	/**
	 * Convenience method to return the only child on a node. Doesn't ensure
	 * that the node has only one child, though.
	 *
	 * @return the only child node on this node
	 */
	public Node getOnlyChild() {
		if (this.right != null) {
			return this.right;
		}
		return this.left;
	}

	public boolean hasOnlyOneChild() {
		return this.left != null && this.right == null || this.left == null && this.right != null;
	}

	public boolean hasNoChildren() {
		return this.left == null && this.right == null;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append(this.value);
		return sb.toString();
	}

}
