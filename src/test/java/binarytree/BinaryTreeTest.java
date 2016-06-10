package binarytree;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTest {

	@Test
	public void insertSimple() {
		final BinaryTree tree = new BinaryTree();
		tree.insert(10);
		Assert.assertEquals(1, tree.getSize());
		tree.insert(20);
		Assert.assertEquals(2, tree.getSize());
	}

	@Test
	public void search() {
		final int expectedValues[] = { 25, 15, 10, 20, 35, 30, 40 };
		final BinaryTree tree = new BinaryTree();
		for (int index = 0; index < expectedValues.length; index++) {
			tree.insert(expectedValues[index]);
		}

		Assert.assertEquals(7, tree.getSize());

		for (int index = 0; index < expectedValues.length; index++) {
			Assert.assertNotNull(tree.search(expectedValues[index]));
		}

		Assert.assertNull(tree.search(100));
		Assert.assertNull(tree.search(0));

	}

}
