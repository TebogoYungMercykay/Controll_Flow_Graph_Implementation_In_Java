public class App {
    public static void main(String[] args) {
        TestOwnDataStructure();
        // TODO: For the Below Test To Work, Replace the List<X> occurences with you own data structure!!!
        // TODO: Something like OwnDataStructure<Edge> or so.
        TestingTheEdgeClass();
        TestingThePathClass();
        SpecExample1();
    }

    public static void SpecExample1(){
        System.out.println("________________________ S T A R T _____________________________");
        Node N1 = new Node("N1");
        Node N2 = new Node("N2");
        Node N3 = new Node("N3");
        Node N4 = new Node("N4");
        Node N5 = new Node("N5");
        CFG cfg = new CFG();
        cfg.addStartNode(N1);
        cfg.addNode(N2);
        cfg.addNode(N3);
        cfg.addNode(N4);
        cfg.addExitNode(N5);
        cfg.addEdge("E1", cfg.getNode("N1"), cfg.getNode("N2"), 0);
        cfg.addEdge("E2", cfg.getNode("N2"), cfg.getNode("N3"), 0);
        cfg.addEdge("E3", cfg.getNode("N3"), cfg.getNode("N4"), 0);
        cfg.addEdge("E4", cfg.getNode("N4"), cfg.getNode("N3"), 0);
        cfg.addEdge("E5", cfg.getNode("N3"), cfg.getNode("N5"), 0);
        printGraph(cfg);
        Path[] simplePaths = cfg.getSimplePaths();
        for(Path p: simplePaths){
            System.out.println(p.toString());
        }
        printBreaker();
        Path[] primePaths = cfg.getPrimePaths();
        for(Path p: primePaths){
            System.out.println(p.toString());
        }
        printBreaker();
        System.out.println("isSESE: " + cfg.isSESE());
        System.out.println("isValid: " + cfg.isValid());
        System.out.println("Shortest: " + cfg.shortestCompTimePath(N1, N2).toString());
        System.out.println("Shortest: " + cfg.shortestCompTimePath(N1, N4).toString());
        System.out.println("Shortest: " + cfg.shortestCompTimePath(N1, N5).toString());
        System.out.println("Shortest: " + cfg.shortestCompTimePath(N3, N4).toString());
        System.out.println("Shortest: " + cfg.shortestCompTimePath(N2, N5).toString());
        System.out.println("Shortest: " + cfg.shortestCompTimePath(N4, N5).toString());
        System.out.println("isReachable: " + cfg.isReachable(N2, N5));
        printBreaker();
        for(CFG graph : cfg.splitGraph()) {
            printGraph(graph);
        }
        System.out.println("__________________________ E N D _______________________________");
        System.out.println("________________________________________________________________");
    }

    public static void TestOwnDataStructure(){
        System.out.println("________________________ S T A R T _____________________________");
        // Create a new list
        List<Integer> myList = new List<>();
        // Append elements
        myList.append(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        // Print the list
        System.out.println("List: " + myList);
        // Check if the list is empty
        System.out.println("Is empty? " + myList.isEmpty());
        // Get an element at a specific index
        System.out.println("Element at index 2: " + myList.get(2));
        // Check if the list contains a specific element
        System.out.println("Contains 2? " + myList.contains(2));
        // Remove an element
        myList.remove(3);
        // Print the updated list
        System.out.println("List after removing 3: " + myList);
        // Get the size of the list
        System.out.println("Size of the list: " + myList.size());
        // Convert the list to an array
        System.out.println("Array: " + myList.toString());
        // Create a new list from an existing list
        List<Integer> newList = new List<>(myList);
        System.out.println("New list: " + newList);
        // Check if two lists are equal
        System.out.println("Lists are equal? " + myList.equals(newList));
        Integer t = newList.pop();
        System.out.println("Testing pop: " + t);
        System.out.println("Array: " + newList.toString());
        System.out.println("Contains: " + myList.contains(t));
        System.out.println("Array: " + myList.toString());
        System.out.println("__________________________ E N D _______________________________");
        System.out.println("________________________________________________________________");
    }

    public static void TestingTheEdgeClass(){
        System.out.println("____________________ E D G E - S T A R T _______________________");
        // Create a new list
        List<Edge> myList = new List<>();
        // Append elements
        Edge N1 = new Edge("Edge 1", null, 45);
        Edge N2 = new Edge("Edge 2", null, 46);
        Edge N3 = new Edge("Edge 3", null, 35);
        Edge N4 = new Edge("Edge 4", null, 75);
        Edge N5 = new Edge("Edge 5", null, 38);
        myList.append(N1);
        myList.append(N2);
        myList.append(N3);
        myList.append(N4);
        myList.append(N5);
        // Get the size of the list
        System.out.println("Size of the list: " + myList.size());
        // Print the list
        System.out.println("List: " + myList);
        // Check if the list is empty
        System.out.println("Is empty? " + myList.isEmpty());
        // Get an element at a specific index
        System.out.println("Element at index 2: " + myList.get(2));
        // Check if the list contains a specific element
        System.out.println("Contains 2? " + myList.contains(N2));
        // Remove an element
        myList.remove(N3);
        // Print the updated list
        System.out.println("List after removing 3: " + myList);
        // Get the size of the list
        System.out.println("Size of the list: " + myList.size());
        // Convert the list to an array
        System.out.println("Array: " + myList.toString());
        // Create a new list from an existing list
        List<Edge> newList = new List<>(myList);
        System.out.println("New list: " + newList);
        // Check if two lists are equal
        System.out.println("Lists are equal? " + myList.equals(newList));
        Edge temp = newList.pop();
        System.out.println("Testing pop: " + temp);
        System.out.println("Array: " + newList.toString());
        System.out.println("Contains: " + myList.contains(temp));
        System.out.println("Array: " + myList.toString());
        System.out.println("__________________________ E N D _______________________________");
        System.out.println("________________________________________________________________");
    }

    public static void TestingThePathClass(){
        System.out.println("____________________ P A T H - S T A R T _______________________");
        Node[] nodes = new Node[5];
        nodes[0] = new Node("Node1");
        nodes[1] = new Node("Node2");
        nodes[2] = new Node("Node3");
        nodes[3] = new Node("Node4");
        nodes[4] = new Node("Node5");
        Edge[] edges = new Edge[4];
        edges[0] = new Edge("Edge 1", nodes[1], 45);
        edges[1] = new Edge("Edge 2", nodes[2], 46);
        edges[2] = new Edge("Edge 3", nodes[3], 35);
        edges[3] = new Edge("Edge 4", nodes[4], 75);
        // edges[4] = new Edge("Edge 5", nodes[0], 38);
        nodes[0].addEdge(nodes[1], "Edge 1", 45);
        nodes[1].addEdge(nodes[2], "Edge 2", 46);
        nodes[2].addEdge(nodes[3], "Edge 3", 35);
        nodes[3].addEdge(nodes[4], "Edge 4", 75);
        // nodes[4].addEdge(nodes[0], "Edge 5", 38);
        Path myPath = new Path(nodes[0], nodes[4], nodes, edges);
        Path myPath2 = new Path(myPath);
        System.out.println("Computational Cost Path 1: " + myPath.computationalCostOfPath());
        System.out.println("Computational Cost Path 2: " + myPath2.computationalCostOfPath());
        System.out.println("To String Path 1: " + myPath.toString());
        System.out.println("To String Path 2: " + myPath2.toString());
        System.out.println("Valid Path 1: " + myPath.validPath());
        System.out.println("Valid Path 2: " + myPath2.validPath());
        // Set nodes array elements to null
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = null;
        }
        // Set edges array elements to null
        for (int i = 0; i < edges.length; i++) {
            edges[i] = null;
        }
        // Set nodes array to null
        nodes = null;
        // Set edges array to null
        edges = null;
        // * About to Test the AppendToPath method!!
        Node[] nodesArray = new Node[2];
        nodesArray[0] = new Node("Node 6");
        nodesArray[1] = new Node("Node 7");
        Edge[] edgesArray = new Edge[2];
        edgesArray[0] = new Edge("Edge 5", nodesArray[0], 67);
        edgesArray[1] = new Edge("Edge 6", nodesArray[1], 98);
        Path path2 = new Path(nodesArray[0], nodesArray[1], nodesArray, edgesArray);
        System.out.println("To String Path 1: " + myPath.toString());
        System.out.println("To String Path 2: " + myPath2.toString());
        System.out.println("To String Path 3: " + path2.toString());
        myPath.appendToPath(path2);
        System.out.println("To String Path 1: " + myPath.toString());
        System.out.println("To String Path 2: " + myPath2.toString());
        System.out.println("To String Path 3: " + path2.toString());
        System.out.println("Valid Path 1: " + myPath.validPath());
        System.out.println("__________________________ E N D _______________________________");
        System.out.println("________________________________________________________________");
    }

    public static void printGraph(CFG graph){
        printBreaker();
        if(graph == null){
            System.out.println("NULL Graph");
        } else {
            System.out.println(graph.toString());
        }
        printBreaker();
    }

    public static void printBreaker(){
        System.out.println("________________________________________________________________");
        System.out.println("________________________________________________________________");
    }
/* THIS IS THE OUTPUT FOR THE CFG!!!
java App
________________________ S T A R T _____________________________
List: 1,2,3,4
Is empty? false
Element at index 2: 3
Contains 2? true
List after removing 3: 1,2,4
Size of the list: 3
Array: 1,2,4
New list: 1,2,4
Lists are equal? true
Testing pop: 1
Array: 2,4
Contains: true
Array: 1,2,4
__________________________ E N D _______________________________
________________________________________________________________
____________________ E D G E - S T A R T _______________________
Size of the list: 5
List: -> Edge 1 -[45]-> NULL,-> Edge 2 -[46]-> NULL,-> Edge 3 -[35]-> NULL,-> Edge 4 -[75]-> NULL,-> Edge 5 -[38]-> NULL
Is empty? false
Element at index 2: -> Edge 3 -[35]-> NULL
Contains 2? true
List after removing 3: -> Edge 1 -[45]-> NULL,-> Edge 2 -[46]-> NULL,-> Edge 4 -[75]-> NULL,-> Edge 5 -[38]-> NULL
Size of the list: 4
Array: -> Edge 1 -[45]-> NULL,-> Edge 2 -[46]-> NULL,-> Edge 4 -[75]-> NULL,-> Edge 5 -[38]-> NULL
New list: -> Edge 1 -[45]-> NULL,-> Edge 2 -[46]-> NULL,-> Edge 4 -[75]-> NULL,-> Edge 5 -[38]-> NULL
Lists are equal? true
Testing pop: -> Edge 1 -[45]-> NULL
Array: -> Edge 2 -[46]-> NULL,-> Edge 4 -[75]-> NULL,-> Edge 5 -[38]-> NULL
Contains: true
Array: -> Edge 1 -[45]-> NULL,-> Edge 2 -[46]-> NULL,-> Edge 4 -[75]-> NULL,-> Edge 5 -[38]-> NULL
__________________________ E N D _______________________________
________________________________________________________________
____________________ P A T H - S T A R T _______________________
Computational Cost Path 1: 201
Computational Cost Path 2: 201
To String Path 1: Node1-> Edge 1 -[45]-> Node2-> Edge 2 -[46]-> Node3-> Edge 3 -[35]-> Node4-> Edge 4 -[75]-> Node5
To String Path 2: Node1-> Edge 1 -[45]-> Node2-> Edge 2 -[46]-> Node3-> Edge 3 -[35]-> Node4-> Edge 4 -[75]-> Node5
Valid Path 1: true
Valid Path 2: true
To String Path 1: Node1-> Edge 1 -[45]-> Node2-> Edge 2 -[46]-> Node3-> Edge 3 -[35]-> Node4-> Edge 4 -[75]-> Node5
To String Path 2: Node1-> Edge 1 -[45]-> Node2-> Edge 2 -[46]-> Node3-> Edge 3 -[35]-> Node4-> Edge 4 -[75]-> Node5
To String Path 3: Node 6-> Edge 5 -[67]-> Node 6-> Edge 6 -[98]-> Node 7
To String Path 1: Node1-> Edge 1 -[45]-> Node2-> Edge 2 -[46]-> Node3-> Edge 3 -[35]-> Node4-> Edge 4 -[75]-> Node5-> Edge 5 -[67]-> Node 6-> Edge 6 -[98]-> Node 7
To String Path 2: Node1-> Edge 1 -[45]-> Node2-> Edge 2 -[46]-> Node3-> Edge 3 -[35]-> Node4-> Edge 4 -[75]-> Node5
To String Path 3: Node 6-> Edge 5 -[67]-> Node 6-> Edge 6 -[98]-> Node 7
Valid Path 1: true
__________________________ E N D _______________________________
________________________________________________________________
________________________ S T A R T _____________________________
________________________________________________________________
________________________________________________________________
N1:
        -> E1 -[0]-> N2
N2:
        -> E2 -[0]-> N3
N3:
        -> E3 -[0]-> N4
        -> E5 -[0]-> N5
N4:
        -> E4 -[0]-> N3
N5:
        No out going edges

________________________________________________________________
________________________________________________________________
N1
N2
N3
N4
N5
N1-> E1 -[0]-> N2
N2-> E2 -[0]-> N3
N3-> E3 -[0]-> N4
N3-> E5 -[0]-> N5
N4-> E4 -[0]-> N3
N1-> E1 -[0]-> N2-> E2 -[0]-> N3
N2-> E2 -[0]-> N3-> E3 -[0]-> N4
N2-> E2 -[0]-> N3-> E5 -[0]-> N5
N3-> E3 -[0]-> N4-> E4 -[0]-> N3
N4-> E4 -[0]-> N3-> E3 -[0]-> N4
N4-> E4 -[0]-> N3-> E5 -[0]-> N5
N1-> E1 -[0]-> N2-> E2 -[0]-> N3-> E3 -[0]-> N4
N1-> E1 -[0]-> N2-> E2 -[0]-> N3-> E5 -[0]-> N5
###
N3-> E3 -[0]-> N4-> E4 -[0]-> N3
N4-> E4 -[0]-> N3-> E3 -[0]-> N4
N4-> E4 -[0]-> N3-> E5 -[0]-> N5
N1-> E1 -[0]-> N2-> E2 -[0]-> N3-> E3 -[0]-> N4
N1-> E1 -[0]-> N2-> E2 -[0]-> N3-> E5 -[0]-> N5
________________________________________________________________
________________________________________________________________
isSESE: true
isValid: true
Shortest: N1-> E1 -[0]-> N2
Shortest: N1-> E1 -[0]-> N2-> E2 -[0]-> N3-> E3 -[0]-> N4
Shortest: N1-> E1 -[0]-> N2-> E2 -[0]-> N3-> E5 -[0]-> N5
Shortest: N3-> E3 -[0]-> N4
Shortest: N2-> E2 -[0]-> N3-> E5 -[0]-> N5
Shortest: N4-> E4 -[0]-> N3-> E5 -[0]-> N5
isReachable: true
________________________________________________________________
________________________________________________________________
________________________________________________________________
________________________________________________________________
N1:
        -> E1 -[0]-> N2
N2:
        -> E2 -[0]-> N3
N3:
        -> E3 -[0]-> N4
        -> E5 -[0]-> N5
N4:
        -> E4 -[0]-> N3
N5:
        No out going edges

________________________________________________________________
________________________________________________________________
__________________________ E N D _______________________________
________________________________________________________________
 */

}
