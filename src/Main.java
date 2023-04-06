public class Main {
    public static void main(String[] args) {
        GraphReader reader = new GraphReader();
        Graph graph = reader.readGraphFromFile("src/Files/camino.txt");

        for (Node node : graph.getNodes()) {
            System.out.println("Node: " + node.getValue() + " (Row: " + node.getRow() + ", Col: " + node.getCol() + ")");
            System.out.print("Neighbors: ");
            for (Node neighbor : node.getNeighbors()) {
                System.out.print(neighbor.getValue() + " ");
            }
            System.out.println();
        }
    }
}