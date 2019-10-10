import java.util.Stack;

//用栈实现队列
public class MyLinkedListed {
    private Stack<Integer> in;
    private Stack<Integer> out;

    public MyLinkedListed(){
        in=new Stack<>();
        out=new Stack<>();
    }
    public void push(int x){
        in.push(x);
    }
    public int pop(){
        if(out.empty()){
            while(!in.empty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }
    public int peek(){
        if(out.empty()){
            while(!in.empty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    public boolean empty(){
        return in.empty()&&out.empty();
    }
}
