import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char [] input = scanner.nextLine().toCharArray();
        Deque <Character> stack = new ArrayDeque<>();
        //boolean isBalanced=true;
        for (char c :input) {
            if (c=='(' || c=='[' || c=='{') {
                stack.push(c);
            } else if (c==')'&& !stack.isEmpty() && stack.pop()=='('){
                continue;
            } else if (c==']'&& stack.size()>0 && stack.pop()=='['){
                continue;
            } else if (c=='}'&& stack.size()>0 && stack.pop()=='{'){
                continue;
            } else {
                System.out.println("NO");
                return;
            }
        } System.out.println("YES");
    }
}
