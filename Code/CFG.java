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
        if((nodes == null) && (edges == null) && (exitNodes == null)) {
            this.nodes = new List<>();
            this.edges = new List<>();
            this.exitNodes = new List<>();
        } else {
            this.nodes = new List<>();
            this.edges = new List<>();
            this.exitNodes = new List<>();
            if (nodes != null) {
                for(Node node : nodes) {
                    this.nodes.append(node);
                }
            }
            if (edges != null) {
                for(Edge edge : edges) {
                    this.edges.append(edge);
                }
            }
            if (exitNodes != null) {
                for(Node node : exitNodes) {
                    this.exitNodes.append(node);
                }
            }
        }
    }

    public CFG(CFG other){
        //TODO: Implement the function
        if (other == null) {
            this.startNode = null;
            this.nodes = new List<>();
            this.edges = new List<>();
            this.exitNodes = new List<>();
        } else {
            this.startNode = new Node(other.startNode.getAnnotation());
            if (other.nodes != null) {
                for (Node node : other.nodes.toArray()) {
                    Node tempNode = new Node(node.getAnnotation());
                    for (Edge edge : node.getEdges()) {
                        Node nextNode = edge.getNext();
                        String annotation = edge.getAnnotation();
                        int compTime = edge.getCompTime();
                        tempNode.addEdge(new Node(nextNode.getAnnotation()), annotation, compTime);
                    }
                    this.nodes.append(tempNode);
                }
            }
            if (other.edges != null) {
                for (Edge edge : other.edges.toArray()) {
                    Node nextNode = edge.getNext();
                    String annotation = edge.getAnnotation();
                    int compTime = edge.getCompTime();
                    Node tempNode = null;
                    if (nextNode != null) {
                        tempNode = new Node(nextNode.getAnnotation());
                        for (Edge nextEdge : nextNode.getEdges()) {
                            Node nextNextNode = nextEdge.getNext();
                            String nextAnnotation = nextEdge.getAnnotation();
                            int nextCompTime = nextEdge.getCompTime();
                            tempNode.addEdge(new Node(nextNextNode.getAnnotation()), nextAnnotation, nextCompTime);
                        }
                    }
                    Edge tempEdge = new Edge(annotation, tempNode, compTime);
                    this.edges.append(tempEdge);
                }
            }
            if (other.exitNodes != null) {
                for (Node node : other.exitNodes.toArray()) {
                    Node tempNode = new Node(node.getAnnotation());
                    for (Edge edge : node.getEdges()) {
                        Node nextNode = edge.getNext();
                        String annotation = edge.getAnnotation();
                        int compTime = edge.getCompTime();
                        tempNode.addEdge(new Node(nextNode.getAnnotation()), annotation, compTime);
                    }

                    this.exitNodes.append(tempNode);
                }
            }
        }
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
