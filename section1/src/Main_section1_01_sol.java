import java.util.Locale;
import java.util.Scanner;

public class Main_section1_01_sol {

    public static int solution(String str, char t){
        int answer = 0;
        str=str.toUpperCase(Locale.ROOT);
        t = Character.toUpperCase(t);
/*        for(int i=0 ; i<str.length();i++){
            if(str.charAt(i)==t){
                answer++;
            }
        }*/

        for(char x : str.toCharArray()){
            if(x==t){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        System.out.println(solution(str, c));

    }

}
