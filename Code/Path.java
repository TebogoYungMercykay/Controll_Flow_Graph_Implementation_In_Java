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
            this.nodes = new List<>();
            this.edges = new List<>();
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
        }
    }

    public Path(Path other) {
        //TODO: Implement the function
        if (other != null) {
            this.startNode = other.startNode;
            this.endNode = other.endNode;
            this.nodes = new List<>();
            this.edges = new List<>();
            if (other.nodes != null) {
                for (Node node : other.nodes.toArray()) {
                    this.nodes.append(node);
                }
            }
            if (other.edges != null) {
                for (Edge edge : other.edges.toArray()) {
                    this.edges.append(edge);
                }
            }
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
            for (Node node : path.nodes.toArray()) {
                this.nodes.append(node);
            }
            for (Edge edge : path.edges.toArray()) {
                this.edges.append(edge);
            }
            this.startNode = path.startNode;
            this.endNode = path.endNode;
        } else {
            return;
        }
    }

    public boolean validPath() {
        //TODO: Implement the function
        if ((edges.Size() + 1) != nodes.Size()) {
            return false;
        } else if (nodes.get(0) != this.startNode) {
            return return false;
        } else if (nodes.get(nodes.size() - 1) != this.endNode) {
            return false;
        } else {
            for (int index = 0; index < edges.Size(); index++) {
                Node tempNode = nodes.get(index);
                Edge tempEdge = edges.get(index);
                if (tempNode != tempEdge.getNext()) {
                    return false;
                }
            }
            return true;
        }
    }

    public String toString() {
        // Do not alter!!!
        String str = "";
        str += ((Node)nodes.toArray()[0]).getAnnotation();
        for(Object e: edges.toArray()) {
            str += e.toString();
        }
        return str;
    }
}
