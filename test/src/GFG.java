// Java program to illustrate
// getModifiers () method

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;

public class GFG {

    // initialize field
    public final int number=1;

    public static void main(String[] args)
            throws NoSuchFieldException
    {

        // get Field object
        Field field
                = GFG.class
                .getDeclaredField("number");

        // apply getModifiers() method
        int modifiers
                = field.getModifiers();
        System.out.println(Modifier.FINAL);
        System.out.println(modifiers);
        System.out.println((modifiers&0x08)==0x08);
        System.out.println(field.getType());
        System.out.println(Collection.class.isAssignableFrom( GFG.class));

        // print the results
        System.out.println(
                Modifier
                        .toString(modifiers));
    }
}