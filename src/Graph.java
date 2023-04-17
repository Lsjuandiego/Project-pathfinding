import java.util.ArrayList;

class Graph {

    private ArrayList<Node> nodes;
    private Node startNode;
    private Node goalNode;

    public Graph() {
        nodes = new ArrayList<>();
    }

    /**
     * Metodo para agregar nodo
     * @param node
     */
    public void addNode(Node node) {
        nodes.add(node);
    }

    /**
     * Obtener los nodos
     * @return
     */
    public ArrayList<Node> getNodes() {
        return nodes;
    }

    /**
     * Altura del mapa
     * @return
     */
    public int getHeight() {
        int numNodes = nodes.size();
        int numColumns = getColumnWidth();
        return (int) Math.floor(numNodes / numColumns);
    }

    /**
     * Ancho del mapa
     * @return
     */
    public int getColumnWidth() {
        if (getNodes().isEmpty()) {
            return 0;
        }
        int firstRow = getNodes().get(0).getRow();
        int count = 0;
        for (Node node : getNodes()) {
            if (node.getRow() == firstRow) {
                count++;
            }
        }
        return count;
    }

    /**
     * Obtiene el nodo inicio
     * @return
     */
    public Node getStartNode() {
        for (Node node : nodes) {
            if (node.isStart()) {
                startNode = node;
            }
        }
        return startNode;
    }

    /***
     * Obtiene el nodo final
     * @return
     */
    public Node getGoalNode() {
        for (Node node : nodes) {
            if (node.isGoal()) {
                goalNode = node;
            }
        }
        return goalNode;
    }

}