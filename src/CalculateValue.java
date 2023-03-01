import java.util.Stack;

public class CalculateValue {
    Stack<Character> expressionStack = new Stack<>();

    char operator;
    public void calculate(char[] exp) {
        int result = 0;
        for (char i : exp) {
            if (i != ')' && i != '}' && i != ']') {
//                System.out.println(i);
                expressionStack.push(i);
            } else {
                int num2 = Integer.parseInt(String.valueOf(expressionStack.pop()));
//                System.out.println(num2);
                operator = expressionStack.pop();
//                System.out.println(operator);
                int num1 = Integer.parseInt(String.valueOf(expressionStack.pop()));
                expressionStack.pop();
                switch(operator){
                    case '+':{
                        result = num1+num2;
                        System.out.println(result);
                        break;
                    }
                    case '-':{
                        result = num1-num2;
                        System.out.println(result);
                        break;
                    }
                    case '*':{
                        result = num1*num2;
                        System.out.println(result);
                        break;
                    }
                    default:
                        System.out.println("Invalid");
                }
                expressionStack.push(String.valueOf(result).charAt(0));
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        String expression = "[8-{1+(1*1)}]";
        char[] exp = expression.toCharArray();
        CalculateValue cv = new CalculateValue();
        cv.calculate(exp);

    }
}