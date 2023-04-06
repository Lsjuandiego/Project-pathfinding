import java.util.*;

class DFS {
    public static List<Node> search(Graph graph, Node start, Node goal) {
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> parents = new HashMap<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            if (node.equals(goal)) {
                return getPath(start, goal, parents);
            }

            if (!visited.contains(node) && !node.isWall()) {
                visited.add(node);
                System.out.println("Visited: " + node.getValue() + " at (" + node.getRow() + ", " + node.getCol() + ")");

                for (Node neighbor : node.getNeighbors()) {
                    if (!visited.contains(neighbor) && !neighbor.isWall()) {
                        parents.put(neighbor, node);
                        stack.push(neighbor);
                    }
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
}