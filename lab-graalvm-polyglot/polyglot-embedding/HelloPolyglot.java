import org.graalvm.polyglot.*;

public class HelloPolyglot {

    static String JS_CODE = "(function myFun(param){console.log('Hello '+param);})";

    public static void main(String[] args) {
        System.out.println("Hello Java!");
        
        try (Context context = Context.create()) {
            context.eval("js", "print('Console JavaScript!');");

            Value value = context.eval("js", JS_CODE);
            value.execute(args[0]);
        }
    }
}

// javac HelloPolyglot.java
// java HelloPolyglot Diego
