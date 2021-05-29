import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1676 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int a = Integer.parseInt(br.readLine());
            int res = 0;
            for(int i = 5; i<=a ;i*=5){
                res += a / i;
            }

            System.out.println(res);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
