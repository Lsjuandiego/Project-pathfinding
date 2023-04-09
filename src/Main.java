import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        GraphReader reader = new GraphReader();
        Graph graph = reader.readGraphFromFile("src/Files/camino.txt");

// Prompt the user to select the algorithms to run
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the algorithms to run (separate with commas):");
        System.out.println("  1. Breadth-first search (BFS)");
        System.out.println("  2. Depth-first search (DFS)");
        System.out.println("  3. Uniform-cost search (UCS)");
        System.out.println("  4. A* search (Manhattan distance)");
        System.out.println("  5. A* search (Euclidean distance)");
        System.out.println("  6. Beam search");
        System.out.println("  7. Hill climbing (Euclidean distance)");
        System.out.println("  8. Hill climbing (Manhattan distance)");
        String[] selectedAlgorithms = scanner.nextLine().trim().split(",");

        // Run the selected algorithms
        for (String algorithm : selectedAlgorithms) {
            switch (algorithm.trim()) {
                case "1":
                    System.out.println("\nRunning Breadth-first search (BFS)...");
                    List<Node> bfsPath = GraphSearch.bfs(graph);
                    printPathAndVisitedNodes(bfsPath);
                    break;
                case "2":
                    System.out.println("\nRunning Depth-first search (DFS)...");
                    List<Node> dfsPath = GraphSearch.dfs(graph);
                    printPathAndVisitedNodes(dfsPath);
                    break;
                case "3":
                    System.out.println("\nRunning Uniform-cost search (UCS)...");
                    List<Node> ucsPath = GraphSearch.ucs(graph);
                    printPathAndVisitedNodes(ucsPath);
                    break;
                case "4":
                    System.out.println("\nRunning A* search with Manhattan distance...");
                    List<Node> aStarManhattanPath = GraphSearch.aStar(graph, HeuristicType.MANHATTAN);
                    printPathAndVisitedNodes(aStarManhattanPath);
                    break;
                case "5":
                    System.out.println("\nRunning A* search with Euclidean distance...");
                    List<Node> aStarEuclideanPath = GraphSearch.aStar(graph, HeuristicType.EUCLIDEAN);
                    printPathAndVisitedNodes(aStarEuclideanPath);
                    break;
                case "6":
                    System.out.println("\nRunning Beam search...");
                    List<Node> beamSearch = GraphSearch.beamSearch(graph, 4, HeuristicType.MANHATTAN);
                    printPathAndVisitedNodes(beamSearch);
                    break;
                case "7":
                    System.out.println("\nRunning Hill climbing with Euclidean distance...");
                    List<Node> hillClimbingPath = GraphSearch.hillClimbing(graph, HeuristicType.EUCLIDEAN );
                    printPathAndVisitedNodes(hillClimbingPath);
                    break;
                case "8":
                    System.out.println("\nRunning Hill climbing with Euclidean distance...");
                    List<Node> hillClimbingManhattanPath = GraphSearch.hillClimbing(graph, HeuristicType.MANHATTAN );
                    printPathAndVisitedNodes(hillClimbingManhattanPath);
                    break;
                default:
                    System.out.println("\nInvalid algorithm selected.");
            }
        }
    }



    private static void printPathAndVisitedNodes(List<Node> path) {
        if (path == null) {
            System.out.println("No path found.");
            return;
        }
        for (Node node : path) {
            System.out.println(node.getValue() + " at (" + node.getRow() + ", " + node.getCol() + ")");
        }
    }
}
