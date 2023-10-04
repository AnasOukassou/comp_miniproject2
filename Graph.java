import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Graph {
    private final int nVertices;
    private int nEdges;
    private final List<List<Integer>> adjacencyList;

    public Graph(int n) {
        nVertices = n;
        nEdges = 0;

        adjacencyList = new ArrayList<>();
        for (int i = 0; i < nVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addVertex(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }

    public void addVertexNO(int source, int destination) {
        addVertex(source, destination);
        addVertex(destination, source);
        nEdges++;
    }

    public int getDegree(int vertex) {
        return adjacencyList.get(vertex).size();
    }

    public boolean isConnected(Integer node1, Integer node2) {
        return adjacencyList.get(node1).contains(node2);
    }

    public void printGraph() {
        for (int i = 0; i < nVertices; i++) {
            System.out.printf("(%d) =>", i);
            for (Integer vertex : adjacencyList.get(i)) {
                System.out.printf(" %d", vertex);
            }
            System.out.println();
        }
    }

    public boolean isDense(List<Integer> subgraphNodes) {
        for (int node1 = 0; node1 < subgraphNodes.size() - 1; node1++) {
            for (int node2 = node1 + 1; node2 < subgraphNodes.size(); node2++) {
                if (!isConnected(node1, node2)) return false;
            }
        }

        return true;
    }

    private int getSmallestDegreeVertex(List<Integer> vertices) {
        int min = vertices.get(0);
        for (int i = 1; i < vertices.size(); i++) {
            int degree = getDegree(vertices.get(1));
            if (degree < min) min = degree;
        }

        return min;
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addVertexNO(0, 1);
        g.addVertexNO(0, 2);
        g.addVertexNO(0, 3);
        g.addVertexNO(0, 4);
        g.addVertexNO(1, 2);
        g.addVertexNO(2, 3);
        g.printGraph();
    }
}
