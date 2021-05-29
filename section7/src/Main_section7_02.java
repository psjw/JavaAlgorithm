public class Main_section7_02 {
    public static void dfs(int a){
        if(a == 1 || a==0 ){
            System.out.print(a);
            return;
        }
        else{
            dfs(a / 2);
            System.out.print(a%2);

        }
    }

    public static void main(String[] args) {
        dfs(11);
    }
}
