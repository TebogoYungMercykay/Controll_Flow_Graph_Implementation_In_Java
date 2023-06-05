public class Edge {
    private final String annotation;
    private final Node nextNode;
    private final int computationalTime;

    public Edge(String annot, Node nextNode, int compTime){
        //TODO: Implement the function
    }

    public Node getNext(){
        //TODO: Implement the function
    }

    public String getAnnotation(){
        //TODO: Implement the function
    }

    public int getCompTime(){
        //TODO: Implement the function
    }

    public String toString(){
        //Provided function, do not alter!!!
        String res = "-> " + annotation + " -[" + computationalTime + "]-"; 
        
        if(nextNode == null)
            res += "> NULL";
        else
            res += "> " + nextNode.getAnnotation();

        return res;
    }
}
