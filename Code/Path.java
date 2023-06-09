public class Path {
    private final Node startNode;
    private Node endNode;
    private final List<Node> nodes;
    private final List<Edge> edges;

    public Path(Node startNode, Node endNode, Node[] nodes, Edge[] edges) {
        //TODO: Implement the function
        this.startNode = startNode;
        this.endNode = endNode;
        if((nodes == null) && (edges == null)) {
            this.nodes = new List<>();
            this.edges = new List<>();
        } else {
            this.nodes = new List<>(nodes);
            this.edges = new List<>(edges);
        }
    }

    public Path(Path other) {
        //TODO: Implement the function
        if (other != null) {
            this.startNode = other.startNode;
            this.endNode = other.endNode;
            this.edges = new List<>(other.edges);
            this.nodes = new List<>(other.nodes);
        } else {
            this.startNode = null;
            this.endNode = null;
            this.nodes = new List<>();
            this.edges = new List<>();
        }
    }

    public Node[] getNodes(){
        Object[] toArrayObjects = this.nodes.toArray();
        Node[] nodeNodes = new Node[toArrayObjects.length];
        for(int i = 0; i < toArrayObjects.length; i++){
            nodeNodes[i] = (Node) toArrayObjects[i];
        }
        return nodeNodes;
    }

    public Edge[] getEdges(){
        Object[] toArrayObjects = this.edges.toArray();
        Edge[] edgeEdges = new Edge[toArrayObjects.length];
        for(int i = 0; i < toArrayObjects.length; i++){
            edgeEdges[i] = (Edge) toArrayObjects[i];
        }
        return edgeEdges;
    }

    public Node getStartNode() {
        return this.startNode;
    }

    public Node getEndNode() {
        return this.endNode;
    }

    public int computationalCostOfPath() {
        //TODO: Implement the function
        if (validPath() == false) {
            return 0;
        } else {
            int costOfPath = 0;
            for (Object edge : edges.toArray()) {
                Edge tempEdge = (Edge) edge;
                costOfPath += tempEdge.getCompTime();
            }
            return costOfPath;
        }
    }

    @SuppressWarnings("unchecked")
    public void appendToPath(Path path) {
        //TODO: Implement the function
        if (path != null) {
            Object[] toArrayObjects = path.edges.toArray();
            Edge[] edgeEdges = new Edge[toArrayObjects.length];
            for(int i = 0; i < toArrayObjects.length; i++){
                edgeEdges[i] = (Edge) toArrayObjects[i];
            }
            toArrayObjects = path.nodes.toArray();
            Node[] nodeNodes = new Node[toArrayObjects.length];
            for(int i = 0; i < toArrayObjects.length; i++){
                nodeNodes[i] = (Node) toArrayObjects[i];
            }
            this.nodes.append(nodeNodes);
            this.edges.append(edgeEdges);
            this.endNode = path.endNode;
        } else {
            return;
        }
    }

    public boolean validPath() {
        if (edges.size() + 1 != nodes.size()) {
            return false;
        } else if (!nodes.get(0).equals(startNode) || !nodes.get(nodes.size() - 1).equals(endNode)) {
            return false;
        } else {
            for (int index = 0; index < edges.size(); index++) {
                Boolean found = false;
                Edge tempEdge = edges.get(index);
                Node ithNode = nodes.get(index);
                for(Edge temp : ithNode.getEdges()){
                    if(temp == tempEdge){
                        found = true;
                        break;
                    }
                }
                Node ithPlusOne = nodes.get(index + 1);
                if (found == true && ithPlusOne != tempEdge.getNext()) {
                    return false;
                }
            }
            return true;
        }
    }

    // Do not alter the next method!!!
    public String toString() {
        String str = "";
        str += ((Node)nodes.toArray()[0]).getAnnotation();
        for(Object e: edges.toArray()) {
            str += e.toString();
        }
        return str;
    }
}
