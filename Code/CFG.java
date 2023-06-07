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
        if(node != null) {
            if(nodes.contains(node) == false) {
                nodes.append(node);
            }
            if(exitNodes.contains(node) == false) {
                exitNodes.append(node);
            }
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

    // Now The Real CFG Begins
    public boolean isValid(){
        //TODO: Implement the function
        /*
            - This function should determine if the CFG is valid.
            - A CFG is valid if and only if the following properties hold:
                - The start node is not null.
                - There is at least one exit node.
                - For every non-exit node in the CFG, at least one of the exit nodes is reachable from this node. In other words, there exists a path from said node to at least one exit node.
            - If the CFG is valid, the function should return true, otherwise false.
        */
        return false;
    }

    public boolean isSESE(){
        //TODO: Implement the function
        /*
            - This function should determine if the CFG is a SESE CFG.
            - A SESE CFG can be described by the following properties:
                - Is a valid CFG.
                - Only has one exit node.
        */
        return false;
    }

    public CFG[] splitGraph(){
        //TODO: Implement the function
        /*
            - This function will attempt to turn any valid CFG into a set of SESE graphs.
            - If the CFG is already a SESE graph, return an array populated with just the current graph. (In other words, the array will have a size of 1)
            - Use the following pseudo-code as a guide on how to split the CFG:
                - For  each  exit  node EN, make a new  CFG  with  the current  CFG s start  node as the  start  node  and EN as the  exit  node.
                - For  every  node N in the  current  CFG  check if N can reach  each of the  exit  nodes. If it can  then  add that  node to the  appropriate  new  CFG.
                - Remember  to also  add all  the  appropriate  edges.
            - Each resulting SESE CFG should only contain nodes that can reach its exit node and only edges that connect nodes in the SESE CFG together.
            - Remove all unnecessary edges from the nodes in the SESE CFG.
            - The original CFG should remain unchanged.
            - Return all the new SESE CFGs in an array.
            - Note the order of the newly created SESE CFGs does not matter as the FitchFork main will sort them.
        */
        return null;
    }

    public boolean isReachable(Node startNode, Node goalNode) {
        //TODO: Implement the function
        /*
            - This function should determine if the goalNode is reachable from the startNode.
            - If it is reachable, the function should return true and false if not.
            - If either the startNode or the goalNode is null, the function should return false.
        */
        return true;
    }

    public Path shortestCompTimePath(Node sN, Node gN) {
        //TODO: Implement the function
        /*
            - This function should determine the shortest path, with respect to computational time, between the sN and the gN.
            - It can be assumed that there exists at least one path between sN and gN
            - This function should return a Path object, containing the shortest path from sN to gN.
            - The resulting path object should be populated with both the edges and the nodes needed to traverse the shortest path.
        */
        return null;
    }

    public Path[] getPrimePaths() {
        //TODO: Implement the function
        /*
            - This function should return all the Prime Paths in the CFG as an array.17
            - It can be assumed that the CFG will be a SESE CFG.
        */
        return null;
    }

    public Path[] getSimplePaths() {
        //TODO: Implement the function
        /*
            - This function should return all the simple paths in the CFG as an array.
            - It can be assumed that the CFG will be a SESE CFG.
        */
        return null;
    }
}
