import java.util.Arrays;

public class Main2 {
/*
r : 뽑고자 하는 개수
temp : r개를 뽑는 결과값을 저장해놓는 배열
current : 현재 개수를 저장해 놓는 값
visited : 방문 여부를 확인하는 배열
 */
    /*
    r : 뽑고자 하는 개수
temp : r개를 뽑는 결과값을 저장해놓는 배열
current : 현재 개수를 저장해 놓는 값
start : 그다음 반복문을 시작하는 값
     */
    private static void makeOverlabPermutation(int r, int[] temp, int current) {
        if (r == current) {
            System.out.println(Arrays.toString(temp));
        } else {
            for (int i = 0; i < arr.length; i++) {
                temp[current] = arr[i];
                makeOverlabPermutation(r, temp, current + 1);
            }
        }
    }

    private static void makePermutation(int r, int[] temp, int current, boolean[] visited) {
        if (r == current) {
            System.out.println(Arrays.toString(temp));
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    temp[current] = arr[i];
                    makePermutation(r, temp, current +1, visited);
                    visited[i] = false;
                }
            }
        }
    }

    static int[] arr = {4, 7, -2, -8, 3};
    static int[] temp = new int[4];
    public static void main(String[] args) {
        makeOverlabPermutation(4, temp, 0);

    }
}
