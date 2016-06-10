package binarytree;

public interface NodeHandler {

	/**
	 * This method should do something to a node. You know, like print it out.
	 *
	 * @param node
	 *            a binary tree node
	 */
	void process(Node node);

	/**
	 * Wrap up any processing of nodes. Perhaps print a newline.
	 */
	void processDone();

}
