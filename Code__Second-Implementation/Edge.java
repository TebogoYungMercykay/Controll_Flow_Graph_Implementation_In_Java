public class Edge {
    private final String annotation;
    private final Node nextNode;
    private final int computationalTime;

    public Edge(String annot, Node nextNode, int compTime){
        this.annotation=annot;
        this.nextNode=nextNode;
        this.computationalTime=compTime;
    }

    public Node getNext(){
        return nextNode;
    }
   @Override
    public boolean equals(Object node)
    {
        if(node==null)
        {
           return false;
        }
         
        if(annotation.equals(((Edge)node).annotation))
            return  true;

        return false;
 
    }


    public int getCompTime(){
        return computationalTime;
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
    public String getAnnotation(){
       return annotation;
    }
}
