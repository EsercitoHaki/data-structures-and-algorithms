package Ex2;

import java.util.HashSet;
import java.util.Set;

//Check if a subarray with 0 sum exists or not
public class Main {
    public static Boolean hasZeroSumSubarray(int[] nums){
        Set<Integer> set = new HashSet<>();

        set.add(0);

        int sum = 0;

        for(int value:nums){
            sum += value;

            if(set.contains(sum)){
                return true;
            }

            set.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        if(hasZeroSumSubarray(nums)){
            System.out.println("Subarray exists");
        }else {
            System.out.println("Subarray does not exists");
        }
    }
}
