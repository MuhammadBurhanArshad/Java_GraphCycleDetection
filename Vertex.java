/* 
 * Vertex class representing a graph vertex
 * 
 * @variables:
    * label: The label of the vertex
    * visited: A boolean variable to track whether the vertex has been visited
 *   
 *
 * @methods:
    * Vertex(char label): Constructor to initialize the vertex with a label
 */

class Vertex {
    char label;
    boolean visited;

    public Vertex(char label) {
        this.label = label;
        this.visited = false;
    }
}