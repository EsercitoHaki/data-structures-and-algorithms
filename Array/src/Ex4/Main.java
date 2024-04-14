package Ex4;

import java.util.Arrays;

//Sort binary array in linear time
public class Main {
    public static void sort(int[] nums)
    {
        int zero = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 0)
            {
                zero++;
            }
        }

        int k = 0;
        while (zero-- != 0)
        {
            nums[k++] = 0;
        }

        while (k < nums.length)
        {
            nums[k++] = 1;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1, 0, 0, 1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
