import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_11052 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            String[] cardArr = br.readLine().split(" ");
            int[] p = new int[cardArr.length + 1];
            for (int i = 0; i < cardArr.length; i++) {
                p[i + 1] = Integer.parseInt(cardArr[i]);
            }
            int[] cardPackArr = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= i; j++) {
                    cardPackArr[i] = Math.max(cardPackArr[i], p[j] + cardPackArr[i - j]);
                }
            }
            bw.write(String.valueOf(cardPackArr[N]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
