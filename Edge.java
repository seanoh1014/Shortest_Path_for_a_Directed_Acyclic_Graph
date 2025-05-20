public class Edge {

    private Vertex target;
    private int weight;

    /*
     * Complete the constructor and add getter methods.
     */
    public Edge(Vertex target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    public Vertex getTarget() {
        return target;
    }

    public int getWeight() {
        return weight;
    }

}
