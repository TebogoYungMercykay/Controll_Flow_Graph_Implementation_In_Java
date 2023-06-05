public class CFG {
    private Node startNode;
    private /*Own data structure goes here of type Node*/ nodes;
    private /*Own data structure goes here of type Edge*/ edges;
    private /*Own data structure goes here of type Node*/ exitNodes;

    public CFG(){
        //TODO: Implement the function
    }

    public CFG(Node[] nodes, Edge[] edges, Node sNode, Node[] exitNodes){
        //TODO: Implement the function
    }

    public CFG(CFG other){
        //TODO: Implement the function
    }

    public boolean isValid(){
        //TODO: Implement the function
    }

    public boolean isSESE(){
        //TODO: Implement the function
    }

    public CFG[] splitGraph(){
        //TODO: Implement the function
    }

    public boolean isReachable(Node startNode, Node goalNode){
        //TODO: Implement the function
    }

    public int compTimeRequired(Path p){
        //TODO: Implement the function
    }

    public Path shortestCompTimePath(Node sN, Node gN){
        //TODO: Implement the function
    }

    public Path[] getPrimePaths(){
        //TODO: Implement the function
    }

    public Path[] getSimplePaths(){
        //TODO: Implement the function
    }

    public void addNode(String annotation){
        //TODO: Implement the function
    }

    public void addNode(Node node){
        //TODO: Implement the function
    }

    public void addEdge(String annotation, Node fromNode, Node toNode, int computationalTime){
        //TODO: Implement the function
    }

    public void addExitNode(Node n){
        //TODO: Implement the function
    }

    public void addStartNode(Node n){
        //TODO: Implement the function
    }

    public String toString() {
        //Provided function, do not alter!!!
        String res = "";
        for(Object n: nodes.toArray()){
            res += n.toString();
        }
        return res;
    }

    public Node getNode(String annotation){
        //TODO: Implement the function
    }
}
