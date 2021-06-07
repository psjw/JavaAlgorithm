import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class Painting {
    private int price;
    private int height;

    public Painting(PaintingBuilder builder) {
        this.price = builder.price;
        this.height = builder.height;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static class PaintingBuilder {
        private int price;
        private int height;

        public int getPrice() {
            return price;
        }

        public PaintingBuilder setPrice(int price) {
            this.price = price;
            return this;
        }

        public int getHeight() {
            return height;
        }

        public PaintingBuilder setHeight(int height) {
            this.height = height;
            return this;
        }

        public Painting build() {
            return new Painting(this);
        }
    }

    @Override
    public String toString() {
        return "Painting{" +
                "price=" + price +
                ", height=" + height +
                '}';
    }
}

public class Main_2515 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            List<Painting> paintings = new ArrayList<>();
            int[] cost = new int[N + 2];
            int[] dd = new int[N + 2];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                paintings.add(new Painting.PaintingBuilder()
                        .setHeight(Integer.parseInt(st.nextToken()))
                        .setPrice(Integer.parseInt(st.nextToken()))
                        .build());
            }

            paintings = paintings.stream()
                    .sorted((painting1, painting2)
                            -> Integer.compare(painting1.getHeight(), painting2.getHeight()))
                    .collect(Collectors.toList());

            cost[0] = paintings.get(0).getPrice();
            int idx = 0;
            int maxCost = 0;
            for (int i = 1; i < N; i++) {
                int nowHeight = paintings.get(i).getHeight();
                while (nowHeight - paintings.get(idx).getHeight() >= S && idx <= i) {
                    if (maxCost < cost[idx]) {
                        maxCost = cost[idx];
                    }
                    idx++;
                }
                cost[i] = maxCost + paintings.get(i).getPrice();
            }

            int result = Arrays.stream(cost).max().getAsInt();
            bw.write(String.valueOf(result));
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

