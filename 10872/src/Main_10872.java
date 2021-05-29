import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10872 {
    public static int factorial(int a){
        if(a == 0 ){
            return  1;
        }else{
            return a * factorial(a - 1);
        }

    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int a = Integer.parseInt(br.readLine());
            System.out.println(factorial(a));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
