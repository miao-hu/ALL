public class StringBuliderDemo {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        sb.append(1);
        sb.append('c');     //append()添加
        sb.append(5.6);
        sb.append(true);
        sb.append("hello");
        System.out.println(sb.toString());//1c5.6truehello
        String t=sb.toString();
        System.out.println(t);  //1c5.6truehello

        //String ss=sb.reverse();这句话是错的，一个是String类型，一个是StringBuilder类型

        sb.reverse();       //StringBuilder字符串可变性
        System.out.println(sb.toString());  //olleheurt6.5c1

        sb.replace(1,3,"AA");
        System.out.println(sb.toString());  //oAAeheurt6.5c1

        sb.replace(1,3,"BBB");
        System.out.println(sb.toString());  //oBBBeheurt6.5c1

        sb.replace(1,3,"BBBB");
        System.out.println(sb.toString());  //oBBBBBeheurt6.5c1
    }

}
