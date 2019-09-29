import java.util.Arrays;
import java.util.Random;

public class Sort {
    /*直接插入排序：
            在无序区间中找无序区间的第一个数，
            然后在有序区间中找合适的位置插入
     * 时间复杂度：
     * 最好       平均          最坏
     * O(n)       O(n^2)        O(n^2）
     * 数据有序                 数据逆序
     * 空间复杂度：O(1)
     */
    public static void insertSort(int[] array){
        for(int i=1;i<array.length;i++){
            int key=array[i];
            int j;
            for(j=i-1;j>=0;j--){  //在有序区间中找插入位置
                if(array[j]<=key){
                    break;
                }else{
                    array[j+1]=array[j];
                }
            }
            array[j+1]=key;
        }
    }

    public static void insertSort1(int[] array){
        for(int i=1;i<array.length;i++){
            int key=array[i];
            int j;
            for(j=i-1;j>=0&&array[j]>key;j++){
                array[j+1]=array[j];
            }
            array[j+1]=key;
        }
    }

    //希尔排序
    public static void shellSort(int[] array){
        int gap=array.length;
        while(true){
            gap=(gap/3)+1;   //gap = gap / 2;
            insertSortWithGap(array,gap);
            if(gap==1){
                break;
            }
        }
    }

    private static void insertSortWithGap(int[] array, int gap) {
        for(int i=gap;i<array.length;i++){
            int key=array[i];
            int j;
            for(j=i-gap;j>=0;j-=gap){
                if(array[j]<=key){
                    break;
                }else{
                    array[j+gap]=array[j];
                }
            }
            array[j+gap]=key;
        }
    }

    //交换
    private static void swap(int[] array, int i, int j) {
        int t=array[i];
        array[i]=array[j];
        array[j]=t;
    }

    //建立一个大堆
    public static void creatHeapBig(int[] array){
        for(int i=(array.length-2)/2;i>=0;i--){
            shiftDownBig(array,i,array.length);
        }
    }

    //向下调整为大堆
    public static void shiftDownBig(int[] array,int index,int size){
        int left=2*index+1;
        while(left<size){
            int right=2*index+2;
            int max=left;
            if(right<size){
                if(array[right]>array[max]){
                    max=right;
                }
            }
            if(array[index]<array[max]){
                swap(array,index,max);
            }else{
                break;
            }
        }
    }

    //堆排序
    public static void heapSort(int[] array){
        creatHeapBig(array);  //先创建一个大堆
        for(int i=0;i<array.length-1;i++){ //排序array.length-1次
            swap(array,0,array.length-1-i);
            shiftDownBig(array,0,array.length-1-i);
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] array){
        for(int i=0;i<array.length-1;i++){  //总共排n-1趟
            boolean isSort=true;
            for(int j=0;j<array.length-1-i;j++){  //到倒数第二个数
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
                    isSort=false;  //只要发生了交换就置为false
                }                  //没有发生一次交换说明数组已经有序
            }
            if(isSort){  //数组已经有序
                return;
            }
        }
    }

    /*直接选择排序（升序）
          每次选择最大的数放在无序区间的最后
     */
    public static void selectSort(int[] array){
        for(int i=0;i<array.length-1;i++){  //循环需要进行array.length-1次
            int maxIndex=0;
            for(int j=1;j<array.length-i;j++){
                if(array[j]>array[maxIndex]){
                    maxIndex=j;
                }
            }
            swap(array,maxIndex,array.length-1-i);
            //每次将最大数放到无序区间的最后
        }
    }

    //直接选择排序（逆序）
    public static void selectSort0(int[] array){
        for(int i=0;i<array.length-1;i++){
            int minIndex=0;
            for(int j=1;j<array.length-i;j++){
                if(array[j]<array[minIndex]){
                    minIndex=j;
                }
            }
            swap(array,minIndex,array.length-i-1);
        }
    }

    //直接选择排序（逆序）
    public static void selectSort1(int[] array){
        for(int i=0;i<array.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[minIndex]){
                    minIndex=j;
                }
            }
            swap(array,i,minIndex);
        }
    }

    //双向选择排序
    public static void selectSort2(int[] array){
        int begin=0;
        int end=array.length-1;
        while(begin<end){  //中间只剩一个数不用判断
            int minIndex=begin;  //无序区间[begin,end]
            int maxIndex=begin;
            for(int i=begin+1;i<=end;i++){
                if(array[i]<array[minIndex]){
                    minIndex=i;
                }
                if(array[i]>array[maxIndex]){
                    maxIndex=i;
                }
            }
            swap(array,minIndex,begin);  //将最小数放到begin位置
            if (maxIndex == begin) {  //如果最大数的下标
                maxIndex = minIndex;  //刚好是刚刚交换的begin
            }                         //故最大下标在刚刚已经交换的minIndex位置
            swap(array,maxIndex,end);   //将最大数放到end位置
            begin++;end--;
        }
    }

    //测试速度
    public static void testSpeed(){
        int[] array= Lab.buildRandom(100000);
        long begin=System.nanoTime();//测当前时间
        bubbleSort(array);
        long end=System.nanoTime();
        double ms=(end-begin)*1.0/1000/1000;
        System.out.printf("冒泡排序一共耗时:%.5f毫秒%n",ms);
    }

    //测试结果是否是正确的
    public static void testRight(){
        int[] a={4,2,7,9,3,9,0};

        int[] b=a.clone();
        insertSort(b);
        System.out.println(Arrays.toString(b));

        int[] c=a.clone();
        Arrays.sort(c);
        System.out.println(Arrays.toString(c));

        System.out.println(Arrays.equals(b,c));  //返回值为:true
    }

    public static void main(String[] args) {
        testRight();
        testSpeed();
        int[] a={3,2,1,9,0};
        selectSort1(a);
        System.out.println(Arrays.toString(a));
    }
}
