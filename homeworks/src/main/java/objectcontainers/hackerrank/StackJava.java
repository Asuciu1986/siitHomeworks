package objectcontainers.hackerrank;

import java.util.Scanner;
import java.util.Stack;

public class StackJava {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(isBalanced(sc.next()));
        }
        sc.close();
    }

    static boolean isBalanced(String stringParanteze) {
        Stack<Character> stackParanteze = new Stack<Character>();
        for (int i = 0; i < stringParanteze.length(); i++) {
            char start = stringParanteze.charAt(i);
            if (start == '(' || start == '[' || start == '{') {
                stackParanteze.push(start);
            } else if (stackParanteze.empty()) {
                return false;
            } else {
                char end = stackParanteze.pop();
                if ((end == '(' && start != ')') || (end == '[' && start != ']')
                        || (end == '{' && start != '}')) {
                    return false;
                }
            }
        }
        return stackParanteze.empty();
    }
}
