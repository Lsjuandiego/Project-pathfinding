import java.util.ArrayList;

class Graph {
    private ArrayList<Node> nodes;
    private Node startNode;
    private Node goalNode;

    public Graph() {
        nodes = new ArrayList<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public Node getStartNode() {
        for (Node node : nodes) {
            if (node.isStart()) {
                startNode = node;
                break;
            }
        }
        return startNode;
    }

    public Node getGoalNode() {
        for (Node node : nodes) {
            if (node.isGoal()) {
                goalNode = node;
                break;
            }
        }
        return goalNode;
    }
    public ArrayList<Node> getNeighbors(Node node) {
        ArrayList<Node> neighbors = new ArrayList<>();
        int row = node.getRow();
        int col = node.getCol();
        int numRows = nodes.size();
        int numCols = nodes.get(0).getNeighbors().size();

        // Check the node above
        if (row > 0) {
            Node neighbor = nodes.get(row - 1).getNeighbors().get(col);
            if (!neighbor.getValue().equals("R") && !neighbor.getValue().equals("M")) {
                neighbors.add(neighbor);
            }
        }

        // Check the node below
        if (row < numRows - 1) {
            Node neighbor = nodes.get(row + 1).getNeighbors().get(col);
            if (!neighbor.getValue().equals("R") && !neighbor.getValue().equals("M")) {
                neighbors.add(neighbor);
            }
        }

        // Check the node to the left
        if (col > 0) {
            Node neighbor = nodes.get(row).getNeighbors().get(col - 1);
            if (!neighbor.getValue().equals("R") && !neighbor.getValue().equals("M")) {
                neighbors.add(neighbor);
            }
        }

        // Check the node to the right
        if (col < numCols - 1) {
            Node neighbor = nodes.get(row).getNeighbors().get(col + 1);
            if (!neighbor.getValue().equals("R") && !neighbor.getValue().equals("M")) {
                neighbors.add(neighbor);
            }
        }

        return neighbors;
    }
}