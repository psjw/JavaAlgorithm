import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

public class Main_section4_02 {
    public static String solution(String str1, String str2) {
        String answer = "YES";
        HashMap<Character,Integer> str1Map = new HashMap();
        HashMap<Character,Integer> str2Map = new HashMap();
        for(int i=0; i< str1.length();i++){
            str1Map.put(str1.charAt(i),str1Map.getOrDefault(str1.charAt(i),0)+1);
        }

        for(int i=0; i< str2.length();i++){
            str2Map.put(str2.charAt(i),str2Map.getOrDefault(str2.charAt(i),0)+1);
        }

//        System.out.println(str1Map);
//        System.out.println(str2Map);
        if(str1Map.size() ==str2Map.size()){
            Iterator<Character> it = str1Map.keySet().iterator();
            while(it.hasNext()){
                char key = it.next();
                if (str1Map.get(key) != str2Map.get(key)) {
                    answer = "NO";
                    break;
                }
            }
        }else{
            answer = "NO";
        }
        return answer;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String str1 = br.readLine();
            String str2 = br.readLine();
            System.out.println(solution(str1,str2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
