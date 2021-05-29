public class Main_section7_06 {
    static int n;
    static int[] ch;

    public static void dfs(int L) {
        if (L == n + 1) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1)
                    tmp += (i + " ");
            }
            if(tmp.length()>0) System.out.println(tmp);
            return;
        } else {
            ch[L] = 1;
            dfs(L + 1); //왼쪽
            ch[L] = 0;
            dfs(L + 1);//오른쪽
        }

    }

    //원소가 n개인 부분집합의 개수는 2^n
    // D(1) -> 사용한다 , 사용하지 않는다.
    // D(1) 사용한다 -> D(2) -> 사용한다. 사용하지 않는다.
    // D(1) 사용한다 -> D(2)  사용한다 ->D(3) 사용한다., 사용하지 지 않는다.
    //  L(레벨)  == n+1  종료
    public static void main(String[] args) {
        n = 3;
        ch = new int[n + 1];
        dfs(1);
    }
}
