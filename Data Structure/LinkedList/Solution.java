import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Soultion {
    //第一种
    public static List<List<Integer>> threeSum1(int[] nums){
        List<List<Integer>> result=new ArrayList<>();
        if(nums.length==0){
            return result;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                        while(i<nums.length-2&&nums[i]==nums[i+1]){
                            i++;
                        }
                        while(j<nums.length-1&&nums[j]==nums[j+1]){
                            j++;
                        }

                    }
                }
            }
        }
        return result;
    }

    /*第二种
        [-4,-1,-1,0,1,2]
         i   j         k
    */
    public static List<List<Integer>> threeSum2(int[] nums){
        List<List<Integer>> result=new ArrayList<>();
        if(nums.length==0){
            return result;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0){ //第一个数就大于0
                break;
            }
            int j=i+1,k=nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    break;
                }else if(nums[i]+nums[j]+nums[k]>0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return result;
    }

    //第三种
    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                while(j<k&&nums[i] + nums[j] + nums[k] < 0){
                    j++;
                }
                if(j>=k)break;
                if(nums[i] + nums[j] + nums[k] ==0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    while(j<k&&nums[j] ==nums[j+1]){
                        j++;
                    }
                    j++;
                }
                while(j<k&&nums[i] + nums[j] + nums[k] > 0){
                        k--;
                }
                if(j>=k)break;
                if(nums[i] + nums[j] + nums[k] ==0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    k--;
                }
            }
            while (i<nums.length-2 && nums[i] == nums[i+1]) {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4};
        List<List<Integer>> list=threeSum1(nums);
        for(int i=0;i<list.size();i++){
             System.out.println(list.get(i));
        }
        System.out.println(threeSum2(nums));
        System.out.println(threeSum3(nums));
    }
}
