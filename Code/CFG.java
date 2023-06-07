public class CFG {
    // Control Flow Graphs(CFG)are a static analysis of software code used in software testing
    private Node startNode;
    private List<Node> nodes;
    private List<Edge> edges;
    private List<Node> exitNodes;

    public CFG() {
        //TODO: Implement the function
        this.startNode = null;
        this.nodes = new List<>();
        this.edges = new List<>();
        this.exitNodes = new List<>();
    }

    public CFG(Node[] nodes, Edge[] edges, Node sNode, Node[] exitNodes) {
        //TODO: Implement the function
        this.startNode = sNode;
        this.startNode = sNode;
        this.nodes = new List<>(nodes);
        this.edges = new List<>(edges);
        this.exitNodes = new List<>(exitNodes);
    }

    public CFG(CFG other) {
        //TODO: Implement the function
        if(other == null) {
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

    public void addNode(String annotation) {
        //TODO: Implement the function
        for (Object node : nodes.toArray()) {
            Node tempNode = (Node) node;
            if(tempNode.getAnnotation() == annotation) {
                return;
            }
        }
        nodes.append(new Node(annotation));
    }

    public void addNode(Node node) {
        //TODO: Implement the function
        if(node != null) {
            nodes.append(node);
        }
    }

    public void addEdge(String annotation, Node fromNode, Node toNode, int computationalTime) {
        //TODO: Implement the function
        if(computationalTime >= 0) {
            for (Object edge : edges.toArray()) {
                Edge tempEdge = (Edge) edge;
                if(tempEdge.getAnnotation() == annotation) {
                    return;
                }
            }
            // Create a new Edge with the given parameters and add it to the list of edges
            Edge edge = new Edge(annotation, toNode, computationalTime);
            fromNode.addEdge(toNode, annotation, computationalTime);
            edges.append(edge);
        }
    }

    public void addExitNode(Node node) {
        //TODO: Implement the function
        if(nodes.contains(node) == false) {
            nodes.append(node);
        }
        if(exitNodes.contains(node) == false) {
            exitNodes.append(node);
        }
    }

    public void addStartNode(Node node) {
        //TODO: Implement the function
        if(startNode == null) {
            startNode = node;
            if(nodes.contains(node) == false) {
                nodes.append(node);
            }
        }
    }

    public String toString() {
        // Do not alter!!!
        String res = "";
        for(Object node: nodes.toArray()) {
            res += node.toString();
        }
        return res;
    }

    public Node getNode(String annotation) {
        //TODO: Implement the function
        for (Object node : nodes.toArray()) {
            Node tempNode = (Node) node;
            if(tempNode.getAnnotation().equals(annotation)) {
                return tempNode;
            }
        }
        return null;
    }

    public int compTimeRequired(Path path) {
        //TODO: Implement the function
        return path.computationalCostOfPath();
    }

    public boolean isValid() {
        //TODO: Implement the function
        return true;
    }

    public boolean isSESE() {
        //TODO: Implement the function
        return true;
    }

    public CFG[] splitGraph() {
        //TODO: Implement the function
        return null;
    }

    public boolean isReachable(Node startNode, Node goalNode) {
        //TODO: Implement the function
        return true;
    }

    public Path shortestCompTimePath(Node sN, Node gN) {
        //TODO: Implement the function
        return null;
    }

    public Path[] getPrimePaths() {
        //TODO: Implement the function
        return null;
    }

    public Path[] getSimplePaths() {
        //TODO: Implement the function
        return null;
    }
}
