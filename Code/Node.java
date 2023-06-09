public class Node {
    // This will be the class that represents the nodes (code blocks) in the CFG.
    private final String annotation;
    private final List<Edge> edges;

    public Node(String annot){
        //TODO: Implement the function
        this.annotation = annot;
        this.edges = new List<>();
    }

    public Node(Node other){
        //TODO: Implement the function
        this.annotation = other.annotation;
        this.edges = new List<>(other.edges);
    }

    public void addEdge(Node nextNode, String annotation, int compTime){
        //TODO: Implement the function
        edges.append(new Edge(annotation, nextNode, compTime));
    }

    public String getAnnotation(){
        //TODO: Implement the function
        return this.annotation;
    }

    public List<Edge> getEdgesList() {
        return edges;
    }

    public Edge[] getEdges(){
        //TODO: Implement the function
        Object[] edgesObjects = this.edges.toArray();
        Edge[] edgeAEdges = new Edge[edgesObjects.length];
        for(int i = 0; i < edgesObjects.length; i++){
            edgeAEdges[i] = (Edge) edgesObjects[i];
        }
        return edgeAEdges;
    }

    public String toString(){
        // Do not alter!!!
        String res = annotation + ":\n";
        if(edges.toArray().length == 0) {
            res += "\t" + "No out going edges" + "\n";
        } else {
            for(Object e: edges.toArray()){
                res += "\t" + e.toString() + "\n";
            }
        }
        return res;
    }
}
