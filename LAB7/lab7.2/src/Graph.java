import java.security.spec.ECGenParameterSpec;
import java.util.HashMap;

public class Graph {

    private int num_vertex;
    private int num_edge;
    private Vertex[] v;
    private LinearProbingHashMap map;

//    Undirected graph : a->b and b->a are the same
    public Graph(int[][] matrix, int num_edge) {
        this.num_vertex = matrix.length;
        this.v = new Vertex[num_vertex];
        this.map = new LinearProbingHashMap(num_edge);

        for (int i=0; i<num_vertex; i++) v[i] = new Vertex(i);

        for (int row=0; row<num_vertex; row++) {
            for (int col=0; col<num_vertex; col++) {
                Edge edge = new Edge(v[row],v[col]);
                Edge edge_t = new Edge(v[col],v[row]);
                if (matrix[row][col] != 0 && !map.containsKey(edge_t)) {
                    map.put(edge, matrix[row][col]);
                    num_edge++;
                }
            }
        }
    }

    public Graph(int num_vertex, int num_edge) {
        this.num_vertex = num_vertex;
        this.num_edge = num_vertex * num_vertex / 4;
        this.v = new Vertex[num_vertex];
        this.map = new LinearProbingHashMap(num_edge);
        for (int i=0; i<num_vertex; i++) v[i] = new Vertex(i);

        int[][] matrix = new int[num_vertex][num_vertex];
        for (int row=0; row<num_vertex; row++) {
             for (int col=0; col<num_vertex; col++) {
                 matrix[row][col] = 0;
             }
        }

        int i=0;
        while (i<this.num_edge) {
            int row = (int) (Math.random() * (num_vertex));
            int col = (int) (Math.random() * (num_vertex));
            if (matrix[row][col] == 0) {
                  map.put(new Edge(v[row],v[col]), (int) (Math.random() * 4) + 1);
                i++;
            }
        }
    }

    public String toString() {
        System.out.println(map.toString());
        return "";
    }

}
