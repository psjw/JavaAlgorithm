public class Main_section7_03 {

    public static int dfs(int a){
        if(a == 1){
            return a;
        }else{
            return a * dfs(a - 1);
        }
    }
    //DFS(5) = 5*DFS(4)  -> DFS(4) = 4*DFS(3) -> 3*DFS(2) ->DFS(2) = 2*DFS(1) -> DFS(1)=1
    public static void main(String[] args) {
        System.out.println(dfs(5));
    }
}
