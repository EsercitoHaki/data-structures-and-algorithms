package Ex5;

//Find the duplicate element in a limited range array
public class Main {
    public static int findDuplicate(int[] nums)
    {
        int duplicate = -1;

        // do for each array element
        for (int j = 0; j < nums.length; j++) {
            int i = nums[j];
            // get the value of the current element
            int val = (i < 0) ? -i : i;

            // make element at index `val` negative if it is positive
            if (nums[val] >= 0) {
                nums[val] = -nums[val];
            } else {
                // if the element is already negative, it is repeated
                duplicate = val;
                break;
            }
        }

        // restore the original array before returning
        for (int i = 0; i < nums.length; i++) {
            // make negative elements positive
            if (nums[i] < 0) {
                nums[i] = -nums[i];
            }
        }

        // return duplicate element
        return duplicate;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4};
        System.out.println(findDuplicate(nums));
    }
}
