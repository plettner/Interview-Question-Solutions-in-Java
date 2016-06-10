package binarytree;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeManagerTest {

	private final TreeBuilder treeBuilder = new TreeBuilder();
	private final BinaryTreeManager manager = new BinaryTreeManager();

	@Test
	public void search_success() {
		final int goal = 5;
		System.out.println("Searching for " + goal);
		final Node node = this.treeBuilder.build();
		final boolean actual = this.manager.search(node, 5);
		Assert.assertTrue(actual);
		System.out.println("===");
	}

	@Test
	public void search_failed() {
		final int goal = 55;
		System.out.println("Searching for " + goal);
		final Node node = this.treeBuilder.build();
		final boolean actual = this.manager.search(node, 55);
		Assert.assertFalse(actual);
		System.out.println("===");
	}

	@Test
	public void insertBig() {
		final int expectedValue = 12;
		final Node root = this.treeBuilder.build();
		this.manager.insert(root, expectedValue);
		final boolean actual = this.manager.search(root, expectedValue);
		Assert.assertTrue(actual);
	}

	@Test
	public void insertSmall() {
		final int expectedValue = 0;
		final Node root = this.treeBuilder.build();
		this.manager.insert(root, expectedValue);
		final boolean actual = this.manager.search(root, expectedValue);
		Assert.assertTrue(actual);
	}

}
