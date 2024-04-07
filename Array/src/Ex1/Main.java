package Ex1;

//Find pair with given sum in the array
public class Main {
    public static void findPair(int[] nums, int target){
        for (int i = 0; i < nums.length; i++){
            for (int j = i +1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    System.out.printf("Pair found (%d, %d)", nums[i], nums[j]);
                    return;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {8, 7, 2, 5, 3, 1};
        int target = 10;
        findPair(nums, target);
    }
}
