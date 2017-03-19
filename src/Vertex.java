/**
 * Representation of a graph vertex
 */
public class Vertex {
    private final String label;   // label attached to this vertex

    /**
     * Construct a new vertex
     * @param label the label attached to this vertex
     */
    public Vertex(String label) {
        if(label == null)
            throw new IllegalArgumentException("null");
        this.label = label;
    }
    
    public Vertex(int label) {
        if (label <= 0) {
            throw new IllegalArgumentException("null");
        }
        this.label = Integer.toString(label);
    }

    /**
     * Get a vertex label
     * @return the label attached to this vertex
     */
    public String getLabel() {
        return label;
    }

    /**
     * A string representation of this object
     * @return the label attached to this vertex
     */
    @Override
    public String toString() {
        return label;
    }

    //auto-generated: hashes on label
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        return result;
    }

    //auto-generated: compares labels
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Vertex other = (Vertex) obj;
        if (label == null) {
            return other.label == null;
        }
        return label.equals(other.label);
    }
    
    /**
     * @return a new Vertex that is a clone of this Vertex
     */
    @Override
    public Vertex clone() {
        return new Vertex(this.label);
    }

}
