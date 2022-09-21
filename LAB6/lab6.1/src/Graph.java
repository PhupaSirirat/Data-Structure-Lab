import java.util.HashMap;

public class Graph {

    private int num_vertex;
    private int num_edge = 0;
    private Vertex[] v;
    private HashMap<Edge ,Integer> map;

//    Directed graph : a->b and b->a are different

    public Graph(int[][] matrix) {
        this.num_vertex = matrix.length;
        this.v = new Vertex[num_vertex];
        this.map = new HashMap();

        for (int i=0; i<num_vertex; i++) v[i] = new Vertex(i);

        for (int row=0; row<num_vertex; row++) {
            for (int col=0; col<num_vertex; col++) {
                if (matrix[row][col] != 0) {
                    map.put(new Edge(v[row],v[col]), matrix[row][col]);
                    num_edge++;
                }
            }
        }
    }

    public Graph(int num_vertex, int num_edge) {
        this.num_vertex = num_vertex;
        this.num_edge = num_vertex * num_vertex / 4;
        this.v = new Vertex[num_vertex];
        this.map = new HashMap<>();
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

    private int weight(Edge e) {
        if (!map.containsKey(e)) return 0;
        return map.get(e);
    }

    public int getNum_vertex(){
        return num_vertex;
    }
    public int getNum_edge(){
        return num_edge;
    }

    public int[][] toMatrix() {
        int[][] matrix = new int[num_vertex][num_vertex];
        for (int row=0; row<num_vertex; row++) {
            for (int col=0; col<num_vertex; col++) {
                Vertex r = new Vertex(row);
                Vertex c = new Vertex(col);
                Edge e = new Edge(r,c);
                matrix[row][col] = weight(e);
            }
        }
        return matrix;
    }
}
