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
            this.startNode =(other.startNode != null) ? new Node(other.startNode) : null;
            this.nodes = new List<>(other.nodes);
            this.edges = new List<>(other.edges);
            this.exitNodes = new List<>(other.exitNodes);
        }
    }

    public void addNode(String annotation) {
        //TODO: Implement the function
        for(Object node : nodes.toArray()) {
            Node tempNode =(Node) node;
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
            for(Object edge : edges.toArray()) {
                Edge tempEdge =(Edge) edge;
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
        for(Object node : nodes.toArray()) {
            Node tempNode =(Node) node;
            if(tempNode.getAnnotation().equals(annotation)) {
                return tempNode;
            }
        }
        return null;
    }

    public int compTimeRequired(Path path) {
        //TODO: Implement the function
        if(path != null) {
            return path.computationalCostOfPath();
        }
        return -1;
    }

    public Path shortestCompTimePath(Node sN, Node gN) {
        /*
            - This function should determine the shortest path, with respect to computational time, between the sN and the gN.
            - It can be assumed that there exists at least one path between sN and gN
            - This function should return a Path object, containing the shortest path from sN to gN.
            - The resulting path object should be populated with both the edges and the nodes needed to traverse the shortest path.
        */
        if(sN.equals(gN)) {
            Node[] tempNode = {sN};
            return new Path(sN, gN, tempNode, null);
        } else {
            Path[] paths = this.getSimplePaths();
            Path shortPath = null;
            for(Path path : paths) {
                if(path.getStartNode() == sN && path.getEndNode() == gN) {
                    if(shortPath == null) {
                        shortPath = path;
                    } else {
                        if(path.computationalCostOfPath() < shortPath.computationalCostOfPath()) {
                            shortPath = path;
                        }
                    }
                }
            }
            return shortPath;
        }
    }

    boolean isSESE() {
        /*
            - This function should determine if the CFG is a SESE CFG.
            - A SESE CFG can be described by the following properties:
                - Is a valid CFG.
                - Only has one exit node.
        */
        return(this.exitNodes.length == 1 && this.isValid());
    }

    CFG[] splitGraph() {
        /*
            - This function will attempt to turn any valid CFG into a set of SESE graphs.
            - If the CFG is already a SESE graph, return an array populated with just the current graph.(In other words, the array will have a size of 1)
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
        if (!isValid()) {
            return new CFG[0];
        } else if(this.isSESE() == true) {
            CFG[] myCFGsArray = new CFG[1];
            myCFGsArray[0] = this;
            return myCFGsArray;
        } else{
            List<Path> paths = new List<>();
            List<Node> visitedNodes = new List<>();
            List<Edge> visitedEdges = new List<>();
            explorePaths(startNode, visitedNodes, visitedEdges, paths);
            // Conversions
            Object[] objects = paths.toArray();
            CFG[] myCFGsArray = new CFG[objects.length];
            int counter = 0;
            System.out.println("Object Length: " + objects.length);
            for(Object path : objects) {
                Path tempPath = (Path) path;
                Node[] exitNodess = new Node[1];
                exitNodess[0] = tempPath.getEndNode();
                Node[] myNodes = tempPath.getNodes();
                for (int i = 0; i < myNodes.length - 1; i++) {
                    if (myNodes[i] != null && myNodes[i + 1] != null) {
                        List<Edge> edgesList = myNodes[i].getEdgesList();
                        Edge[] edgeArray = myNodes[i].getEdges();
                        for (Edge edge : edgeArray) {
                            if (edge.getNext() != myNodes[i + 1]) {
                                edgesList.remove(edge);
                            }
                        }
                    }
                }
                myCFGsArray[counter] = new CFG(tempPath.getNodes(), tempPath.getEdges(), tempPath.getStartNode(), exitNodess);
                counter = counter + 1;
            }
            return myCFGsArray;
        }
    }

    boolean isReachable(Node startNode, Node goalNode) {
        /*
            - This function should determine if the goalNode is reachable from the startNode.
            - If it is reachable, the function should return true and false if not.
            - If either the startNode or the goalNode is null, the function should return false.
        */
        if(startNode == null || goalNode == null) {
            return false;
        } else if (startNode.equals(goalNode) == true) {
            return true;
        } else {
            List<Path> paths = new List<>();
            List<Node> visitedNodes = new List<>();
            List<Edge> visitedEdges = new List<>();
            explorePaths(startNode, visitedNodes, visitedEdges, paths);
            // Conversions
            Object[] objects = paths.toArray();
            boolean searchForStart = true;
            for(Object path : objects) {
                Path tempPath =(Path) path;
                for(Node pathNode : tempPath.getNodes()) {
                    if(searchForStart == true && pathNode.equals(startNode)) {
                        searchForStart = false;
                    } else if(!searchForStart && pathNode.equals(goalNode)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }

    public Path[] getSimplePaths() {
        //TODO: Implement the function
        /*
            - This function should return all the simple paths in the CFG as an array.
            - It can be assumed that the CFG will be a SESE CFG.
            - A SESE CFG can be described by the following properties:
                - Is a valid CFG.
                - Only has one exit node.
        */
        List<Path> paths = new List<>();
        List<Node> visitedNodes = new List<>();
        List<Edge> visitedEdges = new List<>();
        explorePaths(startNode, visitedNodes, visitedEdges, paths);
        // Conversions
        Object[] objects = paths.toArray();
        Path[] myPathsArray = new Path[objects.length];
        int counter = 0;
        for(Object path : objects) {
            Path tempPath =(Path) path;
            myPathsArray[counter] = tempPath;
            counter = counter + 1;
        }
        // return myPathsArray;
        return generateCombinations(myPathsArray);
    }

    public Path[] getPrimePaths() {
        /*
            - This function should return all the Prime Paths in the CFG as an array.17
            - It can be assumed that the CFG will be a SESE CFG.
        */
        Path[] simplePaths = getSimplePaths();
        for(int i = 0; i < simplePaths.length; i++) {
            if(simplePaths[i] != null) {
                for(int j = 0; j < simplePaths.length; j++) {
                    if(i != j && simplePaths[j] != null) {
                        if(isSubset(simplePaths[i], simplePaths[j])) {
                            simplePaths[i] = null;
                            break;
                        }
                    }
                }
            }
        }
        // Count the number of non-null paths
        int counter = 0;
        for(Path path : simplePaths) {
            if(path != null) {
                counter++;
            }
        }
        // Create an array for prime paths
        Path[] primePaths = new Path[counter];
        // Copy non-null paths to the primePaths array
        int index = 0;
        for(Path path : simplePaths) {
            if(path != null) {
                primePaths[index] = path;
                index++;
            }
        }
        return primePaths;
    }
    

    boolean isValid() {
        /*
            - This function should determine if the CFG is valid.
            - A CFG is valid if and only if the following properties hold:
                - The start node is not null.
                - There is at least one exit node.
                - For every non-exit node in the CFG, at least one of the exit nodes is reachable from this node. In other words, there exists a path from said node to at least one exit node.
            - If the CFG is valid, the function should return true, otherwise false.
        */
        if(startNode == null || exitNodes == null) {
            return false;
        } else if (exitNodes.length <= 0) {
            return false;
        } else {
            for(Object nodeObject : this.nodes.toArray()) {
                boolean reachable = false;
                if(nodeObject != null) {
                    for(Object exiObject : exitNodes.toArray()) {
                        if(isReachable((Node) nodeObject, (Node) exiObject)) {
                            reachable = true;
                            break;
                        }
                    }
                    if(reachable == false) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Helper Methods!!
    private void explorePaths(Node currentNode, List<Node> visitedNodes, List<Edge> visitedEdges, List<Path> paths) {
        // Add the current node to the visited nodes
        visitedNodes.append(currentNode);
        // Check if the current node is an exit node
        if(exitNodes.contains(currentNode)) {
            // Conversions Nodes
            Object[] objects = visitedNodes.toArray();
            Node[] myNodesArray = new Node[objects.length];
            int counter = 0;
            for(Object tNode : objects) {
                Node tempNode =(Node) tNode;
                myNodesArray[counter] = tempNode;
                counter = counter + 1;
            }
            // Conversions Edges
            objects = visitedEdges.toArray();
            Edge[] myEdgesArray = new Edge[objects.length];
            counter = 0;
            for(Object tEdge : objects) {
                Edge tempEdge =(Edge) tEdge;
                myEdgesArray[counter] = tempEdge;
                counter = counter + 1;
            }
            // Now Creating a new path using the visited nodes and edges
            Path path = new Path(startNode, currentNode, myNodesArray, myEdgesArray);
            paths.append(path);
        }
        // Explore the outgoing edges from the current node
        Edge[] edges = currentNode.getEdges();
        for(Edge edge : edges) {
            // Check if the edge has already been visited
            if(!visitedEdges.contains(edge)) {
                // append the edge to the visited edges
                visitedEdges.append(edge);
                // Recursively explore the next node in the path
                explorePaths(edge.getNext(), visitedNodes, visitedEdges, paths);
                // Remove the edge from the visited edges to backtrack
                visitedEdges.remove(edge);
            }
        }
        // Remove the current node from the visited nodes to backtrack
        visitedNodes.remove(currentNode);
    }

    public Path[] generateCombinations(Path[] other) {
        List<Path> myPathList = new List<>();
        for(int count = 0; count < other.length; count++) {
            Node[] elements = other[count].getNodes();
            Edge[] edges = other[count].getEdges();
            int n = elements.length;
            for(int i = 1; i <= n; i++) {
                for(int j = 0; j <= n - i; j++) {
                    List<Node> combinations = new List<>();
                    List<Edge> edgeCombo = new List<>();
                    for(int k = j; k < j + i; k++) {
                        combinations.append(elements[k]);
                        if(k != j + i - 1) {
                            edgeCombo.append(edges[k]);
                        }
                    }
                    // Some type Conversions here!!!
                    Node[] tempNodeArray =(this.objectsToNode(combinations.toArray()));
                    Path tempPath = new Path(tempNodeArray[0], tempNodeArray[tempNodeArray.length - 1], tempNodeArray, this.objectsToEdge(edgeCombo.toArray()));
                    boolean match = false;
                    for(Path myTempPath: this.objectsToPath(myPathList.toArray())) {
                        if(sameThing(myTempPath, tempPath) == true) {
                            match = true;
                            break;
                        }
                    }
                    if(match == false &&(tempPath.getNodes().length <= this.getMaxLengthPath(other))) {
                        if(!((this.getLengthPath(tempPath) < this.getMaxLengthPath(other)) &&(tempPath.getNodes().length == this.getMaxLengthPath(other)))) {
                            myPathList.append(tempPath);
                        }
                    }
                }
            }
        }

        return this.objectsToPath(myPathList.toArray());
    }

    public boolean sameThing(Path first, Path second) {
        if((first == null && second != null) || (first != null && second == null)) {
            return false;
        } else if(first == null && second == null) {
            return true;
        } else if(first.getNodes().length != second.getNodes().length) {
            return false;
        } else if(first.getEdges().length != second.getEdges().length) {
            return false;
        } else {
            Edge[] edges1 = first.getEdges();
            Edge[] edges2 = second.getEdges();
            if(edges1.length >= edges2.length) {
                for(int k = 0; k < second.getEdges().length; k++) {
                    if(!edges1[k].equals(edges2[k])) {
                        return false;
                    }
                }
            } else {
                for(int k = 0; k < first.getEdges().length; k++) {
                    if(!edges1[k].equals(edges2[k])) {
                        return false;
                    }
                }
            }
            Node[] nodes1 = first.getNodes();
            Node[] nodes2 = second.getNodes();
            if(nodes1.length >= nodes2.length) {
                for(int k = 0; k < second.getNodes().length; k++) {
                    if(!nodes1[k].equals(nodes2[k])) {
                        return false;
                    }
                }
            } else {
                for(int k = 0; k < first.getNodes().length; k++) {
                    if(!nodes1[k].equals(nodes2[k])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private boolean isSubset(Path first, Path second) {
        Edge[] edges1 = first.getEdges();
        Edge[] edges2 = second.getEdges();
        Node[] nodes1 = first.getNodes();
        Node[] nodes2 = second.getNodes();
    
        if (edges1.length > edges2.length || nodes1.length > nodes2.length) {
            return false;
        }
    
        for (int i = 0; i <= edges2.length - edges1.length; i++) {
            boolean foundSubset = true;
            for (int j = 0; j < edges1.length; j++) {
                if (!edges2[i + j].equals(edges1[j])) {
                    foundSubset = false;
                    break;
                }
            }
            if (foundSubset) {
                return true;
            }
        }
    
        for (int i = 0; i <= nodes2.length - nodes1.length; i++) {
            boolean foundSubset = true;
            for (int j = 0; j < nodes1.length; j++) {
                if (!nodes2[i + j].equals(nodes1[j])) {
                    foundSubset = false;
                    break;
                }
            }
            if (foundSubset) {
                return true;
            }
        }
    
        return false;
    }
    

    // * Just For Conversion
    public Node[] objectsToNode(Object[] other) {
        Node[] tempNodes = new Node[other.length];
        int counter = 0;
        for(Object node : other) {
            tempNodes[counter] =(Node) node;
            counter += 1;
        }
        return tempNodes;
    }

    public Edge[] objectsToEdge(Object[] other) {
        Edge[] tempEdges = new Edge[other.length];
        int counter = 0;
        for(Object edge : other) {
            tempEdges[counter] =(Edge) edge;
            counter += 1;
        }
        return tempEdges;
    }

    public Path[] objectsToPath(Object[] other) {
        Path[] tempPaths = new Path[other.length];
        int counter = 0;
        for(Object path : other) {
            tempPaths[counter] =(Path) path;
            counter += 1;
        }
        return tempPaths;
    }

    public int getLengthPath(Path other) {
        Node[] myPathNode = other.getNodes();
        List<Node> myOtherList = new List<>();
        for(int i = 0; i < myPathNode.length; i++) {
            if(myOtherList.contains(myPathNode[i]) == true) {
                return i;
            } else {
                myOtherList.append(myPathNode[i]);
            }
        }
        return myOtherList.length;
    }

    public int getMaxLengthPath(Path[] other) {
        int max = -1;
        for(int i = 0; i < other.length; i++) {
            int temp = this.getLengthPath(other[i]);
            if(temp > max) {
                max = temp;
            }
        }
        return max;
    }
}
