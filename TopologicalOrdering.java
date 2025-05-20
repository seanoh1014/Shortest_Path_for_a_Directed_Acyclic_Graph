import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.Map;

public class TopologicalOrdering {

    private Deque<Vertex> deque = new LinkedList<>();

    /*
     * The code in the method is very similar to the code
     * in the TopologicalOrdering assignment.
     *
     * Loop through the vertices (values) in the graph map.
     * if the vertex has not been visited then call dfs with
     * that vertex.
     */
    public TopologicalOrdering(Map<String, Vertex> graph) {
        for (Vertex current : graph.values()) {
            if (current.isVisited() == false) {
                dfs(current);
            }
        }

    }

    /*
     * This method is almost identical to the dfs method from the
     * Topological Ordering assignment except that you will loop
     * through the given vertes's edges and get the vertex
     * associated with each edge.
     *
     * Note: Deque<Vertex> deque is an instance variable so it 
     * doesn't need to be passed to the dfs method.
     */
    private void dfs(Vertex vertex) {
        vertex.setVisited(true);

        for (Edge edge : vertex.getEdgeList()) {
            if (edge.getTarget().isVisited() == false) {
                dfs(edge.getTarget());
            }
        }
        
        deque.push(vertex);
    }

    public Deque<Vertex> getDeque() {
        return this.deque;
    }
}
