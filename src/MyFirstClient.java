import java.util.*;

public class MyFirstClient {
    public static void main(String[] args) {
        
        System.out.println("Welcome to the CSE 373 MyGraph "
                + "Test Program!");
        System.out.println();
         
        /*
        Vertex sean = new Vertex("Sean");
        Vertex emily = new Vertex("Emily");
        
        Edge friends = new Edge(sean, emily, 2);
        
        ArrayList<Vertex> vertices = new ArrayList<Vertex>();
        ArrayList<Edge> edges = new ArrayList<Edge>();
        
        vertices.add(sean);
        vertices.add(emily);
        vertices.add(new Vertex("BETHKE"));
        
        edges.add(friends);
        edges.add(new Edge(sean, new Vertex("BETHKE"), 3));
        
        // Initializes and populates a Graph with Vertices and Edges
        System.out.println("Edge " + friends.toString());
        System.out.println("Vertex sean " + sean.toString());
        System.out.println("Vertex emily " + emily.toString());
        
        MyGraph forTesting = new MyGraph(vertices, edges);
        
        System.out.println("Edge Weight (sean > emily): " + forTesting.edgeCost(sean, emily));
        System.out.println();
        System.out.println("Adjacent Vertices Test: " + forTesting.adjacentVertices(sean).toString());
        System.out.println();
        System.out.println("Vertices Test: " + forTesting.vertices().toString());
        System.out.println();
        System.out.println("All Edges Test: " + forTesting.edges().toString());
        
        //forTesting.adjacentVertices(sean).add(new Vertex("BREAK"));
        System.out.println("TESTING BREAK: " + forTesting.adjacentVertices(sean).toString());

        System.out.println();
        System.out.println("Vertices Test: " + forTesting.vertices().toString());
        */
        Vertex sean = new Vertex("Sean");
        Vertex chris = new Vertex("Chris");
        Vertex austin = new Vertex("AUSTIN");
        
        ArrayList<Vertex> verticesTwo = new ArrayList<Vertex>();
        ArrayList<Edge> edgesTwo = new ArrayList<Edge>();
        
        verticesTwo.add(chris);
        verticesTwo.add(sean);
        verticesTwo.add(austin);
        
        
        
        Edge chrisSean = new Edge(sean, chris, 3);
        Edge chrisSeanBreak = new Edge(sean, chris, 3);
        Edge seanAustin = new Edge(sean, austin, 2);
        
        edgesTwo.add(chrisSean);
        edgesTwo.add(chrisSeanBreak);
        edgesTwo.add(seanAustin);
        
        MyGraph forTestingTwo = new MyGraph(verticesTwo, edgesTwo);
        
        System.out.println("Edges " + forTestingTwo.edges().toString());

        //System.out.println(forTestingTwo.edges().toString());
        // create new graph
        
        
        // add in edges, vertices        
        //Collection<Vertex> xyz = forTestingTwo.adjacentVertices(sean);
        //forTestingTwo.adjacentVertices(sean).remove(chris);
        //System.out.println(forTestingTwo.adjacentVertices(sean).contains(chris));

    }
}
