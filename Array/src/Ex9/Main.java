package Ex9;

import java.util.Arrays;

class Main
{

    public static int[] kadane(int[] A)
    {

        if (A.length <= 1) {
            return A;
        }

        int maxSoFar = Integer.MIN_VALUE;

        int maxEndingHere = 0;

        int start = 0, end = 0;

        int beg = 0;

        for (int i = 0; i < A.length; i++)
        {
            maxEndingHere = maxEndingHere + A[i];

            if (maxEndingHere < A[i])
            {
                maxEndingHere = A[i];
                beg = i;
            }

            if (maxSoFar < maxEndingHere)
            {
                maxSoFar = maxEndingHere;
                start = beg;
                end = i;
            }
        }

        return Arrays.copyOfRange(A, start, end + 1);
    }

    public static void main(String[] args)
    {
        int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        int slice[] = kadane(A);
        System.out.print("The contiguous subarray with the largest sum is " +
                Arrays.toString(slice));
    }
}
