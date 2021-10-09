package linkedlist;

public class SingleLinkedList<T> {
    public Node<T> head = null;

    public class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (head == null) { //첫 노드
            head = new Node<T>(data);
        } else {
            Node<T> node = this.head; //주소값
            while (node.next != null) { //맨마지막 노드로 이동
                node = node.next;
            }
            node.next = new Node<T>(data); //새로운 노드 연결
        }
    }

    //public으로 변경 필요
    protected void printALl() {
        if (head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public Node<T> search(T data) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == data) {
                    return node;
                } else {
                    node = node.next;
                }
            }
        }
        return null;
    }

    public boolean delNode(T isData){
        if(this.head == null){
            return false;
        }else{
            Node<T> node = this.head;
            if(node.data == isData){
                this.head = this.head.next;
                return true;
            }else{
                while(node.next!=null){
                    if(node.next.data == isData){
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                return false;
            }
        }
    }



    public void addNodeInside(T data, T isData) {
        Node<T> searchedNode = this.search(isData);

        if (searchedNode == null) {
            this.addNode(data);
        } else {
            Node<T> nextNode = searchedNode.next;
            searchedNode.next = new Node<T>(data);
            searchedNode.next.next = nextNode; //원래 가리키던 기존노드로 세팅
        }
    }


}
