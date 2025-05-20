import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<String> data = readData("data.txt");
        String start = "A", end = "J";
        Map<String, Vertex> graph = getGraph(data);

        for (Vertex v : graph.values()) {
            System.out.print("\n" + v + " ");
            for (Edge e : v.getEdgeList()) {
                System.out.print(e.getTarget());
            }
        }
        /*
         * Complete the main method
         * 1. Set the distance for Vertex A to zero.
         * 2. Create a TopologicalOrdering object
         * 3. Get the Deque of vertices from the TopologicalOrdering object
         * and print it out to make sure it looks correct. 
         * 4. Finally call compute and pass it the deque.
         */
        graph.get(start).setDistance(0);

        TopologicalOrdering order = new TopologicalOrdering(graph);

        System.out.println("\nTopological Order: " + order.getDeque());

        compute(order.getDeque());



        System.out.printf("\nShortest Path is: %s - %s\n", graph.get(end).getPrevious(), end);
        System.out.printf("Distance from %s to %s is %d\n\n", start, end, graph.get(end).getDistance());
    }

    /*
    * The compute method should poll a vertex off Deque and loop through
    * its edges getting each edge's target vertex. if the target's distance is
    * greater than the current vertex's distance plus the edge weight then set
    * the target's distance to the current distance plus the edge weight. Then
    * set the target's pervious vertex to the current vertex.
    *
    * Repeat until the Deque is empty
    */
    public static void compute(Deque<Vertex> deque) {
        while (!deque.isEmpty()) {
            Vertex current = deque.poll();

            for (Edge edge : current.getEdgeList()) {
                Vertex target = edge.getTarget();
                int distance = current.getDistance() + edge.getWeight();

                if (target.getDistance() > distance) {
                    target.setDistance(distance);
                    target.setPrevious(current);
                }
            }
        }

    }

    /*
     * The getGraph method should return a Map where the Key is the Vertex name
     * and the value is the Vertex. 
     *
     * data[0] will contains a list of vertices. Use a loop to create all the vertices. 
     *
     * Each subsequent line in data will contain an edge with a source, target, and
     * weight. For example "A B 4". You will create an Edge object "B 4" for source 
     * Vertex "A". For example, 
     * map.get("A").addEdge(new Edge(map.get("B"), Integer.parseInt("4")));
     * except that you will use loops and variables instead of hardcoding "A", "B",
     * and "4". You will need to use .split(" ") and Integer.parseInt()
     */
    public static Map<String, Vertex> getGraph(List<String> data) {
        Map<String, Vertex> graph = new HashMap<>();

        for (String current : data.get(0).split(" ")) {
            graph.put(current, new Vertex(current));
        }

        for (int i = 1; i < data.size(); i++) {
            String[] arr = data.get(i).split(" ");
            
            graph.get(arr[0]).addEdge(new Edge(graph.get(arr[1]), Integer.parseInt(arr[2])));
        }

        return graph;
    }

    public static List<String> readData(String filename) {
        List<String> list = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File(filename));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.length() > 0) {
                    list.add(line);
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Find not found");
        }
        return list;
    }
}
