import java.io.*;

public class Main2 {
    static String result = "";
    static void update(int[] tree, int node, int start, int end, int index, int value) {
        if (index>=start||end>=index) {
            if (start == end){
                tree[node] = value;
            }else{
                int mid = (start + end) / 2;
                int nextNode = node * 2;
                update(tree, nextNode, start, mid, index, value);
                update(tree, nextNode + 1, mid + 1, end, index, value);
            }
        }
    }
    static void init(int[] a, int[] tree, int node, int start, int end) {
        if (start == end) {
            tree[node] = a[start];
        } else {
            int mid = (start + end) / 2;
            int nextNode = node * 2;

            init(a, tree, nextNode, start, mid);
            init(a, tree, nextNode + 1, mid + 1, end);
            tree[node] = tree[nextNode]*tree[nextNode + 1];
        }
    }

    static int query(int[] tree, int node, int start, int end, int i, int j) {
        if (i > end || j < start) return -1;
        if (i <= start && end <= j) return tree[node];
        int mid = (start + end) / 2;
        int nextNode = node * 2;
        int m1 = query(tree, nextNode, start, mid, i, j);
        int m2 = query(tree, nextNode+ 1, mid + 1, end, i, j);
        return m1*m2;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[] a = new int[n];
        String temp = bf.readLine();
        String[] tempArr = temp.split(" ");
        for (int i = 0; i < tempArr.length; i++) {
            a[i] = Integer.parseInt(tempArr[i]);
        }
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        int tree_size = (1 << (h + 1));
        int[] tree = new int[tree_size];
        init(a,tree,1,0,n-1);
        for(int i =0;i<m;i++){
            temp = bf.readLine();
            tempArr = temp.split(" ");
            if(tempArr[0].equals("C")){
                System.out.println(tempArr[1]+" up/ "+tempArr[2]);
                update(tree,1, 0, n - 1, Integer.parseInt(tempArr[1]), Integer.parseInt(tempArr[2]));
            }else{
                System.out.println(tempArr[1]+" qu/ "+tempArr[2]);
                int result=query(tree, 1, 0, n - 1, Integer.parseInt(tempArr[1]), Integer.parseInt(tempArr[2]));
                System.out.println(result);
            }
        }

//        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
//        int tree_size = (1 << (h + 1));
//        int[] tree = new int[tree_size];
//        init(a, tree, 1, 0, n - 1);
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        for (int i = m - 1; i < n - m + 1; i++) {
//            int start = i - m + 1;
//            int end = i + m - 1;
//            bw.write(query(tree, 1, 0, n - 1, start, end) + " ");
//        }
//        bw.flush();
    }
}
