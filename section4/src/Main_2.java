/*

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Item {
    String name;
    int relation;
    int price;

    public Item(String name, int relation, int price) {
        this.name = name;
        this.relation = relation;
        this.price = price;
    }
    public int relationDiff(final Item otherItem)
    { return this.relation - otherItem.relation; }


    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", relation=" + relation +
                ", price=" + price +
                '}';
    }
}

class Result {


    */
/*
     * Complete the 'solution' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     *//*



    public static List<String> solution(List<List<String>> items, int orderBy, int orderDirection, int pageSize, int pageNumber) {
        // Write your code here
        List<Item> tempItemList = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        items.forEach(item -> {
            Item nItem = new Item(item.get(0), Integer.parseInt(item.get(1)), Integer.parseInt(item.get(2)));
            tempItemList.add(nItem);
        });

        if (orderDirection == 1&& orderBy==1) {
            tempItemList.stream().sorted(
                    (item1, item2)->  item2.relation - item1.relation).sorted((item1, item2) -> item1.name.compareTo(item2.name)).skip((pageNumber + 1) * (pageSize - 1)).limit((pageNumber + 1) * pageSize).forEach(
                    item -> answer.add(item.name)
            );
        }else if(orderDirection == 1&& orderBy==2) {
            tempItemList.stream().sorted(
                    (item1, item2)->  item2.price - item1.price).sorted((item1, item2) -> item1.name.compareTo(item2.name)).skip((pageNumber + 1) * (pageSize - 1)).limit((pageNumber + 1) * pageSize).forEach(
                    item -> answer.add(item.name)
            );
        }else if (orderDirection == 0&& orderBy==1){
            tempItemList.stream().sorted(
                    (item1, item2)->  item1.relation - item2.relation).sorted((item1, item2) -> item1.name.compareTo(item2.name)).skip((pageNumber + 1) * (pageSize - 1)).limit((pageNumber + 1) * pageSize).forEach(
                    item -> answer.add(item.name)
            );
        }else {
            tempItemList.stream().sorted(
                    (item1, item2)->  item1.price - item2.price).sorted((item1, item2) -> item1.name.compareTo(item2.name)).skip((pageNumber + 1) * (pageSize - 1)).limit((pageNumber + 1) * pageSize).forEach(
                    item -> answer.add(item.name)
            );
        }
        return answer;
    }
}


public class Main_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int itemsRows = Integer.parseInt(bufferedReader.readLine().trim());
            int itemsColumns = Integer.parseInt(bufferedReader.readLine().trim());

            List<List<String>> items = new ArrayList<>();

            IntStream.range(0, itemsRows).forEach(i -> {
                try {
                    items.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                    .collect(toList())
                    );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            int orderBy = Integer.parseInt(bufferedReader.readLine().trim());

            int orderDirection = Integer.parseInt(bufferedReader.readLine().trim());

            int pageSize = Integer.parseInt(bufferedReader.readLine().trim());

            int pageNumber = Integer.parseInt(bufferedReader.readLine().trim());

            List<String> result = Result.solution(items, orderBy, orderDirection, pageSize, pageNumber);

            bufferedWriter.write(
                    result.stream()
                            .collect(joining("\n"))
                            + "\n"
            );

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
