import java.util.ArrayList;
import java.util.Scanner;

public class Main_section1_04_sol2 {
    public static ArrayList<String> solution(int n,String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for(String x : str){
            char[] s = x.toCharArray();
            int lt = 0; //단어의 시작 문자
            int rt = x.length() - 1;//단어의 맨끝문자
            while(lt<rt){
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }
        return answer;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        String[] str = new String[n];
        for(int i=0;i<n;i++){
            str[i] = sc.next();
        }

        for (String x : solution(n,str)){
            System.out.println(x);
        }

    }
}
