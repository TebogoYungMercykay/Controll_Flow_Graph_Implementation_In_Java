public class CFG {
    // Control Flow Graphs (CFG)are a static analysis of software code used in software testing
    private Node startNode;
    private List<Node> nodes;
    private List<Edge> edges;
    private List<Node> exitNodes;

    public CFG(){
        //TODO: Implement the function
        this.startNode = null;
        this.nodes = new List<>();
        this.edges = new List<>();
        this.exitNodes = new List<>();
    }

    public CFG(Node[] nodes, Edge[] edges, Node sNode, Node[] exitNodes){
        //TODO: Implement the function
        this.startNode = sNode;
        this.startNode = sNode;
        this.nodes = new List<>(nodes);
        this.edges = new List<>(edges);
        this.exitNodes = new List<>(exitNodes);
    }

    public CFG(CFG other){
        //TODO: Implement the function
        if (other == null) {
            this.startNode = null;
            this.nodes = new List<>();
            this.edges = new List<>();
            this.exitNodes = new List<>();
        } else {
            this.startNode = (other.startNode != null) ? new Node(other.startNode) : null;
            this.nodes = new List<>(other.nodes);
            this.edges = new List<>(other.edges);
            this.exitNodes = new List<>(other.exitNodes);
        }
    }

    // Now The Real CFG Begins
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

    public int compTimeRequired(Path path){
        //TODO: Implement the function
        return path.computationalCostOfPath();
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
