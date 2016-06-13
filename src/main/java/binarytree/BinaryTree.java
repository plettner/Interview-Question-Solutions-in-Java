package binarytree;

public class BinaryTree {

	private Node root;

	public BinaryTree() {
	}

	public int getSize() {
		return this.getSize(this.root);
	}

	public int getSize(Node node) {
		final CountNodeHandler nodeHandler = new CountNodeHandler();
		this.postOrderTraversal(node, nodeHandler);
		return nodeHandler.getCount();
	}

	public void postOrderTraversal(NodeHandler nodeHandler) {
		this.postOrderTraversal(this.root, nodeHandler);
	}

	public void postOrderTraversal(Node node, NodeHandler nodeHandler) {
		this.postOrderTraversalHelper(node, nodeHandler);
		nodeHandler.processDone();
	}

	public void inOrderTraversal(NodeHandler nodeHandler) {
		this.inOrderTraversal(this.root, nodeHandler);
	}

	public void inOrderTraversal(Node node, NodeHandler nodeHandler) {
		this.inOrderTraversalHelper(node, nodeHandler);
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

	public void remove(int value) {
		if (this.root == null) {
			return;
		}
		if (this.root.getValue() == value) {
			final int sizeLeft = this.getSize(this.root.getLeft());
			final int sizeRight = this.getSize(this.root.getRight());
			if (sizeRight > sizeLeft) {
				final Node node = this.findMinimum(this.root.getRight());
				if (node != null) {
					this.root.setValue(node.getValue());
					this.remove(this.root.getRight(), node.getValue());
				}
			} else {
				final Node node = this.findMaximum(this.root.getLeft());
				if (node != null) {
					this.root.setValue(node.getValue());
					this.remove(this.root.getLeft(), node.getValue());
				}
			}

		} else {
			this.remove(this.root, value);
		}
	}

	private void remove(Node parent, int value) {
		if (parent == null) {
			return;
		}

		final Node left = parent.getLeft();
		final Node right = parent.getRight();

		if (left != null && left.getValue() == value) {
			if (left.hasNoChildren()) {
				parent.setLeft(null);
			} else if (left.hasOnlyOneChild()) {
				parent.setLeft(left.getOnlyChild());
			} else {
				final Node node = this.findMaximum(left);
				left.setValue(node.getValue());
				this.remove(left, node.getValue());
			}
		} else if (right != null && right.getValue() == value) {
			if (right.hasNoChildren()) {
				parent.setRight(null);
			} else if (right.hasOnlyOneChild()) {
				parent.setRight(right.getOnlyChild());
			} else {
				final Node node = this.findMinimum(right);
				right.setValue(node.getValue());
				this.remove(right, node.getValue());
			}
		} else if (value < parent.getValue()) {
			this.remove(left, value);
		} else if (value > parent.getValue()) {
			this.remove(right, value);
		}
	}

	private Node findMinimum(Node node) {
		if (node.getLeft() == null) {
			return node;
		}
		return this.findMinimum(node.getLeft());
	}

	private Node findMaximum(Node node) {
		if (node.getRight() == null) {
			return node;
		}
		return this.findMaximum(node.getRight());
	}

}
