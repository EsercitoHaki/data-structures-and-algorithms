package Ex7;
import java.util.Arrays;
public class Main {
    public static void merge(int[] X, int[] Y)
    {
        int m = X.length;
        int n = Y.length;

        for (int i = 0; i < m; i++)
        {
            if (X[i] > Y[0])
            {
                int temp = X[i];
                X[i] = Y[0];
                Y[0] = temp;

                int first = Y[0];

                int k;
                for (k = 1; k < n && Y[k] < first; k++) {
                    Y[k - 1] = Y[k];
                }

                Y[k - 1] = first;
            }
        }
    }

    public static void main (String[] args)
    {
        int[] X = { 1, 4, 7, 8, 10 };
        int[] Y = { 2, 3, 9 };

        merge(X, Y);

        System.out.println("X: " + Arrays.toString(X));
        System.out.println("Y: " + Arrays.toString(Y));
    }
}
