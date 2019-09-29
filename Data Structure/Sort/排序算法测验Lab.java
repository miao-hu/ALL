import java.util.Arrays;
import java.util.Random;

interface SortMethod{   //排序方法接口
    String getName();        //返回排序方法名称
    void sort(int[] a);     //对数组进行排序
}

interface BuildMethod{  //建造数组的接口
    String getName();        //返回建造数组的方法名称
    int[] build(int n);     //返回构造好的大小为n的数组
}

///////////////////////////////////////////////////////////////////////////////////
//各个排序算法实现SortMethod接口
class InsertSortMethod implements SortMethod{
    @Override
    public String getName() {
        return "直接插入排序";
    }

    @Override
    public void sort(int[] a) {
        Sort.insertSort(a);
    }

}

class ShellSortMethod implements SortMethod{
    @Override
    public String getName() {
        return "希尔排序";
    }

    @Override
    public void sort(int[] a) {
        Sort.shellSort(a);
    }
}

class SelectSortMethod implements SortMethod{
    @Override
    public String getName() {
        return "直接选择排序";
    }

    @Override
    public void sort(int[] a) {
        Sort.selectSort(a);
    }
}

class HeapSortMethod implements SortMethod{
    @Override
    public String getName() {
        return "堆排序";
    }

    @Override
    public void sort(int[] a) {
        Sort.heapSort(a);
    }
}

class BubbleSortMethod implements SortMethod{
    @Override
    public String getName() {
        return "冒泡排序";
    }

    @Override
    public void sort(int[] a) {
        Sort.bubbleSort(a);
    }
}

class QuickSortMethod implements SortMethod{
    @Override
    public String getName() {
        return "快速排序";
    }

    @Override
    public void sort(int[] a) {
        QuickSort.quickSort(a);
    }
}

class MergeSortMethod implements SortMethod{
    @Override
    public String getName() {
        return "归并排序";
    }

    @Override
    public void sort(int[] a) {
        MergeSort.mergeSort(a);
    }
}

////////////////////////////////////////////////////////////////////////////////
//各个建造数组的算法实现BuildMethod
class BuildRandomMethod implements BuildMethod{

    @Override
    public String getName() {
        return "构造随机数组";
    }

    @Override
    public int[] build(int n) {
        return Lab.buildRandom(n);
    }
}

class BuildSortedMethod implements BuildMethod{

    @Override
    public String getName() {
        return "构造有序数组";
    }

    @Override
    public int[] build(int n) {
        return Lab.buildSorted(n);
    }
}

class BuildReversedMethod implements BuildMethod{

    @Override
    public String getName() {
        return "构造逆序数组";
    }

    @Override
    public int[] build(int n) {
        return Lab.buildReversed(n);
    }
}

class BuildEqualsMethod implements BuildMethod{

    @Override
    public String getName() {
        return "构造等值数组";
    }

    @Override
    public int[] build(int n) {
        return Lab.buildEquals(n);
    }
}

///////////////////////////////////////////////////////////////////////
public class Lab {

    //建立随机数构成的数组
    public static int[] buildRandom(int num){
        Random random=new Random(20190924);
        int[] array=new int[num];
        for(int i=0;i<num;i++){
            array[i]=random.nextInt(num);
        }
        return array;
    }

    //建立一个随机数构成的有序数组
    public static int[] buildSorted(int num){
        Random random=new Random(20190924);
        int[] array=new int[num];
        for(int i=0;i<num;i++){
            array[i]=random.nextInt(num);
        }
        Arrays.sort(array);
        return array;
    }

    //建立一个元素值都相等的数组
    public static int[] buildEquals(int num){
        return new int[num];//数组中元素全为0
    }

    //建立一个逆序数组
    public static int[] buildReversed(int num){
        Random random=new Random(20190924);
        int[] array=new int[num];
        for(int i=0;i<num;i++){
            array[i]=random.nextInt(num);
        }
        shellSortReverse(array);
        return array;
    }

    private static void shellSortReverse(int[] array){
        int gap=array.length;
        while(true){
            gap=(gap/3)+1;
            insertSortWithGapReverse(array,gap);
            if(gap==1){
                break;
            }
        }
    }

    private static void insertSortWithGapReverse(int[] array, int gap) {
        for(int i=gap;i<array.length;i++){
            int key=array[i];
            int j;
            for(j=i-gap;j>=0;j-=gap){
                if(array[j]<key){
                    array[j+gap]=array[j];
                }else{
                    break;
                }
            }
            array[j+gap]=key;
        }
    }

    public static void main(String[] args) {
        SortMethod[] sms={
                new InsertSortMethod(),
                new ShellSortMethod(),
                new HeapSortMethod(),
                new BubbleSortMethod(),
                new SelectSortMethod(),
                new MergeSortMethod(),
        };
        BuildMethod[] bms={
                new BuildEqualsMethod(),
                new BuildRandomMethod(),
                new BuildSortedMethod(),
                new BuildReversedMethod()
        };

        for(int i=1;i<=4;i++){
            int num=i*5000;
            for(BuildMethod bm:bms){
                int[] a=bm.build(num);
                for(SortMethod sm:sms){
                    int[] b=a.clone();   //防止a的原来数据被改变
                    long begin=System.nanoTime();
                    sm.sort(b);
                    long end=System.nanoTime();
                    double ms=(end-begin)*1.0/1000/1000;
                    System.out.printf("用 %5d 个数据%s后用 %10s       进行数组的排序耗时了%10.5f 毫秒时间",num,bm.getName(),sm.getName(),ms);
                    System.out.println();
                }
            }
            System.out.println();
        }
    }
}


