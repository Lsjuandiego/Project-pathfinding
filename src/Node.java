import java.util.ArrayList;

class Node {
    private String value;
    private int row;
    private int col;
    private ArrayList<Node> neighbors;
    private boolean isStart;
    private boolean isGoal;
    private boolean isWall;
    private int costSoFar;
    private double estimatedTotalCost;
    private int fCost; // costo total del nodo (gCost + hCost)

    public Node(String value, int row, int col) {
        this.value = value;
        this.row = row;
        this.col = col;
        neighbors = new ArrayList<>();
        isStart = value.equals("I");
        isGoal = value.equals("F");
        isWall = value.equals("R") || value.equals("M");
        this.costSoFar = Integer.MAX_VALUE;
        this.estimatedTotalCost = Integer.MAX_VALUE;
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

    public int getFCost() {
        return fCost;
    }

    public boolean isNeighbor(Node other) {
        int rowDiff = Math.abs(this.row - other.row);
        int colDiff = Math.abs(this.col - other.col);
        return (rowDiff == 1 && colDiff == 0) || (rowDiff == 0 && colDiff == 1);
    }

    public void setEstimatedTotalCost(Node goal) {
        int manhattanDist = Math.abs(goal.row - this.row) + Math.abs(goal.col - this.col);
        this.estimatedTotalCost = this.costSoFar + manhattanDist;
    }
    public int getCostSoFar() {
        return costSoFar;
    }

    public void setCostSoFar(int costSoFar) {
        this.costSoFar = costSoFar;
    }

    public double getEstimatedTotalCost() {
        return estimatedTotalCost;
    }

    public void setEstimatedTotalCost(double estimatedTotalCost) {
        this.estimatedTotalCost = estimatedTotalCost;
    }

}