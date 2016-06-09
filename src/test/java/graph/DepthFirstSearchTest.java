package graph;

import org.junit.Assert;
import org.junit.Test;

public class DepthFirstSearchTest {

	private final GraphBuilder graphBuilder = new GraphBuilder();
	private final DepthFirstSearch dfs = new DepthFirstSearch();

	@Test
	public void dfs_found() {
		final Node goal = this.graphBuilder.s3;
		System.out.println("Looking for " + goal.getValue());
		final Node node = this.graphBuilder.build();
		final boolean actual = this.dfs.dfs(node, this.graphBuilder.s3);
		Assert.assertTrue(actual);
		System.out.println("---");
	}

	@Test
	public void dfs_found_s1() {
		final Node goal = this.graphBuilder.s1;
		System.out.println("Looking for " + goal.getValue());
		final Node node = this.graphBuilder.build();
		final boolean actual = this.dfs.dfs(node, this.graphBuilder.s1);
		Assert.assertTrue(actual);
		System.out.println("---");
	}

	@Test
	public void dfs_cannotFind() {
		final Node goal = this.graphBuilder.s7;
		System.out.println("Looking for " + goal.getValue());
		final Node node = this.graphBuilder.build();
		final boolean actual = this.dfs.dfs(node, this.graphBuilder.s7);
		Assert.assertFalse(actual);
		System.out.println("---");
	}

}
