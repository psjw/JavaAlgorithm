import java.util.LinkedList;
import java.util.Queue;

class Node1 {
    int data;
    Node1 lt, rt;

    public Node1(int val) {
        this.data = val;
        lt = rt = null;
    }
}

public class Main_section7_07 {
    private static Node1 root1;

    public static void bfs1(Node1 root) {
        Queue<Node1> q = new LinkedList<>();
        q.offer(root1);
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            System.out.print(L + " : ");
            for (int i = 0; i < len; i++) {
                Node1 current = q.poll();
                System.out.print(current.data + " ");
                if(current.lt!=null){
                    q.offer(current.lt);
                }
                if(current.rt!=null){
                    q.offer(current.rt);
                }
            }
            L++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        root1 = new Node1(1);
        root1.lt = new Node1(2);
        root1.rt = new Node1(3);
        root1.lt.lt = new Node1(4);
        root1.lt.rt = new Node1(5);
        root1.rt.lt = new Node1(6);
        root1.rt.rt = new Node1(7);
        bfs1(root1);
    }
}
