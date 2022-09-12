package lab;

import datastr.ARI;
import datastr.ArrayStack;

import java.lang.reflect.AnnotatedParameterizedType;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nstr  -> Default string." +
                "\nzero -> Index 0 of default string." +
                "\nsubZ -> SubString the index 0." +
                "\nrev  -> Reversed string.\n");
        ArrayStack stack = new ArrayStack();
        System.out.println("Result : "+reverse("12345", stack));

    }

    static String reverse(String str, ArrayStack stack){

        if (str.isEmpty()){
            return "";
        }

        String s = String.format("Call reverse(\"%s\")",str);
        System.out.println(s);
        System.out.println("=== BOTTOM OF STACK ===");

        String subZero, zero, rev="", result;
        zero = String.valueOf(str.charAt(0));
        subZero = str.substring(1);

//        4 parameters -> default_str , index_zero , subString_zero , reversed_String
        ARI e = new ARI(str, zero, subZero, rev);
        stack.push(e);
        System.out.println(stack);

//        recursive call
        result = reverse(subZero, stack) + zero;

//        set Reversed String to rev -> stack.pop() -> return String
        e.setRev(result);
        String return_s = String.format("Return from reverse(\"%s\")",str);
        System.out.println(return_s);
        System.out.println("=== BOTTOM OF STACK ===");
        System.out.println(stack);
        stack.pop();
        return result;
    }
}