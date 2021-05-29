/*
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Result {

    */
/*
     * Complete the 'solution' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     *//*



    public static List<String> solution(List<List<String>> arr) {
        HashMap<String, Long> hashMap = new HashMap<>();
        String name = "";
        String borrowName = "";
        long point = 0;
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            int len = arr.get(i).size();
            for (int j = 0; j < len; j++) {
                if (j == 0) {
                    borrowName = arr.get(i).get(j);
                } else if (j == 1) {
                    name = arr.get(i).get(j);
                } else {
                    if(name.equals(borrowName)){
                        continue;
                    }
                    point = Long.parseLong(arr.get(i).get(j));
                    hashMap.put(borrowName, hashMap.getOrDefault(borrowName, 0L) - point);
                    hashMap.put(name, hashMap.getOrDefault(name, 0L) + point);
                }
            }
        }
        System.out.println(hashMap);

        List<String> mapKeyList = hashMap.keySet().stream().collect(Collectors.toList());
        for (String key : mapKeyList) {
            if (hashMap.get(key) < 0)
                answer.add(key);
        }
        if (answer.size() == 0) {
            answer.add("None");
        }


        return answer.stream().sorted().collect(Collectors.toList());
    }

}

public class Main_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int arrRows = Integer.parseInt(bufferedReader.readLine().trim());
            int arrColumns = Integer.parseInt(bufferedReader.readLine().trim());
            List<List<String>> arr = new ArrayList<>();

            for (int i = 0; i < arrRows; i++) {
                arr.add(Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")));
            }

            List<String> result = Result.solution(arr);

            for (int i = 0; i < result.size(); i++) {
                bufferedWriter.write(result.get(i));

                if (i != result.size() - 1) {
                    bufferedWriter.write("\n");
                }
            }
            bufferedWriter.newLine();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        bufferedReader.close();
        bufferedWriter.close();
    }
}
*/
