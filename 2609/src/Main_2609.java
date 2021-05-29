import java.io.*;
public class Main_2609 {
    public static void main(String[] args) {
        //최대 공약수 * 최소공배수 =  a * b
        //최대 공약수 GCD(a,b)  -> a%b = r  -> GCD(b,r)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] temp=br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            int m = a * b;
            int c=0;
            while(b>0){
                c =a%b;
                a=b;
                b=c;
            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(a+"\n");
            bw.write(m/a+"");
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
