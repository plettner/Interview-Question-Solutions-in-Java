package graph;

public class GraphBuilder {

	public final Node s1 = new Node("Westminster", null, null);
	public final Node s2 = new Node("Waterloo", this.s1, null);
	public final Node s3 = new Node("Trafalgar", this.s1, this.s2);
	public final Node s4 = new Node("Canary", this.s2, this.s3);
	public final Node s5 = new Node("London", this.s4, this.s3);
	public final Node s6 = new Node("Tottenham", this.s5, this.s4);
	public final Node s7 = new Node("NeverFound", null, null);

	public Node build() {
		return this.s6;
	}

}
