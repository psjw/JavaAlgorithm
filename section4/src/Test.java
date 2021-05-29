import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Xc");
        list.add("Xa");

        System.out.println(list);
        List<String> mapKeyList = list.stream().sorted().collect(Collectors.toList());
        System.out.println(mapKeyList);
    }
}
