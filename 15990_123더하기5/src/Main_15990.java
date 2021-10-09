import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_15990 {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int t = Integer.parseInt(br.readLine());

            //시간초과 난다 생성시 처음부터 다시구하게 되므로
            long[][] result = new long[100001][4];
            for (int test = 0; test < t; test++) {
                int n = Integer.parseInt(br.readLine());
                int mod = 1000000009;
                //값이 있으면 continue -> 시간초과방지
                if(result[n][1]>0||result[n][2]>0||result[n][3]>0){
                    bw.write(String.valueOf((result[n][1] + result[n][2] + result[n][3]) % mod+"\n"));
                    continue;
                }

                for (int i = 1; i <= n; i++) {
                    if ((i - 1) >= 0 ) {
                        result[i][1] = result[i - 1][2] + result[i - 1][3];
                        if (i == 1) {
                            result[i][1] = 1;
                        }
                    }
                    if ((i - 2) >= 0) {
                        result[i][2] = result[i - 2][1] + result[i - 2][3];
                        if (i == 2) {
                            result[i][2] = 1;
                        }
                    }

                    if ((i - 3) >= 0) {
                        result[i][3] = result[i - 3][1] + result[i - 3][2];
                        if (i == 3) {
                            result[i][3] = 1;
                        }
                    }
                    result[i][1] %= mod;
                    result[i][2] %= mod;
                    result[i][3] %= mod;
                }

                bw.write(String.valueOf((result[n][1] + result[n][2] + result[n][3]) % mod+"\n"));


            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
