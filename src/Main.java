import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static final String TAG = "Main";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        System.out.println(isValid(a));
    }

    /**
     * Parentheses
     * @param s
     * @return
     */
    public static boolean isValid (String s) {
        final char L_PAREN = '(';
        final char R_PAREN = ')';
        final char L_BRACE = '{';
        final char R_BRACE = '}';
        final char L_BRACKET = '[';
        final char R_BRACKET = ']';

        Stack<Character> stack = new Stack<>();

        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case L_PAREN:
                    stack.push(L_PAREN);
                    break;
                case L_BRACE:
                    stack.push(L_BRACE);
                    break;
                case L_BRACKET:
                    stack.push(L_BRACKET);
                    break;
                case R_PAREN:
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != L_PAREN) return false;
                    break;
                case R_BRACE:
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != L_BRACE) return false;
                    break;
                case R_BRACKET:
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != L_BRACKET) return false;
                    break;
            }
        }

        return stack.isEmpty();
    }


    /**
     * Reverse String only character, not a letter stay in the same place
     * @param s
     * @return
     */
    public static String solution (String s) {
        String result=s;
        int b = s.length()-1;
        for (int i=0; i<s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                while (b>0) {
                    if (Character.isLetter(s.charAt(b))) {
                        break;
                    }
                    if (b>0) b--;
                }
                StringBuilder sb = new StringBuilder(result);
                sb.setCharAt(b,s.charAt(i));
                if (b>0) b--;
                result=sb.toString();
            }
        }
        return result;
    }

    /**
     * Baseball game point
     * @param ops
     * @return
     */
    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int totalScore = 0;
        for (String op : ops) {
            if (op.equals("D")) {
                int newScore = 2 * stack.peek(); // peek looks at the top element of the stack without removing it
                totalScore += newScore;
                stack.push(newScore); //insert an element onto the top of the stack
            } else if (op.equals("C")) {
                totalScore -= stack.pop(); //pop remove the top of element and return the value
            } else if (op.equals("+")) {
                int scoreTwo = stack.pop(); //remove top element
                int newScore = scoreTwo + stack.peek();
                stack.push(scoreTwo);
                stack.push(newScore);
                totalScore += newScore;
            } else {
                stack.push(Integer.parseInt(op));
                totalScore += Integer.parseInt(op);
            }
        }
        return totalScore;
    }

    /**
     * Factorial check
     * @param N
     * @return
     */
    @Deprecated
    public static int factorial(int N) {
        // Your code starts here.
        int fact=1;
        for (int i=1; i<=N; i++) {
            fact=fact*i;
        }
        return fact;
    }

    /**
     * Prime Number
     * @param x
     * @return
     */
    public static boolean isPrime(int x) {
        if(x<=1) {
            return false;
        }
        for(int i=2;i<=x/2;i++) {
            if((x%i)==0) return false;
        }
        return true;
    }

    /**
     * Reverse integer digits
     * @param x
     * @return
     */
    public static int reverseDigits(int x) {
        int num = x, reversed = 0;
        while(num != 0) {
            // get last digit from num
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            // remove the last digit from num
            num /= 10;
        }
        return reversed;
    }
}