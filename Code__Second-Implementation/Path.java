public class Path {
    private final Node startNode;
    private Node endNode;
    private final List<Node> nodes;
    private final List<Edge> edges;

    public Path(Node startNode, Node endNode, Node[] nodes, Edge[] edges){

        if(edges==null)
            this.edges= new List<>();
        else{
            this.edges= new List<>(edges);
        }

        if(nodes==null)
        {
            this.nodes= new List<>();
        
        }
        else{
            this.nodes= new List<>(nodes);
        }

        this.startNode=startNode;
        this.endNode=endNode;

    }
    @Override
    public boolean equals(Object ath)
    {
        if(ath==null)
        {
           return false;
        }
        Path test= (Path)ath;
        if(startNode.equals(test.startNode) && endNode.equals(test.endNode) && nodes.equals(test.nodes) && edges.equals(test.edges))
            return false;
        

        return false;
 
    }
    public List<Edge> getEdges()
    {
        return edges;
    }

    public Boolean isitSimple()
    {
        Object[] Edge= edges.toArray();
        Object[] Edge2=edges.toArray();
        int i=0;
        for(Object e1: Edge)
        {
            i=0;
            while(i<Edge2.length)
            {
                Edge op1=(Edge)e1;
                Edge op2=(Edge) Edge2[i];
                if(!op1.equals(op2) && op1.getNext().equals(op2.getNext()))
                    return !true;

                i++;
            }

        }
        return true;
    }

   public Path(Path other){
        nodes= new List<>(other.nodes.toArray());
        edges= new List<>(other.edges.toArray());

        startNode=other.startNode;
        endNode= other.endNode;
    }

    public Object[] MakeSure(Object[] arr)
    {
        if(arr==null)
            return null;

        return arr;
    }

    public int computationalCostOfPath(){
         int cost=0;
        for(Object edge: edges.toArray())
        {
            cost+=((Edge)edge).getCompTime();
        }
        int cost_2=cost;

        return cost_2;
       
    }
    public Node ENode()
    {
        return endNode;
    }

    @SuppressWarnings("unchecked")
    public void appendToPath(Path p){
        this.endNode=p.endNode;
        Object[] Node=p.nodes.toArray();
        Object[] Edge=p.edges.toArray();
        Node=MakeSure(Node);
        Edge=MakeSure(Edge);

        for(Object n:Node)
        {
            this.nodes.Add((Node)n);
        }
        
        for(Object E:Edge)
        {
            this.edges.Add((Edge)E);
        }
    }

    public boolean validPath(){
        int iteration=nodes.getSize()-1;
        Object[] Edge=edges.toArray();
        Object[] Node=nodes.toArray();
        int lastEdge=edges.getSize()-1;
        int start=0;
        while(start<iteration)
        {
            Edge e=(Edge)Edge[start];
            Node n=(Node)Node[start+1];
            if(!(e.getNext().equals(n))  || !((Edge)Edge[lastEdge]).getNext().equals(endNode))
                return false;
        }
     
        return true;
    }

    
    public List<Node> getNodes()
    {
        return nodes;
    }

  
    public String toString(){
        //Provided function, do not alter!!!
        String str = "";
        str += ((Node)nodes.toArray()[0]).getAnnotation();
        for(Object e: edges.toArray()){
            str += e.toString();
        }
        return str;
    }
    
}
