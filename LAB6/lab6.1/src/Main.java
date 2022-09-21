public class Main {
    public static void main(String[] args) {

//        change num_vertex to see different output
        int num_vertex = 7;
        int[][] matrix = new int[num_vertex][num_vertex];

//        Random adjacency matrix -> matrix
        System.out.println("Random adjacency matrix of graph 1");
        for (int row=0; row<num_vertex; row++) {
            for (int col=0; col<num_vertex; col++) {
                int rand;
                if (Math.random() < 0.4) {
                    rand = (int) (Math.random() * 6);
                    System.out.print(rand + "\t\t");
                }
                else {
                    rand = 0;
                    System.out.print("0\t\t");
                }
                matrix[row][col] = rand;
            }
            System.out.println();
        }

        System.out.println("-----------------");
        System.out.println("Adjacency matrix created from graph 1");
        Graph g1 = new Graph(matrix);
        int[][] matrix_g1 = g1.toMatrix();
        printMatrix(matrix_g1);

        System.out.println("-----------------");
        System.out.println("Adjacency matrix created from graph 2");
        Graph g2 = new Graph(g1.getNum_vertex(), g1.getNum_edge());
        int[][] matrix_g2 = g2.toMatrix();
        printMatrix(matrix_g2);

    }

//    Additional method
    static void printMatrix(int[][] matrix) {
        for (int row=0; row<matrix.length; row++){
            for (int col=0; col<matrix[0].length; col++){
                System.out.print(matrix[row][col] + "\t\t");
            }
            System.out.println();
        }
    }
}
