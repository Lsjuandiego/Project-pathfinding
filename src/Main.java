import java.util.List;

public class Main {
    public static void main(String[] args) {
        GraphReader reader = new GraphReader();
        Graph graph = reader.readGraphFromFile("src/Files/camino.txt");
        List<Node> path = GraphSearch.bfs(graph);
        if (path != null) {
            System.out.println("Path found:");
            for (Node node : path) {
                System.out.println(node.getValue() + " at (" + node.getRow() + ", " + node.getCol() + ")");
            }
        } else {
            System.out.println("No path found.");
        }




    }
}