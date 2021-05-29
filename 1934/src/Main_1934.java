import java.io.*;
import java.util.StringTokenizer;

public class Main_1934 {
    public static int gcd(int a,int b ){
        if (b == 0){
            return a;
        }else{
            return gcd(b, a % b);
        }
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            String testCaseStr = br.readLine();
            int testCaseCntr = Integer.parseInt(testCaseStr);
            int result=0;
            int a =0;
            int b =0;
            for(int i =0 ; i<testCaseCntr;i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                while(st.hasMoreTokens()){
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    result=(a*b)/gcd(a,b);
                    bw.write(result+"\n");
                }
                bw.flush();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
