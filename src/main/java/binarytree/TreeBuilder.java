package binarytree;

public class TreeBuilder {

	public Node n1 = new Node(1, null, null);
	public Node n3 = new Node(3, null, null);
	public Node n2 = new Node(2, this.n1, this.n3);

	public Node n5 = new Node(5, null, null);
	public Node n7 = new Node(7, null, null);
	public Node n6 = new Node(6, this.n5, this.n7);

	public Node n4 = new Node(4, this.n2, this.n6);

	public TreeBuilder() {
	}

	/**
	 * Tree is already built. Just return the "trunk" of the tree.
	 * 
	 * @return the trunk node of the tree
	 */
	public Node build() {
		return this.n4;
	}

}
