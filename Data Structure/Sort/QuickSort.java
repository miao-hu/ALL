import java.util.Arrays;

public class QuickSort {
    //快速排序
    public static void quickSort(int[] array){
        quickSortInter(array,0,array.length-1);
        //快速排序的范围[0,array.length-1]
    }

    /*  [left, right]为排序的范围
            1.选基准值array[left]
            2.调用partition函数得到划分区间后的基准值的下标
                   将值小于基准值的全部放在基准值的左边
                   将值大于基准值的全部放在基准值的右边
            4.分别对左右小区间按同样方式处理
     */
    private static void quickSortInter(int[] array, int left, int right) {
        if(left>=right){
            return;  //排序区间的长度<=1则不需要排序了，退出就好
        }
        //数组的长度大于等于三    三数取中法选择基准值
        //基准值始终是array[left]  交换即可
        if (right - left + 1 >= 3) {
            int mid = (left + right) / 2;
            if (array[left] > array[mid]) {
                if (array[left] > array[right]) {
                    if (array[mid] > array[right]) {
                        swap(array, left, mid);
                    } else {
                        swap(array, left, right);
                    }
                } else {  //刚好是array[left]
                    }
            } else {
                if (array[mid] > array[right]) {
                    if (array[left] > array[right]) {

                    } else {
                        swap(array, left, right);
                    }
                } else {
                    swap(array, left, mid);
                }
            }
        }
        /*  这种排大数据会产生栈溢出
        int pivotIndex=partition3(array,left,right);
        此时已经根据基准值将数组划分为左右区间
        quickSortInter(array,left,pivotIndex-1); //对左区间进行快排
        quickSortInter(array,pivotIndex+1,right); //对右区间进行快排
        */

        int[] pivotIndices = partition4(array, left, right);
        quickSortInter(array, left, pivotIndices[0]);
        quickSortInter(array, pivotIndices[1], right);
    }

    /*
        保证less左边的都比基准值小    big右边的都比基准值大
        [less,big]之间的都和基准值相同     i用来遍历整个d待排序的数组
     */
    private static int[] partition4(int[] array, int left, int right) {
        int less=left;
        int big=right;
        int pivot=array[left];
        int i=left;  //从头开始遍历
        while(i<=big) {
            if(array[i]==pivot){
                i++;
            }else if(array[i]>pivot){
                swap(array,i,big);
                big--;
            }else{
                swap(array,i,less);
                less++;
                i++;
            }
        }
        return new int[] {less-1,big+1};
    }

    private static void swap(int[] array, int i, int j) {
        int t=array[i];
        array[i]=array[j];
        array[j]=t;
    }

    /*1. hoare法
            在区间[begin,end]中进行，选取基准值array[left]
            从最右边开始进行
            如果值大于基准值，end--,找到小于基准值的元素停下
            然后从左边开始找，如果值小于基准值，begin++,找到大于基准值的停下
            然后两数进行交换
            直到begin==end退出循环
            将array[begin]和array[left]交换，然后返回下标

     */
    public static int partition1(int[] array,int left,int right){
        int begin=left;
        int end=right;
        int pivot=array[left];
        while(begin<end){
            while(begin<end&&array[end]>=pivot){
                end--;
            }
            while(begin<end&&array[begin]<=pivot){
                begin++;
            }
            swap(array,begin,end);
        }
        swap(array,left,begin);
        return begin;  //这里返回begin 和end都可以
    }

    /*2.挖坑法
            在区间[begin,end]中进行，选取基准值array[left]
            从最右边开始进行
            如果值大于基准值，end一直--
            找到小于基准值的元素，将它的值赋给array[begin]
            然后从左边开始找，如果值小于基准值，begin++
            找到大于基准值的停下，将它的值付给刚刚的array[end]
            直到begin==end退出循环
            将array[left]的值赋给array[begin]，然后返回下标
     */
    public static int partition2(int[] array,int left,int right){
        int begin=left;
        int end=right;
        int pivot=array[left];
        while(begin<end){
            while(begin<end&&array[end]>=pivot){
                end--;
            }
            array[begin]=array[end];
            while(begin<end&&array[begin]<=pivot){
                begin++;
            }
            array[end]=array[begin];
        }
        array[begin]=pivot;
        return begin;
    }

    /*3.前后下标法
           在区间[left+1,right]中进行，选取基准值array[left]
           从最左边开始进行  i和d的初值都是left+1
           d 左边的全部是小于基准值的，不包括d
           [d,i]全部是大于基准值的
           如果当前元素小于基准值，那么交换d和i下标所对应的元素  然后d++   i++
           如果当前元素大于基准值，那么i++

    */
    public static int partition3(int[] array,int left,int right){
        int d=left+1;
        int pivot=array[left];
        for(int i=left+1;i<=right;i++){  //遍历数组
            if(array[i]<pivot){
                swap(array,i,d);
                d++;
            }
        }
        swap(array,d-1,left);
        return d-1;
    }

    public static void main(String[] args) {
        int[] a={5,4,8,3,9,2,6};
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}
