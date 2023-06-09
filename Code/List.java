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

        public ListNode(ListNode<T> other) {
            this.data = other.data;
            if(other.next != null) {
                this.next = new ListNode<>(other.next);
            }
        }

        public T getData() {
            return data;
        }

        public ListNode<T> getNext() {
            return next;
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
        if(elements != null && elements.length > 0){
            this.append(elements);
        }
    }

    public List(List<T> other) {
        this.length = 0;
        this.head = null;
        if(other != null && other.head != null) {
            this.head = new ListNode<>(other.head);
            this.length = other.length;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Object[] toArray() {
        Object[] array = new Object[length];
        ListNode<T> tempListNode = head;
        int index = 0;
        while(tempListNode != null) {
            array[index] = tempListNode.data;
            tempListNode = tempListNode.next;
            index++;
        }
        return array;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode<T> tempListNode = head;
        while(tempListNode != null) {
            sb.append(tempListNode.data);
            if(tempListNode.next != null) {
                sb.append(",");
            }
            tempListNode = tempListNode.next;
        }
        return sb.toString();
    }

    public void append(T val) {
        ListNode<T> insertListNode = new ListNode<>(val);
        if(head == null) {
            head = insertListNode;
        } else {
            ListNode<T> lastNode = getNodeAt(length - 1);
            lastNode.next = insertListNode;
        }
        length++;
    }

    public void append(T[] elements) {
        if(elements != null) {
            for(T element : elements) {
                append(element);
            }
        }
    }

    public T pop() {
        if(isEmpty() == false) {
            T data = head.getData();
            head = head.getNext();
            return data;
        }
        return null;
    }

    public boolean remove(T val) {
        if(head == null) {
            return false;
        }
        if(head.data.equals(val)) {
            head = head.next;
            length--;
            return true;
        }
        ListNode<T> prevNode = head;
        ListNode<T> currNode = head.next;
        while(currNode != null) {
            if(currNode.data.equals(val)) {
                prevNode.next = currNode.next;
                length--;
                return true;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        return false;
    }

    public boolean remove(List<T> val) {
        boolean removed = false;
        ListNode<T> tempCurrent = val.head;
        while(tempCurrent != null) {
            if(remove(tempCurrent.data)) {
                removed = true;
            }
            tempCurrent = tempCurrent.next;
        }
        return removed;
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
        if(index < 0 || index >= length) {
            return null;
        }
        ListNode<T> currentNode = head;
        for(int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    public ListNode<T> getNodeAt(int index) {
        if(index < 0 || index >= length) {
            return null;
        }
        ListNode<T> currentNode = head;
        for(int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public ListNode<T> search(T search){
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

    public int size(){
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
