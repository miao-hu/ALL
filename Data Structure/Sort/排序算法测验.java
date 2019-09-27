import java.util.Arrays;
import java.util.Random;

interface SortMethod{
    public String getName();
    public void sort(int[] a);
}

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

public class Lab {
    private static SortMethod[] methods={
            new InsertSortMethod(),
            new ShellSortMethod(),
            new HeapSortMethod(),
            new BubbleSortMethod(),
            new SelectSortMethod()
    };

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
        for(int i=1;i<=4;i++){
            int num=i*50000;
            int[] random=buildRandom(num);
            int[] sorted=buildSorted(num);
            int[] reversed=buildReversed(num);
            int[] equals=buildEquals(num);

            for(SortMethod method:methods){
                int[] a=random.clone();
               // int[] b=sorted.clone();
                // int[] c=reversed.clone();
                //int[] d=equals.clone();
                long begin=System.nanoTime();
                method.sort(a);
                long end=System.nanoTime();
                double ms=(end-begin)*1.0/1000/1000;
                System.out.printf("随机情况下：%6d个数   %-5s     耗时%3.5f毫秒%n",num,method.getName(),ms);

            }

        }
    }
}
