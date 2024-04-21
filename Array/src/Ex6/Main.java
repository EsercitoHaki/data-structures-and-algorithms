package Ex6;

//Find maximum length subarray having a given sum
public class Main {
    public static void findMaxLenSubarray(int[] nums, int S)
    {
        int len = 0;
        int ending_index = -1;

        for (int i = 0; i < nums.length; i++)
        {
            int target = 0;

            for (int j = i; j < nums.length; j++)
            {
                target += nums[j];

                if (target == S)
                {
                    if (len < j - i + 1)
                    {
                        len = j - i + 1;
                        ending_index = j;
                    }
                }
            }
        }

        System.out.println("[" + (ending_index - len + 1)
                + ", " + ending_index + "]");
    }
    public static void main(String[] args) {
        int[] nums = { 5, 6, -5, 5, 3, 5, 3, -2, 0 };
        int target = 8;

        findMaxLenSubarray(nums, target);
    }
}
