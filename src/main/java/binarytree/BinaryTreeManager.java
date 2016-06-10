package binarytree;

public class BinaryTreeManager {

	public boolean search(Node node, int goal) {

		if (node == null) {
			return false;
		}

		if (node.getValue() == goal) {
			this.printFound(node);
			return true;
		} else {
			this.printNode(node);
		}

		if (goal < node.getValue()) {
			final boolean result = this.search(node.getLeft(), goal);
			if (result) {
				return result;
			}
		} else {
			final boolean result = this.search(node.getRight(), goal);
			return result;
		}

		return false;
	}

	public Node insert(Node node, int value) {
		if (node == null) {
			return new Node(value, null, null);
		}

		final Node newNode = new Node(value, null, null);
		this.insertHelper(node, newNode);
		return newNode;
	}

	public void insertHelper(Node node, Node newNode) {
		if (newNode.getValue() < node.getValue()) {
			if (node.getLeft() == null) {
				node.setLeft(newNode);
			} else {
				this.insertHelper(node.getLeft(), newNode);
			}
		} else {
			if (node.getRight() == null) {
				node.setRight(newNode);
			} else {
				this.insertHelper(node.getRight(), newNode);
			}
		}
	}

	private void printNode(Node node) {
		System.out.println(node.getValue());
	}

	private void printFound(Node node) {
		System.out.println("" + node.getValue() + " -- Found!");
	}

}
