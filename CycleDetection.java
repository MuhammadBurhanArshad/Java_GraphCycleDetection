/*
 * Main class for testing cycle detection in a graph
 * 
 * @methods:
    * main(String[] args): Main method to test cycle detection 
 */

public class CycleDetection {
    public static void main(String[] args) {
        char[] vertices = { 'A', 'B', 'C', 'D', 'E' };

        GraphCycleDetection graph = new GraphCycleDetection(vertices);
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('B', 'C');
        graph.addEdge('B', 'D');
        graph.addEdge('C', 'E');

        boolean containsCycle = graph.hasCycle();
        System.out.println("Does the graph contain a cycle? " + containsCycle);
    }
}
