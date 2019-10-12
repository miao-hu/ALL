import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<String> stack=new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        System.out.println(stack.empty());
        System.out.println(stack.peek()); //弹出栈顶元素不移除
        System.out.println(stack.pop()); //移除栈顶元素
        System.out.println(stack.search("B"));  //2
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());

    }
}
