import java.lang.reflect.Modifier;

public class Test {


    public static void main(String[] args) {
        int t = Modifier.methodModifiers();
        System.out.println(t);
        //이런 식으로4번 째 비트가 1인지 아닌지를
        // skip private static final field (META_INFO)
//        private static final int FIELD_MODIFIERS =
//                Modifier.PUBLIC         | Modifier.PROTECTED    | Modifier.PRIVATE |
//                        Modifier.STATIC         | Modifier.FINAL        | Modifier.TRANSIENT |
//                        Modifier.VOLATILE;
        System.out.println((t&0x08)==0x08);// static
    }
}
