package binarytree;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTest {

	private BinaryTree buildTree(int[] data) {
		final BinaryTree tree = new BinaryTree();
		for (int index = 0; index < data.length; index++) {
			tree.insert(data[index]);
		}
		return tree;
	}

	@Test
	public void insertSimple() {
		final BinaryTree tree = new BinaryTree();
		tree.insert(10);
		Assert.assertEquals(1, tree.getSize());
		tree.insert(20);
		Assert.assertEquals(2, tree.getSize());
	}

	@Test
	public void searchFound() {
		final int expectedValues[] = { 25, 15, 10, 20, 35, 30, 40 };
		final BinaryTree tree = this.buildTree(expectedValues);
		Assert.assertEquals(7, tree.getSize());

		for (int index = 0; index < expectedValues.length; index++) {
			Assert.assertNotNull(tree.search(expectedValues[index]));
		}
	}

	@Test
	public void searchNotFound() {
		final int expectedValues[] = { 25, 15, 10, 20, 35, 30, 40 };
		final BinaryTree tree = this.buildTree(expectedValues);
		Assert.assertEquals(7, tree.getSize());
		Assert.assertNull(tree.search(100));
		Assert.assertNull(tree.search(0));
	}

	@Test
	public void deleteInOrder() {
		final int expectedValues[] = { 25, 15, 10, 20, 35, 30, 40 };
		final BinaryTree tree = this.buildTree(expectedValues);

		tree.inOrderTraversal(new PrintNodeHandler());
		for (int index = 0; index < expectedValues.length; index++) {
			System.out.println("Remove " + expectedValues[index]);
			tree.remove(expectedValues[index]);
			tree.inOrderTraversal(new PrintNodeHandler());
		}
	}

	@Test
	public void deleteMinValue() {
		final int expectedValue = 10;
		final int expectedValues[] = { 25, 15, expectedValue, 20, 35, 30, 40 };
		final BinaryTree tree = this.buildTree(expectedValues);

		tree.inOrderTraversal(new PrintNodeHandler());
		System.out.println("Remove " + expectedValue);
		tree.remove(expectedValue);
		tree.inOrderTraversal(new PrintNodeHandler());
	}

	@Test
	public void deleteMaxValue() {
		final int expectedValue = 40;
		final int expectedValues[] = { 25, 15, 10, 20, 35, 30, expectedValue };
		final BinaryTree tree = this.buildTree(expectedValues);

		tree.inOrderTraversal(new PrintNodeHandler());
		System.out.println("Remove " + expectedValue);
		tree.remove(expectedValue);
		tree.inOrderTraversal(new PrintNodeHandler());
	}

	@Test
	public void deleteRoot() {
		final int expectedValue = 25;
		final int expectedValues[] = { expectedValue, 15, 10, 20, 35, 30, 40 };
		final BinaryTree tree = this.buildTree(expectedValues);

		tree.inOrderTraversal(new PrintNodeHandler());
		System.out.println("Remove " + expectedValue);
		tree.remove(expectedValue);
		tree.inOrderTraversal(new PrintNodeHandler());

	}

	@Test
	public void deleteRootOfTwo() {
		final int expectedValue = 30;
		final int expectedValues[] = { expectedValue, 40 };
		final BinaryTree tree = this.buildTree(expectedValues);

		tree.inOrderTraversal(new PrintNodeHandler());
		System.out.println("Remove " + expectedValue);
		tree.remove(expectedValue);
		tree.inOrderTraversal(new PrintNodeHandler());
		Assert.assertEquals(1, tree.getSize());
	}
}
