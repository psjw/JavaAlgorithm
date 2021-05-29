// Java program to illustrate
// getGenericType() method

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;

import static java.lang.Math.ceil;

public class GFG1 {

    // initialize field
    private static int number;

    public static void main(String[] args)
            throws NoSuchFieldException
    {
        // get Field object
        Field field
                = GFG.class
                .getDeclaredField("number");
        int h = (int)Math.ceil(Math.log(10) / Math.log(2));
        System.out.println("h = " + h);
        // apply getGenericType() method
        Type type = field.getGenericType();
        System.out.println(field.getType());
        System.out.println(Collection.class.isAssignableFrom(field.getType()));
        // print Results
        System.out.println(
                "Type class: "
                        + type.getClass());
        System.out.println(
                "Type name: "
                        + type.getTypeName());
    }
}