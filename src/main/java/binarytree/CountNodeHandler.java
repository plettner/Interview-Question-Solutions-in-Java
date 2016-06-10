package binarytree;

public class CountNodeHandler implements NodeHandler {

	private int count = 0;

	public void reset() {
		this.count = 0;
	}

	public int getCount() {
		return this.count;
	}

	@Override
	public void process(Node node) {
		this.count++;
	}

	@Override
	public void processDone() {
		// Nothing to do here
	}

}
