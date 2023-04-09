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