public class Path {
    private final Node startNode;
    private Node endNode;
    private final /*Own data structure goes here of type Node*/ nodes;
    private final /*Own data structure goes here of type Edge*/ edges;

    public Path(Node startNode, Node endNode, Node[] nodes, Edge[] edges){
        //TODO: Implement the function
    }

    public Path(Path other){
        //TODO: Implement the function
    }

    public int computationalCostOfPath(){
        //TODO: Implement the function
    }

    @SuppressWarnings("unchecked")
    public void appendToPath(Path p){
        //TODO: Implement the function
    }

    public boolean validPath(){
        //TODO: Implement the function
    }

    public String toString(){
        //Provided function, do not alter!!!
        String str = "";
        str += ((Node)nodes.toArray()[0]).getAnnotation();
        for(Object e: edges.toArray()){
            str += e.toString();
        }
        return str;
    }
    
}
