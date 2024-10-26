package Stack;

public class MainStack {

    public static void main(String[] args){

        Stack myStack = new Stack(3);
        myStack.getHeight();
        myStack.getTop();
        myStack.printStack();

        myStack.push(10);
        System.out.println(
        );
        myStack.printStack();
    }
}
