import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int num_vertex = 9;
        int num_edge = 0;
        int[][] matrix = new int[num_vertex][num_vertex];

//        Create matrix
        for (int row=0; row<num_vertex; row++) {
            for (int col=0; col<num_vertex; col++) {
                int rand;
                if (Math.random() < 0.25 && matrix[row][col]==0) {
                    rand = (int) (Math.random() * 5) + 1;
                    num_edge++;
                }
                else {
                    rand = matrix[row][col];
                }
                matrix[row][col] = matrix[col][row] = rand;
            }
        }

//        print matrix
        System.out.println("adjacency matrix");
        for (int i=0; i< matrix.length; i++){
            for (int j=0; j< matrix.length; j++){
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }

        Graph graph = new Graph(matrix, num_edge);
        System.out.println(graph);


    }
}
