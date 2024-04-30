package Ex10;

public class Main {
    public static int findSmallestSubarrayLen(int[] A, int k)
    {
        int windowSum = 0;

        int len = Integer.MAX_VALUE;

        int left = 0;

        for (int right = 0; right < A.length; right++)
        {
            windowSum += A[right];

            while (windowSum > k && left <= right)
            {
                len = Integer.min(len, right - left + 1);

                windowSum -= A[left];
                left++;
            }
        }

        if (len == Integer.MAX_VALUE) {
            return 0;
        }

        return len;
    }

    public static void main(String[] args)
    {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 21;

        int len = findSmallestSubarrayLen(A, k);

        if (len != Integer.MAX_VALUE) {
            System.out.print("The smallest subarray length is " + len);
        }
        else {
            System.out.print("No subarray exists");
        }
    }
}
