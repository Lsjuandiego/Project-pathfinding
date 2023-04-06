import java.util.List;

public class Main {
    public static void main(String[] args) {
        GraphReader reader = new GraphReader();
        Graph graph = reader.readGraphFromFile("src/Files/camino.txt");

        Node start = null;
        Node goal = null;

        /*
        DFS
         */
        for (Node node : graph.getNodes()) {
            if (node.isStart()) {
                start = node;
            } else if (node.isGoal()) {
                goal = node;
            }
        }

        List<Node> path = BFS.search(start, goal);

        if (path != null) {
            System.out.println("Path found:");
            for (Node node : path) {
                System.out.println(node.getValue() + " at (" + node.getRow() + ", " + node.getCol() + ")");
            }
        } else {
            System.out.println("No path found.");
        }

        System.out.println("Visited nodes:");
        for (Node node : BFS.visitedNodes) {
            System.out.println(node.getValue() + " at (" + node.getRow() + ", " + node.getCol() + ")");
        }
        /*
        termina DFS
         */
        System.out.println("__________________________________");
        //DFS
        path = DFS.search(graph, start, goal);

        if (path != null) {
            System.out.println("Path found:");
            for (Node node : path) {
                System.out.println(node.getValue() + " at (" + node.getRow() + ", " + node.getCol() + ")");
            }
        } else {
            System.out.println("No path found.");
        }

        //end DFS
        /*
        for (Node node : graph.getNodes()) {
            System.out.println("Node: " + node.getValue() + " (Row: " + node.getRow() + ", Col: " + node.getCol() + ")");
            System.out.print("Neighbors: ");
            for (Node neighbor : node.getNeighbors()) {
                System.out.print(neighbor.getValue() + " ");
            }
            System.out.println();
        }

         */
    }
}