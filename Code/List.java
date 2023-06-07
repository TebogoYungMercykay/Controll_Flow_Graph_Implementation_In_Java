public class List<T> {
    // The ListNode Class:
    private class ListNode<T> {
        public T data;
        public ListNode<T> next;

        public String toString(){
            return this.data.toString();
        }

        public ListNode(T val){
            this.data = val;
            this.next = null;
        }
    }

    // The LinkedList Class:
    public int length;
    public ListNode<T> head;

    public List(){
        this.length = 0;
        this.head = null;
    }

    public List(T[] elements){
        this.length = 0;
        this.head = null;
        if (elements != null && elements.length > 0){
            this.append(elements);
        }
    }

    public Object[] toArray() {
        Object[] array = new Object[length];
        ListNode<T> tempListNode = head;
        int index = 0;
        while (tempListNode != null) {
            array[index] = tempListNode.data;
            tempListNode = tempListNode.next;
            index++;
        }
        return array;
    }

    public String toString(){
        String tempString = "";
        if(this.length == 0 || this.head == null){
            return tempString;
        }
        tempString += this.head.toString();
        for(ListNode<T> tempListNode = this.head.next; tempListNode != null; tempListNode = tempListNode.next){
            tempString += "," + tempListNode.toString();
        }
        return tempString;
    }

    public void append(T val){
        ListNode<T> insertListNode = new ListNode<T>(val);
        if(this.length == 0 && this.head == null){
            this.head = insertListNode;
            this.length += 1;
        }
        else {
            ListNode<T> ListNodePtr = this.head;
            while(ListNodePtr.next != null){
                ListNodePtr = ListNodePtr.next;
            }
            ListNodePtr.next = insertListNode;
            this.length += 1;
        }
    }

    public void append(T[] elements) {
        if (elements != null) {
            for (T element : elements) {
                append(element);
            }
        }
    }

    public boolean remove(T val){
        ListNode<T> previousListNode = null;
        ListNode<T> ListNodePtr = this.head;
        if(this.head == null || this.length == 0){
            return false;
        }
        while(ListNodePtr != null && ListNodePtr.data.equals(val) == false){
            previousListNode = ListNodePtr;
            ListNodePtr = ListNodePtr.next;
        }
        if(previousListNode == null && this.head.data.equals(val) == true){
            this.head = this.head.next;
            this.length -= 1;
            return true;
        }
        else if(ListNodePtr != null && previousListNode != null  && ListNodePtr.data.equals(val) == true){
            previousListNode.next = ListNodePtr.next;
            this.length -= 1;
            return true;
        }
        return false;
    }

    public boolean remove(List<T> val){
        int counter = 0;
        ListNode<T> tempCurrent = val.head;
        while(tempCurrent != null){
            boolean removed = this.remove(tempCurrent.data);
            if(removed == true){
                counter += 1;
            }
            tempCurrent = tempCurrent.next;
        }
        if(counter >= 1){
            return true;
        }
        return false;
    }

    public boolean contains(T search){
        if(this.head != null){
            ListNode<T> tempListHead = this.head;
            while(tempListHead != null){
                if(tempListHead.data.equals(search) == true){
                    return true;
                }
                tempListHead = tempListHead.next;
            }
        }
        return false;
    }

    public T get(int index) {
        if (index < 0 || index >= length) {
            return -1;
        }
        ListNode<T> current = head;
        for (int counter = 0; counter < index; counter++) {
            current = current.next;
        }
        return current.data;
    }

    public boolean search(T search){
        if(this.head != null){
            ListNode<T> tempListHead = this.head;
            while(tempListHead != null){
                if(tempListHead.data.equals(search) == true){
                    return tempListHead;
                }
                tempListHead = tempListHead.next;
            }
        }
        return null;
    }

    public int Size(){
        return this.length;
    }

    public boolean equals(List<T> other){
        if(this.length != other.length){
            return false;
        }
        ListNode<T> tempCurrent = other.head;
        ListNode<T> tempCurrent2 = this.head;
        while(tempCurrent != null && tempCurrent2 != null){
            if(!this.contains(tempCurrent.data) || !tempCurrent.data.equals(tempCurrent2.data)){
                return false;
            }
            tempCurrent = tempCurrent.next;
            tempCurrent2 = tempCurrent2.next;
        }
        return true;
    }
}