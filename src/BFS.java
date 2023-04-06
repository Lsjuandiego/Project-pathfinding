import java.util.*;

class BFS {
    public static List<Node> search(Graph graph, Node start, Node goal) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> parents = new HashMap<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Node node = queue.remove();

            if (node.equals(goal)) {
                return getPath(start, goal, parents);
            }

            for (Node neighbor : node.getNeighbors()) {
                if (!visited.contains(neighbor) && !neighbor.isWall()) {
                    visited.add(neighbor);
                    parents.put(neighbor, node);
                    queue.add(neighbor);
                    visitedNodes.add(neighbor); // Add visited node to static list
                }
            }
        }

        return null; // No path found
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

    public static List<Node> visitedNodes = new ArrayList<>(); // Static list of visited nodes
}