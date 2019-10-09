import java.util.Arrays;

/*
将一个数进行一次交换，使得交换后的值比原来的数小
但是为小的数里面最大的那个数
列如：1 9 4 6 7            1 1 5
结果：1 7 4 6 9            1 1 5
 */

public class Solution {
    public static int[] prePermOpt(int[] A){
       for(int i=A.length-2;i>=0;i--){  //从倒数第二个数开始找
           if(A[i]>A[i+1]){  //找到要交换的位置
               /*
               找另一个数，要求比A[i]的值要小，小里面最大的
               如果最大的数有好几个相同的取最左边的
                */
               int max=-1;  //记录A[i]右边的最大值
               int maxIndex=-1;  //记录A[i]右边的最大值的下标
               for(int j=i+1;j<A.length;j++){
                   if(A[j]<A[i]&&A[j]>max){
                       max=A[j];
                       maxIndex=j;
                   }
               }
               //i和maxIndex就是要交换的位置的下标
               if(maxIndex!=-1){
                   int temp=A[i];
                   A[i]=A[maxIndex];
                   A[maxIndex]=temp;
                   return A;
               }
           }
       }
       return A;  //没有符合条件返回原数
    }

    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(prePermOpt(new int[]{1,9,4,6,7})));
        System.out.println(Arrays.toString(prePermOpt(new int[]{1,1,5})));
    }
}
