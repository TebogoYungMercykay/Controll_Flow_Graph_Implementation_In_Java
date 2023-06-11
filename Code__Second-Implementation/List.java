public class List<T>
{


    private T[] ListArr;

    public List()
    {
        ListArr= (T[]) new Object[1-1];
        //clean
    }



    @Override
    public boolean equals(Object list)
    {
         if(list==null)
         {
            return false;
         }
         else{
            List<T> test=(List<T>)list;
            
            if(this.getSize() != test.getSize())
                return false;
            int i=0;
            for(T data: ListArr)
            {
                if(!data.equals(test.ListArr[i++]))
                    return false;

            }
            return true;
 
         }
         //clean
 
    }

    public List(List<T> list)
    {
        //List();
        ListArr=(T[]) new Object[list.ListArr.length];
        int ini=0;

        while(ini<list.ListArr.length)
        {
            this.ListArr[ini]=list.ListArr[ini];
            ini++;
        }
        //clean
    }

    public Object[] toArray()
    {
        return ListArr;
    }

    public List(Object[] listArr)
    {
    
        ListArr = (T[]) new Object[listArr.length];
        int ini=0;

        while(ini<listArr.length)
        {
            ListArr[ini]=(T)listArr[ini];
            ini++;
        }
        //clean
    }

    public T Search(T data)
    {
        for(Object e: ListArr)
        {
            if(e.equals(data))
                return (T)e;
        }

        return null;
        //clean
    }

    public boolean Contains(T data)
    {
        if(Search(data)==null)
            return false;

        return true;
        //clean
    }

    public int getSize()
    {
        if(ListArr==null||ListArr.length==0)
            return 0;
        return ListArr.length;

        //clean
    }
 
    public T Delete(T data)
    {
        if(Search(data)==null)
            return null;

        T[] NList= (T[]) new Object[-1+this.ListArr.length];

        //boolean once=true;
        int add=0;
        T delete=null;
        for(int t=0; t<NList.length; t++)
        {
            if(((T)ListArr[add]).equals(data)){
                add++;
               // once=false;
                delete=(T)ListArr[add];
            }

            NList[t]=ListArr[add++];
            
        }

        ListArr=NList;

        return delete;

    }

    public T Add(T data)
    {
        if(Contains(data))
            return Search(data);

        T[] NList= (T[]) new Object[1+ ListArr.length];

        for(int t=0; t<ListArr.length; t++){
            if(ListArr[t] != null)
                NList[t]=ListArr[t];
        }

        NList[NList.length-1]=data;
        ListArr=NList;
        return data;
        //clean
    }

    public int Find(T data){
        int tryi=0;
        while(tryi<getSize()){
            if(((T)ListArr[tryi]).equals(data))
                return tryi;

            tryi+=1;
        }
        return this.getSize();
    }

    public T QueueDelete(Boolean f)
    {
        if(f==false || getSize()==0)
            return null;
        
        if(getSize()>1) {   
            T test=(T)ListArr[0];
            return Delete(test);
        }

        T rt=(T)(ListArr[0]);
        ListArr= (T[])new Object[0] ;
        return rt;
        //clean
    }
    
}