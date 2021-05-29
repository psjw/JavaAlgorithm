import java.io.*;
import java.util.StringTokenizer;

public class Main_1929 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = 0;
            int b = 0;
            int prime[];
            int index = 0;
            boolean check[];
            while (st.hasMoreTokens()) {
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                check = new boolean[b+1];
                prime = new int[b + 1];
                for(int i =2 ;i<=b;i++){
                    if(check[i])
                        continue;
                    if(i >=a ){
                        prime[index] = i;
                        index++;
                    }
                    for (int j = i*2;j<=b;j+=i){
                        check[j] = true;
                    }
                }
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                for( int k=0; k< index;k++)
                    bw.write(prime[k]+"\n");
                bw.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

