public class Node {
    private final String annotation;
    private final /*Own data structure goes here of type Edge*/ edges;
    
    public Node(String annot){
        //TODO: Implement the function
    }

    public void addEdge(Node nextNode, String annotation, int compTime){
        //TODO: Implement the function
    }

    public String getAnnotation(){
        //TODO: Implement the function
    }

    public Edge[] getEdges(){
        //TODO: Implement the function
    }

    public String toString(){
        //Provided function, do not alter!!!
        String res = annotation + ":\n";
        if(edges.toArray().length == 0)
            res += "\t" + "No out going edges" + "\n";
        else
            for(Object e: edges.toArray()){
                res += "\t" + e.toString() + "\n";
            } 
        return res;
    }
}
