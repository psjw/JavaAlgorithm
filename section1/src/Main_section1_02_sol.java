import java.util.Scanner;

public class Main_section1_02_sol {
    public static String solution(String str) {
        String answer = "";
        //65~90
        //97~122
/*        for(char c : str.toCharArray()){
            if(Character.isLowerCase(c)) {
                answer += Character.toUpperCase(c);
            }else{
                answer += Character.toLowerCase(c);
            }
        }*/
        for(char c : str.toCharArray()){
            if(c>=97&& c<=122){
                answer += (char)(c - 32);
            }else{
                answer += (char)(c +32);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        System.out.println(solution(a));

    }
}

