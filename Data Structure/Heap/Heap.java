import java.util.Arrays;
import java.util.Random;

public class Heap {

    //向下调整（小根堆）   左右子树必须已经是一个堆，才能调整
    public static void shiftDownSmall(int[] array, int index, int size) {
        int left=2*index+1;
        while(left<size){
            int right=2*index+2;
            int min=left;
            if(right<size){
                if(array[right]<array[left]){
                    min=right;
                }
            }
            if(array[index]>array[min]){
                swap(array,index,min);
                index=min;
                left=2*index+1;
            }else{
                break;
            }
        }
    }

    //向下调整（大根堆）   左右子树必须已经是一个堆，才能调整
    public static void shiftDownBig ( int[] array, int index, int size){
        int left=2*index+1;
        while(left<size){
            int right=left+1;
            int max=left;
            if(right<size){
                if(array[right]>array[max]){
                    max=right;
                }
            }
            if(array[index]<array[max]){
                swap(array,index,max);
                index=max;
                left=2*index+1;
            }else{
                break;
            }
        }
    }


    /*向上调整（小根堆）
    直到i==0前一直循环，先找到i的双亲下标
    比较array[parent]和array[i]的值
    如果满足条件退出，不满足交换,然后让i=parent;
     */
    public static void shiftUpSmall ( int[] array, int i){
        while(i!=0){
            int parent=(i-1)/2;
            if(array[parent]>array[i]){
                swap(array,parent,i);
                i=parent;
            }else{
                break;
            }
        }
    }

    //向上调整（大根堆）
    public static void shiftUpBig ( int[] array, int i){
        while(i!=0){
            int parent=(i-1)/2;
            if(array[parent]<array[i]){
                swap(array,parent,i);
                i=parent;
            }else{
                break;
            }
        }
    }

    //交换
    private static void swap ( int[] array, int i, int j){
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    //建小堆(采用向下调整法）
    public static void createHeapSmall(int[] a, int s) {
        for (int i = (s - 2) / 2; i >= 0; i--) {  //从倒数第一个非叶子结点开始
            shiftDownSmall(a, i, s);
        }
    }

    //建大堆(采用向下调整法）
    public static void createHeapBig(int[] a, int s) {
        for (int i = (s - 2) / 2; i >= 0; i--) {  //从倒数第一个非叶子结点开始
            shiftDownBig(a, i, s);
        }
    }

    //堆排序（只能排升序）
    public static void heapSort(int[] array){
        createHeapBig(array,array.length);  //先建立一个大堆，最大的结点在array[0]位置
        for(int i=0;i<array.length-1;i++){  //5个结点循环4次
            swap(array,0,array.length-1-i);
            shiftDownBig(array,0,array.length-i-1);
        }
    }

    public static void main (String[]args){
        int[] a={ 27,15,19,18,28,34,65,49,25,37 };
        shiftDownSmall(a,0,a.length);     //index:0
        System.out.println(Arrays.toString(a));
        System.out.println("=============================");

        int[] b={1,8,3,4,5,4,6,7};
        shiftDownSmall(b,1,b.length);     //index:1
        System.out.println(Arrays.toString(b));
        System.out.println("==============================");

        int[] c={20,10,15,8,9,16};
        shiftDownBig(c,2,c.length);     //index:2
        System.out.println(Arrays.toString(c));
        System.out.println("=============================");

        int[] d={28,19,11,7,5,7,8,6,4,18};
        shiftUpBig(d,d.length-1);
        System.out.println(Arrays.toString(d));
        System.out.println("==============================");

        int[] e={1,4,3,1,2,5,7,6};
        shiftUpSmall(e,e.length-4);
        System.out.println(Arrays.toString(e));
        System.out.println("==============================");

        int[] array=new int[8];
        Random random=new Random(20190922);
        for(int i=0;i<8;i++){
            array[i]=random.nextInt(20);
        }
        System.out.println(Arrays.toString(array));
        createHeapSmall(array, array.length);
        System.out.println(Arrays.toString(array));
        System.out.println("==============================");

        int[] n={7,10,18,3,4};
        heapSort(n);
        System.out.println(Arrays.toString(n));
    }

}
