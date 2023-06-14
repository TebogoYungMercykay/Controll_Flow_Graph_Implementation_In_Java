public class Node {
    private final String annotation;
    private final List<Edge> edges;
    
    public Node(String annot){
        //TODO: Implement the function
        edges= new List<>();
        annotation=annot;
    }
    @Override
    public boolean equals(Object node){
        if(node==null){
           return false;
        }
         
        if(annotation.equals(((Node)node).annotation))
            return  true;

        return false;
 
    }
    public Edge[] getEdges(){
        Edge[] Edges= new Edge[edges.getSize()];
        int start=Edges.length-1;
        while(start>=0)
        {
            Edges[start]=(Edge)edges.toArray()[start];
            start--;
        }
        return Edges;
    }

    public void AddEdge(Edge[] e){
        for(int r=0; r<e.length; r++)
        {
            edges.Add(new Edge(e[r].getAnnotation(), e[r].getNext(), e[r].getCompTime()));
        }
    }

    public void addEdge(Node nextNode, String annotation, int compTime){
        //TODO: Implement the function
        edges.Add(new Edge(annotation, nextNode, compTime));
    }

    public boolean SearchEdge(Edge e){
        if(edges.Contains(e))
            return true;

        return false;
    }
    public Edge FindEdge(Node node){
        for(Object edge: edges.toArray())
        {
            if( ((Edge)edge).getNext().equals(node) )
                return ((Edge)edge);
        }

        return null;
    }

    public String getAnnotation(){
        return annotation;
    }

   

    public String toString(){
        //Provided function, do not alter!!!
        String res = annotation + ":\n";
        if(edges.toArray().length == 0)
            res += "\t" + "No out going edges" + "\n";
        else
            for(Object e: edges.toArray()){
                res += "\t" + e.toString() + "\n";
            } 
        return res;
    }
}
