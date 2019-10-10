import java.util.ArrayList;

public class MinStack{
    private ArrayList<Integer> normal;
    private ArrayList<Integer> min;

    public MinStack(){
        normal=new ArrayList<>();
        min=new ArrayList<>();
    }

    public void push(int x){
        normal.add(x);
        int m;
        if(min.isEmpty()){
            m=x;
        }else if(min.get(min.size()-1)>=x){
            m=x;
        }else{
            m=min.get(min.size()-1);
        }
        min.add(m);
    }
    public void pop(){
        normal.remove(normal.size()-1);
        min.remove(min.size()-1);
    }
    public int top(){
        return normal.get(normal.size()-1);
    }
    public int getMin(){
        return min.get(min.size()-1);
    }
}
