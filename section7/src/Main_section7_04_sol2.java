public class Main_section7_04_sol2 {
    public static int dfs(int n) {
        if(n ==1){
            return n;
        }else if(n == 2){
            return 1;
        }else{
            return dfs(n - 2) + dfs(n - 1);
        }
    }

    // D(5) = D(3)+D(4) ->  D(3) = D(1)+D(2) ->  D(4) = D(2)+D(3) -> D(3) = D(1)+D(2)

    public static void main(String[] args) {

        int n = 45;
        for(int i =1 ;i<=n;i++)
            System.out.print(dfs(i)+" ");
    }
}