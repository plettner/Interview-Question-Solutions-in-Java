package binarytree;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeManagerTest {

	private final TreeBuilder treeBuilder = new TreeBuilder();
	private final BinaryTreeManager search = new BinaryTreeManager();

	@Test
	public void search_success() {
		final int goal = 5;
		System.out.println("Searching for " + goal);
		final Node node = this.treeBuilder.build();
		final boolean actual = this.search.search(node, 5);
		Assert.assertTrue(actual);
		System.out.println("===");
	}

	@Test
	public void search_failed() {
		final int goal = 55;
		System.out.println("Searching for " + goal);
		final Node node = this.treeBuilder.build();
		final boolean actual = this.search.search(node, 55);
		Assert.assertFalse(actual);
		System.out.println("===");
	}

}
