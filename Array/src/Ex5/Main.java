package Ex5;

//Find the duplicate element in a limited range array
public class Main {
    public static int findDuplicate(int[] nums)
    {
        int duplicate = -1;

        for(int i : nums)
        {
            int val = (i < 0) ? -i : i;

            if(nums[val] >= 0)
            {
                nums[val] = -nums[val];
            }else
            {
                duplicate = -nums[val];
                break;
            }
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] < 0)
            {
                nums[i] = -nums[i];
            }
        }

        return duplicate;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4};
        System.out.println(findDuplicate(nums));
    }
}
