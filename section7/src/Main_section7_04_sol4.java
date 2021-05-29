public class Main_section7_04_sol4 {
    static int[] fibo;
    public static int dfs(int n) {
        if(fibo[n]>0){
            return fibo[n];
        }
        if(n ==1){
            return fibo[n]=n;
        }else if(n == 2){
            return fibo[2]=1;
        }else{
            return fibo[n]=dfs(n - 2) + dfs(n - 1);
        }
    }

    // D(5) = D(3)+D(4) ->  D(3) = D(1)+D(2) ->  D(4) = D(2)+D(3) -> D(3) = D(1)+D(2)

    public static void main(String[] args) {

        int n = 45;

        fibo = new int[n+1];
        dfs(n);
        for(int i =1 ;i<=n;i++)
            System.out.print(fibo[i]+" ");
    }
}
