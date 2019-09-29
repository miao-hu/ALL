//归并排序
public class MergeSort {

    //1.第一种
    public static void mergeSort(int[] array){
        mergeSortInter(array,0,array.length);//排序区间范围[0,array.length)
    }

    //排序区间范围[low,high)
    private static void mergeSortInter(int[] array, int low, int high) {
        if(low>=high-1){
            return;
        }
        int mid=(low+high)/2;
        mergeSortInter(array,low,mid);  //左区间
        mergeSortInter(array,mid,high); //右区间
        merge(array,low,mid,high);  //左右有序区间排序后做归并
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int length=high-low;  //归并的区间长度
        int[] extra=new int[length];
        int k=0;
        int i=low,j=mid;
        while(i<mid&&j<high){
            if(array[i]<=array[j]){
                extra[k++]=array[i++];
            }else{
                extra[k++]=array[j++];
            }
        }
        while(i<mid){   //若这个数组还有剩余元素则直接拷贝
            extra[k++]=array[i++];
        }
        while(j<high){  //若这个数组还有剩余元素则直接拷贝
            extra[k++]=array[j++];
        }
        for(int m=0;m<length;m++){   //将extra数组内容拷贝到[low,high)区间
            array[low+m]=extra[m];
        }
    }

    /////////////////////////////////////////////////////////////////////////
    //2.第二种
    /*  在第一种方法中
        每一次归并都需要开辟一个额外的数组，需要不停的耗费时间
        所以直接在刚开始开辟一个足够空间的额外数组就好
        这个数组的长度为array.length    因为是对这个array数组做排序
     */
    public static void mergeSort2(int[] array){
        int[] extra=new int[array.length];
        mergeSortInter2(array,0,array.length,extra);
    }

    private static void mergeSortInter2(int[] array, int low, int high, int[] extra) {
        if(low>=high-1){
            return;
        }
        int mid=(low+high)/2;
        mergeSortInter2(array,low,mid,extra);
        mergeSortInter2(array,mid,high,extra);
        merge2(array,low,mid,high,extra);
    }

    private static void merge2(int[] array, int low, int mid, int high, int[] extra) {
        int length=high-low;  //归并的区间长度
        int k=0;
        int i=low,j=mid;
        while(i<mid&&j<high){
            if(array[i]<=array[j]){
                extra[k++]=array[i++];
            }else{
                extra[k++]=array[j++];
            }
        }
        while(i<mid){   //若这个数组还有剩余元素则直接拷贝
            extra[k++]=array[i++];
        }
        while(j<high){  //若这个数组还有剩余元素则直接拷贝
            extra[k++]=array[j++];
        }
        for(int m=0;m<length;m++){   //将extra数组内容拷贝到[low,high)区间
            array[low+m]=extra[m];
        }
    }

    ///////////////////////////////////////////////////////////////////////////////
    //3.第三种
    public static void mergeSort3(int[] array){
        for(int i=1;i<array.length;i=i*2){
            for(int j=0;j<array.length;j=j+2*i){
                int low=j;
                int mid=j+i;
                if(mid>=array.length){
                    continue;  //break也可以
                }
                int high=mid+i;
                if(high>array.length){
                    high=array.length;
                }
                merge(array,low,mid,high);  //这个区间排序后归并
            }
        }
    }
}


