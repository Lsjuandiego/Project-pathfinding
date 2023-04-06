import java.util.ArrayList;

class Node {
    private String value;
    private int row;
    private int col;
    private ArrayList<Node> neighbors;

    public Node(String value, int row, int col) {
        this.value = value;
        this.row = row;
        this.col = col;
        neighbors = new ArrayList<>();
    }

    public String getValue() {
        return value;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void addNeighbor(Node neighbor) {
        neighbors.add(neighbor);
    }

    public ArrayList<Node> getNeighbors() {
        return neighbors;
    }
}