import java.util.*;

class GraphSearch {
    public static List<Node> bfs(Graph graph) {
        Node start = graph.getStartNode();
        Node goal = graph.getGoalNode();

        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> parents = new HashMap<>();

        queue.offer(start);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.equals(goal)) {
                return getPath(start, goal, parents);
            }

            if (!visited.contains(node) && !node.isWall()) {
                visited.add(node);
                System.out.println("Visited: " + node.getValue() + " at (" + node.getRow() + ", " + node.getCol() + ")");

                for (Node neighbor : node.getNeighbors()) {
                    if (!visited.contains(neighbor) && !neighbor.isWall()) {
                        parents.put(neighbor, node);
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return null; // No path found
    }

    public static List<Node> dfs(Graph graph) {
        Node start = graph.getStartNode();
        Node goal = graph.getGoalNode();

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

    //costo uniforme
    public static List<Node> uniformCostSearch(Graph graph) {
        // Set initial cost of start node to zero
        Node start = graph.getStartNode();
        start.setCost(0);

        // Initialize frontier as a priority queue ordered by node cost
        PriorityQueue<Node> frontier = new PriorityQueue<>(Comparator.comparing(Node::getCost));
        frontier.add(start);

        // Initialize explored set
        Set<Node> explored = new HashSet<>();

        // Search for goal node
        while (!frontier.isEmpty()) {
            // Get node with lowest cost in frontier
            Node current = frontier.poll();

            // Check if current node is goal node
            if (current.isGoal()) {
                // Reconstruct path from start to goal node and return it
                List<Node> path = new ArrayList<>();
                Node node = current;
                while (node != null) {
                    path.add(node);
                    node = node.getParent();
                }
                Collections.reverse(path);
                return path;
            }

            // Add current node to explored set
            explored.add(current);

            // Expand current node and add its neighbors to frontier
            for (Node neighbor : graph.getNeighbors(current)) {
                // Skip neighbors that have already been explored
                if (explored.contains(neighbor)) {
                    continue;
                }

                // Calculate cost from start to neighbor through current node
                int newCost = current.getCost() + graph.getCost(current, neighbor);

                // If neighbor is not in frontier, or if new path to neighbor is cheaper than previous path, update neighbor
                if (!frontier.contains(neighbor) || newCost < neighbor.getCost()) {
                    neighbor.setCost(newCost);
                    neighbor.setParent(current);
                    if (frontier.contains(neighbor)) {
                        frontier.remove(neighbor);
                    }
                    frontier.add(neighbor);
                }
            }
        }
        // Goal node not found
        return null;
    }
}