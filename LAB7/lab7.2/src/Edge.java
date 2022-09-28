import java.util.Objects;

public class Edge {
    private Vertex st, end;
    public Edge(Vertex b, Vertex e) {
        st = b;
        end = e;
    }
    public int getSource() {
        return st.getName();
    }
    public int getDest() {
        return end.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(st, edge.st) && Objects.equals(end, edge.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(st, end);
    }

    public String toString(){
        return st + " - " + end;
    }
}
