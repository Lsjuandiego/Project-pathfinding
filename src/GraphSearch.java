import java.util.*;

class GraphSearch {
    public static List<Node> bfs(Graph graph) {
        Node start = graph.getStartNode();
        Node goal = graph.getGoalNode();

        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> parents = new HashMap<>();

        //El offer es como el add
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
    public static List<Node> ucs(Graph graph) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getCost));
        Map<Node, Node> parentMap = new HashMap<>();
        Map<Node, Integer> costMap = new HashMap<>();

        Node start = graph.getStartNode();
        Node goal = graph.getGoalNode();
        start.setCost(0);
        queue.offer(start);
        parentMap.put(start, null);
        costMap.put(start, 0);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.equals(goal)) {
                // Goal node found, return the path
                return getPath(start, current, parentMap);
            }

            for (Node neighbor : current.getNeighbors()) {
                if (neighbor.isWall()) {
                    continue; // Ignorar nodos que son muros
                }
                int newCost = costMap.get(current) + 1; // Costo constante de 1 para todas las aristas
                if (!costMap.containsKey(neighbor) || newCost < costMap.get(neighbor)) {
                    neighbor.setCost(newCost);
                    queue.add(neighbor);
                    parentMap.put(neighbor, current);
                    costMap.put(neighbor, newCost);
                }
            }
        }

        // Goal node not found
        return null;
    }

    public static List<Node> aStar(Graph graph, HeuristicType heuristic) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getCost));
        Map<Node, Node> parentMap = new HashMap<>();
        Map<Node, Integer> costMap = new HashMap<>();

        Node start = graph.getStartNode();
        Node goal = graph.getGoalNode();
        start.setCost(0);
        queue.add(start);
        parentMap.put(start, null);
        costMap.put(start, 0);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.equals(goal)) {
                // Goal node found, return the path
                return getPath(start, current, parentMap);
            }

            for (Node neighbor : current.getNeighbors()) {
                if (neighbor.isWall()) {
                    continue; // Ignorar nodos que son muros
                }
                int newCost = costMap.get(current) + neighbor.getCost();
                if (!costMap.containsKey(neighbor) || newCost < costMap.get(neighbor)) {
                    neighbor.setCost(newCost);
                    parentMap.put(neighbor, current);
                    costMap.put(neighbor, newCost);

                    int heuristicValue;
                    switch (heuristic) {
                        case MANHATTAN:
                            heuristicValue = getManhattanDistance(neighbor, goal);
                            break;
                        case EUCLIDEAN:
                            heuristicValue = getEuclideanDistance(neighbor, goal);
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid heuristic type.");
                    }

                    int priority = newCost + heuristicValue;
                    neighbor.setPriority(priority);
                    queue.add(neighbor);
                }
            }
        }

        // Goal node not found
        return null;
    }
    private static int getManhattanDistance(Node node1, Node node2) {
        int dx = Math.abs(node1.getRow() - node2.getRow());
        int dy = Math.abs(node1.getCol() - node2.getCol());
        return dx + dy;
    }
    private static int getEuclideanDistance(Node node1, Node node2) {
        int dx = node1.getRow() - node2.getRow();
        int dy = node1.getCol() - node2.getCol();
        return (int) Math.sqrt(dx * dx + dy * dy);
    }


}