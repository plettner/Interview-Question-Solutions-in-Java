package graph;

import org.junit.Assert;
import org.junit.Test;

public class BreadthFirstSearchTest {

	private final GraphBuilder graphBuilder = new GraphBuilder();
	private final BreadthFirstSearch bfs = new BreadthFirstSearch();

	@Test
	public void bfs_found() {
		final boolean expected = true;
		final Node node = this.graphBuilder.build();
		final boolean actual = this.bfs.compute(node, this.graphBuilder.s3);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void bfs_cannotFind() {
		final boolean expected = false;
		final Node node = this.graphBuilder.build();
		final boolean actual = this.bfs.compute(node, this.graphBuilder.s7);
		Assert.assertEquals(expected, actual);
	}

}
