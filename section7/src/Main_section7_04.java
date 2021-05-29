public class Main_section7_04 {
    public static int dfs(int n) {
        int result = 0;
        if (a[n] > 0)
            return a[n];
        else if (n <= 0) {
            return n;
        } else {
            a[n] = dfs(n - 1) + dfs(n - 2);
            return a[n];
        }

    }

    static int[] a = new int[46];

    public static void main(String[] args) {

        a[1] = a[2] = 1;
        int n = 45;
        dfs(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
