import java.util.*;

class AStar {
    private static final int COST_STRAIGHT = 10;
    private static final int COST_DIAGONAL = 14;

    public static List<Node> search(Graph graph, Node start, Node goal, String heuristic) {
        PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> parents = new HashMap<>();
        Map<Node, Integer> gCosts = new HashMap<>();
        Map<Node, Integer> fCosts = new HashMap<>();

        gCosts.put(start, 0);
        fCosts.put(start, calculateHeuristic(start, goal, heuristic));
        queue.add(start);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.equals(goal)) {
                return getPath(start, goal, parents);
            }

            visited.add(node);

            for (Node neighbor : node.getNeighbors()) {
                int gCost = gCosts.get(node) + getCost(node, neighbor);
                int fCost = gCost + calculateHeuristic(neighbor, goal, heuristic);

                if (visited.contains(neighbor) || neighbor.isWall()) {
                    continue;
                }

                if (!queue.contains(neighbor) || fCost < fCosts.get(neighbor)) {
                    parents.put(neighbor, node);
                    gCosts.put(neighbor, gCost);
                    fCosts.put(neighbor, fCost);

                    if (!queue.contains(neighbor)) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        return null; // No path found
    }

    private static int getCost(Node node, Node neighbor) {
        int rowDiff = Math.abs(node.getRow() - neighbor.getRow());
        int colDiff = Math.abs(node.getCol() - neighbor.getCol());

        if (rowDiff == 0 || colDiff == 0) {
            return COST_STRAIGHT;
        } else {
            return COST_DIAGONAL;
        }
    }

    private static int calculateHeuristic(Node node, Node goal, String heuristic) {
        int rowDiff = Math.abs(node.getRow() - goal.getRow());
        int colDiff = Math.abs(node.getCol() - goal.getCol());

        if (heuristic.equals("manhattan")) {
            return (rowDiff + colDiff) * COST_STRAIGHT;
        } else if (heuristic.equals("euclidean")) {
            return (int) (Math.sqrt(rowDiff * rowDiff + colDiff * colDiff) * COST_STRAIGHT);
        } else {
            throw new IllegalArgumentException("Invalid heuristic: " + heuristic);
        }
    }

    private static List<Node> getPath(Node start, Node goal, Map<Node, Node> parents) {
        List<Node> path = new ArrayList<>();
        Node current = goal;

        while (!current.equals(start)) {
            path.add(0, current);
            current = parents.get(current);
        }

        path.add(0, start);
        return path;
    }

    static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node node1, Node node2) {
            return Integer.compare(getFCost(node1), getFCost(node2));
        }

        private int getFCost(Node node) {
            return node.getFCost();
        }
    }
}