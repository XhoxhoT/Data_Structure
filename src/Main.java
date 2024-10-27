import java.net.StandardSocketOptions;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static String reverseString(String reverse){

        // ideja asht qe stringen ta copezojme dhe ta fusim karakter pas karakteri ne stack, mrapa te bajm stack
        //pop up dhe karakteret ti bashkangjisim ne nje string tjt

        String temp = "";
        Stack<Character>myStack = new Stack<>();

       for(char c : reverse.toCharArray()){
           myStack.push(c);
       }

        while(!myStack.isEmpty()){
            temp+=myStack.pop();
        }
        return temp;
    }


    public static boolean isBalancedParentheses(String parentheses){

        Stack<Character>stack = new Stack<>();

        for(char p : parentheses.toCharArray()){

            if(p == '(')
                stack.push(p);
            else if (p == ')'){
                if(stack.isEmpty() || stack.pop() != '(')
                    return false;
            }

        }
        return stack.isEmpty();
    }

    public static void sortStack(Stack<Integer> stack){

        Stack<Integer> myStack = new Stack<>();

        while(!stack.isEmpty()){

            int tmp=stack.pop();

            while(!myStack.isEmpty() && myStack.peek() > tmp){
                stack.push(myStack.pop());
            }
            myStack.push(tmp);
        }

        while(!myStack.isEmpty()){
            stack.push(myStack.pop());
        }

    }

    public static void main(String[] args) {


    }
}