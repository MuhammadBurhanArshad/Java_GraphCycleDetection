/*
 * Graph class to detect cycles
 * 
 * @variables:
    * vertices: Array of vertices
    * adjacencyMatrix: Adjacency matrix representation
    * vertexCount: Number of vertices
 *
 * @methods:
    * GraphCycleDetection(char[] vertexLabels): Constructor to initialize the graph with vertices
    * addEdge(char u, char v): Add an edge between two vertices
    * getIndex(char vertex): Get the index of a vertex
    * hasCycle(): Detect if the graph contains a cycle
    * dfs(int currentIndex, int parentIndex): Depth-First Search (DFS) to detect cycles
 */

class GraphCycleDetection {
    private Vertex[] vertices;
    private int[][] adjacencyMatrix;
    private int vertexCount;

    public GraphCycleDetection(char[] vertexLabels) {
        vertexCount = vertexLabels.length;
        vertices = new Vertex[vertexCount];
        adjacencyMatrix = new int[vertexCount][vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            vertices[i] = new Vertex(vertexLabels[i]);
            for (int j = 0; j < vertexCount; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    public void addEdge(char u, char v) {
        int uIndex = getIndex(u);
        int vIndex = getIndex(v);
        if (uIndex != -1 && vIndex != -1) {
            adjacencyMatrix[uIndex][vIndex] = 1;
            adjacencyMatrix[vIndex][uIndex] = 1;
        }
    }

    private int getIndex(char vertex) {
        for (int i = 0; i < vertexCount; i++) {
            if (vertices[i].label == vertex) {
                return i;
            }
        }
        return -1;
    }

    public boolean hasCycle() {
        for (int i = 0; i < vertexCount; i++) {
            if (!vertices[i].visited) {
                if (dfs(i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int currentIndex, int parentIndex) {
        vertices[currentIndex].visited = true;

        for (int i = 0; i < vertexCount; i++) {
            if (adjacencyMatrix[currentIndex][i] == 1) {
                if (!vertices[i].visited) {
                    if (dfs(i, currentIndex)) {
                        return true;
                    }
                } else if (i != parentIndex) {
                    return true;
                }
            }
        }
        return false;
    }
}
