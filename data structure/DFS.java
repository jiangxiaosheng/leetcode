import java.util.*;

public class DFS {
    static class Graph {
        private final List<List<Integer>> vertices;
        private final boolean[] visited;

        public Graph(int numVertices) {
            vertices = new LinkedList<>();
            for (int i = 0; i < numVertices; i++) {
                vertices.add(new LinkedList<>());
            }
            visited = new boolean[numVertices];
            Arrays.fill(visited, false);
        }

        public void addEdge(int src, int dest) {
            vertices.get(src).add(dest);
            vertices.get(dest).add(src);
        }
    }

    private final Graph graph;
    private int cutVertex = -1;

    public DFS(Graph graph) {
        this.graph = graph;
    }

    public void DFSTraverse(int begin) {
        Arrays.fill(graph.visited, false);
        traverse(begin);
    }

    private void traverse(int vertex) {
        graph.visited[vertex] = true;
        System.out.print(vertex + " ");

        boolean flag = true;
        for (int next : graph.vertices.get(vertex)) {
            if (!graph.visited[next]) {
                traverse(next);
                flag = false;
            }
        }
        if (flag)
            cutVertex = vertex;
    }

    /**
     * @return the vertex that can be removed while the sub-graph is still connected
     */
    public int findCutVertex() {
        return cutVertex;
    }
}
