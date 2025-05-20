import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Vertex {

    private String name;
    private boolean visited;
    private List<Edge> edgeList;
    private int distance;
    private Vertex previous;

    /*
     * Initialize all instance variables
     * distance should be initialized to Integer.MAX_VALUE
     * previous should be set to null
     */
    public Vertex(String name) {
        this.name = name;
        this.visited = false;
        edgeList = new ArrayList<>();
        distance = Integer.MAX_VALUE;
        previous = null;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited(){
        return this.visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public void addEdge(Edge edge) {
        edgeList.add(edge);
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Vertex getPrevious() {
        return previous;
    }

    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        if (previous == null) {
            return name;
        } else {
            return previous.toString() + " - " + name;
        }
    }
}
