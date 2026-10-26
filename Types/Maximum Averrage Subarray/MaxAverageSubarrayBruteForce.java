import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxAverageSubarrayBruteForce {
    int n, k;
    int[] nums;
    FastReader reader = new FastReader();

    static class FastReader {
        BufferedReader b;
        StringTokenizer s; 

        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    s = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace(); 
                }
            }
            return s.nextToken();
        }

        int nextInt() { 
            return Integer.parseInt(next()); 
        }
    }

    public void leerDatos() {
        n = reader.nextInt(); // Tamaño del arreglo
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = reader.nextInt();
        }
        k = reader.nextInt(); // Longitud del subarreglo
    }

    public void resuelve() {
        double maxSum = -Double.MAX_VALUE;

        // Fuerza bruta O(n * k): sumar los elementos de cada subarreglo de tamaño k
        for (int i = 0; i <= n - k; i++) {
            double currentSum = 0;
            for (int j = i; j < i + k; j++) {
                currentSum += nums[j];
            }
            maxSum = Math.max(maxSum, currentSum);
        }

        double maxAverage = maxSum / k;
        System.out.printf("%.5f\n", maxAverage);
    }

    public static void main(String[] args) {
        MaxAverageSubarrayBruteForce solver = new MaxAverageSubarrayBruteForce();
        solver.leerDatos();
        solver.resuelve();
    }   
}