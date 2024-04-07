package Ex3;

//Print all subarrays with 0 sum
public class Main {
    public static void printAllSubarrays(int[] nums){
        for (int i = 0; i < nums.length; i++){
            int sum = 0;

            for(int j = i; j < nums.length; j++){
                sum += nums[j];

                if(sum == 0){
                    System.out.println("Subarrays [" + i + ".." + j + "]");
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        printAllSubarrays(nums);
    }
}
