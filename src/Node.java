import java.util.ArrayList;

class Node {
    double priority;
    private Node parent;
    private String value;
    private int row, col,cost;
    private ArrayList<Node> neighbors;
    private boolean isStart, isGoal, isWall;

    public Node(String value, int row, int col) {
        this.value = value;
        this.row = row;
        this.col = col;
        this.parent = null;
        neighbors = new ArrayList<>();
        isStart = value.equals("I");
        isGoal = value.equals("F");
        isWall = value.equals("R") || value.equals("M");
        this.cost = Integer.MAX_VALUE;
    }
    public void setPriority(double priority) {
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


    public Node getParent() {
        return parent;
    }


    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Saber si es vecino de un nodo dado
     * @param other
     * @return
     */
    public boolean isNeighbor(Node other) {
        int rowDiff = Math.abs(this.row - other.row);
        int colDiff = Math.abs(this.col - other.col);
        return (rowDiff == 1 && colDiff == 0) || (rowDiff == 0 && colDiff == 1);
    }

}