class Node2 {
    int data;
    Node2 lt, rt;

    public Node2(int val) {
        this.data = val;
        lt = rt = null;
    }
}
public class Main_section7_09 {


    //dfs 사용시 자식이 있으면 정확하게 자식이 2진트리로 2개 있어야 된다.
    //만약 자식이 1개 이면 에러
    public static int dfs(int L,Node2 root) {
        if(root.lt ==null && root.rt == null){
            return L;
        }else{
            return Math.min(dfs(L + 1, root.lt), dfs(L + 1, root.rt));
        }
    }
    //최단거리
    //          1
    //      2       3
    //  4       5
    //D(0,1) -> D(1,2) -> D(2,4) return 2 -> D(2,5)  return 2 -> D(1,2) min(2,2)=2 -> D(0,1) -> D(1,3) return 1 -> D(0,1) min(2,1) = 1
    static Node2 root;
    public static void main(String[] args) {
        root = new Node2(1);
        root.lt = new Node2(2);
        root.rt = new Node2(3);
        root.lt.lt = new Node2(4);
        root.lt.rt = new Node2(5);
        int L = 0;
        System.out.println(dfs(0,root));
    }
}
