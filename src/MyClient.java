import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) throws FileNotFoundException {
        
        System.out.println("Welcome to the CSE 373 MyGraph "
                + "Test Program!");
        System.out.println();
        System.out.println("This is the Above and Beyond Portion of my code!");
        
        //creating File instances for my vertices and edges
        File verticesFile = new File("my_vertices.txt");
        File edgesFile = new File("my_edges.txt");
        
        ArrayList<Vertex> vertices = new ArrayList<Vertex>(217); // hard coded for efficiency
        Scanner scanVertices = new Scanner(verticesFile);
        // Scanning in all of the vertices
        while(scanVertices.hasNextLine()) {
            String line = scanVertices.nextLine();
            Scanner lineScan = new Scanner(line);
            vertices.add(new Vertex(lineScan.nextInt()));
        }
      
        // Creating Scanner to read edgesFile
        ArrayList<Edge> edges = new ArrayList<Edge>(2672); // hard coded for efficiency
        Scanner scanEdges = new Scanner(edgesFile);
        scanEdges.nextLine(); // useless information
        scanEdges.nextLine(); // useless information
        
        // Scan in all of the edges and their weights
        while(scanEdges.hasNextLine()) {
            String line = scanEdges.nextLine();
            Scanner lineScan = new Scanner(line);
            Vertex sourceVertex = new Vertex(lineScan.nextInt());
            Vertex destVertex = new Vertex(lineScan.nextInt());
            int edgeWeight = lineScan.nextInt();
            edges.add(new Edge(sourceVertex, destVertex, edgeWeight));
        }
        MyGraph forTesting = new MyGraph(vertices, edges);      
        
        System.out.println(forTesting.adjacentVertices(new Vertex(1)).toString());
        System.out.println();
        System.out.println("Testing: Edge Weight 1 to 4: " + forTesting.edgeCost(new Vertex(1), new Vertex(4)));
        System.out.println();
        int max = -1;
        int min = 272;
        Vertex maxVertex = new Vertex(1);
        Vertex minVertex = new Vertex(1);
        for (Vertex v : vertices) {
            if (forTesting.adjacentVertices(v).size() > max) {
                maxVertex = v;
                max = forTesting.adjacentVertices(v).size();
            }
            if (forTesting.adjacentVertices(v).size() < min) {
                minVertex = v;
                min = forTesting.adjacentVertices(v).size();
            }
        }
        System.out.println("Most Friends Vertex : " + maxVertex.toString());
        System.out.println("Most Friends Adjacency List: " + forTesting.adjacentVertices(maxVertex).toString());
        int sum = 0;
        for (Vertex dest: forTesting.adjacentVertices(maxVertex)) {
            sum += forTesting.edgeCost(maxVertex, dest);
        }
        System.out.println("Average Friend Rating for Most Friends: " 
                + (double) sum / forTesting.adjacentVertices(maxVertex).size());
        System.out.println();
        
        System.out.println("Least Friends Vertex : " + minVertex.toString());
        System.out.println("Least Friends Adjacency List: " + forTesting.adjacentVertices(minVertex).toString());
        sum = 0;
        for (Vertex dest: forTesting.adjacentVertices(minVertex)) {
            sum += forTesting.edgeCost(minVertex, dest);
        }
        System.out.println("Average Friend Rating for Most Friends: " 
                + (double) sum / forTesting.adjacentVertices(minVertex).size());
    }
}
