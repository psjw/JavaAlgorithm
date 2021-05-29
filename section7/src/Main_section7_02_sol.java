public class Main_section7_02_sol {
    public static void dfs(int a) {
        if (a == 0) {
            return;
        } else {
            dfs(a / 2);
            System.out.print(a % 2);
        }
    }

    public static void main(String[] args) {
        dfs(11);
    }
}
