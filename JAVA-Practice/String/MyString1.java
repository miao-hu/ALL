import java.util.Arrays;

//模拟String类

//MyString类不可以被继承
public final class MyString1 {
    private final char[] value;  //不可变量，每次用的时候再复制一份即可

    public MyString(char[] value){
        this.value=Arrays.copyOf(value,value.length);
    }

    public MyString(char[] value, int offset, int count){
        this.value=Arrays.copyOfRange(value,offset,offset+count);
    }

    public char charAt(int index){
        return value[index];
    }

    public char[] toCharArray(){
        return Arrays.copyOf(value,value.length);
    }

    public MyString toUpperCase(){
        char[] value=toCharArray();//再复制一份
        for(int i=0;i<value.length;i++){
            if(Character.isLowerCase(value[i])){
                Character.toUpperCase(value[i]);
            }
        }
        return new MyString(value);
    }

    public boolean equalsIgnoreCase(MyString o){
        if(o==null)return false;
        if(value.length!=o.value.length)return false;
        for(int i=0;i<value.length;i++){
            char a=Character.toUpperCase(value[i]);
            char b=Character.toUpperCase(o.value[i]);
            if(a!=b){
                return false;
            }
        }
        return true;
    }

    // String s = "hello";
    // String t = "world";
    // String o = s + t;    s.concat(t);
    public MyString concat(MyString o){
        char[] v=new char[value.length+o.value.length];
        System.arraycopy(value,0,v,0,value.length);
        System.arraycopy(o.value,0,v,value.length,o.value.length);
        return new MyString(v);
    }
}
