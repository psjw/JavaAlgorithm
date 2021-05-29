import java.io.*;

public class Main_10430 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            int c = Integer.parseInt(temp[2]);
            
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(String.valueOf(((a+b)%c))+"\n");
            bw.write(String.valueOf(((a%c)+(b%c))%c)+"\n");
            bw.write(String.valueOf((a*b)%c)+"\n");
            bw.write(String.valueOf(((a%c)*(b%c))%c));
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
