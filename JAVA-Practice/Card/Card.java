//定义牌的一个类
public class Card {
    public int value;//牌面值
    public String color;//花色

    public Card(int value,String color){
        this.value=value;
        this.color=color;
    }

    @Override
    public boolean equals(Object obj) {
       if(obj==null){
           return false;
       }
       if(!(obj instanceof Card)){
           return false;
       }
       if(obj==this){
           return true;
       }
       Card c=(Card)obj;
       return value==c.value&&color.equals(c.color);
    }

    @Override
    public String toString() {
        String v;
        if(value==1){
            v="A";
        }else if(value==11){
            v="J";
        }else if(value==12){
            v="Q";
        }else if(value==13){
            v="K";
        } else{
            v=String.valueOf(value);//把Int类型的值变为String类型
        }
        return String.format("[%s %s]",color,v);
    }


}
