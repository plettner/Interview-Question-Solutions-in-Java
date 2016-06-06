package linkedlists;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

	@Test
	public void threeValues() {
		final int[] expected = { 1, 2, 3 };
		final LinkedList linkedList = new LinkedList();
		for (final int value : expected) {
			linkedList.append(value);
		}

		Assert.assertEquals(expected.length, linkedList.getLength());
		Assert.assertEquals(expected[0], linkedList.getHead());
		Assert.assertEquals(expected[expected.length - 1], linkedList.getTail());
	}

	@Test
	public void oneValue() {
		final Integer expected = 100;
		final LinkedList linkedList = new LinkedList();
		linkedList.append(expected);
		Integer actual = (Integer) linkedList.getHead();
		Assert.assertEquals(expected, actual);
		actual = (Integer) linkedList.getTail();
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void twoValues() {
		final Integer expectedHead = 1;
		final Integer expectedTail = 2;
		final LinkedList linkedList = new LinkedList();
		linkedList.append(expectedHead);
		linkedList.append(expectedTail);
		Integer actual = (Integer) linkedList.getHead();
		Assert.assertEquals(expectedHead, actual);
		actual = (Integer) linkedList.getTail();
		Assert.assertEquals(expectedTail, actual);
	}

	@Test
	public void getAt() {
		final Integer[] expected = { 1, 2, 3, 4, 5 };
		final LinkedList linkedList = new LinkedList();
		for (final int value : expected) {
			linkedList.append(value);
		}

		Assert.assertEquals(expected.length, linkedList.getLength());
		for (int index = 0; index < expected.length; index++) {
			final Integer actual = (Integer) linkedList.getAt(index);
			Assert.assertEquals(expected[index], actual);
		}
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void getAtZero() {
		final Integer[] expected = { 1, 2, 3, 4, 5 };
		final LinkedList linkedList = new LinkedList();
		for (final int value : expected) {
			linkedList.append(value);
		}

		linkedList.getAt(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void getAtTooBig() {
		final Integer[] expected = { 1, 2, 3, 4, 5 };
		final LinkedList linkedList = new LinkedList();
		for (final int value : expected) {
			linkedList.append(value);
		}

		linkedList.getAt(linkedList.getLength() + 10);
	}

	@Test
	public void insertAtEmptyList() {
		final LinkedList linkedList = new LinkedList();
		final Integer expected = 10;
		linkedList.insertAt(0, expected);
		final Integer actual = (Integer) linkedList.getAt(0);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void insertAtSecondEmptyList() {
		final LinkedList linkedList = new LinkedList();
		final Integer expected = 10;
		linkedList.insertAt(0, 5);
		linkedList.insertAt(1, expected);
		final Integer actual = (Integer) linkedList.getAt(1);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void insertAtManyEmptyList() {
		final LinkedList linkedList = new LinkedList();
		for (int index = 0; index < 10; index++) {
			linkedList.insertAt(index, index);
		}

		for (int index = 0; index < 10; index++) {
			final Integer actual = (Integer) linkedList.getAt(index);
			Assert.assertEquals(Integer.valueOf(index), actual);
		}
	}

	@Test
	public void deleteAtEachLast() {
		final LinkedList linkedList = new LinkedList();
		for (int index = 0; index < 10; index++) {
			linkedList.insertAt(index, index);
		}

		while (linkedList.getLength() > 0) {
			linkedList.deleteAt(linkedList.getLength() - 1);
		}
	}

	@Test
	public void deleteHead() {
		final LinkedList linkedList = new LinkedList();
		for (int index = 0; index < 10; index++) {
			linkedList.insertAt(index, index);
		}

		while (linkedList.getLength() > 0) {
			linkedList.deleteAt(0);
		}
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void deleteNegOne() {
		final LinkedList linkedList = new LinkedList();
		linkedList.deleteAt(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void deleteTooBig() {
		final LinkedList linkedList = new LinkedList();
		linkedList.deleteAt(100);
	}

	@Test
	public void isCircular() {
		final LinkedList linkedList = new LinkedList();
		for (int index = 0; index < 5; index++) {
			linkedList.insertAt(index, index);
		}

		Assert.assertFalse(linkedList.isCircular());
	}

	@Test
	public void isCircularYes() {
		final LinkedList linkedList = new LinkedList();
		for (int index = 0; index < 8; index++) {
			linkedList.insertAt(index, index);
		}

		linkedList.makeCircular(0, linkedList.getLength() - 1);

		Assert.assertTrue(linkedList.isCircular());
	}

}
