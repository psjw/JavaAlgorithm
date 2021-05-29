class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        this.data = val;
        lt=rt = null;
    }
}


public class Main_section7_05 {
//                    1
//                2       3
//            4     5  6     7
// 전위 순회 출력 : 1 2 4 5 3 6 7 (부모 -> 왼쪽 -> 오른쪽)
// 중위 순회 출력 : 4 2 5 1 6 3 7 (왼쪽 -> 부모 -> 오른쪽)
// 후위 순회 출력 : 4 5 2 6 7 3 1 (왼쪽 -> 오른쪽 -> 부모) -> 병합정렬

    static Node root;
    public static void DFS(Node root){
        if(root == null){ //말단
            return;
        }else{
            //System.out.print(root.data + " "); //전위 순회
            DFS(root.lt);
            //System.out.print(root.data + " "); //중위 순회
            DFS(root.rt);
            //System.out.print(root.data + " "); //후위 순회
        }
    }
    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        DFS(root);
    }
}
