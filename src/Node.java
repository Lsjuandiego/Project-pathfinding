import java.util.ArrayList;

class Node {
    private String value;
    private int row;
    private int col;
    private ArrayList<Node> neighbors;
    private boolean isStart;
    private boolean isGoal;
    private boolean isWall;

    public Node(String value, int row, int col) {
        this.value = value;
        this.row = row;
        this.col = col;
        neighbors = new ArrayList<>();
        isStart = value.equals("I");
        isGoal = value.equals("F");
        isWall = value.equals("R") || value.equals("M");
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

    public boolean isStart() {
        return isStart;
    }

    public boolean isGoal() {
        return isGoal;
    }

    public boolean isWall() {
        return isWall;
    }
}