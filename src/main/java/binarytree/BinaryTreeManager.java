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

		if (node.getValue() > goal) {
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

	private void printNode(Node node) {
		System.out.println(node.getValue());
	}

	private void printFound(Node node) {
		System.out.println("" + node.getValue() + " -- Found!");
	}

}
