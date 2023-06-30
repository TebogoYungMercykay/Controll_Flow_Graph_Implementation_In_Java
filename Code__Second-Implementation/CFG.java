public class CFG {
   private Node startNode;
    private List<Node> nodes;
    private List<Edge> edges;
    private List<Node> exitNodes;
    private Node[] PrevNode;
    private int[] Distance;

    public CFG(){
        startNode=null;
        nodes= new List<>();
        edges= new List<>();
        exitNodes= new List<>();
        PrevNode=  new Node[0];
        Distance= new int [0];
    }

    public CFG(Node[] nodes, Edge[] edges, Node sNode, Node[] exitNodes){
        startNode=sNode;

        if(IsArrayEmpty(nodes))
            this.nodes= new List<>();
        else{
            this.nodes= new List<>(nodes);
        }
        
        if(IsArrayEmpty(edges))
        {
            this.edges= new List<>();
        }
        else{
            this.edges= new List<>(edges);
        }

        if(IsArrayEmpty(exitNodes))
        {
            this.exitNodes= new List<>();
        }
        else{
            this.exitNodes= new List<>(exitNodes);
        }
        PrevNode=  new Node[0];
        Distance= new int [0];
       
    }
    public boolean IsArrayEmpty(Object []arr)
    {
        if(arr==null || arr.length==0)
            return true;
        
        return false;
    }

    public CFG(CFG other){
        if(other.startNode==null)
            startNode=null;
        else{
            this.startNode= new Node(other.startNode.getAnnotation());
            Edge[] StartEdge= startNode.getEdges();
            for(int e=0; e<StartEdge.length; e++)
                this.startNode.addEdge(StartEdge[e].getNext(), StartEdge[e].getAnnotation(), StartEdge[e].getCompTime());
        }
        Object [] node=other.nodes.toArray();
        nodes=new List<>();
        for(int n=0; n<node.length; n++){
            Node nnode=(Node)node[n];
            Edge[] nnodeEdge=nnode.getEdges();
            Node add= new Node(nnode.getAnnotation()); 
            add.AddEdge(nnodeEdge);
           
            nodes.Add(add);
        }

        node=other.exitNodes.toArray();
        exitNodes= new List<>();
        for(int n=0; n<node.length; n++){
            Node nnode=(Node)node[n];
            Edge[] nnodeEdge=nnode.getEdges();
            Node add= new Node(nnode.getAnnotation());
            add.AddEdge(nnodeEdge);
            exitNodes.Add(add);
        }

        Object []Edge=other.edges.toArray();
        edges= new List<>();
        for(int e=0; e<Edge.length; e++){
            Edge eEdge=(Edge)Edge[e];
            Edge add= new Edge(eEdge.getAnnotation(), eEdge.getNext(), eEdge.getCompTime());
            edges.Add(add);

        }
        PrevNode=  new Node[0];
        Distance= new int [0];
        
    }

    public boolean isValid(){

        if(startNode==null || !(exitNodes.getSize()>=1))
            return !true;

        
        return TestAllNode();
    }

    public boolean TestAllNode()
    {
        for(Object test: nodes.toArray())
        {
            if(!DoNodesReachExist((Node) test))
                return false;
        }

        return true;
    }

    public boolean isSESE(){
        //TODO: Implement the function

        if(exitNodes.getSize()==1 )
        {
            if(isValid())
                return true;
        }

        return false;
    }
  
    public boolean DoNodesReachExist(Node test)
    {
        if(test==null)
            return false;


        for(Object exist: exitNodes.toArray())
        {
        
            if(isReachable((Node)test, (Node)exist))
                return true;           
            
        }

        return false;

    }
    public CFG[] splitGraph(){
        if(this.isSESE())
        {
            CFG[] one=new CFG[1];
            one[0]=this;
            return one;
        }
        if( this.isValid())
        { 
            int numOfCfg=exitNodes.getSize();
            CFG[] com=new CFG[numOfCfg];

            for(int p=0;p <numOfCfg; p++)
            {
                com[p]= new CFG();
                Node n= new Node(startNode.getAnnotation());
                Edge[]  d= startNode.getEdges();
                n.AddEdge(d);
                com[p].addStartNode(n);
            }

            for(int cfg=0; cfg<numOfCfg; cfg++)
            {
                for(Object node: nodes.toArray())
                {
                    if(isReachable((Node)node, (Node)exitNodes.toArray()[cfg]))
                    {
                        Node n= new Node(((Node)node).getAnnotation());
                        Edge[] d= ((Node)node).getEdges();
                        n.AddEdge(d);
                        com[cfg].addNode(n);
                    }
                } 
            }
            return com;

        }
        return null;
    }

    public boolean isReachable(Node startNode, Node goalNode){
        
        if(startNode.equals(goalNode))
            return true;
        
        FindDistance_Path(startNode);
        if(Distance[nodes.Find(goalNode)] != Integer.MAX_VALUE)
            return true;

        return false;
    }

    public int compTimeRequired(Path p){
        if(p==null)
            return -1;
        return p.computationalCostOfPath();
    }

    public Path shortestCompTimePath(Node sN, Node gN){
        if(sN.equals(gN))
        {
            Node[]t={sN};

            return new Path(sN, gN, t, new Edge[0]);
        }
        FindDistance_Path(sN);
        return FindNodeInPath(sN, gN, PrevNode);
        //TODO: Implement the function
    }

    @Override
    public boolean equals(Object cg)
    {
        if(cg==null)
            return false;
        CFG equy=(CFG)cg;
        MakeSure(startNode);
        if(!startNode.equals(equy.startNode))
            return false;
        
        if( nodes.equals(equy.nodes) && edges.equals(equy.edges) && exitNodes.equals(equy.exitNodes) )
            return true;

        return false;
    }

    public Path FindNodeInPath(Node sN, Node gN, Node [] prev)
    {
        int index=nodes.Find(gN);
        Node temp=gN;

        List<Node> ReversePath= new List<>();
        ReversePath.Add(gN);
        do{
            index=nodes.Find(temp);
            temp=prev[index];
            ReversePath.Add(temp);
        }
        while(temp != sN);

        Node []node= new Node[ReversePath.getSize()];
        int i=0;
        int start=ReversePath.getSize()-1;
        for(int n=start; n>=0; n--)
        {
            node[i++]=(Node)ReversePath.toArray()[n];
        }

        Edge [] edges= new Edge[node.length-1];

        for(int e=0; e<edges.length; e++)
        {
            Node find=node[e+1];
            edges[e]=node[e].FindEdge(find);
        }

        return new Path(sN, gN, node, edges);

    }

    public Path[] getPrimePaths(){
        Path [] SP=getSimplePaths();
        Path[] PP= new Path[0];

        for(int s=0; s<SP.length; s++)
        {
            if(isPrime(SP[s], SP)  && true)
            {
         
                PP=AddPath(PP, SP[s]);
            }
        }
        return PP;
    }
    public boolean isPrime(Path s, Path[] sim)
    {

        for(Path p:sim)
        {
            if( !(p.toString().equals(s.toString())) &&  p.toString().contains(s.toString())  )
            {
                return false;
            }
        }
        return true;
    }

    public Path[] getSimplePaths(){
       
        Node hama= new Node(" wdrfvg");
        int maxLengthSimplePath=nodes.getSize()-1; 
        int currentSize=0;
        Path [] simplePaths= new Path[0];
        while(currentSize<=maxLengthSimplePath)
        {
            if(currentSize==0)
            {
                for(int c=0; c<nodes.getSize(); c++)
                {
                    Node single=(Node)(nodes.toArray()[c]);
                    Node[] nodes= {single};
                    Path add= new Path(single, single, nodes, new Edge[0]);
                    simplePaths=AddPath(simplePaths, add);

                }
            }

            int PathCount=simplePaths.length;

            for(int p=0; p<PathCount; p++)
            {
                hama=MakeSure(hama);
                if(simplePaths[p].getNodes().getSize()==currentSize)//not possible for cur==0;
                {
                    hama=MakeSure(hama);
                    Object[] PathEdge=simplePaths[p].ENode().getEdges();//long
                    for(int i=0; i<PathEdge.length; i++)
                    {
                        Edge[]addEdge={(Edge)PathEdge[i]};
                        Node[] addNode={FindNodeEdge((Edge)PathEdge[i]), ((Edge)PathEdge[i]).getNext()};
                        Path endPiece= new Path(FindNodeEdge((Edge)PathEdge[i]), ((Edge)PathEdge[i]).getNext(), addNode, addEdge);
                        Path begPiece= new Path(simplePaths[p]);
                        begPiece.appendToPath(endPiece);
                        if(begPiece.isitSimple())
                            simplePaths=AddPath(simplePaths, begPiece);
                    }
                }
                MakeSure(hama);
            }
            currentSize++;
        }

        return simplePaths;

    }

    public Path[] AddPath(Path[] arr, Path add)
    {
        Path[] NewA= new Path[arr.length+1];

        for(int p=0; p<arr.length; p++)
        {
            NewA[p]=arr[p];
        }

        NewA[arr.length]=add;

        return NewA;
    }

    public void addNode(String annotation){
       this.addNode(new Node(annotation));
    }
    public void FindDistance_Path(Node start)
    {
        boolean change=true;
        List<Node> check= new List<>();
        Distance= new int[nodes.getSize()];
        for(int d=0; d<nodes.getSize(); d++)
            Distance[d]=Integer.MAX_VALUE;
        
        PrevNode= new Node[nodes.getSize()];
        for(int p=0; p<nodes.getSize(); p++)
            PrevNode[p]=null;

        if(nodes.Find(start) != nodes.getSize())
        {
            Distance[nodes.Find(start)]=0;
            check.Add(start);
        }   
        Node checkNode=null;
        while(!(check.getSize()==0))
        {
            checkNode=check.QueueDelete(true);
            //System.out.println(checkNode);
            Edge [] neighbour=checkNode.getEdges();
            for(int f=0; f<neighbour.length; f++)
            {
                if(Distance[nodes.Find(checkNode)] + neighbour[f].getCompTime() < Distance[nodes.Find((neighbour[f].getNext()))])
                {
                    Distance[nodes.Find((neighbour[f].getNext()))]=Distance[nodes.Find(checkNode)] + neighbour[f].getCompTime() ;
                    PrevNode[nodes.Find((neighbour[f].getNext()))]=checkNode;
                    if(!check.Contains((neighbour[f].getNext())))
                    {
                        check.Add((neighbour[f].getNext()));
                    }
                }
            }
        }

        


    }

    public void addNode(Node node){
        if(node==null)
            return ;

        nodes.Add(node);
    }

   public void addEdge(String annotation, Node fromNode, Node toNode, int computationalTime){
        if(computationalTime<0){
            return;
        }
        Edge add= new Edge(annotation, toNode, computationalTime);
        edges.Add(add);
        fromNode.addEdge(toNode, annotation, computationalTime);
    }

    public void addExitNode(Node n){
        if(n==null)
            return;

        nodes.Add(n);
        exitNodes.Add(n);
        //TODO: Implement the function
    }

    public Node MakeSure(Node rand)
    {
        if(rand==null)
            return null;

        return rand;
    }


    public void addStartNode(Node n){
        if(this.startNode==null)
            this.startNode=n;

        nodes.Add(n);
        nodes.Add(n);
    }

    public String toString() {
        //Provided function, do not alter!!!
        String res = "";
        for(Object n: nodes.toArray()){
            res += n.toString();
        }
        return res;
    }
    public Node FindNodeEdge(Edge ed)
    {
        for(Object e: nodes.toArray())
        {
            if(((Node)e).SearchEdge(ed))
                return (Node)e;
        }
        return null;
    }

    public Node getNode(String annotation){
        Node searchNode= new Node(annotation);
        return nodes.Search(searchNode);
    }
}
