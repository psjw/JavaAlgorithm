import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_section1_03 {
    public static String solution(String str){
        StringTokenizer st = new StringTokenizer(str);
        String result = "";
        String temp = "";
        while(st.hasMoreTokens()){
           temp = st.nextToken();
           if(temp.length()>result.length()){
               result = temp;
           }
        }
        return result;
    }

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println(solution(br.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ;
    }
}
