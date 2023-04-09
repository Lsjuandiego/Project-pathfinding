import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        GraphReader reader = new GraphReader();
        Graph graph = reader.readGraphFromFile("src/Files/camino2.txt");
        List<Node> path = GraphSearch.bfs(graph);
        if (path != null) {
            System.out.println("Path found:");
            for (Node node : path) {
                System.out.println(node.getValue() + " at (" + node.getRow() + ", " + node.getCol() + ")");
            }
        } else {
            System.out.println("No path found.");
        }

        List<Node> pathUcs = GraphSearch.ucs(graph);
        if (pathUcs != null) {
            System.out.println("Path found:");
            for (Node node : pathUcs) {
                System.out.println(node.getValue() + " at (" + node.getRow() + ", " + node.getCol() + ")");
            }
        } else {
            System.out.println("No path found.");
        }


        List<Node> path1 = GraphSearch.aStar(graph, HeuristicType.MANHATTAN);
        System.out.println("Camino encontrado con heurística Manhattan: ");
        if (path1 != null) {
            System.out.println("Path found:");
            for (Node node : path1) {
                System.out.println(node.getValue() + " at (" + node.getRow() + ", " + node.getCol() + ")");
            }
        } else {
            System.out.println("No path found.");
        }

        List<Node> path2 = GraphSearch.aStar(graph, HeuristicType.EUCLIDEAN);
        System.out.println("Camino encontrado con heurística Euclidiana: ");

        if (path2 != null) {
            System.out.println("Path found:");
            for (Node node : path2) {
                System.out.println(node.getValue() + " at (" + node.getRow() + ", " + node.getCol() + ")");
            }
        } else {
            System.out.println("No path found.");
        }

    }
}