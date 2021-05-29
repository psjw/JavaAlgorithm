import java.util.LinkedList;
import java.util.Queue;

class Node3 {
    int data;
    Node3 lt, rt;

    public Node3(int val) {
        this.data = val;
    }
}

public class Main_section7_10 {
    //bfs는 자식이 하나여도 상관없다.
    public static int bfs(Node3 root) {
        Queue<Node3> q = new LinkedList<>();
        q.offer(root);
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node3 cur = q.poll();
                if(cur.lt==null&&cur.rt==null){
                    return L;
                }
                if(cur.lt !=null){
                    q.offer(cur.lt);
                }
                if(cur.rt!=null){
                    q.offer(cur.rt);
                }
            }
            L++;
        }
        return L;
    }

    static Node3 root;

    public static void main(String[] args) {
        root = new Node3(1);
        root.lt = new Node3(2);
        root.rt = new Node3(3);
        root.lt.lt = new Node3(4);
        root.lt.rt = new Node3(5);
        int L = 0;
        System.out.println(bfs(root));
    }
}
