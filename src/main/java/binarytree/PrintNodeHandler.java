package binarytree;

public class PrintNodeHandler implements NodeHandler {

	@Override
	public void process(Node node) {
		System.out.print(String.valueOf(node.getValue()) + " ");
	}

	@Override
	public void processDone() {
		System.out.println();
	}
}
