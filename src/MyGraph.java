import java.util.*;

// Sean Campbell
// Assignment #4 : My Graph
// February 22, 2017
// CSE 373

/**
 * A representation of a graph.
 * Assumes that we do not have negative cost edges in the graph.
 */
public class MyGraph implements Graph {
    private Map<Vertex, ArrayList<Edge>> graph;
    private ArrayList<Edge> edges;

    /**
     * Creates a MyGraph object with the given collection of vertices
     * and the given collection of edges.
     * @param v a collection of the vertices in this graph
     * @param e a collection of the edges in this graph
     * 
     * As discussed in class, it should not be possible for clients of a
     * graph to break the abstraction by adding edges, making illegal weights,
     * etc. So the code most have enough copy-in-copy-out and immutability to 
     * prevent clients from doing such things.
     */
    public MyGraph(Collection<Vertex> v, Collection<Edge> e) {
        this.graph = new HashMap<Vertex, ArrayList<Edge>>();
        this.edges = new ArrayList<Edge>();
        for (Vertex curr: v) {
            // Makes deep copy-in for immutability
            Vertex copy = new Vertex(curr.getLabel());
            // if we encounter a redundant edge we just consider 
            // it redundant information
            if (!this.graph.containsKey(copy)) {
                this.graph.put(copy, new ArrayList<Edge>());
            }
        }
        // Check and see if the edge weights differ, and if they do then throw an 
        // exception
        
        for (Edge curr: e) {
            // Uses addToGraph method to see if the Edge should be considered
            // for the graph
            if (this.addToGraph(curr)) {                
                // if the current graph has the same EDGE, then check and see if 
                // differing weights
                // if they do have differing weights then throw an exception, 
                //otherwise treat as redundant information
                boolean shouldAdd = true;
                // if it currently has edges, then let's go through them
                if (this.graph.get(curr.getSource()) != null) {
                    if (this.graph.get(curr.getSource()).size() != 0) {
                        for (Edge alreadyEdges : this.graph.get
                                (curr.getSource())) {
                            // throws exception if same edge with different 
                            // weight wants to be added
                            if (curr.getSource().equals
                                    (alreadyEdges.getSource()) &&
                                    alreadyEdges.getDestination().equals
                                    (curr.getDestination())) {
                                // considered redundant so do not add
                                shouldAdd = false;
                                if (alreadyEdges.getWeight() != 
                                        curr.getWeight()) {
                                    
                                    throw new IllegalArgumentException("Adding "
                                            + "the same edges "
                                            + "with different weights.");
                                }
                            }
                        }
                    }
                }
                if (shouldAdd) {
                    // creates a deep copy-in of the passed Edge for 
                    // immutability
                    Edge copy = new Edge(curr.getSource(), 
                            curr.getDestination(), curr.getWeight());
                    this.graph.get(copy.getSource()).add(copy);
                    // also adds the edge to the field collection of edges
                    this.edges.add(copy);
                }
            }
        }
    }
    
    /**
     * @param Edge check is used for determining the return value
     * @return true if the edge should be added, false otherwise
     * an edge should be added if the graph contains both the source and the
     * destination vertices, also the edge weight must be greater than or equal
     * to zero; otherwise return false
     */
    private boolean addToGraph(Edge check) {
        // The edges should involve only vertices with labels that are in the 
        // vertices of the graph. That is, there should be no edge from or to 
        // a vertex labeled A if there is no vertex with label A.
        if (this.graph.containsKey(check.getSource()) && 
                this.graph.containsKey(check.getDestination()) &&
                check.getWeight() >= 0) { // checking for negative weights
            return true;
        }
        throw new IllegalArgumentException("invalid input");
    }

    /** 
     * Return the collection of vertices of this graph
     * @return the vertices as a collection (which is anything iterable)
     */
    @Override
    public Collection<Vertex> vertices() {
        List<Vertex> clone = new ArrayList<Vertex>(this.graph.keySet().size());
        for (Vertex v : this.graph.keySet()) {
            clone.add(v.clone());
        }
        return Collections.unmodifiableCollection(clone);
    }

    /** 
     * Return the collection of edges of this graph
     * @return the edges as a collection (which is anything iterable)
     */
    @Override
    public Collection<Edge> edges() {
        if (this.edges != null) {
            List<Edge> clone = new ArrayList<Edge>(this.edges.size());
            for (Edge e : this.edges) {
                // deep copy-out for immutability
                clone.add(e.clone());
            }
            return Collections.unmodifiableCollection(clone);
        }
        return Collections.unmodifiableCollection(new ArrayList<Edge>());
    }

    /**
     * Return a collection of vertices adjacent to a given vertex v.
     *   i.e., the set of all vertices w where edges v -> w exist in the graph.
     * Return an empty collection if there are no adjacent vertices.
     * @param v one of the vertices in the graph
     * @return an iterable collection of vertices adjacent to v in the graph
     * @throws IllegalArgumentException if v does not exist.
     */
    @Override
    public Collection<Vertex> adjacentVertices(Vertex v) {
        // Checks to see if Vertex v exists in the graph
        if (this.graph.get(v) == null) {
            throw new IllegalArgumentException
            ("Vertex does not exist in the graph.");
        }
        // Creates a collection to store adjacent vertices
        ArrayList<Vertex> forReturn = new ArrayList<Vertex>();
        // Checks all edges of Vertex v and adds each destination to the
        // ArrayList
        for (Edge curr: this.graph.get(v)) {
            // deep copy out for immutability
            forReturn.add(curr.getDestination().clone());
        }
        return Collections.unmodifiableCollection(forReturn);
    }

    /**
     * Test whether vertex b is adjacent to vertex a (i.e. a -> b) 
     * in a directed graph.
     * Assumes that we do not have negative cost edges in the graph.
     * @param a one vertex
     * @param b another vertex
     * @return cost of edge if there is a directed edge from a to b 
     * in the graph, return -1 otherwise.
     * @throws IllegalArgumentException if a or b do not exist.
     */
    @Override
    public int edgeCost(Vertex a, Vertex b) {
        // Checks to see if Vertex a or Vertex b does not exist
        if (this.graph.get(a) == null || this.graph.get(b) == null) {
            throw new IllegalArgumentException("Passed Vertex is null");
        }
        // Searching for directed edge from A to B
        for (Edge curr: this.graph.get(a)) {
            if (curr.getDestination().equals(b)) {
                return curr.getWeight();
            }
        }
        // Returns -1 if no directed Edge is found between A and B
        return -1;
    }
}