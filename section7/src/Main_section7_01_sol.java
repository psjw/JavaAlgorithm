import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_section7_01_sol {
    //DFS(3) -> DFS(2) -> DFS(1) -> ...
    public static void dfs(int n) {
        if (n == 0) return;
        else {
            //System.out.println(n);  // 1 2 3
            dfs(n - 1);
            System.out.println(n);  // 3 2 1
        }
    }
    //DFS STACK 저장 정보 (매개변수, 지역변수, 복귀주소)
    //PUSH : D(3) - line6  -> D(2) - line6  -> D(1)  - line6  -> D(0)
    //POP : D(0) ->  D(1) -line 7  부터 sysout -> D(2) - line 7 부터 sysout -> D(3) - line 7 부터 sysout  =>  1 2 3

    //PUSH : D(3) -sysout - line6  -> D(2) - sysout - line6  -> D(1)  -sysout  - line6  -> D(0)  => 3 2 1
    //POP : D(0) ->  D(1) -line 7  부터  -> D(2) - line 7 부터  -> D(3) - line 7 부터

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dfs(3);
    }
}
