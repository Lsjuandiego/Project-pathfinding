import java.util.ArrayList;

class Node {
    int priority;
    private Node parent;
    private String value;
    private int row, col,cost;
    private ArrayList<Node> neighbors;
    private boolean isStart, isGoal, isWall;
    private static final int UNIT_COST = 1; // Costo uniforme para todas las aristas

    public Node(String value, int row, int col) {
        this.value = value;
        this.row = row;
        this.col = col;
        this.parent = null;
        neighbors = new ArrayList<>();
        isStart = value.equals("I");
        isGoal = value.equals("F");
        isWall = value.equals("R") || value.equals("M");
        this.cost = 0;
    }
    public void setPriority(int priority) {
        this.priority = priority;
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


    public int getCost() {
        return UNIT_COST;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}