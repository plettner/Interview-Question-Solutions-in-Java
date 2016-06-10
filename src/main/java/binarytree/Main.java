package binarytree;

public class Main {

	private BinaryTree buildTree() {
		final BinaryTree binaryTree = new BinaryTree();
		binaryTree.insert(10);
		binaryTree.insert(3);
		binaryTree.insert(5);
		binaryTree.insert(0);
		binaryTree.insert(17);
		binaryTree.insert(15);
		binaryTree.insert(20);
		return binaryTree;
	}

	public void go() {
		final BinaryTree binaryTree = this.buildTree();

		System.out.println("Post Order Traversal");
		binaryTree.postOrderTraversal(new PrintNodeHandler());

		System.out.println("In Order Traversal");
		binaryTree.inOrderTraversal(new PrintNodeHandler());

		System.out.println("Tree size = " + binaryTree.getSize());
	}

	public static void main(String[] args) {
		new Main().go();
	}
}
