package binarytree;

public class BinaryTree {

	private Node root;

	public BinaryTree() {
	}

	public int getSize() {
		final CountNodeHandler nodeHandler = new CountNodeHandler();
		this.postOrderTraversal(nodeHandler);
		return nodeHandler.getCount();
	}

	public void postOrderTraversal(NodeHandler nodeHandler) {
		this.postOrderTraversalHelper(this.root, nodeHandler);
		nodeHandler.processDone();
	}

	public void inOrderTraversal(NodeHandler nodeHandler) {
		this.inOrderTraversalHelper(this.root, nodeHandler);
		nodeHandler.processDone();
	}

	public void inOrderTraversalHelper(Node node, NodeHandler nodeHandler) {
		if (node == null) {
			return;
		}

		this.inOrderTraversalHelper(node.getLeft(), nodeHandler);
		nodeHandler.process(node);
		this.inOrderTraversalHelper(node.getRight(), nodeHandler);
	}

	public void postOrderTraversalHelper(Node node, NodeHandler nodeHandler) {
		if (node == null) {
			return;
		}

		nodeHandler.process(node);

		this.postOrderTraversalHelper(node.getLeft(), nodeHandler);
		this.postOrderTraversalHelper(node.getRight(), nodeHandler);

	}

	public void insert(int value) {

		final Node newNode = new Node(value, null, null);

		if (this.root == null) {
			this.root = newNode;
			return;
		}

		this.insertHelper(this.root, newNode);
	}

	/**
	 * Recursively search for the right place to put the new node into the tree.
	 * Note that the tree will end up unbalanced if the data is entered in, say,
	 * sorted order.
	 *
	 * @param node
	 *            the current node that you're looking at
	 * @param newNode
	 *            the new node to be added to the tree
	 */
	private void insertHelper(Node node, Node newNode) {

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

	public Node search(int value) {
		return this.searchHelper(this.root, value);
	}

	private Node searchHelper(Node node, int value) {
		if (node == null) {
			return null;
		}

		if (node.getValue() == value) {
			return node;
		}

		final Node foundNode = this.searchHelper(node.getLeft(), value);
		if (foundNode != null) {
			return foundNode;
		}
		return this.searchHelper(node.getRight(), value);
	}

}
