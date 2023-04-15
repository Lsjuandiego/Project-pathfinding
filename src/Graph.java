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

    public int getHeight() {
        int numNodes = nodes.size();
        int numColumns = getColumnWidth();
        return (int) Math.floor(numNodes / numColumns);
    }

    public int getColumnWidth() {
        if (getNodes().isEmpty()) {
            return 0;
        }
        // Column width is the number of nodes in the first row
        int firstRow = getNodes().get(0).getRow();
        int count = 0;
        for (Node node : getNodes()) {
            if (node.getRow() == firstRow) {
                count++;
            }
        }
        return count;
    }
    public Node getStartNode() {
        for (Node node : nodes) {
            if (node.isStart()) {
                startNode = node;
            }
        }
        return startNode;
    }

    public Node getGoalNode() {
        for (Node node : nodes) {
            if (node.isGoal()) {
                goalNode = node;
            }
        }
        return goalNode;
    }

}