/*
    异常是从方法抛出的，方法的调用者可以捕获以及处理该异常
    库方法可以检测出错误，但只有调用者才知道出现错误时需要做什么
    异常处理最根本的优势就是将检测错误（由被调用的方法）从
    处理错误（由调用方法完成）中分离出来
 */

public class MyArrayList {
    private int[] array;
    private int size;

    public MyArrayList(){
        array=new int[10];
        size=0;
    }

    public int get(int index){
        if(index<0||index>=array.length){
            throw new ArrayIndexOutOfBoundsException(); //抛出下标越界异常
        }
        return array[index];
    }
}
