import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphReader {
    private Graph graph;

    public GraphReader() {
        graph = new Graph();
    }

    public Graph readGraphFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            int row = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");

                for (int col = 0; col < values.length; col++) {
                    String value = values[col];
                    Node node = new Node(value, row, col);
                    graph.addNode(node);

                    if (col > 0) {
                        Node left = graph.getNodes().get(graph.getNodes().size() - 2);
                        node.addNeighbor(left);
                        left.addNeighbor(node);
                    }

                    if (row > 0) {
                        Node top = graph.getNodes().get(graph.getNodes().size() - values.length - 1);
                        node.addNeighbor(top);
                        top.addNeighbor(node);
                    }
                }

                row++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return graph;
    }}