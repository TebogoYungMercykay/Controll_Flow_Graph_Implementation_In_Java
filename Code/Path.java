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
            this.nodes = new List<>(other.nodes.toArray());
            this.edges = new List<>(other.edges.toArray());
        } else {
            this.startNode = null;
            this.endNode = null;
            this.nodes = new List<>();
            this.edges = new List<>();
        }
    }

    public int computationalCostOfPath() {
        //TODO: Implement the function
        if (validPath() == false) {
            return 0;
        } else {
            int costOfPath = 0;
            for (Edge edge : edges.toArray()) {
                costOfPath += edge.getCompTime();
            }
            return costOfPath;
        }
    }

    @SuppressWarnings("unchecked")
    public void appendToPath(Path path) {
        //TODO: Implement the function
        if (path != null) {
            this.nodes.append(path.nodes.toArray());
            this.edges.append(path.edges.toArray());
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
            int index = 0;
            for (Edge edge : edges) {
                Node nextNode = nodes.get(index).getNext();
                if (!nextNode.equals(edge.getNext())) {
                    return false;
                }
                index++;
            }
        }
        return true;
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
