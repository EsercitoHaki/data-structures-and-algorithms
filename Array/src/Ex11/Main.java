package Ex11;
import java.util.HashMap;
import java.util.Map;

class Main
{
    public static void rearrange(int[] A)
    {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i: A) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        for (int i: A)
        {
            if (freq.containsKey(i))
            {
                int n = freq.get(i);
                while (n-- != 0) {
                    System.out.print(i + " ");
                }

                freq.remove(i);
            }
        }
    }

    public static void main(String[] args)
    {
        int[] A = { 5, 4, 5, 5, 3, 1, 2, 2, 4 };

        rearrange(A);
    }
}