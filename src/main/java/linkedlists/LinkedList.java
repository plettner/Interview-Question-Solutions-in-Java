package linkedlists;

public class LinkedList {

	public class Node {

		private final Object value;
		private Node next;

		public Node(Object object) {
			this.value = object;
			this.next = null;
		}

		public Object getValue() {
			return this.value;
		}

		public Node getNext() {
			return this.next;
		}

		public void setNext(Node node) {
			this.next = node;
		}

		@Override
		public String toString() {
			if (this.value == null) {
				return "<null>";
			}
			return this.value.toString();
		}
	}

	private Node head = null;

	public LinkedList() {

	}

	public Object getHead() {
		final Node node = this.getHeadNode();
		if (node != null) {
			return node.getValue();
		}
		return null;
	}

	public Object getTail() {
		final Node node = this.getTailNode();
		if (node != null) {
			return node.getValue();
		}
		return null;
	}

	public Object getAt(int index) {
		if (index < 0 || index >= this.getLength()) {
			throw new IndexOutOfBoundsException("Index of " + index + " is out of range");
		}
		final Node node = this.getAtNode(index);
		if (node != null) {
			return node.getValue();
		}
		throw new RuntimeException("Shouldn't have null entries in node list");
	}

	public void insertAt(int index, Object value) {
		if (index < 0 || index > this.getLength()) {
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}

		final Node newNode = this.createNode(value);

		// Special case -- index = 0
		if (index == 0) {
			newNode.setNext(this.getHeadNode());
			this.setHeadNode(newNode);
			return;
		}

		int count = 0;
		Node node = this.getHeadNode();
		while (node != null) {
			count++;
			if (count == index) {
				newNode.setNext(node.getNext());
				node.setNext(newNode);
				return;
			}
			node = node.getNext();
		}
	}

	public void insertAfter(Object previousValue, Object newValue) {
		final Node node = this.findNode(previousValue);
		if (node != null) {
			// Didn't find that value
			// TODO: Should this throw an exception?
			return;
		}
		this.insertAfterNode(node, newValue);
	}

	private void insertAfterNode(Node node, Object value) {
		if (node == null) {
			return;
		}
		final Node newNode = this.createNode(value);
		newNode.setNext(node.getNext());
		node.setNext(newNode);
	}

	private Node findNode(Object value) {
		Node node = this.getHeadNode();
		while (node != null) {
			if (node.getValue().equals(value)) {
				return node;
			}
			node = node.getNext();
		}

		return null;
	}

	private Node findPreviousNode(Object value) {
		Node node = this.getHeadNode();
		while (node != null) {
			if (node.getNext() != null && node.getNext().getValue() != null
					&& node.getNext().getValue().equals(value)) {
				return node;
			}
			node = node.getNext();
		}
		return null;
	}

	public void append(Object object) {
		if (object == null) {
			return; // not allowing null entries in this list
		}
		final Node node = this.createNode(object);
		final Node tail = LinkedList.findTailNode(this.getHeadNode());
		if (tail == null) {
			this.setHeadNode(node);
		} else {
			tail.setNext(node);
		}

	}

	public int getLength() {
		int length = 0;
		Node node = this.getHeadNode();
		while (node != null) {
			length++;
			node = node.getNext();
		}
		return length;
	}

	private Node getHeadNode() {
		return this.head;
	}

	private void setHeadNode(Node node) {
		final Node nodeTail = LinkedList.findTailNode(node);
		if (nodeTail != null) {
			nodeTail.setNext(this.getHeadNode());
			this.head = node;
		}
	}

	private Node getTailNode() {
		return LinkedList.findTailNode(this.getHeadNode());
	}

	private static Node findTailNode(Node node) {
		if (node == null) {
			return null;
		}
		while (node.getNext() != null) {
			node = node.getNext();
		}
		return node;
	}

	private Node createNode(Object object) {
		return new Node(object);
	}

	private Node getAtNode(int index) {
		if (index < 0 || index >= this.getLength()) {
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
		int count = 0;
		Node node = this.getHeadNode();
		while (node != null) {
			if (count == index) {
				return node;
			}
			count++;
			node = node.getNext();
		}

		throw new IndexOutOfBoundsException("Somehow ran off the end of the list");
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("[");
		Node node = this.getHeadNode();
		while (node != null) {
			if (node != this.getHeadNode()) {
				sb.append(", ");
			}
			sb.append(node != null ? node.getValue().toString() : "<null>");
			node = node.getNext();
		}
		sb.append("]");
		return sb.toString();
	}

}
