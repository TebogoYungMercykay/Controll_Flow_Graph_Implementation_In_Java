public class Edge {
    // This is the class that will represent the edges in the CFG.
    private final String annotation;
    private final Node nextNode;
    private final int computationalTime;

    public Edge(String annot, Node nextNode, int compTime){
        //TODO: Implement the function
        this.annotation = annot;
        this.nextNode = nextNode;
        this.computationalTime = compTime;
    }

    public Node getNext(){
        //TODO: Implement the function
        return this.nextNode;
    }

    public String getAnnotation(){
        //TODO: Implement the function
        return this.annotation;
    }

    public int getCompTime(){
        //TODO: Implement the function
        return this.computationalTime;
    }

    public String toString(){
        // Do not alter!!!
        String res = "-> " + annotation + " -[" + computationalTime + "]-";
        if(nextNode == null) {
            res += "> NULL";
        } else {
            res += "> " + nextNode.getAnnotation();
        }
        return res;
    }
}
