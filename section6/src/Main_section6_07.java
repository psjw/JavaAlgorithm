import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_section6_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Point(x, y));
        }
        Collections.sort(arr);
        for (Point p : arr) System.out.println(p.x + " "+p.y);
    }

}
 class Point implements Comparable<Point> {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        //this(앞) o(뒤) :  -> 정렬 음수값 넘겨줌  this -  o ( 오름차순  10 - 20 = -10) // 내림차순 o - this ( 10- 20 = -10) : 음수값이 리턴되야함 무조건
        if (this.x == o.x) return this.y - o.y;
        else return this.x - o.x;

    }
}


